package com.java.java8;

import java.util.Arrays;
import java.util.List;

public class MethodReferenceTest {
    public static void print(String s){
        System.out.println(s);
    }

    public void sample(String s){
        List<String> students = Arrays.asList("Alice", "Bob", "Charlie");
//        students.forEach(MethodReferenceTest::abc);
    }
    public static void main(String[] args) {
        List<String> students = Arrays.asList("Alice", "Bob", "Charlie");
//        students.forEach(x->System.out.println(x));
        students.forEach(MethodReferenceTest::print);
    }

    public void abc(String s){
        System.out.println(s);
    }

}

