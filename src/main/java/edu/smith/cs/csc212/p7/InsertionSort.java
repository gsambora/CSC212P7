package edu.smith.cs.csc212.p7;

import java.util.ArrayList;
import java.util.List;

public class InsertionSort {

	/**
	 * Insertion list goes through elements of the original and adds them to a sorted list one at a time, finding the correct spot
	 * @param input - the list to be sorted
	 */
	public static void insertionSort(List<Integer> input) {
		ArrayList<Integer> sorted = new ArrayList<>();
		
		//loop until the original list is empty
		while(true) {
			int insert = input.get(0);
			// just add the first item to the sorted list because otherwise the for loop is ruined
			if ( sorted.size() == 0 ) {
				sorted.add( insert );
			}
			else { 
				// look for the correct spot in the sorted list
				for (int i=0; i<sorted.size(); i++) {
						// if this isn't the right spot and we aren't at the end of the list, move on
						if ( (insert > sorted.get(i)) && (i<(sorted.size()-1))){
							continue;
						}
						// if we made it to the end of the list, make this the last item
						else if ((insert > sorted.get(i)) && (i == (sorted.size()-1)) ) {
							sorted.add(i+1, insert);
							break;
						}
						// otherwise, just add
						else {
							sorted.add(i, insert);
							break;
						}
				}
			}
			// remove from original list after placing 
			input.remove(0);
			
			// if the original list is empty, stop
			if ( input.size() == 0 ) {
				input.addAll(sorted);
				break;
			} 
		}
	}

}
