package cs228hw2;

import java.util.Collection;
import java.util.List;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.ArrayList;

/**
 * @Author Haadi Majeed
 */

/**
 * The type Amusing linked list.
 *
 * @param <E> the type parameter
 */
public class AmusingLinkedList<E> implements List<E> {
    /**
     * First node
     */
    private Node head;
    /**
     * How big is the linked list
     */
    private int size;

    /**
     * Instantiates a new Amusing linked list.
     */
    public AmusingLinkedList() {
        head = null;
        size = 0;
    }

    /**
     * Appends the specified element to the end of this list (optional
     * operation).
     *
     * <p>Lists that support this operation may place limitations on what
     * elements may be added to this list.  In particular, some
     * lists will refuse to add null elements, and others will impose
     * restrictions on the type of elements that may be added.  List
     * classes should clearly specify in their documentation any restrictions
     * on what elements may be added.
     *
     * @param element to be appended to this list
     * @return {@code true} (as specified by {@link Collection#add})
     */
    @Override
    public boolean add(E element) {
        Node toAdd = new Node(null, head, element);
        if (size == 0) {
            toAdd.prev = toAdd;
            toAdd.next = toAdd;
            head = toAdd;
            size++;
            return true;
        }
        if (size % 2 == 0) {
            head.prev.next.next = toAdd;
            toAdd.prev = head.prev;
            toAdd.next = head;
            head.prev = toAdd;
        } else {
            head.prev.next = toAdd;
            toAdd.next = head;
        }
        size = Math.abs(size - -1);
        return true;
    }

    /**
     * Inserts the specified element at the specified position in this list
     * (optional operation).  Shifts the element currently at that position
     * (if any) and any subsequent elements to the right (adds one to their
     * indices).
     *
     * @param index index at which the specified element is to be inserted
     * @param elem element to be inserted
     */
    @Override
    public void add(int index, E elem) {
        if (index < 0 || index > size) throw new IndexOutOfBoundsException("index is out of bounds");

        Node curNode = head;
        int s = size;
        clear();
        for (int i = 0; i < (s + 1); i++) {
            if (i == index) {
                add(elem);
                continue;
            }
            add(curNode.data);
            curNode = curNode.next;
        }
    }

    /**
     * Appends all of the elements in the specified collection to the end of
     * this list, in the order that they are returned by the specified
     * collection's iterator (optional operation).  The behavior of this
     * operation is undefined if the specified collection is modified while
     * the operation is in progress.  (Note that this will occur if the
     * specified collection is this list, and it's nonempty.)
     *
     * @param arg0 collection containing elements to be added to this list
     * @return {@code true} if this list changed as a result of the call
     */
    @SuppressWarnings("unchecked")
	@Override
    public boolean addAll(Collection<? extends E> arg0) {
        if (arg0.size() == 0) return false;
        E[] objects = (E[]) arg0.toArray();
        for (int i = 0; i < objects.length; i++) {
            add(objects[i]);
        }
        return true;

    }

    /**
     * Inserts all of the elements in the specified collection into this
     * list at the specified position (optional operation).  Shifts the
     * element currently at that position (if any) and any subsequent
     * elements to the right (increases their indices).  The new elements
     * will appear in this list in the order that they are returned by the
     * specified collection's iterator.  The behavior of this operation is
     * undefined if the specified collection is modified while the
     * operation is in progress.  (Note that this will occur if the specified
     * collection is this list, and it's nonempty.)
     *
     * @param arg1 index at which to insert the first element from the
     *              specified collection
     * @param arg0 collection containing elements to be added to this list
     * @return {@code true} if this list changed as a result of the call
     */
    @SuppressWarnings("unchecked")
	@Override
    public boolean addAll(int arg0, Collection<? extends E> arg1) {
        if (arg1.size() <= 0 || arg1 == null) {
            return false;
        }

        int i = 0;
        for (Object o : arg1) {
            add(arg0 + (i), (E) o);
            i++;
        }

        return true;
    }

    /**
     * Removes all of the elements from this list (optional operation).
     * The list will be empty after this call returns.
     */
    @Override
    public void clear() {
        head = null;
        size = 0;
    }

    /**
     * Returns {@code true} if this list contains the specified element.
     * More formally, returns {@code true} if and only if this list contains
     * at least one element {@code e} such that
     * {@code Objects.equals(o, e)}.
     *
     * @param arg0 element whose presence in this list is to be tested
     * @return {@code true} if this list contains the specified element
     */
    @Override
    public boolean contains(Object arg0) {

        return indexOf(arg0) >= 0;
    }

    /**
     * Returns {@code true} if this list contains all of the elements of the
     * specified collection.
     *
     * @param  arg0 collection to be checked for containment in this list
     * @return {@code true} if this list contains all of the elements of the
     *         specified collection
     */
    @SuppressWarnings("unchecked")
	@Override
    public boolean containsAll(Collection<?> arg0) {
        for (int i = 0; i < arg0.size(); i++) {
            if (!contains(((List<E>) arg0).get(i)))
                return false;
        }
        return true;
    }

    /**
     * Returns the element at the specified position in this list.
     *
     * @param arg0 index of the element to return
     * @return the element at the specified position in this list
     */
    @Override
    public E get(int arg0) {
        Node curpos = head;
        for (int i = 0; i < arg0; i++) {
            curpos = curpos.next;
        }
        return curpos.getData();
    }

    /**
     * Returns the index of the first occurrence of the specified element
     * in this list, or -1 if this list does not contain the element.
     * More formally, returns the lowest index {@code i} such that
     * {@code Objects.equals(o, get(i))},
     * or -1 if there is no such index.
     *
     * @param arg0 element to search for
     * @return the index of the first occurrence of the specified element in
     */
    @Override
    public int indexOf(Object arg0) {
        try {
            if (isEmpty())
                throw new NullPointerException();
            Node curpos = head;
            for (int i = 0; i < size; i++) {
                if (curpos.data == arg0) return i;
                curpos = curpos.next;
            }
            return -1;
        } catch (Exception e) {
            return -1;
        }
    }

    /**
     * Returns {@code true} if this list contains no elements.
     *
     * @return {@code true} if this list contains no elements
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Returns an iterator over the elements in this list in proper sequence.
     *
     * @return an iterator over the elements in this list in proper sequence
     */
    @Override
    public Iterator<E> iterator() {
        AmusingListIterator iter = new AmusingListIterator();
        return iter;
    }

    /**
     * Returns the index of the last occurrence of the specified element
     * in this list, or -1 if this list does not contain the element.
     * More formally, returns the highest index {@code i} such that
     * {@code Objects.equals(o, get(i))},
     * or -1 if there is no such index.
     *
     * @param arg0 element to search for
     * @return the index of the last occurrence of the specified element in
     *         this list, or -1 if this list does not contain the element
     */
    @Override
    public int lastIndexOf(Object arg0) {
        if (isEmpty() || !contains(arg0))
            return -1;
//        if (arg0 == null)
//            throw new NullPointerException();
        Node curpos = head;
        int hit = -1;

        for (int i = 0; i < size; i++) {
            if (curpos.data == arg0) hit = i;
            curpos = curpos.next;
        }
        return hit;

    }

    /**
     * Returns a list iterator over the elements in this list (in proper
     * sequence).
     *
     * @return a list iterator over the elements in this list (in proper
     *         sequence)
     */
    @Override
    public ListIterator<E> listIterator() {
        return new AmusingListIterator();
    }

    /**
     * Returns a list iterator over the elements in this list (in proper
     * sequence), starting at the specified position in the list.
     * The specified index indicates the first element that would be
     * returned by an initial call to {@link ListIterator#next next}.
     * An initial call to {@link ListIterator#previous previous} would
     * return the element with the specified index minus one.
     *
     * @param arg0 index of the first element to be returned from the
     *        list iterator (by a call to {@link ListIterator#next next})
     * @return a list iterator over the elements in this list (in proper
     *         sequence), starting at the specified position in the list
     * @throws IndexOutOfBoundsException if the index is out of range
     *         ({@code index < 0 || index > size()})
     */
    @Override
    public ListIterator<E> listIterator(int arg0) {
        if (arg0 < 0 || arg0 > size) throw new IndexOutOfBoundsException("index is out of bounds");
        return new AmusingListIterator(arg0);
    }

    /**
     * Removes the element at the specified position in this list (optional
     * operation).  Shifts any subsequent elements to the left (subtracts one
     * from their indices).  Returns the element that was removed from the
     * list.
     *
     * @param arg0 the index of the element to be removed
     * @return the element previously at the specified position
     */
    @Override
    public boolean remove(Object arg0) throws NullPointerException {

    	boolean contains = false; // return value for remove
		Node curNode = head;
		int oldSize = size;
		clear(); // Rebuild the entire list
		for (int i = 0; i < oldSize; i++) {
			if (curNode.data != arg0) add(curNode.data); // if it isn't o, add it to new list
			else contains = true; // otherwise, do nothing but change `return value`

			curNode = curNode.next; // walk the list
		}
		return contains; //Do we gottem or nah?
    }

    /**
     * Removes the first occurrence of the specified element from this list,
     * if it is present (optional operation).  If this list does not contain
     * the element, it is unchanged.  More formally, removes the element with
     * the lowest index {@code i} such that
     * {@code Objects.equals(o, get(i))}
     * (if such an element exists).  Returns {@code true} if this list
     * contained the specified element (or equivalently, if this list changed
     * as a result of the call).
     *
     * @param arg0 element to be removed from this list, if present
     * @return {@code true} if this list contained the specified element
     */
    @Override
    public E remove(int arg0) {
        if (arg0 < 0 || arg0 >= size) {
            throw new IndexOutOfBoundsException();
        }
        // Must happen prior to the replacement
        Node curpos = head;
        for (int i = 0; i < arg0; i++) {
            curpos = curpos.next;
        }
        E replacedData = curpos.data;
        for (int i = arg0; i < size - 1; i++) {
            curpos.data = curpos.next.data;
            curpos = curpos.next;
        }
        Node newLastNode = null;
        if (size % 2 == 1) {
            head.prev = curpos.prev;
            newLastNode = head.prev.next;
        } else {
            newLastNode = head.prev;
        }
        newLastNode.next = head;
        size--;

        return replacedData;
    }

    /**
     * Removes from this list all of its elements that are contained in the
     * specified collection (optional operation).
     *
     * @param arg0 collection containing elements to be removed from this list
     * @return {@code true} if this list changed as a result of the call
     * @return {@code false} if this list has not changed as a result of the call
     */
    @Override
    public boolean removeAll(Collection<?> arg0) {
        if (arg0.size() <= 0 || arg0 == null) return false;

        ListIterator<E> li = listIterator();
        
        while (li.hasNext()) {
        	if (arg0.contains(li.next())) {
        		li.remove();
        	}
        }

        return true;
    }

    /**
     * Retains only the elements in this list that are contained in the
     * specified collection (optional operation).  In other words, removes
     * from this list all of its elements that are not contained in the
     * specified collection.
     *
     * @param arg0 collection containing elements to be retained in this list
     * @return {@code true} if this list changed as a result of the call
     */
    @SuppressWarnings("unchecked")
	@Override
    public boolean retainAll(Collection<?> arg0) {
        if (head == null) return false;
        Object[] retvals = new Object[size];
        Node curpos = head;
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (arg0.contains(curpos.data)) {
                retvals[count++] = curpos.data;
            }
            curpos = curpos.next;
        }
        clear();
        for (int i = 0; i < count; i++) {
            add((E) retvals[i]);
        }
        return true;
    }

    /**
     * Replaces the element at the specified position in this list with the
     * specified element (optional operation).
     *
     * @param arg0 index of the element to replace
     * @param arg1 element to be stored at the specified position
     * @return the element previously at the specified position
     * @throws IndexOutOfBoundsException if the index is out of range
     *         ({@code index < 0 || index >= size()})
     */
    @Override
    public E set(int arg0, E arg1) {
        if (arg0 > size - 1 || arg0 < 0) throw new IndexOutOfBoundsException();

        Node curNode = getNodeAtIndex(arg0);


        E returnStuff = curNode.data;
        curNode.data = arg1;
        return returnStuff;
    }

    /**
     * Returns the number of elements in this list.  If this list contains
     * more than {@code Integer.MAX_VALUE} elements, returns
     * {@code Integer.MAX_VALUE}.
     *
     * @return the number of elements in this list
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Returns a view of the portion of this list between the specified
     * {@code fromIndex}, inclusive, and {@code toIndex}, exclusive.  (If
     * {@code fromIndex} and {@code toIndex} are equal, the returned list is
     * empty.)  The returned list is backed by this list, so non-structural
     * changes in the returned list are reflected in this list, and vice-versa.
     * The returned list supports all of the optional list operations supported
     * by this list.<p>
     *
     * @param arg0 low endpoint (inclusive) of the subList
     * @param arg1 high endpoint (exclusive) of the subList
     * @return a view of the specified range within this list
     * @throws IndexOutOfBoundsException for an illegal endpoint index value
     *         ({@code fromIndex < 0 || toIndex > size ||
     *         fromIndex > toIndex})
     */
    @Override
    public List<E> subList(int arg0, int arg1) {
        if (arg0 > arg1 || arg1 > size || arg0 < 0) throw new IndexOutOfBoundsException();
        ArrayList<E> output = new ArrayList<E>();
        int i = 0;
        Node curpos = head;
        for (; i < arg0; i++) {
            curpos = curpos.next;
        }
        for (; i < arg1; i++) {
            output.add(curpos.data);
            curpos = curpos.next;
        }

        return output;
    }

    /**
     * Returns an array containing all of the elements in this list in proper
     * sequence (from first to last element).
     *
     * <p>The returned array will be "safe" in that no references to it are
     * maintained by this list.  (In other words, this method must
     * allocate a new array even if this list is backed by an array).
     * The caller is thus free to modify the returned array.
     *
     * <p>This method acts as bridge between array-based and collection-based
     * APIs.
     *
     * @return an array containing all of the elements in this list in proper
     *         sequence
     */
    @Override
    public Object[] toArray() {
        Object[] output = new Object[size];
        Node curpos = head;
        for (int i = 0; i < size; i++) {
            output[i] = curpos.data;
            curpos = curpos.next;
        }
        return output;
    }

    @SuppressWarnings("unchecked")
    /**
     * Returns an array containing all of the elements in this list in
     * proper sequence (from first to last element); the runtime type of
     * the returned array is that of the specified array.  If the list fits
     * in the specified array, it is returned therein.  Otherwise, a new
     * array is allocated with the runtime type of the specified array and
     * the size of this list.
     *
     * @param a the array into which the elements of this list are to
     *          be stored, if it is big enough; otherwise, a new array of the
     *          same runtime type is allocated for this purpose.
     * @return an array containing the elements of this list
     */

    @Override
    public <T> T[] toArray(T[] a) {

        if (a.length < size)
            a = (T[]) java.lang.reflect.Array.newInstance(
                    a.getClass().getComponentType(), size);

        Node curNode = head;
        for (int i = 0; i < size; i++) {
            a[i] = (T) curNode.data;
            curNode = curNode.next;
        }

        return a;
    }

    /**
     * Turns the entire linked list into a string to output, the format is as follows
     * (Index of current node) (Index of previous node) (index of next node) (current node's data)
     * @return builder a string with all the data
     *
     * Also have fun reading this, I wanted to commit toaster bath upon completion
     */
    public String toString() {
        String builder = ""; //Start of a something new
        Node curpos = head; //Wonder what this does
        for (int i = 0; i < size; i++) { //Go thru all nodes in the data struct
            builder += String.valueOf(i); //index of current node
            builder += " "; //space for formatting
            if (i == 0) { //prev index for 0th node
                if(size % 2 == 0) //is the list even?
                    builder += String.valueOf(size - 2);
                else builder += String.valueOf(size-1); //nop the list is odd
            } else if (i % 2 == 0) { //prev index link for even and not first element
                builder += String.valueOf((i - 2));
            } else { //prev index for odd and not first
                builder += "-1";
            }
            builder += " "; //space for formatting

            if (i == size - 1) { //next for end case
                builder += "0";
            } else { //otherwise the next is just current index + 1
                builder += String.valueOf(i + 1);
            }
            builder += " "; //space for formatting
            try { //attempt to add the data value
                builder += curpos.data.toString();
            } catch (NullPointerException e) { //will go into this if the element is null
                builder += "null";
            }
            builder += "\n"; //new line for next node

            curpos = curpos.next; //move on
        }
//        System.out.println(building + "\n \n");
        String output = builder.substring(0, builder.length() - 1); //remove the final line's "\n" character
//        System.out.println(output);
        return output;
        }



    /**
     * Gets node at index.
     *
     * @param n the n
     * @return the node at index
     */
    public Node getNodeAtIndex(int n) {
        if (isEmpty() || n > size) return null;
        Node curpos = head;
        for (int i = 0; i < n; i++) {
            curpos = curpos.next;
        }
        return curpos;
    }

    /**
     * The type Node.
     */
    public class Node {
        /**
         * The Next.
         */
        Node next;
        /**
         * The Prev.
         */
        Node prev;
        /**
         * The Data.
         */
        E data;

        /**
         * Instantiates a new Node.
         *
         * @param p the p
         * @param n the n
         * @param d the d
         */
        public Node(Node p, Node n, E d) {
            data = d;
            next = n;
            prev = p;
        }

        /**
         * Gets data.
         *
         * @return the data
         */
        @SuppressWarnings("unused")
        public E getData() {
            return data;
        }

        /**
         * Gets next.
         *
         * @return the next
         */
        @SuppressWarnings("unused")
        public Node getNext() {
            return next;
        }

        /**
         * Gets prev.
         *
         * @return the prev
         */
        @SuppressWarnings("unused")
        public Node getPrev() {
            return prev;
        }
    }

    /**
     * The type Amusing iterator.
     */
    public class AmusingIterator implements Iterator<E> {
        /**
         * The Pointy place.
         */
        protected int pointyPlace = 0;
        /**
         * The Last returned index.
         */
        protected int lastReturnedIndex = -1;

        /**
         * Instantiates a new Amusing iterator.
         */
        public AmusingIterator() {
        }

        @Override
        public boolean hasNext() {
            return head != null && pointyPlace < size;
        }

        @Override
        public E next() {
            if (head == null || pointyPlace >= size) {
                throw new NoSuchElementException("The list is empty or is out of data.");
            }

            return getNodeAtIndex(lastReturnedIndex = pointyPlace++).data;
        }

        @Override
        public void remove() {
            if (lastReturnedIndex < 0) {
                throw new IllegalStateException("This function cannot be called at this time.");
            }

            AmusingLinkedList.this.remove(lastReturnedIndex);
            pointyPlace = lastReturnedIndex;
            lastReturnedIndex = -1;
        }
    }

    /**
     * The type Amusing list iterator.
     */
    public class AmusingListIterator extends AmusingIterator implements ListIterator<E> {
        /**
         * Instantiates a new Amusing list iterator.
         */
        public AmusingListIterator() {
            super();
            pointyPlace = 0;
        }

        /**
         * Instantiates a new Amusing list iterator.
         *
         * @param index the index
         */
        public AmusingListIterator(int index) {
            super();
            pointyPlace = index;
        }

        @Override
        public boolean hasPrevious() {
            return head != null && pointyPlace > 0;
        }

        @Override
        public E previous() {
            if (head == null || pointyPlace > size || pointyPlace - 1 < 0) throw new NoSuchElementException("list is empty");

            return getNodeAtIndex(lastReturnedIndex = --pointyPlace).data;
        }

        @Override
        public int nextIndex() {
            return pointyPlace;
        }

        @Override
        public int previousIndex() {
            return pointyPlace - 1;
        }

        @Override
        public void set(E e) {
            if (lastReturnedIndex < 0) throw new IllegalStateException("can't call");

            AmusingLinkedList.this.set(lastReturnedIndex, e);
        }

        @Override
        public void add(E e) {
            int i = pointyPlace;
            AmusingLinkedList.this.add(i, e);
            pointyPlace = i + 1;
            lastReturnedIndex = -1;
        }
    }
}
