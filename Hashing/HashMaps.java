package Hashing;

import java.util.*;

public class HashMaps {
	public static void main(String[] args) {
		HashMap<String, Integer> map = new HashMap<>();
		
		// Insertion
		map.put("India", 120);
		map.put("France", 80);
		map.put("Germany", 50);
		
		System.out.println(map);
		
		// Update
		// map.put() creates new pair if the key is not present.
		// If the key is already present, then it updates that key with new value.
		map.put("France", 55);
		
		// Search or Lookup for key
		if (map.containsKey("India")) {
			System.out.println("Key is present");
		} else {
			System.out.println("Key is not present");
		}
		
		System.out.println();
		
		// Search or Lookup for value corresponding to yhe key
		System.out.println(map.get("India"));
		System.out.println(map.get("Indonesia"));
		
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
		
		System.out.println();
		
		// Removing key
		map.remove("India");
	}
}