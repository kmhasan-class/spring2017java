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
public class Fraction {
    private int numerator;
    private int denominator;

    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public int getDenominator() {
        return denominator;
    }

    public void setDenominator(int denominator) {
        this.denominator = denominator;
    }

    public int getNumerator() {
        return numerator;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }
    
    Fraction add(Fraction b) {
        Fraction a = this;
        Fraction c = new Fraction(a.numerator * b.denominator + b.numerator * a.denominator,
                a.denominator * b.denominator);
        return c;
    }
}
