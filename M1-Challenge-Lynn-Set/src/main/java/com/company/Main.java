package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Main {

    public static List<Customer> positiveAccounts = new ArrayList<>();
    public static List<Customer> negativeAccounts = new ArrayList<>();

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


    public static void newData() {
        ArrayList<Customer> newCustomers = new ArrayList<>();
        ArrayList<Integer> newCustomersId = new ArrayList<>();

        for (int i = 0; i < customerData.toArray().length; i++) {
            Customer customer = new Customer();
            AccountRecord accountRecord = new AccountRecord();
            customer.setId(Integer.parseInt(customerData.get(i)[0]));
            customer.setName(customerData.get(i)[1]);
            accountRecord.setCharge(Integer.parseInt(customerData.get(i)[2]));
            accountRecord.setChargeDate(customerData.get(i)[3]);
            
            if (newCustomersId.contains(customer.getId())) {
                int index = newCustomersId.indexOf(customer.getId());
                customer = newCustomers.get(index);
                customer.addCharge(accountRecord);
                newCustomers.remove(index);
                newCustomers.add(index, customer);
            } else {
                customer.addCharge(accountRecord);
                newCustomersId.add(customer.getId());
                newCustomers.add(customer);
            }
        }


        for (Customer customer : newCustomers) {
                System.out.println(customer);

                if (customer.getBalance() > 0)
                    positiveAccounts.add(customer);
                else
                    negativeAccounts.add(customer);
        }
    }


    public static void main(String[] args) {
        //Update this
        newData();
        System.out.println(" ");
        System.out.println("Positive Balance Accounts: "+positiveAccounts);
        System.out.println("Negative Balance Accounts: "+negativeAccounts);
    }
}
