/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sorting.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 *
 * @author kmhasan
 */
public class SortingDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int intData[] = {5, 4, 2, 1, 3, 5, 3, 21, 5, 6, 3};
        System.out.println("Before sorting: " + Arrays.toString(intData));
        Arrays.sort(intData);
        System.out.println("After sorting:  " + Arrays.toString(intData));

        double doubleData[] = {2.35, 1.25, -63.21, 12.32, 9.87};
        System.out.println("Before sorting: " + Arrays.toString(doubleData));
        Arrays.sort(doubleData);
        System.out.println("After sorting:  " + Arrays.toString(doubleData));

        String stringData[] = {"Java", "C++", "C", "Python", "Ruby", "Javascript"};
        System.out.println("Before sorting: " + Arrays.toString(stringData));
        Arrays.sort(stringData);
        System.out.println("After sorting:  " + Arrays.toString(stringData));
        
        ArrayList<String> stringList = new ArrayList<>();
        stringList.add("Java");
        stringList.add("C++");
        stringList.add("C");
        stringList.add("Python");
        stringList.add("Ruby");
        stringList.add("Javascript");
        
        System.out.println("Before sorting: " + stringList);
        Collections.sort(stringList);
        System.out.println("After sorting:  " + stringList);
        
        ArrayList<Student> studentsList = new ArrayList<>();
        studentsList.add(new Student(566, "Md. Hasan Tareque", 3.44));
        studentsList.add(new Student(420, "Md. Rakibul Hasan", 3.88));
        studentsList.add(new Student(114, "Shahriar Manzoor", 3.99));
        studentsList.add(new Student(240, "Rajon Bardhan", 3.25));
        System.out.println("Before sorting: " + studentsList);
        Collections.sort(studentsList);
        System.out.println("After sorting:  " + studentsList);
    }
    
}
