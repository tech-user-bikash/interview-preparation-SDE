package com.java.java8;

import java.util.List;
import java.util.function.*;

public class Test {
    public static void main(String[] args) {
        Emp emp = () -> 250;
        Predicate<Emp> pred1 = (e)->e.getSalary() > 100;
        Predicate<Emp> pred2 = (e)->e.getSalary() > 200;
        Predicate<Emp> pred3 = pred1.and(pred2);
        System.out.println(pred3.test(emp));


        Predicate<Integer> predicate = (x)-> x > 100;
        Function<Integer, Integer> function = (x)->x * x;
        Consumer<Integer> consumer = System.out::print;
        Supplier<Integer> supplier = ()-> 102;
        BiPredicate<Integer, Integer> biPredicate;
        BiFunction<Integer, Integer, Integer> biFunction;
        BiConsumer<Integer, Integer> biConsumer;

        UnaryOperator<Integer> unaryOperator;
        BinaryOperator<Integer> binaryOperator;


        if(predicate.test(supplier.get())){
            consumer.accept(function.apply(supplier.get()));
        }

    }

}
interface Emp {
    int getSalary();
}