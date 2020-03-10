package main;

import java.util.ArrayList;
import java.util.Collections;

public class SortSearch {

	//2 sorts, 2 searches
	//make methods static and as general as possible
	//have the sort methods pass in an array of Comparable and the number of items in the array
	
	//selection sort
	public static ArrayList<Comparable> selectionSort(ArrayList<Comparable> a, int n) {
		for(int i=0; i<n-1; i++) {
			int max = i;
			for(int j=i+1; j<n; j++) {
				if(a.get(j).compareTo(a.get(max)) < 0) {
					max = j;
				}
			}
			if(max != i) {
				Comparable holder = a.get(max);
				a.set(max, a.get(i));
				a.set(i, holder);
			}
		}
		return a;
	}
	
	//insertion sort
	public static ArrayList<Comparable> insertionSort(ArrayList<Comparable> a, int n) {
		int hole;
		Comparable val;
		for(int i=1; i<n; i++) {
			hole = i;
			val = a.get(i);
			while(hole>0 && a.get(hole-1).compareTo(val)>0) {
				a.set(hole, a.get(hole-1));
				hole -= 1;
			}
			a.set(hole, val);
		}
		return a;
	}
	
	//sequential search
	public static ArrayList<Comparable> linearSearch(String n, ArrayList<Comparable> a, char c) {
		ArrayList<Comparable> result = new ArrayList<>();
		Comparable comp = null;
		for(int i=0; i<a.size(); i++) {
			switch(c) {
			case 'E':
				if(((Employee)(a.get(i))).equals(n)) {
					result.add(a.get(i));
				}
				break;
			case 'S':
				if(((Student)(a.get(i))).equals(n)) {
					result.add(a.get(i));
				}
				break;
			case 'W':
				if(((Widget)(a.get(i))).equals(n)) {
					result.add(a.get(i));
				}
				break;
			}
		}
		if(result.size()>0) {
			return result;
		}
		return null;
	}
	
	//binary search
	
}