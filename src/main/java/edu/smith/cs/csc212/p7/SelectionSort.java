package edu.smith.cs.csc212.p7;

import java.util.ArrayList;
import java.util.List;

public class SelectionSort {
	
	/**
	 * Selection sort gets the smallest item within the list and adds it to a new sorted list, working until the original list is empty.
	 * @param input - the list to be sorted.
	 */
	public static void selectionSort(List<Integer> input) {
		ArrayList<Integer> sorted = new ArrayList<>();
		
		// loop until the original list is empty
		while(true) {
			int N = input.size();
			int smallest = input.get(0);			
			for (int i=0; i<N; i++) {
					if ( smallest >= input.get(i) ){
						smallest = input.get(i);
					}
			}
			//add the smallest value to the sorted list and remove it from the original list 
			sorted.add(smallest);
			input.remove(input.indexOf(smallest));
			
			// if the original list is empty, add all of the values in the sorted list to it and end the loop
			if ( input.size() == 0 ) {
				input.addAll(sorted);
				break;
			} 
		}
	}
}
