/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package midtermexamsection4;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

/**
 *
 * @author kmhasan
 */
public class MidtermExamSection4 {

    public int countLines(String filename) {
        int count = 0;
        
        try {
            RandomAccessFile input = new RandomAccessFile(filename, "r");
            
            String line;
            while ((line = input.readLine()) != null) {
                count++;
            }
            
            /*
            while (true) {
                String line = input.readLine();
                if (line == null)
                    break;
                count++;
            }
            */
        } catch (FileNotFoundException fnfe) {

        } catch (IOException ioe) {
            
        }
        
        return count;
    }

    public int getSquaredSum(ArrayList<Integer> numbersList) {
        int sum = 0;
        /*
        for (int i = 0; i < numbersList.size(); i++)
            sum = sum + numbersList.get(i) * numbersList.get(i);
        */
        for (Integer num : numbersList)
            sum = sum + num * num;
        
        return sum;
    }

    public MidtermExamSection4() {
        int lines = countLines("input");
        System.out.println("Number of lines = " + lines);
        
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(3);
        numbers.add(2);
        int sum = getSquaredSum(numbers);
        System.out.println("Squared sum = " + sum);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MidtermExamSection4 m = new MidtermExamSection4();
    }

}
