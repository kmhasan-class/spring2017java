/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pi.calculator;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kmhasan
 */
public class PICalculator {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            //long totalTerms = 1000000003l;
            long totalTerms = 1000000003l;
            long startTime;
            long stopTime;
            
            startTime = System.currentTimeMillis();
            SingleThreadedPiCalculator calculator;
            // 10 billion = 10000000000l
            calculator = new SingleThreadedPiCalculator(totalTerms);
            System.out.printf("PI = %.10f\n", calculator.getPi());
            stopTime = System.currentTimeMillis();
            System.out.printf("Time taken: %.2f seconds\n", (stopTime - startTime) / 1000.0);
            
            /*
            Homework 3: divide the task for p threads
            p is the number of threads
            n is the number of terms to use
            You need to divide the tasks in a loop, start the threads and join them.
            Once they are done, you have to add up the result and show the final value.
            */
            startTime = System.currentTimeMillis();
            MultithreadedPiCalculator c1;
            MultithreadedPiCalculator c2;
            c1 = new MultithreadedPiCalculator(0, totalTerms / 2);
            c2 = new MultithreadedPiCalculator(totalTerms / 2, totalTerms);
            c1.start();
            c2.start();
            c1.join();
            c2.join();
            System.out.printf("PI = %.10f\n", c1.getPi() + c2.getPi());
            stopTime = System.currentTimeMillis();
            System.out.printf("Time taken: %.2f seconds\n", (stopTime - startTime) / 1000.0);
            
            startTime = System.currentTimeMillis();
            int p = 4; // number of threads
            long dt = totalTerms / p;
            ArrayList<Thread> threads = new ArrayList<>();
            for (int i = 0; i < p; i++) {
                if (totalTerms % p != 0 && i == p - 1)
                    threads.add(new MultithreadedPiCalculator(i * dt, totalTerms));
                else threads.add(new MultithreadedPiCalculator(i * dt, (i + 1) * dt));
            }
            for (Thread t : threads)
                t.start();
            for (Thread t : threads)
                t.join();
            double pi = 0;
            for (Thread t : threads)
                pi += ((MultithreadedPiCalculator) t).getPi();
            System.out.printf("PI = %.10f\n", pi);
            stopTime = System.currentTimeMillis();
            System.out.printf("Time taken: %.2f seconds\n", (stopTime - startTime) / 1000.0);
        } catch (InterruptedException ex) {
            Logger.getLogger(PICalculator.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
