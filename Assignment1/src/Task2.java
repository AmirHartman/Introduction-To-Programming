import java.util.Scanner;

public class Task2 {

	// input: 2 whole numbers a,b   * a<=b *
	// output: random whole number in the range [a,b]
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter two numbers 'a', 'b' that statisfy a<=b");
		int min =  scanner.nextInt(); // i like to call 'a' --> "min"
		int max =  scanner.nextInt(); // i like to call 'b' --> "max"
		
		int range = max - min + 1; // add 1 to include the number max itself
		
		// convert range * random to int which gives random int number [0 - range) then adding "min" 
		int ans = (int)(Math.random() * range) + min; 
		System.out.println(ans);
	}

}
