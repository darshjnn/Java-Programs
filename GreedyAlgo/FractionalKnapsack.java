/*
Fractional Knapsack

Given the weights and values of N items, put these items in a knapsack of
capacity W to get the maximum total value in the knapsack.

value [60, 100, 120]
weight [10, 20, 30]
w = 50
ans 240

*/

package GreedyAlgo;

import java.util.*;

public class FractionalKnapsack {
	public static int fractionalKnapsack(int[] weight, int[] value, int capacity) {
		double[][] ratio = new double[weight.length][2];
		for (int i = 0; i < weight.length; i++) {
			ratio[i][0] = i;
			ratio[i][1] = value[i] / (double) weight[i];
		}
		Arrays.sort(ratio, Comparator.comparingDouble(r -> r[1]));
		int profit = 0;
		int c = capacity;
		for (int i = (ratio.length - 1); i >= 0; i--) {
			int index = (int) ratio[i][0];
			if (c >= weight[index]) {
				c -= weight[index];
				profit += value[index];
			} else {
				profit += (int) (c * ratio[i][1]);
				break;
			}
		}
		return profit;
	}
	
	public static void main(String[] args) {
		int[] value = {60, 100, 120};
		int[] weight = {10, 20, 30};
		int capacity = 50;
		System.out.println(fractionalKnapsack(weight, value, capacity));
	}
}