/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package string.demo;

/**
 *
 * @author kmhasan
 */
public class StringDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String input;

        // finding out the length of a string
        input = "31llo";
        int length = input.length();
        System.out.println(length);

        if (length == 13) {
            System.out.println("ID okay");
        } else {
            System.out.println("ID must be 13 digits long");
        }

        char ch = input.charAt(1);
        System.out.println("Character at index 1 = " + ch);

        if (ch >= '0' && ch <= '9') {
            System.out.println("Character is a digit");
        } else {
            System.out.println("Character is not a digit");
        }
        
        for (int i = 0; i < input.length(); i++)
            System.out.println(input.charAt(i));
    }

}
