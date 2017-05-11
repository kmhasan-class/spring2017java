/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multithreading.demo;

/**
 *
 * @author kmhasan
 */
public class MultithreadingDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Printer printer1 = new Printer("Printer 1", 1, 1000);
        Printer printer2 = new Printer("Printer 2", 1, 1000);
        Printer printer3 = new Printer("Printer 3", 1, 1000);
        Printer printer4 = new Printer("Printer 4", 1, 1000);
        printer1.start();
        printer2.start();
        printer4.start();
        printer3.start();
    }
    
}
