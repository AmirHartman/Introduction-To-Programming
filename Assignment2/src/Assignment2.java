public class Assignment2 {

	// Task 1

	public static boolean isSquareMatrix(boolean[][] matrix) {

		// ---------------write your code BELOW this line only! ------------------
		boolean output = true;

		// Invalid inputs return false
		if (matrix == null || matrix.length == 0)
			output = false;
		else
			// check if the number of rows and columns is equal
			for (boolean[] line : matrix)
				if (line.length != matrix.length) // matrix.length is the number of lines
					output = false;

		return output;

		// ---------------write your code ABOVE this line only! ------------------
	}

	// Task 2
	public static boolean isSymmetricMatrix(boolean[][] matrix) {

		// ---------------write your code BELOW this line only! ------------------

		boolean output = true;
		for (int i = 0; i < matrix.length; i++)

			// j=i - we can skip cells that we checked because each time we check 2 cells
			// [i][j],[j][i]
			for (int j = i; j < matrix[i].length; j++)
				if (matrix[i][j] != matrix[j][i])
					output = false;

		return output;

		// ---------------write your code ABOVE this line only! ------------------
	}

	// Task 3
	public static boolean isAntiReflexiveMatrix(boolean[][] matrix) {

		// ---------------write your code BELOW this line only! ------------------

		boolean output = true;
		for (int i = 0; i < matrix.length; i++)
			if (matrix[i][i] != false)
				output = false;

		return output;

		// ---------------write your code ABOVE this line only! ------------------
	}

	// Task 4
	public static boolean isLegalInstance(boolean[][] matrix) {

		// ---------------write your code BELOW this line only! ------------------

		boolean output = false;
		if (isSquareMatrix(matrix))
			if (isSymmetricMatrix(matrix) & isAntiReflexiveMatrix(matrix))
				output = true;

		return output;
		// ---------------write your code ABOVE this line only! ------------------
	}

	// Task 5
	public static boolean isPermutation(int[] array) {

		// ---------------write your code BELOW this line only! ------------------

		boolean output = true;
		for (int i = 0; i < array.length; i++) // going through each index (each number that should be in the array)
		{
			int c = 0;
			for (int j = 0; j < array.length; j++) // going through the array and counts how much i value exist
				if (array[j] == i)
					c++;
			if (c != 1)
				output = false;

		}
		return output;

		// ---------------write your code ABOVE this line only! ------------------
	}

	// Task 6
	public static boolean hasLegalSteps(boolean[][] flights, int[] tour) {

		// ---------------write your code BELOW this line only! ------------------

		boolean output = true;
			
		for (int i = 0; i < tour.length - 1; i++) // check if flight exist till i<=tour.length - 2
			if (!flights[tour[i]][tour[i + 1]])
				output = false;
		return output;

		// ---------------write your code ABOVE this line only! ------------------
	}

	// Task 7
	public static boolean isSolution(boolean[][] flights, int[] tour) {

		// ---------------write your code BELOW this line only! ------------------

		if (tour.length != flights.length | tour == null)
			throw new IllegalArgumentException("int[]tour is illigal input");

		boolean output = false;
		int lastElement = tour[tour.length - 1]; // check if there is back home route
		if (isPermutation(tour) & tour[0] == 0 & hasLegalSteps(flights, tour) & flights[lastElement][0])
			output = true;
		return output;

		// ---------------write your code ABOVE this line only! ------------------
	}

	////////////////////////////////////////
	/////// Part 1 ends here ////////
	////////////////////////////////////////

	// Task 8
	public static int[] createFirstPerm(int n) {
		// ---------------write your code BELOW this line only! ------------------

		int[] output = new int[n];
		for (int i = 0; i < n; i++)
			output[i] = i;
		return output;

		// ---------------write your code ABOVE this line only! ------------------
	}

	// Task 9
	public static int factorial(int n) {
		// ---------------write your code BELOW this line only! ------------------

		int output = 1; // for n=0, n=1 it will not get into the loop and return 1
		for (int i = 2; i <= n; i++)
			output *= i;
		return output;

		// ---------------write your code ABOVE this line only! ------------------
	}

	// Task 10
	public static void copyArray(int[] source, int[] destination) {
		// ---------------write your code BELOW this line only! ------------------

		for (int i = 0; i < source.length; i++)
			destination[i] = source[i];

		// ---------------write your code ABOVE this line only! ------------------
	}

	// Task 11
	public static void swap(int[] permutation, int[] directions, int mobileIndex) {
		// ---------------write your code BELOW this line only! ------------------

		int finalIndex = mobileIndex + directions[mobileIndex];

		if (0 <= finalIndex & finalIndex < permutation.length) // the condition tells if finalIndex is a valid index
		{
			int memory = permutation[mobileIndex];
			permutation[mobileIndex] = permutation[finalIndex];
			permutation[finalIndex] = memory;

			memory = directions[mobileIndex];
			directions[mobileIndex] = directions[finalIndex];
			directions[finalIndex] = memory;
		}

		// ---------------write your code ABOVE this line only! ------------------
	}

	// Task 12
	public static void reverseDirections(int[] permutation, int[] directions, int mobileElement) {
		// ---------------write your code BELOW this line only! ------------------

		for (int i = 0; i < permutation.length; i++)
			if (permutation[i] > mobileElement)
				directions[i] *= -1;

		// ---------------write your code ABOVE this line only! ------------------
	}

	// Task 13
	public static int findMobileIndex(int[] permutation, int[] directions) {
		// ---------------write your code BELOW this line only! ------------------

		int output = -1;
		int max = -1;
		for (int i = 0; i < permutation.length; i++)
			if (isMobileNumber(permutation, directions, i) && permutation[i] > max) // if permutation[i] is not mobile
																					// number no need to check if bigger
																					// than max
			{
				max = permutation[i];
				output = i;
			}
		return output;

		// ---------------write your code ABOVE this line only! ------------------
	}

	// Assistance function for Task 13
	public static boolean isMobileNumber(int[] permutation, int[] directions, int candidateIndex) {
		boolean output = false;
		int finalIndex = candidateIndex + directions[candidateIndex];
		if (0 <= finalIndex & finalIndex < permutation.length) // checks if finalIndex is valid index
			if (permutation[candidateIndex] > permutation[finalIndex])
				output = true;
		return output;
	}

	// Task 14
	public static int[][] generatePermutations(int n) {
		// ---------------write your code BELOW this line only! ------------------

		int[] permutation = createFirstPerm(n);
		int[] directions = new int[n];
		for (int i = 0; i < n; i++)
			directions[i] = -1;
		int nop = factorial(n); // nop == Number Of Permutations
		int[][] result = new int[nop][n];
		copyArray(permutation, result[0]);
		int mobileIndex = findMobileIndex(permutation, directions);
		int copyToIndex = 1;
		while (mobileIndex != -1 & copyToIndex < nop) {
			int mobileEelement = permutation[mobileIndex];
			swap(permutation, directions, mobileIndex);
			reverseDirections(permutation, directions, mobileEelement);
			copyArray(permutation, result[copyToIndex]);
			copyToIndex++;
			mobileIndex = findMobileIndex(permutation, directions);
		}

		return result;

		// ---------------write your code ABOVE this line only! ------------------
	}

	// Task 15
	public static int[] solve(boolean[][] flights) {
		// ---------------write your code BELOW this line only! ------------------

		if (!isLegalInstance(flights))
			throw new IllegalArgumentException("Flights is illigal instance");
		int[] output = null;
		int[][] permutations = generatePermutations(flights.length);
		for (int i = 0; i < permutations.length; i++)
			if (isSolution(flights, permutations[i])) {
				output = new int[flights.length];
				copyArray(permutations[i], output);
			}

		return output;

		// ---------------write your code ABOVE this line only! ------------------
	}

	// Task 16
	public static boolean solve2(boolean[][] flights) {
		// ---------------write your code BELOW this line only! ------------------
		if (!isLegalInstance(flights))
			throw new IllegalArgumentException("Flights is illigal instance");
		boolean output = true;
		int count = 0;
		int n = flights.length; // n - the size of the chart (flights is [n x n])
		int[][] permutations = generatePermutations(n);
		int[][] uniqueSolves = new int[factorial(n) / 2 + 1][n]; // the array is factorial(n)/2 + 1 long because each
																	// solve can be reversed and +1 if its odd number
		for (int i = 0; i < permutations.length; i++) // go through all permutations
			if (isSolution(flights, permutations[i]) & !doesReverseRouteExist(uniqueSolves, permutations[i])) {
				copyArray(permutations[i], uniqueSolves[count]);
				//printArr(uniqueSolves[count]);    uncomment to see all possible solutions
				count++;
			}
		
		if (count < 2)
			output = false;
		return output;

		// ---------------write your code ABOVE this line only! ------------------
	}

	
	// Assistance functions for Task 16
	// -----------------------------------------------------------------------------
	public static boolean doesReverseRouteExist(int[][] uniqueSolves, int[] solve) {
		boolean output = false;
		for (int i = 0; i < uniqueSolves.length; i++) 
			if (areArraysEqual(uniqueSolves[i], reverseRoute(solve)))
				output = true;

		return output;
	}

	public static int[] reverseRoute(int[] solve) {
		int[] output = new int[solve.length];
		int i = 1, j = solve.length - 1;
		while (i < solve.length & j >= 0 & i <= j) {
			output[i] = solve[j];
			output[j] = solve[i];
			i++;
			j--;
		}
		return output;
	}

	public static boolean areArraysEqual(int[] array1, int[] array2) {
		boolean output = true;
		if (array1.length != array2.length)
			output = false;
		else
			for (int i = 0; i < array1.length; i++)
				if (array1[i] != array2[i])
					output = false;
		return output;

	}

	public static void printArr(int[] arr) {
		for (int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");
		System.out.println();
	}
	// -----------------------------------------------------------------------------

}