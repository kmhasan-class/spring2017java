/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package console.calculator;

/**
 *
 * @author kmhasan
 */
public class ConsoleCalculator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int number1 = 10;
        int number2 = 3;
        int result = number1 << number2;
        /*
            + ADDITION
            - SUBTRACTION
            * MULTIPLICATION
            / DIVISION
            % MOD
            ^ XOR
            | bitwise OR
            & bitwise AND
            << left shift
            >> right shift
        */
        System.out.printf("Result: %d\n", result);
    }
    
}
