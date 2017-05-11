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
class Printer extends Thread {
    private String label;
    private int start;
    private int end;

    public Printer(String label, int start, int end) {
        this.label = label;
        this.start = start;
        this.end = end;
    }
    
    public void print() {
        for (int i = start; i <= end; i++)
            System.out.printf("%s: %d\n", label, i);
    }
    
    @Override
    public void run() {
        print();
    }
}
