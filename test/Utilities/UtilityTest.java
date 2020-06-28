/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilities;

import Model.Customer;
import Model.Income;
import java.util.ArrayList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author DELL
 */
public class UtilityTest {

    public UtilityTest() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testGetTotalIncome() {
        System.out.println("getTotalIncome");
        int incomeId = 5016;
        Utility instance = new Utility();
        double expResult = 45.13;
        double result = instance.getTotalIncome(incomeId);
        assertEquals(expResult, result, 0.0);
    }

    @Test
    public void testGetTaxLevelByTNTT() {
        System.out.println("getTaxLevelByTNTT");
        double TNTT = 25;
        Utility instance = new Utility();
        int expResult = 4; // expected level = 4: 18tr -> 32tr
        int result = instance.getTaxLevelByTNTT(TNTT);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testGetTaxLevelByTNTT2() {
        System.out.println("getTaxLevelByTNTT");
        double TNTT = 0;
        Utility instance = new Utility();
        int expResult = 0; // expected level = 4: 18tr -> 32tr
        int result = instance.getTaxLevelByTNTT(TNTT);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testGetTaxLevelByTNTT3() {
        System.out.println("getTaxLevelByTNTT");
        double TNTT = -22.5;
        Utility instance = new Utility();
        int expResult = 0; // expected level = 4: 18tr -> 32tr
        int result = instance.getTaxLevelByTNTT(TNTT);
        assertEquals(expResult, result);
    }
    

    @Test
    public void testGetTaxRatioByLevel() {
        System.out.println("getTaxRatioByLevel");
        int level = 3;
        Utility instance = new Utility();
        double expResult = 15;
        double result = instance.getTaxRatioByLevel(level);
        assertEquals(expResult, result, 0.0);
    }
    
    @Test
    public void testGetTaxRatioByLevel2() {
        System.out.println("getTaxRatioByLevel");
        int level = 0;
        Utility instance = new Utility();
        double expResult = 0;
        double result = instance.getTaxRatioByLevel(level);
        assertEquals(expResult, result, 0.0);
    }
    
    @Test
    public void testGetTaxRatioByLevel3() {
        System.out.println("getTaxRatioByLevel");
        int level = -3;
        Utility instance = new Utility();
        double expResult = 0;
        double result = instance.getTaxRatioByLevel(level);
        assertEquals(expResult, result, 0.0);
    }
    

    @Test
    public void testGetReduceDetail() {
        System.out.println("getReduceDetail");
        Customer customer = new Customer(100000, "Lam Nguyen", 22, "Nam",
                "Chuong My, Hanoi", "00109801111", "'2555866666'",
                "Có", 2, "Có");
        Income income = new Income(5016, customer, 5, 2020, 40, 0.6, 0.48,
                0.25, 3.5, 0, 0, 0, 0.3, 0);
        Utility instance = new Utility();
        ReduceDetail reduceDetail = instance.getReduceDetail(income);
        assertTrue(reduceDetail.getGtgcbt() == 9); // Có gtgcbt
        assertTrue(reduceDetail.getGtgcpt() == 7.2); // 2 ng phụ thuộc x 3.6
        assertTrue(reduceDetail.getGtbhbb() == 4.2); //10.5% x 40
    }
    
    @Test
    public void testGetReduceDetail2() {
        System.out.println("getReduceDetail2");
        Customer customer = new Customer(100000, "Lam Nguyen", 22, "Nam",
                "Chuong My, Hanoi", "00109801111", "'2555866666'",
                "Có", 0, "Có");
        Income income = new Income(5016, customer, 5, 2020, 32, 0.6, 0.48,
                0.25, 3.5, 0, 0, 0, 0.3, 0);
        Utility instance = new Utility();
        ReduceDetail reduceDetail = instance.getReduceDetail(income);
        assertTrue(reduceDetail.getGtgcbt() == 9); // Có gtgcbt
        assertTrue(reduceDetail.getGtgcpt() == 0); // 0 ng phụ thuộc x 3.6
        assertTrue(reduceDetail.getGtbhbb() == 3.36); //10.5% x 32
    }
    
    @Test
    public void testGetReduceDetail3() {
        System.out.println("getReduceDetail3");
        Customer customer = new Customer(100000, "Lam Nguyen", 22, "Nam",
                "Chuong My, Hanoi", "00109801111", "'2555866666'",
                "Có", 3, "Có");
        Income income = new Income(5016, customer, 5, 2020, 32, 0.6, 0.48,
                0.25, 3.5, 0, 0, 0, 0.3, 0);
        Utility instance = new Utility();
        ReduceDetail reduceDetail = instance.getReduceDetail(income);
        assertTrue(reduceDetail.getGtgcbt() == 9); // Có gtgcbt
        assertTrue(reduceDetail.getGtgcpt() == 10.8); // 3 ng phụ thuộc x 3.6
        assertTrue(reduceDetail.getGtbhbb() == 3.36); //10.5% x 32
    }
    
    @Test
    public void testGetReduceDetail4() {
        System.out.println("getReduceDetail4");
        Customer customer = new Customer(100000, "Lam Nguyen", 22, "Nam",
                "Chuong My, Hanoi", "00109801111", "'2555866666'",
                "Có", 3, "Có");
        Income income = new Income(5016, customer, 5, 2020, 32, 0.6, 0.48,
                0.25, 3.5, 0, 0, 0, 0.3, 0);
        Utility instance = new Utility();
        ReduceDetail reduceDetail = instance.getReduceDetail(income);
        assertTrue(reduceDetail.getPcanuong() == 0.48); // phụ cấp ăn uống = 0.48 < 0.73
    }
    
    @Test
    public void testGetReduceDetail5() {
        System.out.println("getReduceDetail5");
        Customer customer = new Customer(100000, "Lam Nguyen", 22, "Nam",
                "Chuong My, Hanoi", "00109801111", "'2555866666'",
                "Có", 3, "Có");
        Income income = new Income(5016, customer, 5, 2020, 32, 0.6, 1.2,
                0.25, 3.5, 0, 0, 0, 0.3, 0);
        Utility instance = new Utility();
        ReduceDetail reduceDetail = instance.getReduceDetail(income);
        assertTrue(reduceDetail.getPcanuong() == 0.73); // phụ cấp ăn uống = 1.2 > 0.73
    }
    
    @Test
    public void testGetReduceDetail6() {
        System.out.println("getReduceDetail6");
        Customer customer = new Customer(100000, "Lam Nguyen", 22, "Nam",
                "Chuong My, Hanoi", "00109801111", "'2555866666'",
                "Có", 3, "Có");
        Income income = new Income(5016, customer, 5, 2020, 32, 0.6, 1.2,
                0.05, 3.5, 0, 0, 0, 0.3, 0);
        Utility instance = new Utility();
        ReduceDetail reduceDetail = instance.getReduceDetail(income);
        assertTrue(reduceDetail.getPcvpp() == 0.05); // phụ cấp văn phòng phẩm = 0.05 < 0.083333
    }
    
    @Test
    public void testGetReduceDetail7() {
        System.out.println("getReduceDetail7");
        Customer customer = new Customer(100000, "Lam Nguyen", 22, "Nam",
                "Chuong My, Hanoi", "00109801111", "'2555866666'",
                "Có", 3, "Có");
        Income income = new Income(5016, customer, 5, 2020, 32, 0.6, 1.2,
                0.25, 3.5, 0, 0, 0, 0.3, 0);
        Utility instance = new Utility();
        ReduceDetail reduceDetail = instance.getReduceDetail(income);
        assertTrue(reduceDetail.getPcvpp() == 0.083333); // phụ cấp văn phòng phẩm = 0.25 > 0.083333
    }

    @Test
    public void testGetListTaxAmountByLevels() {
        System.out.println("getListTaxAmountByLevels");
        Utility instance = new Utility();
        ArrayList<Double> listTaxAmountByLevels = instance.getListTaxAmountByLevels();
        assertTrue(listTaxAmountByLevels.get(0) == 0.25);
        assertTrue(listTaxAmountByLevels.get(1) == 0.5);
        assertTrue(listTaxAmountByLevels.get(2) == 1.2);
        assertTrue(listTaxAmountByLevels.get(3) == 2.8);
        assertTrue(listTaxAmountByLevels.get(4) == 5.0);
        assertTrue(listTaxAmountByLevels.get(5) == 8.4);
    }

    @Test
    public void testCaculateLowerLevelTaxAmount() {
        System.out.println("caculateLowerLevelTaxAmount");
        int level = 3;
        Utility instance = new Utility();
        double expResult = 0.75;
        double result = instance.caculateLowerLevelTaxAmount(level);
        assertEquals(expResult, result, 0.0);
    }
    
    @Test
    public void testCaculateLowerLevelTaxAmount2() {
        System.out.println("caculateLowerLevelTaxAmount");
        int level = 4;
        Utility instance = new Utility();
        double expResult = 1.95;
        double result = instance.caculateLowerLevelTaxAmount(level);
        assertEquals(expResult, result, 0.0);
    }
    
    @Test
    public void testCaculateLowerLevelTaxAmount3() {
        System.out.println("caculateLowerLevelTaxAmount");
        int level = 0;
        Utility instance = new Utility();
        double expResult = 0;
        double result = instance.caculateLowerLevelTaxAmount(level);
        assertEquals(expResult, result, 0.0);
    }
    
    @Test
    public void testCaculateLowerLevelTaxAmount4() {
        System.out.println("caculateLowerLevelTaxAmount");
        int level = -2;
        Utility instance = new Utility();
        double expResult = 0;
        double result = instance.caculateLowerLevelTaxAmount(level);
        assertEquals(expResult, result, 0.0);
    }

    @Test
    public void testCaculateTax() {
        System.out.println("caculateTax");
        double TNTT = 25; // level = 4 > 1
        Utility instance = new Utility();
        double expResult = 3.35;
        double result = instance.caculateTax(TNTT);
        assertEquals(expResult, result, 0.0);
    }
    
    @Test
    public void testCaculateTax2() {
        System.out.println("caculateTax");
        double TNTT = 13.1567; // level = 3 > 1
        Utility instance = new Utility();
        double expResult = 1.2235;
        double result = instance.caculateTax(TNTT);
        assertEquals(expResult, result, 0.0);
    }
    
    @Test
    public void testCaculateTax3() {
        System.out.println("caculateTax");
        double TNTT = 4; // level = 1
        Utility instance = new Utility();
        double expResult = 0.2;
        double result = instance.caculateTax(TNTT);
        assertEquals(expResult, result, 0.0);
    }
    
    @Test
    public void testCaculateTax4() {
        System.out.println("caculateTax");
        double TNTT = 0;
        Utility instance = new Utility();
        double expResult = 0;
        double result = instance.caculateTax(TNTT);
        assertEquals(expResult, result, 0.0);
    }
    
    @Test
    public void testCaculateTax5() {
        System.out.println("caculateTax");
        double TNTT = -22.45;
        Utility instance = new Utility();
        double expResult = 0;
        double result = instance.caculateTax(TNTT);
        assertEquals(expResult, result, 0.0);
    }
    

    @Test
    public void testCheckOnlyDigitCharacter() {
        System.out.println("checkOnlyDigitCharacter");
        String s = "";
        Utility instance = new Utility();
        boolean expResult = false;
        boolean result = instance.checkOnlyDigitCharacter(s);
        assertEquals(expResult, result);
    }

    @Test
    public void testCheckOnlyDigitCharacter2() {
        System.out.println("checkOnlyDigitCharacter");
        String s = "saas@&_sc";
        Utility instance = new Utility();
        boolean expResult = false;
        boolean result = instance.checkOnlyDigitCharacter(s);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testCheckOnlyDigitCharacter3() {
        System.out.println("checkOnlyDigitCharacter");
        String s = "ab25ssa";
        Utility instance = new Utility();
        boolean expResult = false;
        boolean result = instance.checkOnlyDigitCharacter(s);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testCheckOnlyDigitCharacter4() {
        System.out.println("checkOnlyDigitCharacter");
        String s = "123456789"; // true
        Utility instance = new Utility();
        boolean expResult = true;
        boolean result = instance.checkOnlyDigitCharacter(s);
        assertEquals(expResult, result);
    }
}
