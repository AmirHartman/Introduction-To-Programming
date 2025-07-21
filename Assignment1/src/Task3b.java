import java.util.Scanner;

public class Task3b {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter 'n','k'");
		int n = scanner.nextInt();
		int k = scanner.nextInt();
		
		int ans;
		if (n == 0)
			ans = 1%k;
		else
		{
			ans = 2;
			for (int i=1; i<n;i++) // n is not included because ans is already 2^1
				ans = ((ans%k) * (2%k) ) % k; // parallel to [ ans = (ans*2)%k ] we type it this way in order to calculate when n>=31
		}
		System.out.println(ans);
	}

}
