package edu.smith.cs.csc212.p7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class TestSorting {
	/**
	 * This is useful for testing whether sort algorithms work!
	 * @param items - the list of integers.
	 * @return true if it is sorted, false if not.
	 */
	private static boolean checkSorted(List<Integer> items) {
		for (int i=0; i<items.size()-1; i++) {
			if (items.get(i) > items.get(i+1)) {
				System.err.println("items out of order: "+items.get(i)+", "+items.get(i+1) + " at index="+i);
				return false;
			}
		}
		return true;
	}
	
	/**
	 * This tests whether a doubly linked list is sorted
	 * @param items - doubly linked list of integers
	 * @return true if sorted, false if not 
	 */
	private static boolean doubleCheckSorted(DoublyLinkedList<Integer> items) {
		for (int i=0; i<items.size()-1; i++) {
			if (items.getIndex(i) > items.getIndex(i+1)) {
				System.err.println("items out of order: "+items.getIndex(i)+", "+items.getIndex(i+1) + " at index="+i);
				return false;
			}
		}
		return true;
	}
	
	/**
	 * Here's some data!
	 */
	private static int[] data = {9,8,7,6,5,4,3,2,1};
	
	@Test
	public void testBubbleSort() {
		// See if the data can be reversed:
		ArrayList<Integer> sortMe = new ArrayList<>();
		for (int y : data) {
			sortMe.add(y);
		}
		BubbleSort.bubbleSort(sortMe);
		Assert.assertTrue(checkSorted(sortMe));
		
		// For good measure, let's shuffle it and sort it again to see if that works, too.
		Collections.shuffle(sortMe);
		BubbleSort.bubbleSort(sortMe);
		Assert.assertTrue(checkSorted(sortMe));
	}
	
	@Test
	public void testClassBubbleSort() {
		// See if the data can be reversed:
		ArrayList<Integer> sortMe = new ArrayList<>();
		sortMe.addAll(Arrays.asList(35, 88, 11, 47, 14, 24, 41, 62, 27));
		
		BubbleSort.bubbleSort(sortMe);
		Assert.assertTrue(checkSorted(sortMe));
	}
	
	@Test
	public void testSelectionSort() {
		// See if the data can be reversed:
		ArrayList<Integer> sortMe = new ArrayList<>();
		for (int y : data) {
			sortMe.add(y);
		}
		SelectionSort.selectionSort(sortMe);
		Assert.assertTrue(checkSorted(sortMe));
		
		// For good measure, let's shuffle it and sort it again to see if that works, too.
		Collections.shuffle(sortMe);
		SelectionSort.selectionSort(sortMe);
		Assert.assertTrue(checkSorted(sortMe));
	}
	
	@Test
	public void testClassSelectionSort() {
		// See if the data can be reversed:
		ArrayList<Integer> sortMe = new ArrayList<>();
		sortMe.addAll(Arrays.asList(35, 88, 11, 47, 14, 24, 41, 62, 27));
		
		SelectionSort.selectionSort(sortMe);
		Assert.assertTrue(checkSorted(sortMe));
	}

	@Test
	public void testInsertionSort() {
		// See if the data can be reversed:
		ArrayList<Integer> sortMe = new ArrayList<>();
		for (int y : data) {
			sortMe.add(y);
		}
		InsertionSort.insertionSort(sortMe);
		Assert.assertTrue(checkSorted(sortMe));
		
		// For good measure, let's shuffle it and sort it again to see if that works, too.
		Collections.shuffle(sortMe);
		InsertionSort.insertionSort(sortMe);
		Assert.assertTrue(checkSorted(sortMe));
	}
	
	@Test
	public void testClassInsertionSort() {
		// See if the data can be reversed:
		ArrayList<Integer> sortMe = new ArrayList<>();
		sortMe.addAll(Arrays.asList(35, 88, 11, 47, 14, 24, 41, 62, 27));
		
		InsertionSort.insertionSort(sortMe);
		Assert.assertTrue(checkSorted(sortMe));
	}

	@Test
	public void testMergeSort() {
		// See if the data can be reversed:
		int[] sorted1 = {1,3,5,6,7};
		int[] sorted2 = {2,4,5,8,11};
		
		ArrayList<Integer> sortMe1 = new ArrayList<>();
		ArrayList<Integer> sortMe2 = new ArrayList<>();
		for (int y : sorted1) {
			sortMe1.add(y);
		}
		for (int y : sorted2) {
			sortMe2.add(y);
		}
		
		ArrayList<Integer> merged = MergeSort.mergeSort(sortMe1, sortMe2);
		Assert.assertTrue(checkSorted(merged));
		
	}
	
	@Test
	public void testClassMergeSort() {
		// See if the data can be reversed:
		ArrayList<Integer> sortMe1 = new ArrayList<>();
		sortMe1.addAll(Arrays.asList(11, 14, 24, 27, 35, 41, 47, 62, 88));
		ArrayList<Integer> sortMe2 = new ArrayList<>();
		sortMe2.addAll(Arrays.asList(12, 13, 26, 29, 30, 45, 52, 70, 90));
		
		ArrayList<Integer> merged = MergeSort.mergeSort(sortMe1, sortMe2);
		Assert.assertTrue(checkSorted(merged));
	}

	@Test
	public void testRecursiveMergeSort() {
		// See if the data can be reversed:
		ArrayList<Integer> sortMe = new ArrayList<>();
		for (int y : data) {
			sortMe.add(y);
		}
		List<Integer> fixed = MergeSort.recursiveMerge(sortMe);
		Assert.assertTrue(checkSorted(fixed));
		
		//For good measure, let's shuffle it and sort it again to see if that works, too.
		Collections.shuffle(sortMe);
		List<Integer> fixed2 = MergeSort.recursiveMerge(sortMe);
		Assert.assertTrue(checkSorted(fixed2));
	}
	
	@Test
	public void testClassRecursiveMergeSort() {
		// See if the data can be reversed:
		ArrayList<Integer> sortMe = new ArrayList<>();
		sortMe.addAll(Arrays.asList(35, 88, 11, 47, 14, 24, 41, 62, 27));
		
		List<Integer> fixed = MergeSort.recursiveMerge(sortMe);
		Assert.assertTrue(checkSorted(fixed));
	}
	
	@Test
	public void testIterativeMergeSort() {
		// See if the data can be reversed:
		ArrayList<Integer> sortMe = new ArrayList<>();
		for (int y : data) {
			sortMe.add(y);
		}
		ArrayList<Integer> sortMe2 = new ArrayList<>();
		sortMe2.addAll(sortMe);
		
		List<Integer> fixed = MergeSort.iterativeMerge(sortMe);
		Assert.assertTrue(checkSorted(fixed));
		
		//For good measure, let's shuffle it and sort it again to see if that works, too.
		Collections.shuffle(sortMe2);
		List<Integer> fixed2 = MergeSort.iterativeMerge(sortMe2);
		Assert.assertTrue(checkSorted(fixed2));
	}
	
	@Test
	public void testClassIterativeMergeSort() {
		// See if the data can be reversed:
		ArrayList<Integer> sortMe = new ArrayList<>();
		sortMe.addAll(Arrays.asList(35, 88, 11, 47, 14, 24, 41, 62, 27));
		
		List<Integer> fixed = MergeSort.iterativeMerge(sortMe);
		Assert.assertTrue(checkSorted(fixed));
	}
	
	@Test
	public void testdoubleMergeSort() {
		// See if the data can be reversed:
		int[] sorted1 = {1,3,5,6,7};
		int[] sorted2 = {2,4,5,8,11};
		DoublyLinkedList<Integer> sortMe1 = new DoublyLinkedList<Integer>();
		DoublyLinkedList<Integer> sortMe2 = new DoublyLinkedList<Integer>();
		for ( int i : sorted1 ) {
			sortMe1.addBack(i);
		}
		for ( int i : sorted2 ) {
			sortMe2.addBack(i);
		}
		
		DoublyLinkedList<Integer> merged = MergeSort.doubleMergeSort(sortMe1, sortMe2);
		Assert.assertTrue(doubleCheckSorted(merged));
		
	}
	
	@Test
	public void testClassDoubleMergeSort() {
		// See if the data can be reversed:
		int[] sorted1 = {11, 14, 24, 27, 35, 41, 47, 62, 88};
		int[] sorted2 = {12, 13, 26, 29, 30, 45, 52, 70, 90};
		DoublyLinkedList<Integer> sortMe1 = new DoublyLinkedList<Integer>();
		DoublyLinkedList<Integer> sortMe2 = new DoublyLinkedList<Integer>();
		for ( int i : sorted1 ) {
			sortMe1.addBack(i);
		}
		for ( int i : sorted2 ) {
			sortMe2.addBack(i);
		}
		
		DoublyLinkedList<Integer> merged = MergeSort.doubleMergeSort(sortMe1, sortMe2);
		Assert.assertTrue(doubleCheckSorted(merged));
	}

	@Test
	public void testIterativeDoubleMergeSort() {
		// See if the data can be reversed:
		DoublyLinkedList<Integer> sortMe = new DoublyLinkedList<Integer>();
		for (int y : data) {
			sortMe.addBack(y);
		}
		DoublyLinkedList<Integer> sortMe2 = new DoublyLinkedList<Integer>();
		ArrayList<Integer> shuffled = new ArrayList<>();
		for (int y : data) {
			shuffled.add(y);
		}
		
		DoublyLinkedList<Integer> fixed = MergeSort.doubleMerge(sortMe);
		Assert.assertTrue(doubleCheckSorted(fixed));
		
		//For good measure, let's shuffle it and sort it again to see if that works, too.
		Collections.shuffle(shuffled);
		for (int y : shuffled) {
			sortMe2.addBack(y);
		}
		
		DoublyLinkedList<Integer> fixed2 = MergeSort.doubleMerge(sortMe2);
		Assert.assertTrue(doubleCheckSorted(fixed2));
	}
	
	@Test
	public void testClassIterativeDoubleMergeSort() {
		int[] needSort = { 35, 88, 11, 47, 14, 24, 41, 62, 27 } ;
		
		DoublyLinkedList<Integer> sortMe = new DoublyLinkedList<Integer>();
		for (int y : needSort) {
			sortMe.addBack(y);
		}
		
		DoublyLinkedList<Integer> fixed = MergeSort.doubleMerge(sortMe);
		for ( int i = 0; i < fixed.size(); i++ ) {
		}
		Assert.assertTrue(doubleCheckSorted(fixed));
	}
}


