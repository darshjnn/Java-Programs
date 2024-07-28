/*
We are given an infinite supply of denominations [1, 2, 5, 10, 20, 50, 100, 500, 2000].
Find min no. of coins/notes to make change for a value V.

V = 121
ans = 3 (100+20+1)

V = 590
ans = 4 (500+50+20+20)

*/

package GreedyAlgo;

public class IndianCoins {
    // Works only for Canonical Coin System
	public static int coinChange(int[] denomination, int amount) {
		int n = denomination.length;
		if (amount == 0) {
			return 0;
		}
		if (amount < denomination[0]) {
			return -1;
		}
		int coins = 0;
		for (int i = (n - 1); i >= 0; i--) {
			if (amount >= denomination[i]) {
				++coins;
				amount -= denomination[i];
				++i;
			}
		}
		if (coins == -1 || amount != 0) {
			return -1;
		}
		return coins;
	}
	
	public static void main(String[] args) {
		int[] denomination = {1, 2, 5, 10, 20, 50, 100, 500, 2000};
		int V = 590;
		System.out.println(coinChange(denomination, V));
	}
}