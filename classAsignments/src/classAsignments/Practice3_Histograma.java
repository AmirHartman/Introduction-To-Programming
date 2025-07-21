package classAsignments;

public class Practice3_Histograma {

	public static void main(String[] args) {
		int[] grades = { 0, 1, 1, 1, 2, 1, 2,6,4,1,2,5,3,3,3,2,1,1,0,0,0,5,5 };
		int maxGrade=checkMax(grades);
		int[] result = histography(grades,maxGrade);
		printArr(result);
		
	}

	public static int[] histography(int[] arr, int maxGrade) {
		int[]result = new int[maxGrade+1];
		for(int num:arr) {
			for (int i=0;i< result.length;i++)
				if (num==i)
					result[i]++;
		}

		return result;
	}
	
	public static void printArr(int[]arr) {
		for (int i=0;i<arr.length;i++)
			System.out.println(arr[i]+" ");
	}
	
	public static int checkMax(int[] arr) {
		int num = arr[0];
		for(int item:arr)
			if (item>num)
				num=item;
		return num;
	}

}
