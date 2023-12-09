//Implementation of Array Lists

import java.util.ArrayList;
import java.util.Collections;

public class ArrayLists {
    public static void main(String args[]){
        ArrayList<Integer> list = new ArrayList<Integer>(); // To create ArrayList of Integers
        // ArrayList<String> list2 = new ArrayList<String>(); // To create ArrayList of Integers
        // ArrayList<Boolean> list3 = new ArrayList<Boolean>(); // To create ArrayList of Integers
        
        //ADD ELEMENT IN ARRAYLIST
        list.add(0);
        list.add(1); 
        list.add(3);
        System.out.println(list); 
        
        //GET AN ELEMENT
        System.out.println(list.get(0));
        System.out.println(list.get(2));
        
        //INSERT ELEMENT IN MIDDLE
        list.add(2, 2);
        System.out.println(list);
        
        //SET AN ELEMENT BY REPLACING AN ELEMENT
        list.set(0, 4);
        System.out.println(list);
        
        //DELETE AN ELEMENT 
        list.remove(0);
        System.out.println(list);
        
        //SIZE OF ARRAYLIST
        System.out.println(list.size());
        
        //LOOPS IMPLEMENTATION ON ARRAYLIST
        for (int i = 0; i<list.size(); i++){
            System.out.print(" " + list.get(i) + " ");
        }
        System.out.println();
        
        //SORT AN ARRAYLIST
        Collections.sort(list);
        System.out.println(list);
    }
}


