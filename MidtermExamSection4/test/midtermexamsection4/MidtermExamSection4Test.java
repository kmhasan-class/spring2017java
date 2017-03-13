/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package midtermexamsection4;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author kmhasan
 */
public class MidtermExamSection4Test {
    
    public MidtermExamSection4Test() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of countLines method, of class MidtermExamSection4.
     */
    @Test
    public void testCountLines() {
        System.out.println("countLines");
        String filename = "input";
        MidtermExamSection4 instance = new MidtermExamSection4();
        int expResult = 3;
        int result = instance.countLines(filename);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getSquaredSum method, of class MidtermExamSection4.
     */
    @Test
    public void testGetSquaredSum() {
        System.out.println("getSquaredSum");
        ArrayList<Integer> numbersList = new ArrayList<>();
        numbersList.add(3);
        numbersList.add(2);
        numbersList.add(1);
        MidtermExamSection4 instance = new MidtermExamSection4();
        int expResult = 14;
        int result = instance.getSquaredSum(numbersList);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
}
