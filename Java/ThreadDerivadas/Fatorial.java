import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

/**
 * Created by PauloPalma on 26/06/2016.
 */
class Fatorial implements Runnable {
    int n = 0;
    int res = 0;

    int getRes() {
        return res;
    }

    private int calcular(int n) {
        if (n <= 0) {
            return 1;
        } else {
            return n * calcular(n - 1);
        }
    }

    public void run() {


        res = calcular(n);



    }

    Fatorial(int n){
        this.n = n ;
    }


}
