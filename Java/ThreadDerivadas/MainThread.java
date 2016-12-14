import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.lang.management.ManagementFactory;

/**
 * Created by PauloPalma on 26/06/2016.
 */
public class MainThread {


    public static void main(String[] args) throws InterruptedException {

        int numProcessadores = Runtime.getRuntime().availableProcessors();


        for (int p = 0; p < numProcessadores; p++) {

            ThreadDerivada td = new ThreadDerivada();
            td.start();
        }
        System.out.println();

        for (int p = 0; p < 13; p++) {

            Fatorial f = new Fatorial(p);
            Thread t = new Thread(f, Integer.toString(p));

            t.start();
            t.join();

            System.out.println(t.getName() + " " + f.getRes());

        }


    }


}
