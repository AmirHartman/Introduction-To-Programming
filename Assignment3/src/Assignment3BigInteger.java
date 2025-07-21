import java.math.BigInteger;
import java.util.Random;

class Assignment3BigInteger {

	public static BigInteger sumSmaller(BigInteger n) {
		BigInteger sum = new BigInteger("0");
		BigInteger i = new BigInteger("1");
		while (i.compareTo(n) == -1) {
			sum = sum.add(i);
			i = i.add(BigInteger.ONE);
		}
		return sum;
	}

	public static void printRandoms(int n) {
		Random r = new Random();
		for (int i = 0; i < n; i++)
			System.out.println(r.nextInt());
	}

	public static boolean isPrime(BigInteger n) {
		boolean ans = true;
		BigInteger i = new BigInteger("2");
		if (n.equals(BigInteger.ONE) | n.equals(BigInteger.ZERO))
			ans = false;
		else 
			while (ans & (i.multiply(i)).compareTo(n) <= 0) {
				if ((n.mod(i)).equals(BigInteger.ZERO))
					ans = false;
				i = i.add(BigInteger.ONE);
		}
		return ans;
	}

	public static BigInteger randomPrime(int n) {
		BigInteger randBig = new BigInteger("0");
		Random r = new Random();
		boolean primeGenerated = false;
		while (!primeGenerated) {
			BigInteger number = new BigInteger(n, r);
			if (isPrime(number)) {
				primeGenerated = true;
				randBig = number;
			}
		}

		return randBig;
	}

}