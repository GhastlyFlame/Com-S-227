	package cs228hw2.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import cs228hw2.AmusingLinkedList;

/**
 * Tests of SubLists. Test cases run on just about every method in List and
 * ListIterator, so if I happen to run tests on on a method you didn't implement, you
 * can disable the test using the "@Disabled" decorator, or delete it. I tried to
 * localize tests to each individual method as best as possible, however the most basic
 * methods like add(), remove(), size() etc. show up frequently. Note... I am not doing
 * any pointer testing here. I neglected too because I am assuming you are implementing
 * your sublist such that you aren't reinventing the wheel. In other words, if your remove
 * works on your AmusingLinkedList, I would hope that it works the same here. The main
 * thing to test with sublists is that changes to the sublist impact the parent list. 
 * 
 * @author Braedon Giblin (bgiblin@iastate.edu)
 *
 */
class SubListTests {
	public AmusingLinkedList<Integer> list;
	
	@BeforeEach
	void setUpBefore(){
		list = new AmusingLinkedList<Integer>();
		list.add(0);
		list.add(10);
		list.add(20);
		list.add(30);
		list.add(40);
		list.add(50);
		list.add(60);
		list.add(70);
		list.add(80);
		list.add(90);
		list.add(null);
	}
	
	@AfterEach
	void teardown() {
		list.clear();
	}

	@Test
	void testAddE() {
		List<Integer> a = list.subList(2, 4);
		
		assertEquals(20, (int)a.get(0));
		assertEquals(30, (int)a.get(1));
		assertThrows(IndexOutOfBoundsException.class, () -> {a.get(2);});
		
		assertTrue(a.add(99));
		assertEquals(12, list.size());
		assertEquals(0, (int)list.get(0));
		assertEquals(10, (int)list.get(1));
		assertEquals(20, (int)list.get(2));
		assertEquals(30, (int)list.get(3));
		assertEquals(99, (int)list.get(4));
		assertEquals(40, (int)list.get(5));
		
		assertEquals(3, a.size());
		assertEquals(20, (int)a.get(0));
		assertEquals(30, (int)a.get(1));
		assertEquals(99, (int)a.get(2));
		
		assertTrue(a.add(null));
		assertEquals(4, a.size());
		assertEquals(13, list.size());
		assertEquals(null, a.get(3));
		
	}

	@Test
	void testAddIntE() {
		List<Integer> a = list.subList(0, 4);
		
		assertEquals(0, (int)a.get(0));
		assertEquals(10, (int)a.get(1));
		assertEquals(4, a.size());
		assertThrows(IndexOutOfBoundsException.class, () -> {a.get(4);});
		
		
		a.add(0, 99);
		assertEquals(12, list.size());
		assertEquals(99, (int)list.get(0));
		assertEquals(00, (int)list.get(1));
		assertEquals(10, (int)list.get(2));
		assertEquals(20, (int)list.get(3));
		assertEquals(30, (int)list.get(4));
		assertEquals(40, (int)list.get(5));
		
		assertEquals(5, a.size());
		assertEquals(99, (int)a.get(0));
		assertEquals(00, (int)a.get(1));
		assertEquals(10, (int)a.get(2));
		assertEquals(30, (int)a.get(4));
		assertThrows(IndexOutOfBoundsException.class, () -> {a.get(5);});
		
		a.add(5, null);
		assertEquals(6, a.size());
		assertEquals(13, list.size());
		assertEquals(null, a.get(5));
		assertThrows(IndexOutOfBoundsException.class, () -> {a.get(6);});
		
		assertThrows(IndexOutOfBoundsException.class, () -> {a.add(7, 90);});
		assertThrows(IndexOutOfBoundsException.class, () -> {a.add(-1, 90);});
	}

	@Test
	void testAddAllCollectionOfQextendsE() {
		Integer[] data = {99, null, 50};
		Integer[] dataB = {};
		List<Integer> c = Arrays.asList(data);
		List<Integer> cB = Arrays.asList(dataB);
		List<Integer> a = list.subList(10, 11);
		
		assertEquals(null, a.get(0));
		assertEquals(1, a.size());
		assertThrows(IndexOutOfBoundsException.class, () -> {a.get(4);});
		
		
		a.addAll(c);
		assertEquals(14, list.size());
		assertEquals(0, (int)list.get(0));
		assertEquals(null, list.get(10));
		assertEquals(99, (int)list.get(11));
		assertEquals(null, list.get(12));
		assertEquals(50, (int)list.get(13));
		assertThrows(IndexOutOfBoundsException.class, () -> {list.get(14);});
		
		assertEquals(4, a.size());
		assertEquals(null, a.get(0));
		assertEquals(99, (int)a.get(1));
		assertEquals(null, a.get(2));
		assertEquals(50, (int)a.get(3));
		assertThrows(IndexOutOfBoundsException.class, () -> {a.get(4);});
		
		
		a.addAll(cB);
		assertEquals(4, a.size());
		assertEquals(14, list.size());
		assertEquals(50, (int)a.get(3));
		assertThrows(IndexOutOfBoundsException.class, () -> {a.get(6);});
	}

	@Test
	void testAddAllIntCollectionOfQextendsE() {
		Integer[] data = {99, null, 50};
		Integer[] dataB = {};
		List<Integer> c = Arrays.asList(data);
		List<Integer> cB = Arrays.asList(dataB);
		List<Integer> a = list.subList(0, 11);
		
		assertThrows(IndexOutOfBoundsException.class, () -> {a.addAll(-1, c);});
		assertThrows(IndexOutOfBoundsException.class, () -> {a.get(12);});
		
		assertEquals(0, (int)a.get(0));
		assertEquals(11, a.size());
		assertThrows(IndexOutOfBoundsException.class, () -> {a.get(11);});
		
		
		assertTrue(a.addAll(0, c));
		assertEquals(14, list.size());
		assertEquals(99, (int)list.get(0));
		assertEquals(50, (int)list.get(2));
		assertEquals(70, (int)list.get(10));
		assertEquals(80, (int)list.get(11));
		assertThrows(IndexOutOfBoundsException.class, () -> {list.get(14);});
		
		assertEquals(14, a.size());
		assertEquals(99, (int)a.get(0));
		assertEquals(null, a.get(1));
		assertEquals(50, (int)a.get(2));
		assertEquals(00, (int)a.get(3));
		assertEquals(null, a.get(13));		
		assertThrows(IndexOutOfBoundsException.class, () -> {a.get(14);});
		
		assertFalse(a.addAll(14, cB));
		assertEquals(14, a.size());
		assertEquals(14, list.size());
		assertEquals(50, (int)a.get(2));
		assertThrows(IndexOutOfBoundsException.class, () -> {a.get(14);});
		
		assertTrue(a.addAll(14, c));
		assertEquals(17, a.size());
		assertEquals(17, list.size());
		
		
	}

	@Test
	void testClear() {
		List<Integer> a = list.subList(0, 4);
		
		a.clear();
		assertEquals(0, a.size());
		assertEquals(7, list.size());
		assertEquals(40, (int)list.get(0));
		
		assertTrue(a.add(314));
		assertEquals(314, (int)a.get(0));
		assertEquals(314, (int)list.get(0));
		assertEquals(1, a.size());
		assertEquals(8, list.size());
	}

	@Test
	void testContains() {
		List<Integer> a = list.subList(8, 11);
		
		assertTrue(a.contains(80));
		assertFalse(a.contains(70));
		assertTrue(a.contains(null));
		a.remove(null);
		assertFalse(a.contains(null));
		
	}

	@Test
	void testContainsAll() {
		List<Integer> a = list.subList(8, 11);
		Integer[] data = {90, null};
		List<Integer> li = Arrays.asList(data);
		Integer[] dataB = {70, null};
		List<Integer> liB = Arrays.asList(dataB);
		Integer[] dataC = {98, 99};
		List<Integer> liC = Arrays.asList(dataC);
		
		assertTrue(a.containsAll(li));
		assertFalse(a.containsAll(liB));
		a.remove(null);
		assertFalse(a.containsAll(li));
		assertFalse(a.containsAll(liC));
	}

	@Test
	void testGet() {
		List<Integer> a = list.subList(8, 11);
		
		assertEquals(80, (int)a.get(0));
		assertEquals(90, (int)a.get(1));
		assertEquals(null, a.get(2));
		assertThrows(IndexOutOfBoundsException.class, () -> {a.get(3);});
		assertThrows(IndexOutOfBoundsException.class, () -> {a.get(-1);});
	}

	@Test
	void testIndexOf() {
		list.add(90);
		List<Integer> a = list.subList(8, 12);
		
		assertEquals(-1, a.indexOf(50));
		assertEquals(1, a.indexOf(90));
		assertEquals(2, a.indexOf(null));
		
		
	}

	@Test
	void testIsEmpty() {
		List<Integer> a = list.subList(8, 11);
		List<Integer> b = list.subList(11, 11);
		
		assertFalse(a.isEmpty());
		assertTrue(b.isEmpty());
		
		a.clear();
		assertTrue(a.isEmpty());
		
		a.add(5);
		assertFalse(a.isEmpty());
		a.remove(0);
		assertTrue(a.isEmpty());
	}

	@Test
	void testIterator() {
		List<Integer> a = list.subList(1, 4);
		
		Iterator<Integer> i = a.iterator();
		
		assertTrue(i.hasNext());
		assertEquals(10, (int)i.next());
		assertTrue(i.hasNext());
		assertEquals(20, (int)i.next());
		assertTrue(i.hasNext());
		assertEquals(30, (int)i.next());
		assertFalse(i.hasNext());
		assertThrows(NoSuchElementException.class, () -> {i.next();});
	}

	@Test
	void testLastIndexOf() {
		list.add(90);
		List<Integer> a = list.subList(8, 12);
		
		assertEquals(-1, a.lastIndexOf(50));
		assertEquals(3, a.lastIndexOf(90));
		assertEquals(2, a.lastIndexOf(null));
	}

	@Test
	void testListIterator() {
		List<Integer> a = list.subList(0, 3);
		ListIterator<Integer> li = a.listIterator();
		ListIterator<Integer> liB;
		
		assertTrue(li.hasNext());
		assertEquals(0, (int)li.next());
		assertTrue(li.hasNext());
		assertEquals(10, (int)li.next());
		assertTrue(li.hasNext());
		assertEquals(20, (int)li.next());
		assertFalse(li.hasNext());
		assertThrows(NoSuchElementException.class, () -> {li.next();});
		assertTrue(li.hasPrevious());
		assertEquals(20, (int)li.previous());
		assertTrue(li.hasPrevious());
		assertEquals(10, (int)li.previous());
		assertTrue(li.hasPrevious());
		assertEquals(0, (int)li.previous());
		assertFalse(li.hasPrevious());
		assertThrows(NoSuchElementException.class, () -> {li.previous();});
		
		liB = a.listIterator();
		
		assertEquals(0, liB.nextIndex());
		assertEquals(-1, liB.previousIndex());
		assertThrows(IllegalStateException.class, () -> {liB.set(10);});
		assertThrows(IllegalStateException.class, () -> {liB.remove();});
		liB.add(-10);
		assertEquals(-10, (int)a.get(0));
		assertEquals(-10, (int)list.get(0));
		assertEquals(0, (int)liB.next());
		assertEquals(12, list.size());
		liB.remove();
		assertEquals(-10, (int)a.get(0));
		assertEquals(-10, (int)list.get(0));
		assertThrows(IllegalStateException.class, () -> {liB.set(10);});
		assertThrows(IllegalStateException.class, () -> {liB.remove();});
		assertEquals(10, (int)liB.next());
		liB.set(50);
		assertEquals(50, (int)a.get(1));
		liB.set(60);
		assertEquals(60, (int)a.get(1));
		
		List<Integer> b = list.subList(3, 10);
		ListIterator<Integer> liC = b.listIterator();
		assertEquals(30, (int)liC.next());
		liC.remove();
		assertEquals(10, list.size());
		assertEquals(6, b.size());
		assertEquals(40, (int)list.get(3));
		assertEquals(40, (int)b.get(0));
	}

	@Test
	void testListIteratorInt() {
		// Assuming that if regular list iterator works, then a list iterator at a new index will also work.
		// Therefore, we will just smoke test the basic operations to ensure the positioning is correct
		
		List<Integer> a = list.subList(2, 6);
		ListIterator<Integer> li;
		
		li = a.listIterator(2);
		assertEquals(2, li.nextIndex());
		assertEquals(1, li.previousIndex());
		assertTrue(li.hasNext());
		assertEquals(40, (int)li.next());
		assertTrue(li.hasPrevious());
		assertEquals(40, (int)li.previous());
		
		li = a.listIterator(4);
		assertFalse(li.hasNext());
		assertTrue(li.hasPrevious());
		assertEquals(50, (int)li.previous());
		assertThrows(IndexOutOfBoundsException.class, () -> {a.listIterator(5);});
	}

	@Test
	void testRemoveObject() {
		list.add(90);
		list.add(90);
		
		List<Integer> a = list.subList(9, 13);
		
		assertEquals(4, a.size());
		assertEquals(13, list.size());
		
		assertEquals(90, (int)a.get(0));
		assertEquals(90, (int)list.get(9));
		a.remove(Integer.valueOf(90));
		assertEquals(null, a.get(0));
		assertEquals(null, list.get(9));
		assertEquals(3, a.size());
		assertEquals(12, list.size());
		assertFalse(a.remove(Integer.valueOf(10)));
	}

	@Test
	void testRemoveInt() {
		List<Integer> a = list.subList(8, 11);
		
		assertEquals(3, a.size());
		assertEquals(11, list.size());
		
		assertEquals(80, (int)a.get(0));
		assertEquals(80, (int)list.get(8));
		a.remove(1);
		assertEquals(null, a.get(1));
		assertEquals(null, list.get(9));
		assertEquals(2, a.size());
		assertEquals(10, list.size());
		
		assertThrows(IndexOutOfBoundsException.class, () -> {a.remove(2);});
	}

	@Test
	void testRemoveAll() {
		list.add(null);
		list.add(20);
		list.add(0);
		list.add(20);
		list.add(30);
		list.add(10);
		Integer[] data = {0, 20, null, 99};
		
		List<Integer> a = list.subList(0, 14);
		
		assertEquals(17, list.size());
		assertEquals(14, a.size());
		
		assertTrue(a.removeAll(Arrays.asList(data)));
		assertEquals(11, list.size());
		assertEquals(8, a.size());
		
		a.removeAll(null);
		assertEquals(11, list.size());
		assertEquals(8, a.size());
		
	}

	@Test
	void testRetainAll() {
		list.add(null);
		list.add(20);
		list.add(0);
		list.add(20);
		list.add(30);
		list.add(10);
		Integer[] data = {0, 20, null, 99};
		Integer[] dataB = {1, 21, 2, 99};
		
		List<Integer> a = list.subList(0, 14);
		
		assertEquals(17, list.size());
		assertEquals(14, a.size());
		
		assertTrue(a.retainAll(Arrays.asList(data)));
		assertEquals(9, list.size());
		assertEquals(6, a.size());
		
		assertEquals(0, (int)a.get(0));
		assertEquals(20, (int)a.get(1));
		assertEquals(null, a.get(2));
		assertEquals(null, a.get(3));
		assertEquals(20, (int)a.get(4));
		assertEquals(0, (int)a.get(5));
		
		assertEquals(0, (int)list.get(0));
		assertEquals(20, (int)list.get(1));
		assertEquals(null, list.get(2));
		assertEquals(null, list.get(3));
		assertEquals(20, (int)list.get(4));
		assertEquals(0, (int)list.get(5));
		assertEquals(20, (int)list.get(6));
		assertEquals(30, (int)list.get(7));
		assertEquals(10, (int)list.get(8));
		
		assertTrue(a.retainAll(Arrays.asList(dataB)));
		assertEquals(0, a.size());
		assertEquals(3, list.size());
		
		assertFalse(a.retainAll(list));
	}

	@Test
	void testSet() {
		List<Integer> a = list.subList(0, 6);
		
		assertEquals(6, a.size());
		assertEquals(11, list.size());
		
		assertEquals(30, (int)a.set(3, 33));
		assertEquals(33, (int)a.get(3));
		assertEquals(33, (int)list.get(3));
		assertEquals(6, a.size());
		assertEquals(11, list.size());
		
		a = list.subList(3, 6);
		
		assertEquals(40, (int)a.set(1, 44));
		assertEquals(44, (int)a.get(1));
		assertEquals(44, (int)list.get(4));
		assertEquals(3, (int)a.size());
		assertEquals(11, list.size());
	}

	@Test
	void testSize() {
		List<Integer> a = list.subList(0, 6);
		
		assertEquals(6, a.size());
		assertEquals(11, list.size());
		
		a.add(10);
		assertEquals(7, a.size());
		assertEquals(12, list.size());
		
		a.remove(3);
		assertEquals(6, a.size());
		assertEquals(11, list.size());
		
		a = list.subList(6, 6);
		assertEquals(0, a.size());
		
		a.add(0, 10);
		a.add(1, 10);
		assertEquals(2, a.size());
		assertEquals(13, list.size());
		a.addAll(list);
		assertEquals(15, a.size());
		assertEquals(26, list.size());
	}

	@Test
	void testSubList() {
		List<Integer> a = list.subList(0, 6);
		List<Integer> b = a.subList(0, 3);
		
		assertNotNull(a.subList(0, 6));
		assertNotNull(a.subList(5, 5));
		
		assertThrows(IndexOutOfBoundsException.class, () -> {a.subList(-1, 5);});
		assertThrows(IndexOutOfBoundsException.class, () -> {a.subList(0, 7);});
		assertThrows(IndexOutOfBoundsException.class, () -> {a.subList(6, 5);});
		
		b.add(0, 5);
		assertEquals(5, (int)list.get(0));
		assertEquals(5, (int)a.get(0));
		assertEquals(5, (int)b.get(0));
		
		list.set(0, 3);
		assertEquals(3, (int)list.get(0));
		assertEquals(3, (int)a.get(0));
		assertEquals(3, (int)b.get(0));
		
		assertEquals(12, list.size());
		assertEquals(7, a.size());
		assertEquals(4, b.size());
		
		b.remove(0);
		assertEquals(11, list.size());
		assertEquals(6, a.size());
		assertEquals(3, b.size());
		assertEquals(0, (int)list.get(0));
		assertEquals(0, (int)a.get(0));
		assertEquals(0, (int)b.get(0));
		
		List<Integer> c = b.subList(0, 2);
		c.add(22);
		assertEquals(12, list.size());
		assertEquals(7, a.size());
		assertEquals(4, b.size());
		assertEquals(3, c.size());
		assertEquals(22, (int)list.get(2));
		assertEquals(22, (int)a.get(2));
		assertEquals(22, (int)b.get(2));
		assertEquals(22, (int)c.get(2));
		
		// Assuming if we can make 3 sublists that all effect each other, we can make infinite
	}

	@Test
	void testToArray() {
		List<Integer> a = list.subList(0, 5);
		Integer[] expected = {0, 10, 20, 30, 40};
		Object[] out;

		out = a.toArray();
		assertArrayEquals(expected, out);
		a.remove(0);
		assertArrayEquals(expected, out);
	}

	@Test
	void testToArrayTArray() {
		List<Integer> a = list.subList(8, 11);
		
		Integer[] out = new Integer[3];
		a.toArray(out);
		Integer[] expected = {80, 90, null};
		assertArrayEquals(expected, out);
		a.remove(2);
		assertArrayEquals(expected, out);
		a.add(null);
		out = new Integer[1];
		out = a.toArray(out);
		assertArrayEquals(expected, out);
		a.add(99);
		Integer[] expectedB = {80, 90, null, 99, null, null, null, null, null, null};
		out = new Integer[10];
		Integer[] outB = a.toArray(out);
		assertArrayEquals(expectedB, out);
		assertArrayEquals(expectedB, outB);
	}

	@Test
	void testToString() {
		// Not entirely sure how toString() should work here... the returned sublist
		// does not necessarily need to be a linked list, this perhaps the another
		// implementation of toString() would suffice... however I decided to implement
		// sublist such that it mimics our linked list... and thus returns a result
		// in the same format (even though the node links are only theoretical, and not
		// actually the indicated values at all. However, this gives the best impression
		// that this is a sublist of our linked list (as otherwise, the printed indexes 
		// would not relate to our sublist at all).
		
		List<Integer> a = list.subList(0, 7);
		String expected = "0 6 1 0\n"
						+ "1 -1 2 10\n"
						+ "2 0 3 20\n"
						+ "3 -1 4 30\n"
						+ "4 2 5 40\n"
						+ "5 -1 6 50\n"
						+ "6 4 0 60";


		assertEquals(expected, a.toString());
		a.add(null);
		
		expected = "0 6 1 0\n"
			  	 + "1 -1 2 10\n"
				 + "2 0 3 20\n"
				 + "3 -1 4 30\n"
				 + "4 2 5 40\n"
				 + "5 -1 6 50\n"
				 + "6 4 7 60\n"
				 + "7 -1 0 null";
		
		
		assertEquals(expected, a.toString());
		
	}

}
