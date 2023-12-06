public class KeypadCombinations {
    public static String[] keypad = {".", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx", "yz"};
    
    public static void printComb(String str, int index, String combination) {
        if (str.length() == index){
            System.out.println(combination);
            return;
        }
        
        for (int i = 0; i < keypad[str.charAt(index) - '0'].length(); i++){
            printComb(str, index + 1, combination + keypad[str.charAt(index) - '0'].charAt(i));
        }
    }
    public static void main(String[] args) {
        printComb("689", 0, "");
    }
}
