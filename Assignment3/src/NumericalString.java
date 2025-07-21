public class NumericalString {
	public static boolean legalNumericString(String s, int b) {
		if (b < 0 | b > 10)
			throw new IllegalArgumentException("Illegal number base");
		boolean ans = false;
		if ((s != null & s != "")) {
			int lastNumber = toInt(s.charAt(s.length() - 1));
			if (((lastNumber != 0) | (lastNumber == 0 & s.length() == 1))) {
				int c = 0;
				for (int i = 0; i < s.length(); i++)
					if (toInt(s.charAt(i)) < b & toInt(s.charAt(i)) >= 0)
						c++;
				if (c == s.length())
					ans = true;
			}
		}
		return ans;
	}

	public static String decimalIncrement(String s) {
		if (!legalNumericString(s, 10))
			throw new IllegalArgumentException("'s' doesnt represent legal number");
		String ans = "";
		int n = toInt(s.charAt(0));
		if (n < 9)
			ans = (n + 1) + s.substring(1);
		else {
			if (s.length() == 1)
				ans = "01";
			else
				ans = 0 + decimalIncrement(s.substring(1));
		}

		return ans;
	}

	public static String decimalDouble(String s) {
		if (!legalNumericString(s, 10))
			throw new IllegalArgumentException("'s' doesnt represent legal number at the base of 10");
		String ans = "";
		ans = stringMultiply(s, 2);
		return ans;
	}

	public static String binary2Decimal(String s) {
		String ans = "";
		ans = otherBase2Decimal(s, 2);
		return ans;
	}

	public static String octal2Decimal(String s) {
		String ans = "";
		ans = otherBase2Decimal(s, 8);
		return ans;
	}
	
	public static int toInt(char c) {
		return "0123456789".indexOf(c);
	}
	
	public static void main(String[] args) {
		
	}
	
	
	//I wrote these recursive String functions to help me in Tasks 3.3, 3.4, 3.5;
	//From what I understood the functions are allowed to deal only with strings with no int values calculations
	//in order to calculate big numbers calculations.
	//-----------------------------------------------------------------------------
	public static String stringMultiply(String s, int mult) {
		return stringMultiply(s, mult, 0);
	}
	
	public static String stringMultiply(String s, int mult, int r) {
		String ans = "";
		int n = toInt(s.charAt(0));
		int newResult = n * mult + r;
		if (s.length() == 1) {
			ans = "0";
			for (int i = 0; i < newResult; i++)
				ans = decimalIncrement(ans);
		} else {
			r = newResult / 10;
			ans = newResult % 10 + stringMultiply(s.substring(1), mult, r);
		}
		return ans;
	}

	public static String stringAdd(String s1, String s2) {
		String output = "";
		String longString = s1;  // for now assumes the string are in the same length
		String shortString = s2; // for now assumes the string are in the same length
		if (s1.length() != s2.length())
			if (s1.length() > s2.length()) {
				longString = s1;
				shortString = s2;
			}
			else
			{
				longString = s2;
				shortString = s1;
			}
		
		while (shortString.length() != longString.length())
			shortString = shortString + "0";
		int sLength = shortString.length();
		int r = 0;
		for (int i=0; i<sLength; i++) {
			int digit1 = toInt(longString.charAt(i));
			int digit2 = toInt(shortString.charAt(i));
			int digitSum = digit1 + digit2 + r;
			r = digitSum/10;
			output = output + digitSum%10;
		}
		if (r!=0) 
			output = output + r;
		
		return output;
	}

	public static String otherBase2Decimal(String s, int base) {
		if (!legalNumericString(s, base))
			throw new IllegalArgumentException("'s' doesnt represent legal number at the base of " + base);
		String ans = "0";
		String power = "1";
		for(int i=0; i<s.length(); i++) {
			String toAdd = stringMultiply(power, toInt(s.charAt(i)));
			ans = stringAdd(ans, toAdd);
			power = stringMultiply(power, base);
			}
		return ans;
	}

}

