package classAsignments;

public class Class5arraySorting {

	public static void main(String[] args) {
		int[] myArr = { 0, 0, 0, 1, 2, 3, 5, -1 };
		System.out.println(isSorted(myArr));
	}

	// assumes arr != null
	public static boolean isSorted(int[] arr) {
		boolean sorted = true;
		int i = arr[0];
		while (sorted & i < arr.length - 1) {
			if (arr[i] > arr[i + 1])
				sorted = false;
			i++;
		}
		return sorted;
	}
	
	
}
