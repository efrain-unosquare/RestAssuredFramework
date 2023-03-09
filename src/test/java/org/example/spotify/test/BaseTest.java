package org.example.spotify.test;

import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;

public class BaseTest {

    @BeforeMethod
    public void beforeMethod(Method method){
        System.out.println("Starting test: " + method.getName());
        System.out.println("Thread id: " + Thread.currentThread().getId());
    }
}
