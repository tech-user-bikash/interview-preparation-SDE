package com.java.java8;

import java.util.Optional;

public class OptionalTest {
    public static void main(String[] args) {
        String name = null;
        String ans = Optional.ofNullable((String)getName()).orElse("A");
//        String ans1 = Optional.ofNullable((String)getName()).orElse("A");
        System.out.println(ans);
//        System.out.println(ans1);
    }

    private static Object getName(){
        return null;
    }
}
