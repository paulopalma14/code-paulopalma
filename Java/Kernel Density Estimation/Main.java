import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

/**
 * Created by PauloPalma on 22/05/2016.
 */
public class Main {

    /**
     * @param args Arguments from cmd.
     * @throws IOException Error reading the image.
     */
    public static void main(String[] args) throws IOException {

        double[] result = new double[256];
        double[] histo = new double[256];
        double[] times = new double[20];
        String path = "src/lena4096x4096.png" ;


        for (int b = 0; b < 1; b++) {
            KernelDensityEstimation kde = new KernelDensityEstimation(path, histo, result);

            double start = System.currentTimeMillis();

            kde.start();
            times[b] = (System.currentTimeMillis() - start) / 1000;
        }

        writeFile(times, "Times.txt");
        writeFile(result, "kGrays.txt");
        writeFile(histo, "histo.txt");

    }

    /**
     * Write file with data from any array.
     * X is the size of the array .
     * Y are the values.
     *
     * @param array Array with the values.
     * @param name  File name.
     * @throws FileNotFoundException        File not found or not possible to create.
     * @throws UnsupportedEncodingException Unsupported Encoding.
     */
    private static void writeFile(double[] array, String name) throws FileNotFoundException, UnsupportedEncodingException {

        PrintWriter writer = new PrintWriter(name, "UTF-8");

        for (int i = 0; i < array.length; i++) {
            writer.print(i + " " + array[i] + "\n");
        }
        writer.close();
    }

}
