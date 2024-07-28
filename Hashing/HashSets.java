/*
Insert/Add, Search/Contains, Delete/Remove, all these take O(1) time
*/

package Hashing;

import java.util.HashSet;
import java.util.Iterator;

public class HashSets {
	public static void main(String[] args) {
		HashSet<Integer> s = new HashSet<>();
		
		// Add Elements
		s.add(1);
		s.add(2);
		s.add(3);
		s.add(4);
		
		
		// Search Element
		if (s.contains(2)) {
			System.out.println("Found 2");
		}
		
		if (!s.contains(6)) {
			System.out.println("Did not found 6");
		}
		
		// Remove Element
		s.remove(1);
		
		// Size of HashSet
		System.out.println("Size of HashSet: " + s.size());
		
		//Print HashSet
		System.out.println(s);
		
		s.add(1);
		
		//Iterator in HashSet
		Iterator<Integer> it = s.iterator();
		//noinspection WhileLoopReplaceableByForEach
		while(it.hasNext()) {
			System.out.print(it.next() + " ");
		}
		
		System.out.println();
		
		// Another way
		for (Integer i : s) {
			System.out.print(i + " ");
		}
	}
}