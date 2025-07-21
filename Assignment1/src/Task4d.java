import java.util.Scanner;

public class Task4d {
	
	// input: whole composite positive number 'n'
	// output: number of random rolls needed to find random number 'a' to fulfill  < a^n-1%n != 1 >  in the range [1,n-1]

	public static void main(String[] args) {
		Scanner scanner = new Scanner (System.in);
		int ans = 0;	
		System.out.println("Enter 'n'");
		int n = scanner.nextInt();
		int r=1; // r for remainder
				
		while (r==1) {
			ans++;  // random roll counter
			
			// using the formula from Task2    
			// range = n-1
			// range = max - min + 1  -->  min=1  -->  range=max  -->   ans = (int)(Math.random() * max) + 1;   max = n-1
			
			int a = (int)( ( Math.random() * n-1) ) +1;
			
			for (int i = 1; i < n; i++) // taken from Task4c == a^n-1%n
				r = ((r%n) * (a%n) ) % n;			
		}
		System.out.println(ans);

	}

}
