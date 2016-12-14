import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;

public class FibonacciIter
{

   
   public static void writeFile(PrintWriter file ,int x , double y)
   {
      
      file.println(x + "\t" + y);     
      
   }
   
   public static long fib(int n)
   {
      int prev1 = 0, prev2 = 1;
      for (int i = 0; i < n; i++)
      {
         int savePrev1 = prev1;
         prev1 = prev2;
         prev2 = savePrev1 + prev2;
      }
      return prev1;
   }

   public static void main(String[] args)
   {
      try
      {
         PrintWriter writer = new PrintWriter("the-file-name.txt", "UTF-8");
         
         long startTime = System.currentTimeMillis();
        

         for (int i = 0; i <= 100000; i++)
         {            
            
            fib(i);
            long stopTime = System.currentTimeMillis();
            double elapsedTime = stopTime - startTime;                
            writeFile(writer, i, elapsedTime/100000.0);
            
         }
         
         
      } catch (FileNotFoundException | UnsupportedEncodingException e)
      {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }

      
      
   }

}
