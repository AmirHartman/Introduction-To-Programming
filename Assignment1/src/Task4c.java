import java.util.Scanner;

public class Task4c {

	public static void main(String[] args) {
		Scanner scanner = new Scanner (System.in);
		boolean ans = false;
		System.out.println("Enter 'n','a'");
		int n = scanner.nextInt();
		int a = scanner.nextInt();
		
		//a^(n-1)
		int r = 1; // r for remainder
		for (int i = 1; i < n; i++)   // i "<" n (not included) because we need n-1 multiplies 
			r = ((r%n) * (a%n) ) % n; // using (𝑎 ⋅ 𝑏)%𝑘 = ((𝑎%𝑘) ⋅ (𝑏%𝑘)) %𝑘 like in Task3b or allow big numbers like n=31 a=30
	
		if(r == 1)
			ans = true;
		
		System.out.println(ans);
	}

}
