/**
 * Created by PauloPalma on 19/04/2016.
 */

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Random;

public class BubbleSort {

    private static int tableSize= 10;
    private static int[] vet;
    private static int aux ;

    public static int[] bubble(int[] vet) {
        //int aux = 0;

        for (int i = 0; i < vet.length - 1 ; i++) {
            for (int j = 0; j < vet.length - 1 ; j++) {
                if (vet[j] > vet[j + 1]) {
                    aux = vet[j];
                    vet[j] = vet[j + 1];
                    vet[j + 1] = aux;

                }
            }
        }

        return vet;
    }

    public static int[] rand() {
        int[] vet = new int[tableSize];
        Random randomGenerator = new Random();
        for (int i = 0; i < tableSize; i++) {

            vet[i] = randomGenerator.nextInt(100);

        }

        return vet;
    }



    public static void main(String[] args) {
        try{
        PrintWriter writer = new PrintWriter("fibonacciIter.txt", "UTF-8");
        long startTime = System.currentTimeMillis();

        for (int i = 0 ; i <= 50 ; i++){
            vet = new int[tableSize];
            vet = rand() ;


            bubble(vet);

            long stopTime = System.currentTimeMillis();
            double elapsedTime = stopTime - startTime;
            writer.println(i + "\t" + elapsedTime / 100000.0);

            System.out.println(" ");
            System.out.println("Vetor organizado:");
            for (int b = 0; b < tableSize ; b++) {
                System.out.println(" " + vet[b]);
            }

            tableSize =+ i*100 ;
        }

            writer.close() ;
        }
        catch (FileNotFoundException | UnsupportedEncodingException e)
        {
            e.printStackTrace();
        }




       // System.out.println("Tamanho da Tabela:" + tableSize + "Tempo :" + time);

    }

}




