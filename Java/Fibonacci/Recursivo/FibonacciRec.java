import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class FibonacciRec
{

   public static void writeFile(PrintWriter file, int x, double y)
   {

   }

   public static int fib(int n)
   {
      if (n < 2)
      {
         return n;
      }
      else
      {
         return fib(n - 1) + fib(n - 2);
      }
   }

   public static void main(String[] args)
   {
      try
      {
         PrintWriter writer = new PrintWriter("fibonacciRec.txt", "UTF-8");

         long startTime = System.currentTimeMillis();

         for (int i = 0; i <= 50; i++)
         {

            fib(i);
            long stopTime = System.currentTimeMillis();
            double elapsedTime = stopTime - startTime;
            writer.println(i + "\t" + elapsedTime / 100000.0);
            System.out.println(i);
            

         }
         writer.close();

      } catch (FileNotFoundException | UnsupportedEncodingException e)
      {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }

   }

}
