/*
LinkedHashMaps maintains the order of insertion of elements., which not in the case of HashMaps.
In TreeMaps, keys are sorted, due to which Time Complexity of insertion, deletion and getting the
element node is O(logn), which is O(1) or O(lambda) in case of HashMaps or LinkedHashMaps.

Worst Time Complexity of HashMaps can be O(n) in some rare cases when all the nodes are added on
the same bucket index. But, in most cases, it is O(1) or O(lambda).

Singly Linked Lists are used to implement HashMaps.
Doubly Linked Lists are used to implement LinkedHashMaps.
Red Black Trees are used to implement TreeMaps.
*/

package Hashing;

import java.util.*;

public class TreeMaps {
	public static void main(String[] args) {
		TreeMap<String, Integer> map = new TreeMap<>();
		map.put("B", 2);
		map.put("E", 5);
		map.put("C", 3);
		map.put("A", 1);
		map.put("D", 4);
		
		System.out.println(map);
		System.out.println();
		
		// Iterate
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}
		
		System.out.println();
		
		// Another way to Iterate
		Set<String> keys = map.keySet();
		for (String key : keys) {
			System.out.println(key + " : " + map.get(key));
		}
	}
}