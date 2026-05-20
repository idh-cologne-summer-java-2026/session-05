package idh.java;

public class MyLinkedList<T> {

	/**
	 * Helper class for the list elements
	 * 
	 * It's an "inner class", i.e., can only be used within MyLinkedList. 
	 */
	private class ListElement {
		T payload;
		ListElement next = null;

		ListElement(T value) {
			this.payload = value;
		}
		
		public int size() {
			if (next == null) {
				return 1;
			} else {
				return next.size() + 1;
			}
		}
		
		public T get(int index) {
			if (index == 0) {
				return payload;
			} else {
				if (next == null) { 
					return null; 
				} else {
					return next.get(index - 1);
				}
			}
		}
	}

	/**
	 * We only need to store the very first element of our list, because it will
	 * know whether there is a next element.
	 */
	ListElement first;

	/**
	 * Returns the value at the specified index, or {@code null} if out of bounds.
	 *
	 * @param index zero-based position of the element to retrieve
	 * @return the value at {@code index}, or {@code null}
	 */
	public T get(int index) {
		if (isEmpty()) {
			return null;
		}
		return first.get(index);
		/*
		ListElement el = getElement(index);
		if (el == null)
			return null;
		else 
			return el.payload;
			*/
	}

	
	/**
     * Returns the number of elements in this list.
     *
     * @return the number of elements
     */
	public int size() {
		
		if (isEmpty())
			return 0;
		return first.size();

				
		/*		
		int s = 1;
		ListElement current = first;

		while (current.next != null) {
			current = current.next;
			s += 1;
		}
		return s;
		*/
	}

	/**
     * Returns {@code true} if this list contains the specified object.
     * Comparison is performed using {@link Object#equals}.
     *
     * @param o the object to search for
     * @return {@code true} if the object is present, {@code false} otherwise
     */
	public boolean contains(Object o) {
		ListElement current = first;

		while (current != null) {
			if (current.payload.equals(o))
				return true;
			current = current.next;
			
		}
		return false;
	}

	/**
     * Removes the first occurrence of the specified object from the list.
     * Comparison is performed using {@link Object#equals}.
     *  
     * @param o the object to remove
     * @return {@code true} if an element was removed, {@code false} if not found
     */
	public boolean remove(Object o) {
		// If list is empty, we don't remove anything
		if (isEmpty())
			return false;
		
		// special treatment for first element
		if (first.payload.equals(o)) {
			first = first.next;
			// important: End the function now
			return true;
		}
		
		ListElement current = first;
		ListElement previous = null;
		while (current != null) {
			if (current.payload.equals(o)) {
				// skip current element
				previous.next = current.next;
				return true;
			}
			previous = current;
			current = current.next;
			
		}
		return false;
	}

	
	/**
	 * Replaces the element at the specified index with the given value and
	 * returns the previously stored value.
	 *
	 * @param index   zero-based position of the element to replace
	 * @param element the new value to store at {@code index}
	 * @return the value previously stored at {@code index}, or {@code null}
	 *         if the index is out of bounds
	 */
	public T set(int index, T element) {
	    ListElement e = getElement(index);
	    if (e != null) {
	        T oldValue = e.payload;
	        e.payload = element;
	        return oldValue;
	    }
	    return null;
	}
	
	/**
     * Appends the specified value to the end of this list.
     *
     * @param value the value to add
     */
    public void add(T value) {
        ListElement newElement = new ListElement(value);
        if (first == null) {
            first = newElement;
        } else {
            last().next = newElement;
        }
    }
    	

	 /**
     * Removes and returns the element at the specified index.
     * Returns {@code null} if the index is out of bounds.
     * 
     * @param index zero-based position of the element to remove
     * @return the removed element's value, or {@code null} if out of bounds
     */
	public T remove(int index) {
		if (isEmpty())
			return null;
				
		// special treatment for first element
		if (index == 0) {
			T removedValue = first.payload;
			first = first.next;
			// important: End the function now
			return removedValue;
		}
		
		ListElement current = first;
		ListElement previous = null;		
		while (current != null) {
			if (index == 0) {
				T removedValue = current.payload;
				// move to next element
				previous.next = current.next;
				return removedValue;
			}
			previous = current;
			current = current.next;
			index--;
		}
		return null;
	}

	/**
     * Returns {@code true} if this list contains no elements.
     *
     * @return {@code true} if the list is empty
     */
	public boolean isEmpty() {
		return first == null;
	}

	/**
     * Removes all elements from this list. The list will be empty after this call.
     */
	public void clear() {
		first = null;
	}


	/**
	 * Internal method that iterates over the list, returning the last element
	 * (i.e., the one whose next field is null)
	 * 
	 * @return
	 */
	private ListElement last() {
		if (first == null)
			return null;
		ListElement current = first;

		while (current.next != null) {
			current = current.next;
		}
		return current;
	}

	/**
	 * Internal method to get the list element (not the value) of the list at the
	 * specified index position.
	 * 
	 * @param index
	 * @return
	 */
	private ListElement getElement(int index) {
		if (isEmpty())
			return null;
		ListElement current = first;
		while (current != null) {
			if (index == 0)
				return current;
			index--;
			current = current.next;
		}
		return null;
	}

}
