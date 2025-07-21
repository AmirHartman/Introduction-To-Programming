import java.util.Scanner;

public class Task4f {

	public static void main(String[] args) {
		Scanner scanner = new Scanner (System.in);
		int ans=0;
		System.out.println("Enter 'x','y'");
		int x = scanner.nextInt();
		int y= scanner.nextInt();
		
		boolean isPrimeFound = false;
		while(!isPrimeFound) {
			
			//from Task2
			int range = y - x + 1;
			ans = (int)(Math.random() * range) + x; 
			
			//from Task4e
			int c=0;
			int r=1;
			while (c<5 & r==1) {
				c++;
				int a = (int)( ( Math.random() * ans-1) ) +1; 
				for (int i = 1; i < ans; i++)
					r = ((r%ans) * (a%ans) ) % ans;			
			}
			if (r==1) 
				isPrimeFound = true;
			
			
		}
		System.out.println(ans);				
		
		
	}

}
