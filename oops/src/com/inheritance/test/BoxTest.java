package com.inheritance.test;

import com.inheritance.models.Box;
import com.inheritance.models.BoxWeight;

public class BoxTest {
    public static void main(String[] args) {
        Box bw1 = new BoxWeight(50, 50, 50, 50);

        System.out.println(bw1);
    }
}
