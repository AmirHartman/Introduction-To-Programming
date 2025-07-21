import java.util.Scanner;

public class Task4b {

	public static void main(String[] args) {
		Scanner scanner = new Scanner (System.in);
		System.out.println("Enter 'n'");
		int n = scanner.nextInt();
		int ans = 0; // ans is the counter of prime numbers up to n (included)
		
		// go through each number [1< m <=n] and check if its a prime number
		for (int m=2; m<=n; m++) 
		{
			boolean isPrime = true;
			for(int p=2; p*p<=m & isPrime; p++)
				if (m%p == 0) 
					isPrime = false;
			if (isPrime)
				ans += 1;
		}
		System.out.println(ans);
	}

}
