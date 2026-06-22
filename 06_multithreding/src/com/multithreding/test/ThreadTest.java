package com.multithreding.test;

import com.multithreding.demo.MyThread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadTest {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();

        for(int i = 0; i < 100; i++){
            executorService.execute(new MyThread());
        }
    }
}
