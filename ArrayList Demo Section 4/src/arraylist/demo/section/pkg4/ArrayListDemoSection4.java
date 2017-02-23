/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arraylist.demo.section.pkg4;

import java.util.ArrayList;
/**
 *
 * @author kmhasan
 */
public class ArrayListDemoSection4 {

    public ArrayListDemoSection4() {
        int x[] = new int[4];
        x[0] = 30;
        x[1] = 87;
        x[2] = 89;
        x[3] = 33;
        for (int i = 0; i < x.length; i++)
            System.out.println(x[i]);
        
        ArrayList<Integer> numbersList = new ArrayList<>();
        numbersList.add(30);
        numbersList.add(87);
        numbersList.add(89);
        for (int i = 0; i < numbersList.size(); i++)
            System.out.println(numbersList.get(i));
        
        // enhanced for loop
        for (Integer num : numbersList)
            System.out.println(num);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new ArrayListDemoSection4();
    }
    
}
