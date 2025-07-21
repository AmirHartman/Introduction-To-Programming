
public class RunFromHere {

	public static void main(String[] args) {
		int NUM_OF_PRIMES_TO_PRINT = 500;

		BinaryPrimesIterator bpi = new BinaryPrimesIterator();
//		System.out.println(bpi.next().toIntString()); // 2
//		System.out.println(bpi.next().toIntString()); // 3
//		System.out.println(bpi.next().toIntString()); // 5
//		System.out.print("Generated primes so far: ");
//		System.out.println(bpi.getNumberOfGeneratedPrimes().toIntString()); // 3
//		System.out.println("For loop…");
//		for (int i = 0; i < 8; i += 1) { bpi.next(); };
//		System.out.println("Genereated primes so far: ");
//		System.out.println(bpi.getNumberOfGeneratedPrimes().toIntString()); // 11
//		System.out.println(bpi.next().toIntString()); // 37
		
		for (int i=0; i<NUM_OF_PRIMES_TO_PRINT; i++) {
			BinaryNumber nextNumber = bpi.next();
			System.out.println("Decimal: "+nextNumber.toIntString()+" Binary: "+nextNumber);
		}
		System.out.println("Generated primes so far: ");
		System.out.println(bpi.getNumberOfGeneratedPrimes().toIntString()); // 3
		}
	
}
