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
	public static ArrayList<Comparable> linearSearch(String n, ArrayList<Comparable> a, char c) throws FormatException {
		if(n.trim().equals("")) {
			throw new FormatException("Please enter search information in search box.");
		}
		ArrayList<Comparable> result = new ArrayList<>();
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
		throw new FormatException("Search unsuccessful.");
	}
	
	//binary search
	public ArrayList<Comparable> binarySearch(String n, ArrayList<Comparable> a, char c, Comparable input) throws FormatException {
		if(n.trim().equals("")) {
			throw new FormatException("Please enter search information in search box.");
		}
		ArrayList<Comparable> result = new ArrayList<>();
		ArrayList<Comparable> arr = new ArrayList<>(selectionSort(a, a.size()));
		int start = 0;
		int end = arr.size()-1;
		int mid = (end-start)/2;
		switch(c) {
		case 'E':
			while(start <= end) {
				if(((Employee)(arr.get(mid))).compareTo(input) < 0) {
					start = mid + 1;
				}
				else if(((Employee)(arr.get(mid))).compareTo(input) > 0) {
					end = mid - 1;
				}
				else {
					result.add(arr.get(mid));
					arr.remove(mid);
					start = 0;
					end = arr.size()-1;
					mid = (start+end)/2;
					continue;
				}
				mid = (start+end)/2;
			}
			break;
		case 'S':
			while(start <= end) {
				if(((Student)(arr.get(mid))).compareTo(input) < 0) {
					start = mid + 1;
				}
				else if(((Student)(arr.get(mid))).compareTo(input) > 0) {
					end = mid - 1;
				}
				else {
					result.add(arr.get(mid));
					arr.remove(mid);
					start = 0;
					end = arr.size()-1;
					mid = (start+end)/2;
					continue;
				}
				mid = (start+end)/2;
			}
			break;
		case 'W':
			while(start <= end) {
				if(((Widget)(arr.get(mid))).compareTo(input) < 0) {
					start = mid + 1;
				}
				else if(((Widget)(arr.get(mid))).compareTo(input) > 0) {
					end = mid - 1;
				}
				else {
					result.add(arr.get(mid));
					arr.remove(mid);
					start = 0;
					end = arr.size()-1;
					mid = (start+end)/2;
					continue;
				}
				mid = (start+end)/2;
			}
			break;
		}
		
		if(result.size()>0) {
			return result;
		}
		throw new FormatException("Search unsuccessful.");
	}
}