/*
Bit Operators:
	Binary AND &
	Binary OR |
	Binary XOR ^
	Binary One's Complement ~
	Binary Left Shift <<
	Binary Right Shift >>

*/

package BitManipulation;

public class BitOperators {
	public static void main(String[] args) {

//		Binary AND
		System.out.println(5 & 6);

//		Binary OR
		System.out.println(5 | 6);

//		Binary XOR
		System.out.println(5 ^ 6);

//		Binary 1's Complement
		System.out.println(~5);
		System.out.println(~0);

//		Binary Left Shift
//		a << b = a * (2^b)
		System.out.println(5 << 2);

//		Binary Right Shift
//		a >> b = a / (2^b)
		System.out.println(6 >> 1);
		
	}
}