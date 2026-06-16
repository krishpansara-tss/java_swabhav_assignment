package com.shopingmanagement.services;

import com.shopingmanagement.model.Customer;
import com.shopingmanagement.model.Product;
import com.shopingmanagement.reposetory.UserReposetory;

import java.util.Map;

import static com.shopingmanagement.reposetory.UserReposetory.userList;

public class CustomerService {

    public void registerCustomer(String name){
        Customer customer = new Customer(name);
        userList.put(customer.getCustomerId().toUpperCase(), customer);
        System.out.println("Account created successfully having ID: " + customer.getCustomerId());
        System.out.println("Do login to buy products.");
    }

    public Customer loginCustomer(String userId){
        Map<String, Customer> customerList = UserReposetory.getUserList();

        Customer customer = customerList.get(userId.toUpperCase());

        if(customer == null){
            System.out.println("No customer Found with userID: " + userId);
            return null;
        }

        return customer;
    }


}
