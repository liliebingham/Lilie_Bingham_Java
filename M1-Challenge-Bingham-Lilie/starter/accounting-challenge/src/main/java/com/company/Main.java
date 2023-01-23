package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.HashMap;

public class Main {

    private static List<String[]> customerData = Arrays.asList(
            new String[] {"1","Wayne Enterprises","10000","12-01-2021"},
            new String[] {"2","Daily Planet","-7500","01-10-2022"},
            new String[] {"1","Wayne Enterprises","18000","12-22-2021"},
            new String[] {"3","Ace Chemical","-48000","01-10-2022"},
            new String[] {"3","Ace Chemical","-95000","12-15-2021"},
            new String[] {"1","Wayne Enterprises","175000","01-01-2022"},
            new String[] {"1","Wayne Enterprises","-35000","12-09-2021"},
            new String[] {"1","Wayne Enterprises","-64000","01-17-2022"},
            new String[] {"3","Ace Chemical","70000","12-29-2022"},
            new String[] {"2","Daily Planet","56000","12-13-2022"},
            new String[] {"2","Daily Planet","-33000","01-07-2022"},
            new String[] {"1","Wayne Enterprises","10000","12-01-2021"},
            new String[] {"2","Daily Planet","33000","01-17-2022"},
            new String[] {"3","Ace Chemical","140000","01-25-2022"},
            new String[] {"2","Daily Planet","5000","12-12-2022"},
            new String[] {"3","Ace Chemical","-82000","01-03-2022"},
            new String[] {"1","Wayne Enterprises","10000","12-01-2021"}
    );

    public static void main(String[] args) {

        HashMap<String, Customer> companies = new HashMap<>();
        List<Customer> customers = new ArrayList<>();


        for (int i = 0; i < customerData.size(); i++) {

            Customer c;
            String[] curr = customerData.get(i);
            String name = curr[1];

            if (!companies.containsKey(name)) {

                c = new Customer();
                c.setId(Integer.parseInt(curr[0]));
                c.setName(name);

                companies.put(name, c);
                customers.add(c);
            } else {
                c = companies.get(name);
            }

            AccountRecord charge = new AccountRecord();
            charge.setCharge(Integer.parseInt(curr[2]));
            charge.setChargeDate(curr[3]);

            c.getCharges().add(charge);

        }

        List<Customer> pos = new ArrayList<>();
        List<Customer> neg = new ArrayList<>();

        for (Customer c : customers) {
            int total = c.getBalance();

            if (total >= 0) {
                pos.add(c);
            } else {
                neg.add(c);
            }

        }

        System.out.println("Positive accounts:");
        for (Customer c : pos) {
            System.out.println(c.toString());
            System.out.println();
        }
        System.out.println();
        System.out.println("Negative accounts:");
        for (Customer c : neg) {
            System.out.println(c.toString());
            System.out.println();
        }
    }
}
