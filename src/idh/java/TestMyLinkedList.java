package idh.java;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestMyLinkedList {
	MyLinkedList<String> ll;

	@BeforeEach
	public void setUp() {
		ll = new MyLinkedList<String>();
	}

	@Test
	public void testClear() {
		ll.add("A");
		ll.add("B");
		ll.add("C");
		ll.add("D");
		assertFalse(ll.isEmpty());
		assertEquals(4, ll.size());
		ll.clear();
		assertTrue(ll.isEmpty());
		assertEquals(0, ll.size());
	}

	@Test
	public void testAdd() {
		assertEquals(0, ll.size());
		assertTrue(ll.isEmpty());

		// add to empty list
		ll.add("A");
		assertEquals("A", ll.get(0));

		// add to non-empty list
		ll.add("B");
		assertEquals("A", ll.get(0));
		assertEquals("B", ll.get(1));
		assertEquals(2, ll.size());

		// add at end of longer list
		ll.add("C");
		ll.add("D");
		ll.add("E");
		ll.add("F");

		assertEquals("A", ll.get(0));
		assertEquals("B", ll.get(1));
		assertEquals("C", ll.get(2));
		assertEquals("D", ll.get(3));
		assertEquals("E", ll.get(4));
		assertEquals("F", ll.get(5));
		assertEquals(6, ll.size());
	}

	@Test
	public void testGet() {
		
		// get from empty list
		assertEquals(null, ll.get(0));

		ll.add("A");
		ll.add("B");
		ll.add("C");
		ll.add("D");
		ll.add("E");
		ll.add("F");

		// get first element
		assertEquals("A", ll.get(0));

		// get middle element
		assertEquals("D", ll.get(3));

		// get last element
		assertEquals("F", ll.get(5));
		
		// get non-existing element 
		assertEquals(null, ll.get(25));

	}

	@Test
	public void testSize() {
		assertEquals(0, ll.size());
		ll.add("A");
		assertEquals(1, ll.size());
		ll.add("B");
		assertEquals(2, ll.size());
		ll.add("C");
		ll.add("D");
		ll.add("E");
		assertEquals(5, ll.size());
		ll.clear();
		assertEquals(0, ll.size());
	}

	@Test
	public void testContains() {
		ll.add("A");
		ll.add("B");
		ll.add("C");
		ll.add("D");
		ll.add("E");
		ll.add("F");
		assertTrue(ll.contains("C"));
		assertTrue(ll.contains("F"));
		assertTrue(ll.contains("A"));
		assertFalse(ll.contains("Z"));
	}

	@Test
	public void testRemoveByIndex() {
		ll.add("A");
		ll.add("B");
		ll.add("C");
		ll.add("D");

		// test removing the first element
		assertEquals("A", ll.remove(0));
		assertEquals(3, ll.size());

		// test removing the last element
		assertEquals("D", ll.remove(2));
		assertEquals(2, ll.size());

		// test removing a middle element
		ll.clear();
		ll.add("A");
		ll.add("B");
		ll.add("C");
		ll.add("D");
		assertEquals("B", ll.remove(1));
		assertEquals(3, ll.size());
	}

	@Test
	public void testRemoveByObject() {
		// remove from empty list
		assertFalse(ll.remove("A"));

		ll.add("A");
		ll.add("B");
		ll.add("C");
		ll.add("D");
		ll.add("E");

		// remove non-existing element from non-empty list
		assertFalse(ll.remove("F"));
		assertEquals(5, ll.size());

		// remove middle element
		assertTrue(ll.remove("C"));
		assertEquals(4, ll.size());

		// remove first element
		assertTrue(ll.remove("A"));
		assertEquals(3, ll.size());

		// remove last element
		assertTrue(ll.remove("E"));
		assertEquals(2, ll.size());
	}
}