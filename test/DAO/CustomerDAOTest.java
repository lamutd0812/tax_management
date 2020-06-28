/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Customer;
import java.util.ArrayList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author DELL
 */
public class CustomerDAOTest {

    CustomerDAO instance = new CustomerDAO();

    public CustomerDAOTest() {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
        instance.con.rollback();
    }

    @Test
    public void testGetListCustomer() {
        System.out.println("getListCustomer");
        int expResult = 9;
        ArrayList<Customer> result = instance.getListCustomer();
        assertEquals(expResult, result.size());
    }

    @Test
    public void testGetCustomerById() {
        System.out.println("getCustomerById");
        int id = 10001;
        Customer result = instance.getCustomerById(id);
        assertEquals("Nguyễn Văn An", result.getName());
        assertEquals(25, result.getAge());
        assertEquals("Nam", result.getSex());
        assertEquals("Phường Văn Quán", result.getAddress());
        assertEquals("0123456785", result.getCmt());
        assertEquals("3588864289", result.getTaxId());
        assertEquals("Có", result.getGtgcbt());
        assertEquals(1, result.getGtgcpt());
        assertEquals("Có", result.getGtbhbb());
    }

    @Test
    public void testUpdateCustomer() {
        System.out.println("updateCustomer");
        Customer customer = new Customer(10001, "Phạm Văn Khoa", 25, "Nam",
                "Phường Văn Quán", "0123456785", "3588864289", "Có", 1, "Có");
        boolean expResult = true;
        boolean result = instance.updateCustomer(customer);
        Customer updatedCustomer = instance.getCustomerById(10001);
        assertEquals(expResult, result);
        assertEquals("Phạm Văn Khoa", updatedCustomer.getName());
    }

    @Test
    public void testAddCustomer() {
        System.out.println("addCustomer");
        Customer customer = new Customer(10045, "Test Nguyen", 35, "Nữ",
                "Phường Yeen Nghĩa", "1122459999", "5124569741", "Có", 3, "Có");
        boolean expResult = true;
        boolean result = instance.addCustomer(customer);
        assertEquals(expResult, result);
    }

    @Test
    public void testDeleteCustomer() {
        // this case fail: foreign key error
        System.out.println("deleteCustomer");
        int id = 10001;
        boolean expResult = true;
        boolean result = instance.deleteCustomer(id);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testDeleteCustomer2() {
        // this case pass
        System.out.println("deleteCustomer");
        int id = 10047;
        boolean expResult = true;
        boolean result = instance.deleteCustomer(id);
        assertEquals(expResult, result);
    }

}
