package com.company;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;

public class CustomerTest {



    Customer c;
    @Before
    public void setUp() {

        c = new Customer();
        c.setName("Artichoke Pizza");
        c.setId(334678987);

        AccountRecord charge1 = new AccountRecord();
        charge1.setCharge(12345);
        charge1.setChargeDate("01-19-2023");
        c.getCharges().add(charge1);

        AccountRecord charge2 = new AccountRecord();
        charge2.setCharge(-12345);
        charge2.setChargeDate("01-20-2023");
        c.getCharges().add(charge2);

        AccountRecord charge3 = new AccountRecord();
        charge3.setCharge(100);
        charge3.setChargeDate("01-21-2023");
        c.getCharges().add(charge3);
    }

    @Test
    public void testGetBalance() {
        assertEquals(c.getBalance(), 12345 - 12345 + 100);
    }


    @Test
    public void testToString() {
        assertEquals(c.toString(), "Customer ID: 334678987\nCustomer name: Artichoke Pizza\nCustomer Balance: 100");
    }

}
