import java.util.Iterator;
import java.util.LinkedList;

public class BinaryPrimesIterator implements Iterator<BinaryNumber> {

    private BinaryNumber numberOfGeneratedPrimes;
    private LinkedList<BinaryNumber> primes;


    //Do not change this constructor
    public BinaryPrimesIterator() {
        this.primes = new LinkedList<>();
        this.numberOfGeneratedPrimes = new BinaryNumber('0');
        this.primes.add(new BinaryNumber('2'));     //the first prime number
    }

    //Do not change this method
    public BinaryNumber getNumberOfGeneratedPrimes() {
        return this.numberOfGeneratedPrimes;
    }

    //Do not change this method
    private void increaseNumberOfGeneratedPrimes() {
        this.numberOfGeneratedPrimes=numberOfGeneratedPrimes.add(new BinaryNumber('1'));
    }

    //Do not change this method
    @Override
    public boolean hasNext() {
        return true;
    }
    //----------write your code BELOW this line only!!!---------------------------------------------------------

    //=========================== Intro2CS 2024/1, ASSIGNMENT 4, TASK 4.1 ================================================
    @Override
    public BinaryNumber next() {
        // Do not remove or change the next two lines
        if (!hasNext())
            throw new RuntimeException("No more primes.");  // will never happen
        BinaryNumber lastPrime = primes.removeLast(); // using removeLast instead of primes.get(getNumberOfGeneratedPrimes()) because of efficiency
        primes.addLast(lastPrime); // adds back the prime we just removed 
        BinaryNumber bn1 = new BinaryNumber('1');
        BinaryNumber bn0 = new BinaryNumber('0');
        BinaryNumber nextPrime = lastPrime.add(bn1); // we need to check only from the last prime forward
        boolean nextPrimeHasFound = false;
        while (!nextPrimeHasFound) {
        	boolean isPrime = true;
        	Iterator<BinaryNumber> it = primes.iterator();
	        while (isPrime & it.hasNext()) {
        		if (nextPrime.mod(it.next()).equals(bn0))
        			isPrime = false;
	        }
	        if (isPrime) {
	        	increaseNumberOfGeneratedPrimes();
	        	primes.addLast(nextPrime);
	        	nextPrimeHasFound = true;
	        } 
	        else
	        	nextPrime = nextPrime.add(bn1);
        }
        return lastPrime;
    }

    
//=========================== Private methods of your own ================================================  



//--------------write your code ABOVE this line only!!!---------------------------------------------------------


}
