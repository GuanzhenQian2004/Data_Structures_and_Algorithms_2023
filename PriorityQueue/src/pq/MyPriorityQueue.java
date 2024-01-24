// Name: Steven Qian
// Computing ID: uen9ke
// Homework Name: HW12-PriorityQueue
// Resources used: None

package pq;

import java.util.ArrayList;

/**
 * MyPriorityQueue is a generic priority queue implementation using a max heap.
 *
 * @param <T> the type of elements in the priority queue, must extend Comparable
 */
public class MyPriorityQueue<T extends Comparable<T>> implements SimplePQ<T> {

    private final ArrayList<T> heap;

    /**
     * Constructs an empty priority queue.
     */
    public MyPriorityQueue() {
        heap = new ArrayList<>();
    }

    /**
     * Calculates the index of the parent of the element at the specified position.
     *
     * @param pos the position of the element
     * @return the index of the parent
     */
    private int parent(int pos) {
        return (pos - 1) / 2;
    }

    /**
     * Calculates the index of the left child of the element at the specified position.
     *
     * @param pos the position of the element
     * @return the index of the left child
     */
    private int leftChild(int pos) {
        return (2 * pos) + 1;
    }

    /**
     * Calculates the index of the right child of the element at the specified position.
     *
     * @param pos the position of the element
     * @return the index of the right child
     */
    private int rightChild(int pos) {
        return (2 * pos) + 2;
    }

    /**
     * Checks if the element at the specified position is a leaf node.
     *
     * @param pos the position of the element
     * @return true if the element is a leaf, false otherwise
     */
    private boolean isLeaf(int pos) {
        return pos + 1 > (size() / 2);
    }

    /**
     * Swaps the elements at the specified positions in the heap.
     *
     * @param pos1 the position of the first element
     * @param pos2 the position of the second element
     */
    private void swap(int pos1, int pos2) {
        if (!heap.isEmpty()) {
            T temp = heap.get(pos1);
            heap.set(pos1, heap.get(pos2));
            heap.set(pos2, temp);
        }
    }

    /**
     * Maintains the max heap property by recursively fixing the heap starting from the given position.
     *
     * @param pos the position to start the max heapify process
     */
    private void maxHeapify(int pos) {
        if (heap.isEmpty() || isLeaf(pos)) {
            return;
        }

        int swapPos = pos;

        if (leftChild(pos) < heap.size() - 1 && heap.get(leftChild(pos)).compareTo(heap.get(swapPos)) > 0) {
            swapPos = leftChild(pos);
        }
        if (rightChild(pos) < heap.size() && heap.get(rightChild(pos)).compareTo(heap.get(swapPos)) > 0) {
            swapPos = rightChild(pos);
        }

        if (swapPos != pos) {
            swap(pos, swapPos);
            maxHeapify(swapPos);
        }
    }

    /**
     * Adds an element to the priority queue and maintains the max heap property.
     *
     * @param t the element to be added
     */
    public void add(T t) {
        heap.add(t);
        int index = heap.size() - 1;

        while (heap.get(index).compareTo(heap.get(parent(index))) > 0 && index > 0) {
            swap(index, parent(index));
            index = parent(index);
        }
    }

    /**
     * Clears all elements from the priority queue.
     */
    public void clear() {
        heap.clear();
    }

    /**
     * Checks if the priority queue contains the specified element.
     *
     * @param o the element to be checked
     * @return true if the element is in the priority queue, false otherwise
     */
    public boolean contains(Object o) {
        return heap.contains(o);
    }

    /**
     * Retrieves the element with the highest priority without removing it from the priority queue.
     *
     * @return the element with the highest priority, or null if the priority queue is empty
     */
    public T peek() {
        if (!heap.isEmpty()) {
            return heap.get(0);
        }
        return null;
    }

    /**
     * Removes and returns the element with the highest priority from the priority queue.
     *
     * @return the element with the highest priority, or null if the priority queue is empty
     */
    public T remove() {
        if (heap.isEmpty()) {
            return null;
        }

        T task = heap.get(0);
        heap.set(0, heap.get(heap.size() - 1));

        maxHeapify(0);
        heap.remove(heap.size() - 1);
        return task;
    }

    /**
     * Returns the number of elements in the priority queue.
     *
     * @return the number of elements in the priority queue
     */
    public int size() {
        return heap.size();
    }

    /**
     * Returns a string representation of the priority queue.
     *
     * @return a string representation of the priority queue
     */
    @Override
    public String toString() {
        return heap.toString();
    }
}