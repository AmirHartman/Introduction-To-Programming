import java.util.Scanner;

public class Task4e {

	public static void main(String[] args) {
		Scanner scanner = new Scanner (System.in);
		boolean ans = false;
		System.out.println("Enter 'n'");
		int n = scanner.nextInt();
		int r=1; // r for remainder
		int c=0; // c for count
				
		//next lines inspired by Task4d -- the explanations are in Task4d
		while (c<5 & r==1) // c *<* 5 because c starts at 0;  && because  
			{
			c++;
			int a = (int)( ( Math.random() * n-1) ) +1; //generates random number
			for (int i = 1; i < n; i++)                // == a^n-1%n
				r = ((r%n) * (a%n) ) % n;
			}
		if (r==1)
			ans = true; // if r is still 1 it means the loop broke because c=5 and we can declare that n is prime
			
		System.out.println(ans);
	}
}



