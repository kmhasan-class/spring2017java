/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package file.io.demo.section.pkg3;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;

/**
 *
 * @author kmhasan
 */
public class FileIODemoSection3 {

    public void readUsingScanner() {
        int x = 0;
        double y = 0.0;
        String s = "";

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter an integer, a double and a string");

        x = scanner.nextInt();
        y = scanner.nextDouble();
        s = scanner.next();

        System.out.println(x);
        System.out.println(y);
        System.out.println(s);
    }

    public void readUsingBufferedReader() {
        int x = 0;
        double y = 0.0;
        String s = "";

        BufferedReader bufferedReader;
        bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Enter an integer, a double and a string");

        try {
            x = Integer.parseInt(bufferedReader.readLine());
            y = Double.parseDouble(bufferedReader.readLine());
            s = bufferedReader.readLine();
        } catch (IOException ioe) {
            System.out.println("Can't read anymore!");
        }

        System.out.println(x);
        System.out.println(y);
        System.out.println(s);
    }

    public void readUsingRandomAccessFile() {
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile("input.txt", "r");
            int x = Integer.parseInt(randomAccessFile.readLine());
            double y = Double.parseDouble(randomAccessFile.readLine());
            String s = randomAccessFile.readLine();
            System.out.println(x);
            System.out.println(y);
            System.out.println(s);
        } catch (FileNotFoundException fnfe) {
            System.out.println("Could not find the input file");
        } catch (IOException ioe) {
            System.out.println("Can't read anymore!");
        }

    }

    public void readFromFileUsingLoop() {
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile("input.txt", "r");
            String line;

            while (true) {
                line = randomAccessFile.readLine();
                if (line == null) {
                    break;
                }
                System.out.println(line);
            }

        } catch (FileNotFoundException fnfe) {
            System.out.println("Could not find the input file");
        } catch (IOException ioe) {
            System.out.println("Can't read anymore!");
        }

    }

    public void writeToFile() {
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile("output.txt", "rw");
            String message1 = "Hello there!";
            String message2 = "It's a bright and sunny day today!";
            int x = 12;
            randomAccessFile.writeBytes(x + "\n");
            randomAccessFile.writeBytes(message1 + "\n");
            randomAccessFile.writeBytes(message2 + "\n");
        } catch (FileNotFoundException fnfe) {
            System.out.println("File doesn't exist");
        } catch (IOException ioe) {
            System.out.println("Can't write to the file");
        }
    }

    public FileIODemoSection3() {
//        readUsingScanner();
//        readUsingBufferedReader();
//        readUsingRandomAccessFile();
//        readFromFileUsingLoop();
        writeToFile();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new FileIODemoSection3();
    }

}
