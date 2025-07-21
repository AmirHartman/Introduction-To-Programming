public class Paths {

	public static boolean findIfPath(int[][] mat) {
		boolean ans = true;
		// ---------------write your code BELOW this line only!--------------
		ans = findIfPath(mat, 0, 0);
		// ---------------write your code ABOVE this line only!--------------
		return ans;
	}

	public static boolean findIfPath(int[][] arr, int i, int j) {
		boolean output = false;
		if (i == arr.length - 1 & j == arr[i].length - 1)
			output = true;
		else {
			boolean checkSecondRoute = true;
			int m = arr[i][j] / 10;
			int n = arr[i][j] % 10;
			if ((i + m < arr.length && j + n < arr[i].length) && findIfPath(arr, i + m, j + n)) {
				output = true;
				checkSecondRoute = false;
			}
			if (checkSecondRoute && (i + n < arr.length && j + m < arr[i].length) && findIfPath(arr, i + n, j + m))
				output = true;
		}
		return output;
	}

	public static int countPaths(int[][] mat) {
		int ans = 0;
		// ---------------write your code BELOW this line only!--------------
		ans = countPaths(mat, 0, 0);
		// ---------------write your code ABOVE this line only!--------------
		return ans;
	}

	public static int countPaths(int[][] arr, int i, int j) {
		int output = 0;

		if (i == arr.length - 1 & j == arr[i].length - 1)
			output = 1;
		else {
			int m = arr[i][j] / 10;
			int n = arr[i][j] % 10;
			if (i + m < arr.length && j + n < arr[i].length)
				output = output + countPaths(arr, i + m, j + n);
			if (i + n < arr.length && j + m < arr[i].length)
				output = output + countPaths(arr, i + n, j + m);
		}
		return output;
	}

	public static void printPaths(int[][] mat) {
		// ---------------write your code BELOW this line only!--------------
		printPaths(mat, 0, 0, "");
		// ---------------write your code ABOVE this line only!--------------
	}

	public static void printPaths(int[][] arr, int i, int j, String route) {
		route = route + " -> [" + i + "][" + j + "]";
		if (i == 0 & j == 0)
			route = "[0][0]";

		if (i == arr.length - 1 & j == arr[i].length - 1) {
			System.out.println(route);
		} else {
			int m = arr[i][j] / 10;
			int n = arr[i][j] % 10;
			if (i + m < arr.length && j + n < arr[i].length)
				printPaths(arr, i + m, j + n, route);
			if (i + n < arr.length && j + m < arr[i].length)
				printPaths(arr, i + n, j + m, route);
		}
	}

	public static boolean ifSubPath(int[][] mat, int cost) {
		boolean ans = false;
		// ---------------write your code BELOW this line only!--------------
		ans = ifSubPath(mat, cost, 0, 0, 0);
		// ---------------write your code ABOVE this line only!--------------
		return ans;
	}

	public static boolean ifSubPath(int[][] arr, int cost, int sum, int i, int j) {
		boolean output = false;
		sum = sum + arr[i][j];
		if (findIfPath(arr, i, j) & sum == cost)
			output = true;
		else {
			int m = arr[i][j] / 10;
			int n = arr[i][j] % 10;
			if (i + m < arr.length && j + n < arr[i].length)
				output = ifSubPath(arr, cost, sum, i + m, j + n);
			if (!output & (i + n < arr.length && j + m < arr[i].length))
				output = ifSubPath(arr, cost, sum, i + n, j + m);
		}
		return output;
	}

}
