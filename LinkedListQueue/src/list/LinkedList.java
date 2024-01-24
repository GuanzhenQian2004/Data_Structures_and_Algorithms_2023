// Name: Steven Qian
// Computing ID: uen9ke
// Homework Name: LinkedList Queue
// Resources used: None

package list;

/**
 * 
 * A custom built linked list
 * T here is the type the list stores
 */
public class LinkedList<T> implements SimpleList<T>{

	/* Dummy head and tail */
	private ListNode<T> head, tail;
	private int size;
	
	public LinkedList() {
		head = new ListNode<T>(null);
		tail = new ListNode<T>(null);
		head.next = tail;
		tail.prev = head;
		size = 0;
	}
	
	public int size() {
		return this.size;
	}
	
	/**
	 * Clears out the entire list
	 */
	public void clear() {

		head.next = tail;
		tail.prev = head;

		this.size = 0;
	}
	
	/**
	 * Inserts new data at the end of the list (i.e., just before the dummy tail node)
	 * @param data
	 */
	public void insertAtTail(T data) {
		ListNode<T> temp = new ListNode<T>(data);

		temp.prev = tail.prev;
		temp.next = tail;

		tail.prev.next = temp;
		tail.prev = temp;

		size++;
	}

	/**
	 * Inserts data at the front of the list (i.e., just after the dummy head node
	 * @param data
	 */
	public void insertAtHead(T data) {
		ListNode<T> temp = new ListNode<T>(data);

		temp.prev = head;
		temp.next = head.next;

		head.next.prev = temp;
		head.next = temp;

		size ++;
	}
	
	/**
	 * Inserts node such that index becomes the position of the newly inserted data
	 * @param data
	 * @param index
	 */
	public void insertAt(int index, T data) {

		if (index > size || index < 0) {return;}  //if index == size then insert at tail (before dummy tail)
													// if index == 0 then insert at head (before dummy head)

		if (index == 0) {insertAtHead(data);}
		else if (index == size) {insertAtTail(data);}

		else {

			ListNode<T> temp = new ListNode<>(data);
			ListNode<T> pointer = head.next;

			for(int i = 0; i < index; i++){

				pointer = pointer.next;

			}

			temp.prev = pointer.prev;
			temp.next = pointer;
			temp.prev.next = temp;
			pointer.prev = temp;
			size++;
		}
	}
	
	/**
	 * Inserts data after the node pointed to by iterator
	 */
	public void insert(ListIterator<T> it, T data) {

		ListNode<T> temp = new ListNode<>(data);

		temp.next = it.curNode.next;
		temp.prev = it.curNode;

		it.curNode.next.prev = temp;
		it.curNode.next = temp;

		size++;
	}
	
	
	
	public T removeAtTail(){

		if (size == 0) {return null;}

		ListIterator<T> it = new ListIterator<>(tail.prev);

		return remove(it);
	}
	
	public T removeAtHead(){

		if (size == 0) {return null;}

		ListIterator<T> it = new ListIterator<>(head.next);

		return remove(it);
	}
	
	/**
	 * Remove based on Iterator position
	 * Sets the iterator to the node AFTER the one removed
	 */
	public T remove(ListIterator<T> it) {

		T removedData = it.value();
		it.curNode.prev.next = it.curNode.next;
		it.curNode.next.prev = it.curNode.prev;
		it.moveForward();
		size--;

		return removedData;
	}
	
	/**
	 * Returns index of first occurrence of the data in the list, or -1 if not present
	 * @param data
	 * @return
	 */
	public int find(T data) {

		int index = -1;
		ListNode<T> temp = head.next;
		for(int i = 0; i < size; i++){
			if(temp.getData().equals(data)){
				return i;
			}
			temp = temp.next;
		}
		return -1;

	}
	
	/**
	 * Returns the data at the given index, null if anything goes wrong (index out of bounds, empty list, etc.)
	 * @param index
	 * @return
	 */
	public T get(int index) {

		if(index < 0 || index >= size){
			return null;
		}
		ListNode<T> temp = head.next;
		for(int i = 0; i < index; i++) {
			temp = temp.next;
		}
		return temp.getData();

	}
	
	/**
	 * Returns the list as space separated values
	 */
	public String toString() {
		String toRet = "[";
		
		ListNode<T> curNode = head.next;
		while(curNode != tail) {
			toRet += curNode.getData() + ", ";
			curNode = curNode.next;
		}
		
		return toRet + "]";
	}
	
	/* Return iterators at front and end of list */
	public ListIterator<T> front(){
		ListIterator<T> it = new ListIterator<>(head.next);
		return it;
	}

	public ListIterator<T> back(){
		ListIterator<T> it = new ListIterator<>(tail.prev);
		return it;
	}
	
	
}
