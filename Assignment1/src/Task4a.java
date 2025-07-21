import java.util.Scanner;

public class Task4a {
	
	// input: n *1 < n <= MV      output: does n prime? (T/F)

	public static void main(String[] args) {
		Scanner scanner = new Scanner (System.in);
		System.out.println("Enter 'n'");
		int n = scanner.nextInt();
		boolean ans = true;
		
		
		for (int p = 2; p*p <= n & ans; p++) // & ans because if we found a divider we don't need to continue
			if (n%p == 0)    // if true it means that n is composite and not prime --> ans value changes
				ans = false;
		System.out.println(ans);
	}

}
