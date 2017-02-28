/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arraylist.demo.pkgfor.section.pkg3;

import java.util.ArrayList;

/**
 *
 * @author kmhasan
 */
public class ArrayListDemoForSection3 {

    public ArrayListDemoForSection3() {
        int array[] = new int[4]; // in Java
        array[0] = 45;
        array[1] = 43;
        array[2] = array[0] * 5;
        array[3] = 66;
        
        array[1] = 49;
        for (int i = 0; i < array.length; i++)
            System.out.printf("%d\n", array[i]);
        
        
        ArrayList<Integer> list = new ArrayList<>();
        list.add(45);
        list.add(66);
        
        list.remove(0);
        for (int i = 0; i < list.size(); i++)
            System.out.println(list.get(i));
        
        // Need to talk about Enhanced for loop in next class
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayListDemoForSection3 obj = new ArrayListDemoForSection3();
    }

}
