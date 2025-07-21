
public class runfromhere {

	public static void main(String[] args) {
		Assignment2 r = new Assignment2();

		// boolean[][]arr = new boolean[2][2];
		int[] output;

//		boolean[][] arr = { { false, false }, { true, true } };
//		boolean[][] oneFlight = { { false } };

		boolean[][] flightsDraw1 = { { false, false, true, true }, { false, false, true, true },
				{ true, true, false, true }, { true, true, true, false } };

		boolean[][] wrongF = { { false, true, true, false }, { true, false, true, true }, { true, true, false, true },
				{ false, true, true, false } };
		int[] wrongT = { 1, 3, 2, 0 };

		boolean[][] flightsDraw2 = { { false, false, true, false }, { false, false, true, true },
				{ true, true, false, true }, { false, true, true, false } };

		int[] permutation = { 0, 2, 4, 2, 1, 3, 6 };

		System.out.println(r.hasLegalSteps(wrongF, wrongT));
//		int[] directions = {-1,-1,1,1};

		System.out.println(r.solve2(flightsDraw1));

//		printArr(permutation);
//		printArr(r.reverseRoute(permutation));

//		printArr(permutation);
//		printArr(directions);

//		r.reverseDirections(permutation, directions, 8);;

//		printArr(permutation);
//		printArr(directions);

//		int n = r.findMobileIndex(permutation, directions);
//		System.out.println(n);
//		printArr(r.createFirstPerm(7));

//		int n=7;
//		int[][]result = r.generatePermutations(n);
//		for (int i=0;i<r.factorial(n);i++)
//			printArr(result[i]);

//		System.out.println(r.factorial(9));

//		int[]solve = r.solve(flightsDraw2);
//		printArr(solve);
//		System.out.println(solve);

	}

	public static void printArr(int[] arr) {
		for (int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");
		System.out.println();
	}

}
