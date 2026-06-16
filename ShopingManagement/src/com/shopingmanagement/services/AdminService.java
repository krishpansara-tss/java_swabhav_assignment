package com.shopingmanagement.services;

public class AdminService {
    public static boolean adminLogin(String username, String password){
        if(username.equals("admin@123")){
            if(password.equals("123456")){
                return true;
            }else{
                System.out.println("Password doesn't match");
                return false;
            }
        }else{
            System.out.println("Username doesn't match");
            return false;
        }

    }
}
