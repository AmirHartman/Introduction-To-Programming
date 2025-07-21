
import java.util.Iterator;
import java.util.LinkedList;

import javax.management.RuntimeErrorException;

public class BinaryNumber implements Comparable<BinaryNumber> {

	private BitList bits;

	private static BinaryNumber Zero() {
		return new BinaryNumber(0);
	}

	private static BinaryNumber One() {
		return new BinaryNumber(1);
	}

	// Do not change this constructor
	private BinaryNumber(int i) {
		bits = new BitList();
		if (i == 0)
			bits.addFirst(Bit.ZERO);
		if (i == 1)
			bits.addFirst(Bit.ONE);
		else if (i != 0)
			throw new IllegalArgumentException("This Constructor may only get either zero or one.");
	}

	// Copy constructor
	// Do not change this constructor
	public BinaryNumber(BinaryNumber number) {
		bits = new BitList(number.bits);
	}

	// Do not change this method
	public int length() {
		return bits.size();
	}

	// Do not change this method
	public boolean isLegal() {
		return bits.isNumber() & bits.isReduced();
	}

	// ----------write your code BELOW this line
	// only!!!---------------------------------------------------------

	// =========================== Intro2CS 2024/1, ASSIGNMENT 4, TASK 3.1
	// ================================================
	public BinaryNumber(char c) {
		if (!(c >= '0' & c <= '9'))
			throw new IllegalArgumentException("Input char doesn't represent legal digit");
		this.bits = new BitList();
		bits.addFirst(Bit.ZERO);
		int counter = "0123456789".indexOf(c);
		for (int i = 0; i < counter; i++) {
			int oneBitsCounter = 0;
			while (bits.isNumber() && bits.removeFirst().equals(Bit.ONE))
				oneBitsCounter++;
			bits.addFirst(Bit.ONE);
			for (int j = 0; j < oneBitsCounter; j++)
				bits.shiftLeft();
		}
	}

	// =========================== Intro2CS 2024/1, ASSIGNMENT 4, TASK 3.2
	// ================================================
	public String toString() {
		// Do not remove or change the next two lines
		if (!isLegal()) // Do not change this line
			throw new RuntimeException("I am illegal.");// Do not change this line
		String output = "";
		BinaryNumber newInstanceOfThis = new BinaryNumber(this);
		while (newInstanceOfThis.bits.isNumber())
			output = newInstanceOfThis.bits.removeFirst() + output;
		return output;
	}

	// =========================== Intro2CS 2024/1, ASSIGNMENT 4, TASK 3.3
	// ================================================
	public boolean equals(Object other) {
		boolean isEqual = true;
		if (!(other instanceof BinaryNumber)) 
			isEqual = false;
		BinaryNumber otherBinary = (BinaryNumber)other;
		if (otherBinary.length() != this.length())
			isEqual = false;
		Iterator<Bit> it1 = bits.iterator();
		Iterator<Bit> it2 = otherBinary.bits.iterator();
		while (isEqual & it1.hasNext())
			if (!(it1.next().equals(it2.next())))
				isEqual = false;
		return isEqual;
	}

	// =========================== Intro2CS 2024/1, ASSIGNMENT 4, TASK 3.4
	// ================================================
	public BinaryNumber add(BinaryNumber addMe) {
		if (!(addMe instanceof BinaryNumber) | !addMe.isLegal())
			throw new IllegalArgumentException("The input does not represent legal BinaryNumber");
		int maxLength = Math.max(this.bits.size(), addMe.bits.size()) + 1;
		BinaryNumber result = null;
		BinaryNumber n1 = new BinaryNumber(this);
		BinaryNumber n2 = new BinaryNumber(addMe);
		n1.bits.padding(maxLength);
		n2.bits.padding(maxLength);
		Bit r = new Bit(0);
		for (int i = 0; i < maxLength; i++) {
			Bit b1 = n1.bits.removeFirst();
			Bit b2 = n2.bits.removeFirst();
			Bit sum = Bit.fullAdderSum(b1, b2, r);
			r = Bit.fullAdderCarry(b1, b2, r);
			if (result == null)
				result = new BinaryNumber(sum.toInt());
			else
				result.bits.addLast(sum);
		}
		result.bits.reduce();
		return result;
	}

	// =========================== Intro2CS 2024/1, ASSIGNMENT 4, TASK 3.5
	// ================================================
	public int compareTo(BinaryNumber other) {
		if (!other.isLegal())
			throw new IllegalArgumentException("The compared object is not legal instance of BinaryNumber");
		int result = 0;
		if (this.equals(other))
			result = 0; // reassigning 0 to skip all other tests (result = 0 is also used as condition
						// to continue the while loop)
		else if (bits.size() != other.bits.size())
			if (bits.size() > other.bits.size())
				result = 1;
			else
				result = -1;
		else {
			BinaryNumber n1 = new BinaryNumber(this);
			BinaryNumber n2 = new BinaryNumber(other);
			while (result == 0 & n1.bits.size() > 0) {
				int intBit1 = n1.bits.removeLast().toInt();
				int intBit2 = n2.bits.removeLast().toInt();
				if (intBit1 != intBit2) {
					if (intBit1 > intBit2)
						result = 1;
					else
						result = -1;
				}
			}
		}
		return result;
	}

	// =========================== Intro2CS 2024/1, ASSIGNMENT 4, TASK 3.6
	// ================================================
	public BinaryNumber subtract(BinaryNumber subtractMe) {
		if (!subtractMe.isLegal())
			throw new IllegalArgumentException("The input is not legal instance of BinarayNumber");
		if (this.compareTo(subtractMe) == -1)
			throw new IllegalArgumentException("The input must be smaller than the number you subtract from");
		BinaryNumber result = new BinaryNumber(0);
		result.bits.removeFirst(); // creates empty BinaryNumber
		BinaryNumber n1 = new BinaryNumber(this);
		BinaryNumber n2 = new BinaryNumber(subtractMe);
		if (bits.size() != subtractMe.bits.size())
			n2.bits.padding(n1.bits.size());
		while (n1.bits.size() > 0) {
			int intBit1 = n1.bits.removeFirst().toInt();
			int intBit2 = n2.bits.removeFirst().toInt();
			if (intBit1 - intBit2 >= 0)
				result.bits.addLast(new Bit(intBit1 - intBit2));
			else {
				int intNextBit = n1.bits.removeFirst().toInt();
				int zeroCounter = 0;
				while (intNextBit == 0) {
					intNextBit = n1.bits.removeFirst().toInt();
					zeroCounter++;
				}
				n1.bits.addFirst(Bit.ZERO);
				for (int i = 0; i < zeroCounter; i++)
					n1.bits.addFirst(Bit.ONE);
				result.bits.addLast(Bit.ONE);
			}
		}
		result.bits.reduce();
		return result;
	}

	// =========================== Intro2CS 2024/1, ASSIGNMENT 4, TASK 3.7
	// ================================================
	public int toInt() {
		// Do not remove or change the next two lines
		if (!isLegal()) // Do not change this line
			throw new RuntimeException("I am illegal.");// Do not change this line
		if (length() > 31)
			throw new RuntimeException("This binary number is too big to be presented as int type.");
		int result = 0;
		int i = 0;
		for (Bit bit : bits) {
			result += bit.toInt() * Math.pow(2, i);
			i++;
		}
		return result;
	}

	// =========================== Intro2CS 2024/1, ASSIGNMENT 4, TASK 3.8
	// ================================================
	public BinaryNumber multiply(BinaryNumber multiplyMe) {
		if (!multiplyMe.isLegal())
			throw new IllegalArgumentException("The input is not legal instance of BinarayNumber");
		BinaryNumber result = new BinaryNumber(0);
		result.bits.removeFirst(); // creates empty BinaryNumber
		BinaryNumber[] numbersToAdd = new BinaryNumber[multiplyMe.length()];
		int i = 0;
		for (Bit bitOfN2 : multiplyMe.bits) {
			BinaryNumber curr = new BinaryNumber(0);
			curr.bits.removeFirst(); // creates empty BinaryNumber
			for (int j = 0; j < i; j++)
				curr.bits.addLast(Bit.ZERO);
			for (Bit bitOfN1 : bits)
				curr.bits.addLast(new Bit(bitOfN1.toInt() * bitOfN2.toInt()));
			curr.bits.reduce();
			numbersToAdd[i] = curr;
			i++;
		}
		for (BinaryNumber number : numbersToAdd)
			result = result.add(number);
		result.bits.reduce();
		return result;
	}

	// =========================== Intro2CS 2024/1, ASSIGNMENT 4, TASK 3.9
	// ================================================
	public BinaryNumber divide(BinaryNumber divisor) {
		if (!divisor.isLegal())
			throw new IllegalArgumentException("The input is not legal instance of BinarayNumber");
		if (divisor.equals(Zero()))
			throw new RuntimeException("Dividing by 0 is not possible.");
		BinaryNumber result = new BinaryNumber(0);
		result.bits.removeFirst(); // creates empty BinaryNumber
		BinaryNumber copyOfThis = new BinaryNumber(this);
		BinaryNumber r = new BinaryNumber(0);
		r.bits.removeFirst(); // creates empty BinaryNumber
		while (copyOfThis.length() > 0) {
			r.bits.addFirst(copyOfThis.bits.removeLast());
			r.bits.reduce();
			if (r.compareTo(divisor) >= 0) {
				result.bits.addFirst(Bit.ONE);
				r = r.subtract(divisor);
			} else
				result.bits.addFirst(Bit.ZERO);
		}
		result.bits.reduce();
		return result;
	}

	// =========================== Intro2CS 2024/1, ASSIGNMENT 4, TASK 3.10
	// ================================================
	public BinaryNumber mod(BinaryNumber modulus) {
		if (!modulus.isLegal())
			throw new IllegalArgumentException("The input is not legal instance of BinarayNumber");
		BinaryNumber result = this.divide(modulus);
		result = result.multiply(modulus);
		result = this.subtract(result);
		result.bits.reduce();
		return result;
	}

	// =========================== Intro2CS 2024/1, ASSIGNMENT 4, TASK 3.11
	// ================================================
	public BinaryNumber(String s) {
		if (!stringIsNumber(s))
			throw new IllegalArgumentException("The string does not represent legal number");
		BinaryNumber output = Zero();
		BinaryNumber base = new BinaryNumber('9');
		base = base.add(One()); // creating BinaryNumber which its value is (Decimal)10 --> (Binary)1010
		BinaryNumber power = One();
		for (int i=s.length()-1; i>=0; i--) { // start from i=s.length-1 because charAt(i) is LSB
			BinaryNumber currCharAsBinary = new BinaryNumber(s.charAt(i));
			currCharAsBinary = currCharAsBinary.multiply(power);
			output = output.add(currCharAsBinary);
			power = power.multiply(base);
		}
		bits = output.bits;
	}

	// =========================== Intro2CS 2024/1, ASSIGNMENT 4, TASK 3.12
	// ================================================
	public String toIntString() {
		// Do not remove or change the next two lines
		if (!isLegal()) // Do not change this line
			throw new RuntimeException("I am illegal.");// Do not change this line
		String output = "";		
		BinaryNumber base = new BinaryNumber("10");
		BinaryNumber copyOfThis = new BinaryNumber(this);
		while (copyOfThis.compareTo(Zero()) > 0) {
			output =  copyOfThis.mod(base).toInt() + output;
			copyOfThis = copyOfThis.divide(base);
		}
		return output;
	}

//=========================== Private methods of your own ================================================  


	// checks if the String represents legal number
	private static boolean stringIsNumber(String s) {
		if (!(allCharsAreNumbers(s)))
			throw new IllegalArgumentException("Not all the chars in the string are numbers.");
		return s.charAt(0) != '0';
	}

	// checks if all characters in the String s are numbers
	private static boolean allCharsAreNumbers(String s) {
		boolean output = true;
		char[] allowedChars = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
		for (int i = 0; i < s.length(); i++) {
			boolean isCharAllowed = false;
			for (char aC : allowedChars)
				if (s.charAt(i) == aC)
					isCharAllowed = true;
			if (!isCharAllowed)
				output = false;
		}
		return output;
	}

//--------------write your code ABOVE this line only!!!---------------------------------------------------------

	// Returns this * 2
	// Do not change this method
	public BinaryNumber multiplyBy2() {
		BinaryNumber output = new BinaryNumber(this);
		output.bits.shiftLeft();
		output.bits.reduce();
		return output;
	}

	// Returns this / 2
	// Do not change this method
	public BinaryNumber divideBy2() {
		BinaryNumber output = new BinaryNumber(this);
		if (!equals(Zero()))
			output.bits.shiftRight();
		return output;
	}

}
