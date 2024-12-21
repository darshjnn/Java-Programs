/*
Bit Operations:
	1. Get i-th Bit
	2. Set i-th Bit
	3. Clear i-th Bit
	5. Update i-th Bit
	6. Clear last i-th Bit
	7. Clear range of Bits
*/

package BitManipulation;

public class BitOperation {
	// Get i-th Bit
	public static int getBit(int n, int index) {
		int bitMask = 1 << index;
		return (n & bitMask) == 0 ? 0 : 1;
	}
	
	// Set i-th Bit
	public static int setBit(int n, int index) {
		int bitMask = 1 << index;
		return n | bitMask;
	}
	
	// Clear i-th Bit
	public static int clearBit(int n, int index) {
		int bitMask = ~(1 << index);
		return n & bitMask;
	}
	
	// Update i-th Bit
	public static int updateBit(int n, int bit, int index) {
	/*
		Approach 1:
		
		if (bit == 0) {
			return clearBit(n, index);
		} else {
			return setBit(n, index);
		}

	*/
		
		// Approach 2:
		n = clearBit(n, index);
		int bitMask = bit << index;
		return n | bitMask;
	}
	
	// Clear Last i Bits
	public static int clearIBits(int n, int index) {
		int bitMask = (~0) << (index);
		return n & bitMask;
		
	}
	
	// Clear Range of Bits
	public static int clearRangeOfBits(int n, int start, int end) {
		int a = (~0) << (end + 1);
		int b = (1 << start) - 1;
		int bitMask = a | b;
		return n & bitMask;
	}
	
	public static void main(String[] args) {
		// Get Bit
		System.out.print("Get Bit: ");
		System.out.println(getBit(10, 3));
		
		// Set Bit
		System.out.print("Set Bit: ");
		System.out.println(setBit(10, 2));
		
		// Clear Bit
		System.out.print("Clear Bit: ");
		System.out.println(clearBit(10, 1));
		
		// Update Bit
		System.out.print("Update Bit: ");
		System.out.println(updateBit(10, 1, 2));
		
		// Clear Last i Bits
		System.out.print("Clear Last I Bits: ");
		System.out.println(clearIBits(10, 2));
		
		// Clear Range of Bits
		System.out.print("Update Range of Bits: ");
		System.out.println(clearRangeOfBits(10, 2, 4));
	}
}