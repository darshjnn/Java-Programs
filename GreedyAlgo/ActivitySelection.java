/*
Activity Selection

You are given n activities with their start and end times. Select the maximum number of activities
that can be performed by a single person, assuming that a person can only work on a single
activity at a time. Activities are sorted according to end time.

start = [10, 12, 20]
end = [20, 25, 30]
ans: 2 (AO & A2)

*/

package GreedyAlgo;

import java.util.*;

public class ActivitySelection {
	//	End times are sorted
	public static ArrayList<Integer> activitySelectionSorted(int[] start, int[] end) {
		ArrayList<Integer> list = new ArrayList<>();
		int counter = 1;
		int lastSelection = start[0];
		list.add(0);
		for (int i = 1; i < start.length; i++) {
			if (start[i] >= lastSelection) {
				++counter;
				list.add(i);
				lastSelection = end[i];
			}
		}
		System.out.println("Maximum Activities that can be performed: " + counter);
		return list;
	}
	
	//	End times are not sorted
	//	Time Complexity: O(nlogn)
	public static ArrayList<Integer> activitySelectionUnsorted(int[] start, int[] end) {
		ArrayList<Integer> list = new ArrayList<>();
		int[][] activities = new int[start.length][3];
		for (int i = 0; i < start.length; i++) {
			activities[i][0] = i;
			activities[i][1] = start[i];
			activities[i][2] = end[i];
		}
		Arrays.sort(activities, Comparator.comparingInt(a -> a[2]));
		int counter = 1;
		list.add(activities[0][0]);
		int lastSelection = activities[0][2];
		for
		(int i = 1; i < activities.length; i++) {
			if (activities[i][1] >= lastSelection) {
				++counter;
				list.add(activities[i][0]);
				lastSelection = activities[i][2];
			}
		}
		System.out.println("Maximum Activities that can be performed: " + counter);
		return list;
	}
	
	public static void main(String[] args) {
		int[] start = {1, 3, 0, 5, 8, 5};
		int[] end = {2, 4, 6, 7, 9, 9};
		ArrayList<Integer> activity1 = activitySelectionSorted(start, end);
		System.out.println(activity1);
		System.out.println();
		int[] startUnsorted = {3, 1, 0, 5, 8, 5};
		int[] endUnsorted = {4, 2, 6, 7, 9, 9};
		ArrayList<Integer> activity2 = activitySelectionUnsorted(startUnsorted, endUnsorted);
		System.out.println(activity2);
	}
}