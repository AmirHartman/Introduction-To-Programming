import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Iterator;

public class BitList extends LinkedList<Bit> {
    private int numberOfOnes;

    // Do not change the constructor
    public BitList() {
        numberOfOnes = 0;
    }

    // Do not change the method
    public int getNumberOfOnes() {
        return numberOfOnes;
    }

//----------write your code BELOW this line only!!!---------------------------------------------------------

//=========================== Intro2CS 2024/1, ASSIGNMENT 4, TASK 2.1 ================================================

    public void addLast(Bit element) {
    	if (element == null)
    		throw new IllegalArgumentException("You cannot add null to BitList");
    	if (element.toInt() == 1)
    		numberOfOnes++;
    	super.addLast(element);
    }

    public void addFirst(Bit element) {
    	if (element == null)
    		throw new IllegalArgumentException("You cannot add null to BitList");
    	if (element.toInt() == 1)
    		numberOfOnes++;
    	super.addFirst(element);
    }

    public Bit removeLast() {
    	if (size() == 0)
    		throw new NoSuchElementException("Nothing to remove from list");
    	Bit removed = super.removeLast();
    	if (removed.toInt() == 1)
    		numberOfOnes--;
    	return removed;
    }

    public Bit removeFirst() {
    	if (size() == 0)
    		throw new NoSuchElementException("Nothing to remove from list");
    	Bit removed = super.removeFirst();
    	if (removed.toInt() == 1)
    		numberOfOnes--;
    	return removed;
    }

    //=========================== Intro2CS 2024/1, ASSIGNMENT 4, TASK 2.2 ================================================
    public String toString() {
    	String output = ">";
    	for (Bit currBit : this)
    		output = currBit.toString() + output;
    	output = "<" + output;
    	return output;
    }


    //=========================== Intro2CS 2024/1, ASSIGNMENT 4, TASK 2.3 ================================================
    public BitList(BitList other) {
    	if (other == null | !(other instanceof BitList))
    		throw new IllegalArgumentException
    			("BitList copy constructor must get instance of (Bitlist != null)");
    	for (Bit bit : other)
    		addLast(bit);
    }

    //=========================== Intro2CS 2024/1, ASSIGNMENT 4, TASK 2.4 ================================================
    public boolean isNumber() {
    	boolean output = false;
    	if (size() > 0)
    		output = true;
    	return output;
    }

    //=========================== Intro2CS 2024/1, ASSIGNMENT 4, TASK 2.5 ================================================
    public boolean isReduced() {
    	boolean output = false;
    	// || - is to be more efficient - no need to check other condition if size == 1
    	// && - is to not reach first of empty list
    	// no need to run this.isNumber because we check all ranges of size, if size == 0 return false.
    	if (size() == 1 || (size() > 1 && getLast().toInt() == 1)) 
    		output = true;
    	return output;
    }

    public void reduce() {
    	if (size() == 0)
    		throw new UnsupportedOperationException("Unable to reduce empty list");
    	while (!isReduced())
    		removeLast();
    }


    //=========================== Intro2CS 2024/1, ASSIGNMENT 4, TASK 2.6 ================================================
    public Bit shiftRight() {
    	Bit output = null;
    	if (size() != 0)
    		if (size() == 1) {
    			output = removeFirst();
    			addLast(Bit.ZERO);
    		}
    		else output = removeFirst();
    	return output;
    }

    public void shiftLeft() {
    	addFirst(Bit.ZERO);
    }

    //=========================== Intro2CS 2024/1, ASSIGNMENT 4, TASK 2.7 ================================================
    public void padding(int newLength) {
    	while (size() < newLength)
    		addLast(Bit.ZERO);
    }


//=========================== Private methods of your own ================================================  



//--------------write your code ABOVE this line only!!!---------------------------------------------------------

    //----------------------------------------------------------------------------------------------------------
    // The following overriding methods must not be changed.
    //----------------------------------------------------------------------------------------------------------
    public boolean add(Bit e) {
        throw new UnsupportedOperationException("Do not use this method!");
    }

    public void add(int index, Bit element) {
        throw new UnsupportedOperationException("Do not use this method!");
    }

    public Bit remove(int index) {
        throw new UnsupportedOperationException("Do not use this method!");
    }

    public boolean offer(Bit e) {
        throw new UnsupportedOperationException("Do not use this method!");
    }

    public boolean offerFirst(Bit e) {
        throw new UnsupportedOperationException("Do not use this method!");
    }

    public boolean offerLast(Bit e) {
        throw new UnsupportedOperationException("Do not use this method!");
    }

    public Bit set(int index, Bit element) {
        throw new UnsupportedOperationException("Do not use this method!");
    }

    public boolean remove(Object o) {
        throw new UnsupportedOperationException("Do not use this method!");
    }
}
