/*
Job Sequencing

Given an array of jobs where every job has a deadline and profit if the job is finished
before the deadline. It is also given that every job takes a single unit of time, so the
minimum possible deadline for any job is 1. Maximize the total profit if only one job can
be scheduled at a time.

Job A = 4, 20
Job B = 1, 10
Job C = 1,40
Job D = 1,30

Ans: C, A

*/

package GreedyAlgo;

import java.util.*;

public class JobSequencing {
	static class Jobs {
		int id;
		int d;
		int p;
		
		Jobs(int id, int deadline, int profit) {
			this.id = id;
			this.d = deadline;
			this.p = profit;
		}
	}
	
	public static void jobSequence(int[][] jobsArray) {
		ArrayList<Jobs> jobs = new ArrayList<>();
		for (int i = 0; i < jobsArray.length; i++) {
			jobs.add(new Jobs(i, jobsArray[i][0], jobsArray[i][1]));
		}
		
		// Sorting Jobs in Descending order with respect to Profit
		jobs.sort((a, b) -> (b.p - a.p));
		
		int time = 0;
		int profit = 0;
		ArrayList<Integer> sequence = new ArrayList<>();
		for (Jobs curr : jobs) {
			if (time < curr.d) {
				++time;
				profit += curr.p;
				sequence.add(curr.id);
			}
		}
		System.out.print("Job Sequence: ");
		for (int i : sequence) {
			System.out.print(i + " ");
		}
		System.out.println();
		System.out.println("No. of Jobs: " + sequence.size());
		System.out.println("Profit: " + profit);
	}
	
	public static void main(String[] args) {
		int[][] jobsArray = {{4,20}, {1,10}, {1,40}, {1,30}};
		jobSequence(jobsArray);
	}
}