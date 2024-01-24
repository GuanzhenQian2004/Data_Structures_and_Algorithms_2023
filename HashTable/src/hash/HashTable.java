
// Name: Steven Qian
// Computing ID: uen9ke
// Homework Name: HW11-HashTable
// Resources used: None


package hash;

import java.util.ArrayList;
import java.util.LinkedList;

@SuppressWarnings("unchecked")
public class HashTable<K, V> implements SimpleMap<K, V> {

    private static final int INITIAL_CAP = 5;
    private static final double LOAD_FACTOR_THRESHOLD = 0.75;
    private int currentCapacity = INITIAL_CAP;
    private int size = 0; // Added size variable
    private ArrayList<LinkedList<HashNode<K, V>>> table; // Using separate chaining with LinkedList

    public int getSize() {
        return size;
    }

    public HashTable() {
        this(INITIAL_CAP);
    }

    public HashTable(int capacity) {
        this.currentCapacity = capacity;
        this.table = new ArrayList<>(capacity);
        for (int i = 0; i < capacity; i++) {
            table.add(new LinkedList<>());
        }
    }

    @Override
    public void insert(K key, V value) {
        int index = getIndex(key);
        LinkedList<HashNode<K, V>> bucket = table.get(index);

        for (HashNode<K, V> node : bucket) {
            if (node.getKey().equals(key)) {
                node.setValue(value);
                return;
            }
        }

        bucket.add(new HashNode<>(key, value));
        size++;

        if ((double) size / currentCapacity > LOAD_FACTOR_THRESHOLD) {
            resizeAndRehash();
        }
    }

    @Override
    public V retrieve(K key) {
        int index = getIndex(key);
        LinkedList<HashNode<K, V>> bucket = table.get(index);

        for (HashNode<K, V> node : bucket) {
            if (node.getKey().equals(key)) {
                return node.getValue();
            }
        }

        return null; // Key not found
    }

    @Override
    public boolean contains(K key) {
        int index = getIndex(key);
        LinkedList<HashNode<K, V>> bucket = table.get(index);

        for (HashNode<K, V> node : bucket) {
            if (node.getKey().equals(key)) {
                return true;
            }
        }

        return false; // Key not found
    }

    @Override
    public void remove(K key) {
        int index = getIndex(key);
        LinkedList<HashNode<K, V>> bucket = table.get(index);

        // Iterate through the bucket
        //bucket.removeIf(node -> node.getKey().equals(key));

        for (HashNode<K, V> node : bucket) {
            if (node.getKey().equals(key)) {
                bucket.remove(node);
                size--;
            }

        }
    }

    public void printHashTable() {
        for (int idx = 0; idx < this.currentCapacity; ++idx) {
            System.out.print(idx + ": ");
            printEntriesByIndex(idx);
        }
    }

    private void printEntriesByIndex(int idx) {
        LinkedList<HashNode<K, V>> bucket = table.get(idx);
        if (bucket.isEmpty()) {
            System.out.println("no entries");
        } else {
            for (HashNode<K, V> node : bucket) {
                System.out.print(node + " ");
            }
            System.out.println();
        }
    }

    private void resizeAndRehash() {
        int newCapacity = currentCapacity * 2 + 1;
        ArrayList<LinkedList<HashNode<K, V>>> newTable = new ArrayList<>(newCapacity);

        for (int i = 0; i < newCapacity; i++) {
            newTable.add(new LinkedList<>());
        }

        for (LinkedList<HashNode<K, V>> bucket : table) {
            for (HashNode<K, V> node : bucket) {
                int newIndex = Math.abs(node.getKey().hashCode()) % newCapacity;
                newTable.get(newIndex).add(node);
            }
        }

        currentCapacity = newCapacity;
        table = newTable;
    }

    private int getIndex(K key) {
        return Math.abs(key.hashCode()) % currentCapacity;
    }
}