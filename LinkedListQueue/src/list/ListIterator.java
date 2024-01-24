// Name: Steven Qian
// Computing ID: uen9ke
// Homework Name: LinkedList Queue
// Resources used: None

package list;

public class ListIterator<T> {
	protected ListNode<T> curNode;  /* Current node (of type ListNode) */
	
        /* ListIterator constructor. Accepts the current node. */
	public ListIterator(ListNode<T> currentNode) { 
		curNode = currentNode;
	}
	
	/**
	 * These two methods tell us if the iterator has run off
	 * the list on either side
	 */
	public boolean isPastEnd() { 
		if (curNode == null) {
			return true;
		}
		return false;
		/* Hint: How do you know if you’re at the dummy tail node? */
	}
	
	public boolean isPastBeginning() {
		if (curNode == null) {
			return true;
		}
		return false;
		/* Hint: How do you know if you’re at the dummy head node? */
	}
	
	/**
	 * Get the data at the current iterator position
	 * Return the data if appropriate, otherwise return null
	 */
	public T value() {
		if (isPastBeginning() && isPastEnd()) {
			return null;
		}
		return curNode.getData();
		/* Hint: Remember to first validate the position of the Iterator */
	}
	
	/**
	 * These two methods move the cursor of the iterator
	 * forward / backward one position
	 */
	public void moveForward() { 
		if (isPastBeginning()) {return;}   //check with ta
		curNode = curNode.next;
		/* Hint: Remember to check IF you can move forward before you do! */
                /*       (Otherwise, do not move at all) */
	}
	
	public void moveBackward() {
		if (isPastEnd()) {return;}
		curNode = curNode.prev;
		/* Hint: Remember to check IF you can move backwards before you do! */
		/*       (Otherwise, do not move at all) */
	}
}


