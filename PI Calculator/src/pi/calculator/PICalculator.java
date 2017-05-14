/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pi.calculator;

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
            /*
            SingleThreadedPiCalculator calculator;
            // 10 billion = 10000000000l
            calculator = new SingleThreadedPiCalculator(1000000000l);
            System.out.printf("PI = %.10f\n", calculator.getPi());
            */
            
            /*
            Homework 3: divide the task for p threads
            p is the number of threads
            n is the number of terms to use
            You need to divide the tasks in a loop, start the threads and join them.
            Once they are done, you have to add up the result and show the final value.
            */
            MultithreadedPiCalculator c1;
            MultithreadedPiCalculator c2;
            c1 = new MultithreadedPiCalculator(0, 500000000l);
            c2 = new MultithreadedPiCalculator(500000000l, 1000000000l);
            c1.start();
            c2.start();
            c1.join();
            c2.join();
            System.out.printf("PI = %.10f\n", c1.getPi() + c2.getPi());
        } catch (InterruptedException ex) {
            Logger.getLogger(PICalculator.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
