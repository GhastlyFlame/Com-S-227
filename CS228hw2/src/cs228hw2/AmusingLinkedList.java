package cs228hw2;

import java.util.*;

//import java.awt.List;

public class AmusingLinkedList<E> implements List<E> {
    private Node head;
    private int size;

    public AmusingLinkedList() {
        head = null;
        size = 0;
    }


    @Override
    public boolean add(E element) {
        Node toAdd = new Node();
        toAdd.prev = null;
        toAdd.data = element;
        toAdd.next = head;
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
            head.prev = toAdd;
        } else {
            head.prev.next = toAdd;
        }
        size++;
        return true;
    }

    @Override
    public void add(int index, E item) {

        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException();
        int i = 0;
        Node curpos = head;
        add(null);
        for (; i < index; i++) {
            curpos = curpos.next;
        }
        E tempNow = curpos.data;
        curpos.data = item;
        for (; i < size; i++) {
            curpos = curpos.next;
            E tempNext = curpos.data;
            curpos.data = tempNow;
            tempNow = tempNext;
        }
        curpos.data = tempNow;
    }

    @Override
    public boolean addAll(Collection<? extends E> arg0) {
        if (arg0.size() == 0) return false;
        E[] objects = (E[]) arg0.toArray();
        for (int i = 0; i < objects.length; i++) {
            add(objects[i]);
        }
        return true;

    }

    @Override
    public boolean addAll(int arg0, Collection<? extends E> arg1) {
        int i = arg0;
//        for ()
        return false;
    }

    @Override
    public void clear() {
        head = null;
        size = 0;
    }

    @Override
    public boolean contains(Object arg0) {

        return indexOf(arg0) >= 0;
    }

    @Override
    public boolean containsAll(Collection<?> arg0) {
        for (int i = 0; i < arg0.size(); i++) {
            if (!contains(((List<E>) arg0).get(i)))
                return false;
        }
        return true;
    }

    @Override
    public E get(int arg0) {
        Node curpos = head;
        for (int i = 0; i < arg0; i++) {
            curpos = curpos.next;
        }
        return curpos.getData();
    }

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

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public Iterator<E> iterator() {
        // TODO Auto-generated method stub
        return null;
    }

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

    @Override
    public ListIterator<E> listIterator() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ListIterator<E> listIterator(int arg0) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean remove(Object arg0) {
        if (arg0 == null)
            throw new NullPointerException();
        if (contains(arg0))
            return false;
        int location = indexOf(arg0);
        Node curpos = head;
        int i = 0;
        for (; i < location; i++) {
            curpos = curpos.next; //to get to the one right before(?)
        }

        curpos.next = curpos.next.next;
        size--;
//then gotta reassign nodes that follow to be linked for prev correctly so gotta iterate thru the rest
        for (; i < size; i++) {
//do shit
        }
        return true;
    }


    @Override
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        // Must happen prior to the replacement
        Node curNode = head;
        for (int i = 0; i < index; i++) {
            curNode = curNode.next;
        }
        E replacedData = curNode.data;
        for (int i = index; i < size-1; i++) {
            curNode.data = curNode.next.data;
            curNode = curNode.next;
        }
        Node newLastNode = null;
        //Size is one greater than the last index value so this is if the last index is EVEN
        if (size % 2 == 1) {
            head.prev = curNode.prev;
            newLastNode = head.prev.next;
        } else {
            newLastNode = head.prev;
        }
        newLastNode.next = head;
        curNode = null;
//      Decrement size do to the loss of a node
        size--;
//        removeHelper(index);

        return replacedData;
    }


    @Override
    public boolean removeAll(Collection<?> arg0) {
        // TODO Auto-generated method stub
        size -= arg0.size();
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> arg0) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public E set(int arg0, E arg1) {
//        E output;
//        Node curpos = head;
//        for (int i = 0; i < arg0; i++) {
//            curpos = curpos.next;
//        }
//        output = curpos.getData();
//        curpos.data = arg1;
//
//        return output;
        if (arg0 > size - 1 || arg0 < 0) throw new IndexOutOfBoundsException();

        Node curNode = getNodeAtIndex(arg0);


        E returnStuff = curNode.data;
        curNode.data = arg1;
        return returnStuff;
    }

    @Override
    public int size() {
        return size;
    }

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

    @Override
    public <T> T[] toArray(T[] arg0) {
//        T[] output = new T[arg0.length];
        return null;
    }

    public Node getNodeAtIndex(int n) {
        if (isEmpty() || n > size) return null;
        Node curpos = head;
        for (int i = 0; i < n; i++) {
            curpos = curpos.next;
        }
        return curpos;
    }

    public class Node {
        Node next;
        Node prev;
        E data;

//		public Node() {
//			data = null;
//			prev = null;
//			next = null;
//		}

        @SuppressWarnings("unused")
        public E getData() {
            return data;
        }

        @SuppressWarnings("unused")
        public Node getNext() {
            return next;
        }

        @SuppressWarnings("unused")
        public Node getPrev() {
            return prev;
        }
    }

    public class AmsuingListIterator<E> implements ListIterator<E> {
        private Node curPos;

        private AmsuingListIterator() {
            curPos = head;
        }

        public boolean hasNext() {
            return curPos.next != head;
        }

        @SuppressWarnings("unchecked")
        public E next() {
            if (!hasNext())
                throw new NoSuchElementException();
            curPos = curPos.next;
            return (E) curPos.data;
        }

        public boolean hasPrevious() {
            return curPos != head;
        }

        @SuppressWarnings("unchecked")
        public E previous() {
            if (!hasPrevious())
                throw new NoSuchElementException();
            curPos = curPos.prev;
            return (E) curPos.next.data;
        }

        @Override
        public void add(E arg0) {
            // TODO Auto-generated method stub
            size++;
        }

        @Override
        public int nextIndex() {
            // TODO Auto-generated method stub
            return 0;
        }

        @Override
        public int previousIndex() {
            // TODO Auto-generated method stub
            return 0;
        }

        @Override
        public void remove() {
            // TODO Auto-generated method stub
            size--;

        }

        @Override
        public void set(E arg0) {
            // TODO Auto-generated method stub

        }
    }
}
