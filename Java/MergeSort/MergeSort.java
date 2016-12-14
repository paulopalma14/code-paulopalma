import com.sun.scenario.effect.Merge;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by PauloPalma on 26/06/2016.
 */
public class MergeSort {

    public static void main(String[] args) {

        Integer[] vet = rand(30);
        mergeSort(vet);
        System.out.println(Arrays.toString(vet));

    }

    private static Integer[] rand(int tableSize) {
        Integer[] vet = new Integer[tableSize];
        Random randomGenerator = new Random();
        for (int i = 0; i < tableSize; i++) {

            vet[i] = randomGenerator.nextInt(100);

        }

        return vet;
    }

    /*private static void mergeSort(Integer[] A, Integer p, Integer r){

        if (p < r){
           int q = (int) Math.floor((p+r)/2.0);
            mergeSort(A ,p ,q);
            mergeSort(A , q+1 ,r);
            merge(A, p , q, r);
        }

    }

    private static void merge(Integer[] A, Integer p, Integer q, Integer r){

        int n1 = q - p + 1 ;
        int n2 = r - q ;

        int[]L = new int[n1+1];
        int[]R = new int[n2+1];

        for (int i = 0 ; i < n1 ; i++) L[i] = A[p + i];
        for(int j = 0; j < n2; j++) R[j] = A[q + j + 1];

        L[n1] = Integer.MAX_VALUE ;
        R[n2] = Integer.MAX_VALUE ;

        int i = 0 ;
        int j = 0 ;

        for (int k = p ; k <= r ; k++){
            if (L[i] <= R[j]){
                A[k] = L[i++] ;
            }else {
                A[k] = R[j++];
            }
        }
    }*/


    private static Comparable[] mergeSort(Integer[] list) {

        //Verifica se existem elementos suficientes para ordenar
        if (list.length <= 1) {
            return list;
        }

        //Divisão do array inicial
        Integer[] first = new Integer[list.length / 2];
        Integer[] second = new Integer[list.length - first.length];
        System.arraycopy(list, 0, first, 0, first.length);
        System.arraycopy(list, first.length, second, 0, second.length);

        //Chamada recursiva para fazer as varias divisões
        mergeSort(first);
        mergeSort(second);

        merge(first, second, list);
        return list;
    }

    private static void merge(Integer[] first, Integer[] second, Integer[] result) {
        int iFirst = 0;
        int iSecond = 0;
        int iMerged = 0;

        while (iFirst < first.length && iSecond < second.length) {
            if (first[iFirst].compareTo(second[iSecond]) < 0) {
                result[iMerged] = first[iFirst];
                iFirst++;
            } else {
                result[iMerged] = second[iSecond];
                iSecond++;
            }
            iMerged++;
        }

        System.arraycopy(first, iFirst, result, iMerged, first.length - iFirst);
        System.arraycopy(second, iSecond, result, iMerged, second.length - iSecond);
    }

}
