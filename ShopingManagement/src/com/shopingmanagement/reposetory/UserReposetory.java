package com.shopingmanagement.reposetory;

import com.shopingmanagement.model.Admin;
import com.shopingmanagement.model.Customer;
import com.shopingmanagement.model.User;

import java.util.HashMap;
import java.util.Map;

public class UserReposetory {

    public static Map<String, Customer> userList = new HashMap<>();
    public static Map<String, Admin> adminList = new HashMap<>();

    public static Map<String, Customer> getUserList() {
        return userList;
    }
}
