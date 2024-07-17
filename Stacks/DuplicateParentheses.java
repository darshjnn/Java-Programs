/*
Duplicate Parentheses

Given a BALANCED expression, find if it contains duplicate parentheses or not. A set of
parentheses are duplicate if the same subexpression is surrounded by multiple
parentheses.

Return a true if it contains duplicates else return false.

example: (((a+(b)))+(c+d))   true

example: ((((a)+(b))+c+d))   true

example: ((a+b) + (c+d))    false

example: (((a+b)) + c)       true

*/

package Stacks;

import java.util.Stack;

public class DuplicateParentheses {
	public static boolean hasDuplicateParentheses(String s) {
		Stack<Character> stack = new Stack<>();
		for (char c : s.toCharArray()) {
			if (c == ')') {
				int count = 0;
				while (!stack.isEmpty() && stack.pop() != '(') {
					++count;
				}
				if (count < 1) {
					return true;
				}
			} else {
				stack.push(c);
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		String str = "((a + b) + (c + d))";
		System.out.println(hasDuplicateParentheses(str));
	}
}