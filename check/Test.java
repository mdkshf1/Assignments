package com.springcore.check;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {
    public static void main(String[] args) {
        ApplicationContext ap = new AnnotationConfigApplicationContext("config.class");
        Adress address = (Adress) ap.getBean("address");
        System.out.println(address);
        address.str();
    }
}
