package Strings;

public class ReversalOfStringUsingStringsBuilder {
    public static void main(String args[]){

        StringBuilder strb = new StringBuilder("Tony");

        for(int i=0; i<strb.length()/2; i++){

            char front = strb.charAt(i);
            char back = strb.charAt(strb.length()-i-1);

            strb.setCharAt(i, back);
            strb.setCharAt(strb.length()-i-1, front);

        }

        System.out.println(strb);
        
    }    
}
