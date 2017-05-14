/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pi.calculator;

/**
 *
 * @author kmhasan
 */
public class MultithreadedPiCalculator extends Thread {
    private long start;
    private long stop;
    private double pi;
    
    public MultithreadedPiCalculator(long start, long stop) {
        this.start = start;
        this.stop = stop;
    }
    
    public double getPi() {
        return pi;
    }
    
    @Override
    public void run() {
        pi = 0;
        for (long i = start; i < stop; i++) {
            if (i % 2 == 1)
                pi -= 1.0 / (2*i + 1);
            else pi += 1.0 / (2*i + 1);
        }
        pi = pi * 4;
        System.out.println("Done processing [" + start + ", " + stop + ")");
    }
}
