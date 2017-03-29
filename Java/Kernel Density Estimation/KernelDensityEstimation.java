import org.apache.commons.math3.util.FastMath;

import java.awt.image.DataBufferByte;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static javax.imageio.ImageIO.read;

/**
 * Created by PauloPalma on 22/05/2016. <br>
 *<br>
 * Class that determinates the KDE of a single Image. <br>
 *<br>
 * example of usage : <br>
 *<code><br>
  double[] result = new double[256]; <br>
  double[] histo = new double[256]; <br>
  KernelDensityEstimation kde = new KernelDensityEstimation("src/lena4096x4096.png", histo, result);<br>
  kde.start();
 </code>
 * */
class KernelDensityEstimation implements Runnable {

    private int[] img;
    private double[] result;
    private double[] hist;
    private double h;
    private int N;
    private int flag;
    private int inc;

    /**
     * @param path   Image's Path.
     * @param histo  Array with histogram's results.
     * @param result Array with kde's results.
     * @throws IOException Error reading the image.
     */
    KernelDensityEstimation(String path, double[] histo, double[] result) throws IOException {

        File fimage = new File(path);

        byte[] dataImage = ((DataBufferByte) read(fimage).getRaster().getDataBuffer()).getData();
        this.img = new int[dataImage.length];

        genGrays(dataImage);

        this.result = result;
        this.hist = histo;
        this.N = img.length;
        double med = average();
        double s = desvioP(med);
        this.h = bandwidth(s);
        this.inc = result.length / Runtime.getRuntime().availableProcessors();

        histoCalc();

    }

    /**
     *
     */
    void start() {

        createThreads();
    }

    /**
     *
     */
    public void run() {

        int id;
        synchronized (this) {
            this.flag++;
        }
        id = this.flag;
        int max = (id * this.inc);
        int min = (id - 1) * this.inc;
        for (int x = min; x < max; x++) {
            result[x] = this.kde(x);
        }
    }

    /**
     * Create threads to improve the calc speed.
     */
    private void createThreads() {
        int cores = Runtime.getRuntime().availableProcessors();
        ExecutorService pool = Executors.newFixedThreadPool(cores);

        for (int i = 0; i < cores; i++) {
            pool.execute(this);
        }
        pool.shutdown();

        try {
            pool.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    /**
     * @param x Value to analize.
     * @return Return the value of Kernel Densety Estimation of x.
     */
    private double kde(double x) {

        double y = 0.0;
        for (int i = 0; i < this.N; i++) y += nucleo(((x - this.img[i]) / this.h));
        y /= N * h;
        return y;
    }

    /**
     * @param u Value of u.
     * @return Return kernel value.
     */
    private double nucleo(double u) {

        return (1.0 / (Math.sqrt(2.0) * Math.PI)) * (FastMath.exp(-0.5 * (u * u)));
    }

    /**
     * @return Return average of gray values.
     */
    private double average() {

        int media = 0;
        for (int i = 0; i < this.N; i++) media += img[i];

        return media / this.N;
    }

    /**
     * @param med Average of gray values.
     * @return Return Standard Deviation of gray values.
     */
    private double desvioP(double med) {

        double s = 0.0;
        for (int i = 0; i < this.N; i++) {
            s += FastMath.pow(img[i] - med, 2);
        }

        return Math.sqrt(s / this.N);
    }

    /**
     * @param s Standard Deviation of gray values.
     * @return Return Bandwidth of gray values.
     */
    private double bandwidth(double s) {

        return 1.06 * s * FastMath.pow(this.N, (-1.0 / 5.0));
    }

    /**
     * Use the image to generate the gray values.
     *
     * @param dataImage Array of image pixels.
     */
    private void genGrays(byte[] dataImage) {

        for (int i = 0; i < dataImage.length; i++) this.img[i] += dataImage[i] & 0xff;

    }

    /**
     * Calculate the histogram of grays.
     */
    private void histoCalc() {

        for (int i = 0; i < N; i++) hist[img[i]] += 1;

        for (int i = 0; i < hist.length; i++) hist[i] = (hist[i] / N) * 100.0;

    }
}
