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
public class SingleThreadedPiCalculator {
    private long terms;

    public SingleThreadedPiCalculator(long terms) {
        this.terms = terms;
    }
    
    /*
    Homework 1: try to solve this by doing all your calculations
    with fractions
    Homework 2: Use BigDecimal instead of double
    */
    public double getPi() {
        double pi = 0;
        for (long i = 0; i < terms; i++) {
            if (i % 2 == 1)
                pi -= 1.0 / (2*i + 1);
            else pi += 1.0 / (2*i + 1);
        }
        return pi * 4;
    }

    public long getTerms() {
        return terms;
    }
}
