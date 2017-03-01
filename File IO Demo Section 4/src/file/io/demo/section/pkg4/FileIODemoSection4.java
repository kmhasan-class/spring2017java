/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package file.io.demo.section.pkg4;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author kmhasan
 */
public class FileIODemoSection4 {

    public void readUsingScanner() {
        int x;
        double y;
        System.out.println("Reading using Scanner");
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter an integer and a floating point number");
        x = scanner.nextInt();
        y = scanner.nextDouble();

        System.out.println("integer x " + x);
        System.out.println("double y " + y);
    }

    public void readUsingBufferedReader() {
        int x;
        double y;
        System.out.println("Reading using BufferedReader");
        BufferedReader bufferedReader;
        bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Enter an integer and a floating point number");
        try {
            x = Integer.parseInt(bufferedReader.readLine());
            y = Double.parseDouble(bufferedReader.readLine());

            System.out.println("integer x " + x);
            System.out.println("double y " + y);
        } catch (IOException ioe) {
            System.err.println("Can't read from the keyboard anymore!");
        }
    }

    public void readFromFile() {
        RandomAccessFile randomAccessFile;
        try {
            randomAccessFile = new RandomAccessFile("input.txt", "r");
            String line;

            while (true) {
                line = randomAccessFile.readLine();
                if (line == null) {
                    break;
                }
                System.out.println(line);
            }

        } catch (FileNotFoundException fnfe) {
            System.err.println("Could not find this file!");
        } catch (IOException ioe) {
            System.err.println("Can't read from that resource anymore!");
        }
    }

    public void writeToFile() {
        RandomAccessFile randomAccessFile;
        try {
            randomAccessFile = new RandomAccessFile("output.txt", "rw");
            randomAccessFile.writeBytes("Hello world!\n");
            randomAccessFile.writeBytes("Hi there!\n");
        } catch (FileNotFoundException fnfe) {
            System.err.println("Could not find this file!");
        } catch (IOException ioe) {
            System.err.println("Can't read from that resource anymore!");
        }
    }

    public void task1() {
        try {
            RandomAccessFile inputFile = new RandomAccessFile("numbers.txt", "r");
            
            int n = Integer.parseInt(inputFile.readLine());
            
            ArrayList<Integer> numbersList = new ArrayList<>();
            for (int i = 0; i < n; i++)
                numbersList.add(Integer.parseInt(inputFile.readLine()));
            
            int sum = 0;
            for (Integer num : numbersList)
                sum = sum + num;
            
            System.out.println("Sum is " + sum);
            
            // home work: do the min, max and average calculations
            // challenge: try to compute the standard deviation
        } catch (FileNotFoundException fnfe) {
            System.err.println("File not found!");
        } catch (IOException ioe) {
            System.err.println("IOException");
        }
    }

    public FileIODemoSection4() {
//        readUsingScanner();
//        readUsingBufferedReader();
//        readFromFile();
//        writeToFile();
        task1();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        FileIODemoSection4 obj = new FileIODemoSection4();
    }

}
