package edu.smith.cs.csc212.p7;

import java.util.ArrayList;
import java.util.List;

public class MergeSort {
	
	/**
	 * Merge two sorted lists to return one sorted list
	 * @param input1 - first sorted list
	 * @param input2 - second sorted list
	 * @return - returning a third, sorted combination of the inputs
	 */
	public static ArrayList<Integer> mergeSort(List<Integer> input1, List<Integer> input2) {
		ArrayList<Integer> merged = new ArrayList<>();
		while ( true ) {
			// if we run out of items in the first list, add all remaining items in the second list
			if ( input1.size() == 0 ) {
				merged.addAll(input2);
				break;
			}
			// if we run out of items in the second list, add all remaining items in the first list
			else if ( input2.size() == 0 ){
				merged.addAll(input1);
				break;
			}
			else {
				// if the front item in the first list is less than the front item in the second list, add the one in the first list to the merged one
				if ( input1.get(0) < input2.get(0) ) {
					merged.add( input1.get(0) );
					input1.remove(0);
				}
				// otherwise, add the front item in the second list to the merged one 
				else {
					merged.add( input2.get(0) );
					input2.remove(0);
				}
			}
		}
		// return the entire merged list
		return merged;
	}
	
	/**
	 * Sort a single list recursively by merging smaller lists within the main list
	 * Structure of code taken from "Data Structures and Algorithms in Java" by Drozdek
	 * 
	 * @param input - list to be sorted 
	 * @return a sorted list
	 */
	public static List<Integer> recursiveMerge(List<Integer> input) {
		ArrayList<Integer> merged = new ArrayList<>();
		// If the input list contains more than one element, split it into two lists and recursiveMerge both. 
		// Then, mergeSort the two resulting sorted lists
		if ( input.size() > 1 ) {
			int middle = input.size() / 2;
			
			List<Integer> left = recursiveMerge( new ArrayList<>(input.subList(0, middle))  );
			List<Integer> right = recursiveMerge( new ArrayList<>(input.subList(middle, input.size())) );

			return mergeSort( left, right ); 
		}
		
		// If the input is one element, it is already sorted. Return again
		else {
			return input;
		} 
		
	}
	
	/**
	 * Sort iteratively by first splitting the input into lists with one element each. This means each mini-list is sorted. 
	 * Then, mergeSort each mini-list until the result is the length of the original input
	 * 
	 * @param input - the list to be sorted 
	 * @return a sorted list
	 */
	public static List<Integer> iterativeMerge(List<Integer> input) {
		ArrayList<List<Integer>> littleLists = new ArrayList<>();
		
		// loop until we have one sorted list
		while( true ) {
			// break down the input list into lists with one element each until the input list is empty
			if ( input.size() > 0 ) {
				List<Integer> miniList = new ArrayList<Integer>();
				miniList.add(input.get(0));
				littleLists.add( miniList );
				input.remove(0);
			}
			
			else if ( input.size() == 0 ) {
				while( true ) {
					// until there is only one sorted sublist, mergeSort the first two sublists
					if ( littleLists.size() > 1 ) {
						List<Integer> firstList = new ArrayList<Integer>();
						firstList.addAll(littleLists.get(0));
						List<Integer> secondList = new ArrayList<Integer>();
						secondList.addAll(littleLists.get(1));
						
						List<Integer> newEntry = mergeSort(firstList, secondList);
						
						littleLists.remove( littleLists.get(0) );
						littleLists.remove( littleLists.get(0) );
						
						littleLists.add( newEntry );						
						
					}
					else {
						break;
					}
				}
				break;
			}
		}
		return littleLists.get(0);
	
	}
	
	/**
	 * mergeSort, but for doubly linked lists. Not much is different except for methods used to add to lists. 
	 * @param input1 - first sorted list
	 * @param input2 - second sorted list
	 * @return a sorted doubly linked list
	 */
	public static DoublyLinkedList<Integer> doubleMergeSort(DoublyLinkedList<Integer> input1, DoublyLinkedList<Integer> input2) {
		DoublyLinkedList<Integer> merged = new DoublyLinkedList<Integer>();
		while ( true ) {
			// if the first list is empty, add all remaining elements of the second list to the merged list. 
			if ( input1.size() == 0 ) {
				int i;
				for ( i = 0; i < input2.size(); i++ ) {
					merged.addBack(input2.getIndex(i));
				}
				break;
			}
			// if the second list is empty, add all remaining elements of the first list to the merged list. 
			else if ( input2.size() == 0 ){
				int i;
				for ( i = 0; i < input1.size(); i++ ) {
					merged.addBack(input1.getIndex(i));
				}
				break;
			}
			// if the front of the first list is smaller than the front of the second list, add it to the merged list.
			else {
				if ( input1.getFront() < input2.getFront() ) {
					merged.addBack( input1.getFront() );
					input1.removeFront();
				}
				// otherwise, add the front of the second list to the merged list
				else {
					merged.addBack( input2.getFront() );
					input2.removeFront();
				}
			}
		}
		return merged;
	}
	
	/**
	 * Iteratively sort a doubly linked list using the mergeSort technique
	 * @param input - list to be sorted
	 * @return a sorted doubly linked list
	 */
	public static DoublyLinkedList<Integer> doubleMerge(DoublyLinkedList<Integer> input) {
		// littleLists is a list of sorted lists. First it is all one element lists, but in the end it should contain one sorted list
		ArrayList<DoublyLinkedList<Integer>> littleLists = new ArrayList<>();
		while( true ) {
			// First, make tiny one-element lists of the elements within the input list until the input list is empty
			if ( input.size() > 0 ) {
				DoublyLinkedList<Integer> miniList = new DoublyLinkedList<Integer>();
				miniList.addBack(input.getFront());
				littleLists.add( miniList );
				input.removeFront();
			}
			// Once that is done, mergeSort the first two sorted lists until only one sorted list remains
			else if ( input.size() == 0 ) {
				while( true ) {
					if ( littleLists.size() > 1 ) {
						DoublyLinkedList<Integer> firstList = new DoublyLinkedList<Integer>();
						firstList = littleLists.get(0).copy();
						for ( int i = 0; i < firstList.size(); i++ ) {
						}
						DoublyLinkedList<Integer> secondList = new DoublyLinkedList<Integer>();
						secondList = littleLists.get(1).copy();
						for ( int i = 0; i < secondList.size(); i++ ) {
						}
						
						DoublyLinkedList<Integer> newEntry = doubleMergeSort(firstList, secondList);
						
						littleLists.remove( littleLists.get(0) );
						littleLists.remove( littleLists.get(0) );
						
						littleLists.add( newEntry );
						
						
					}
					else {
						break;
					}
				}
				break;
			}
		}
		return littleLists.get(0);
	}

}
