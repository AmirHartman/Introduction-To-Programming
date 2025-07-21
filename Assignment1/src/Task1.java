import java.util.Scanner;

public class Task1 {

	public static void main(String[] args) {
		Scanner myScanner = new Scanner(System.in);
		// Variables scan
		System.out.println("Please enter the integers 'a', 'b', 'q', 'r'.");
		int a = myScanner.nextInt();
		int b = myScanner.nextInt();
		int q = myScanner.nextInt();
		int r = myScanner.nextInt();
		boolean ans = false; // Set to be false - might change later
		if (b>r & b!=0 & a == (q*b+r) ) // tests if the numbers make a integer divide and the reserve equation
			ans = true;
		System.out.println(ans);
	}

}
