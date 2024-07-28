package Strings;
public class Strings {
    public static void main(String args[]) {
        String name1 = "Tony";
        String name2 = "Tony";
        
        if (name1.equals(name2)) {
            System.out.println("They are the same string");
        } 
        else {
            System.out.println("They are different strings");
        }
        
        // DO NOT USE == to check for string equality
        // Gives correct answer here
        if (name1 == name2) {
            System.out.println("They are the same string");
        } 
        else {
            System.out.println("They are different strings");
        }
        
        // Gives incorrect answer here
        if (new String("Tony") == new String("Tony")) {
            System.out.println("They are the same string");
        } 
        else {
            System.out.println("They are different strings");
        }

        //Substring
        String name = "TonyStark";
        System.out.println(name.substring(0, 4));

        //ParseInt Method of Integer class
        String str = "123";
        int number = Integer.parseInt(str);
        System.out.println(number);

        //ToString Method of String class
        int num1 = 123;
        String str2 = Integer.toString(num1);
        System.out.println(str2);
    }
}
