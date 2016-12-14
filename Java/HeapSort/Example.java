package eda.heap_sort;

public class Example
{
	private static int[] NewCopy(int[] A)
	{
		int[] B = new int[A.length + 1];
		for (int k = 1; k < B.length; k++)
			B[k] = A[k - 1];
		B[0] = Integer.MIN_VALUE;
		return B;
	}

	public static void PrintArray(int[] A)
	{
		System.out.println();
		for (int i = 1; i < A.length; i++)
			System.out.format("%3d", i);
		System.out.println();
		for (int i = 1; i < A.length; i++)
			System.out.format("%3d", A[i]);
		System.out.println();
	}

	public static void main(String[] args) {
		 int[] C = {4,1,3,2,16,9,10,14,8,7};
		 int[] A = NewCopy(C);
		 PrintArray(A);
		 HeapSort hs = new HeapSort(A);
		 PrintArray(A);
	}
}
