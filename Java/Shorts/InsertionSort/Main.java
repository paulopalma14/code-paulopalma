/**
 * Created by PauloPalma on 26/04/2016.
 */

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Random;

class InsertionSort {

    private static int tableSize = 10;

    public static void main(String[] args) {
        try {
            PrintWriter writer = new PrintWriter("InsertionSort.txt", "UTF-8");
            long startTime = System.currentTimeMillis();

            for (int i = 1; i <= 50; i++) {

                int arr[] = rand();
                System.out.println("Before \n" + Arrays.toString(arr));


                insertionSort(arr);
                long stopTime = System.currentTimeMillis();
                double elapsedTime = stopTime - startTime;
                writer.println(i + "\t" + elapsedTime / 100000.0);

                tableSize = +i * 100;
            }
            writer.close();
        } catch (FileNotFoundException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    private static int[] rand() {
        int[] vet = new int[tableSize];
        Random randomGenerator = new Random();
        for (int i = 0; i < tableSize; i++) {

            vet[i] = randomGenerator.nextInt(100);

        }

        return vet;
    }

    private static void insertionSort(int arr[]) {

        int N = arr.length;
        for (int i = 1; i < N; i++) {
            int j = i - 1;
            int temp = arr[i];
            while (j >= 0 && temp < arr[j]) {
                arr[j + 1] = arr[j];
                j--;
                ;
            }
            arr[j + 1] = temp;
        }
        System.out.println("After");
        //Printing array after pass
        System.out.println(Arrays.toString(arr));

    }
}





