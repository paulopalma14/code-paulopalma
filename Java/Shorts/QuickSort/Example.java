package eda.quick_sort;

public class Example
{

	public static void main(String[] args)
	{
		int[] asd = {
				0,3,4,4,6,56,7,8,32,1,2
		};
		
		System.out.println("Quick-Sort Algorithm");
		QuickSort.run(asd, 0, asd.length - 1);
		
		for(int i = 0; i < asd.length; i ++)
		{
			System.out.println(i + " - " + asd[i]);
		}
		
		main2();

	}
	
	// A utility function to print contents of arr
    void printArr( int arr[], int n )
    {
        int i;
        for ( i = 0; i < n; ++i )
            System.out.print(arr[i]+" ");
    }
 
    // Driver code to test above
    public static void main2()
    {
        IterativeQuickSort ob = new IterativeQuickSort();
        int arr[] = {4, 3, 5, 2, 1, 3, 2, 3};
        ob.QuickSort(arr, 0, arr.length-1);
        ob.printArr(arr, arr.length);
    }

}
