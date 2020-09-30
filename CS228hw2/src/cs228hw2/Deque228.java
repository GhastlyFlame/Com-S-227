package cs228hw2;

/**
 * @author Haaaaaaadi Majeed 
 */

import java.util.*;


@SuppressWarnings("rawtypes")
public class Deque228<E> implements Deque<E> {

    private ArrayList<E> theDeQueue;

    public Deque228() {
        theDeQueue = new ArrayList<E>();
    }

    @Override
    public boolean isEmpty() {
        return theDeQueue.isEmpty();
    }

    @Override
    public Object[] toArray() {
        return theDeQueue.toArray();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return theDeQueue.toArray(a);
    }

    @Override
    public boolean containsAll(Collection c) {
        return theDeQueue.containsAll(c);
    }

    @SuppressWarnings("unchecked")
	@Override
    public boolean addAll(Collection c) {
        return theDeQueue.addAll(c);
    }

    @Override
    public boolean removeAll(Collection c) {
        return theDeQueue.removeAll(c);
    }

    @Override
    public boolean retainAll(Collection c) {
        return theDeQueue.retainAll(c);
    }

    @Override
    public void clear() {
        theDeQueue.clear();
    }

    @Override
    public void addFirst(E e) {
        theDeQueue.add(0 ,e);
    }

    @Override
    public void addLast(E e) {
        theDeQueue.add(e);
    }

    @Override
    public boolean offerFirst(E e) {
        theDeQueue.add(0 ,e);
        return true;
    }

    @Override
    public boolean offerLast(E e) {
        theDeQueue.add(e);
        return true;
    }

    @Override
    public E removeFirst() {
        if(theDeQueue.size() == 0)
            throw new NoSuchElementException();
        return theDeQueue.remove(0);
    }

    @Override
    public E removeLast() {
        if(theDeQueue.size() == 0)
            throw new NoSuchElementException();
        return theDeQueue.remove(theDeQueue.size() - 1);
    }

    @Override
    public E pollFirst() {
        return theDeQueue.remove(0);
    }

    @Override
    public E pollLast() {
        return theDeQueue.remove(theDeQueue.size() - 1);
    }

    @Override
    public E getFirst() {
        if(theDeQueue.size() == 0)
            throw new NoSuchElementException();
        return theDeQueue.get(0);
    }

    @Override
    public E getLast() {
        if(theDeQueue.size() == 0)
            throw new NoSuchElementException();
        return theDeQueue.get(theDeQueue.size() - 1);
    }

    @Override
    public E peekFirst() {
        return theDeQueue.get(0);
    }

    @Override
    public E peekLast() {
        return theDeQueue.get(theDeQueue.size() - 1);
    }

    @Override
    public boolean removeFirstOccurrence(Object o) {
        return theDeQueue.remove(o);
    }

    @Override
    public boolean removeLastOccurrence(Object o) {
        theDeQueue.remove(theDeQueue.lastIndexOf(o));
        return true;
    }

    @Override
    public boolean add(E e) {
        return theDeQueue.add(e);
    }

    @Override
    public boolean offer(E e) {
        return theDeQueue.add(e);
    }

    @Override
    public E remove() {
        if(theDeQueue.size() == 0)
            throw new NoSuchElementException();
        return theDeQueue.remove(0);
    }

    @Override
    public E poll() {
        return theDeQueue.remove(0);
    }

    @Override
    public E element() {
        if(theDeQueue.size() == 0)
            throw new NoSuchElementException();
        return theDeQueue.get(0);
    }

    @Override
    public E peek() {
        return theDeQueue.get(0);
    }

    @Override
    public void push(E e) {
        theDeQueue.add(0, e);
    }

    @Override
    public E pop() {
        if(theDeQueue.size() == 0)
            throw new NoSuchElementException();
        return theDeQueue.remove(0);
    }

    @Override
    public boolean remove(Object o) {
        return theDeQueue.remove(o);
    }

    @Override
    public boolean contains(Object o) {
        return theDeQueue.contains(o);
    }

    @Override
    public int size() {
        return theDeQueue.size();
    }

    @Override
    public Iterator<E> iterator() {
        return theDeQueue.iterator();
    }

    @Override
    public Iterator<E> descendingIterator() {
        return null;
    }
}