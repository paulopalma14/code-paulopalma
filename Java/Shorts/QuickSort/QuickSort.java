package eda.quick_sort;

public class QuickSort
{
	public static void run(int[] v, int vStart, int vEnd)
	{
		if(vStart < vEnd)
		{
			int q = Partition(v, vStart, vEnd);
			run(v, vStart, q - 1);
			run(v, q+1, vEnd );
		}
	}

	private static int Partition(int[] v, int vStart, int vEnd)
	{
		int x = v[vEnd];
		int i = vStart - 1;
		for(int j = vStart; j < vEnd; j++){
			if(v[j] <= x)
			{
				i = i + 1;
                int temp = v[i];
                v[i] = v[j];
                v[j] = temp;
			}
		}
		
        int temp = v[i+1];
        v[i+1] = v[vEnd];
        v[vEnd] = temp;
		return 1+i;
	}
}
