package com.shopingmanagement.services;

import com.shopingmanagement.model.Customer;
import com.shopingmanagement.model.Product;
import com.shopingmanagement.reposetory.UserReposetory;

import java.util.Map;

import static com.shopingmanagement.reposetory.UserReposetory.userList;

public class CustomerService {

    public void registerCustomer(String name){
        Customer customer = new Customer(name);
        userList.put(customer.getName(), customer);
    }

    public Customer loginCustomer(String userId){
        Map<String, Customer> customerList = UserReposetory.getUserList();

        Customer customer = customerList.get(userId);

        if(customer == null){
            System.out.println("No customer Found with userID: " + userId);
            return null;
        }

        return customer;
    }


}
