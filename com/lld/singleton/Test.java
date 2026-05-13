package com.lld.singleton;

import java.lang.reflect.Array;
import java.lang.reflect.Field;

public class Test {
    public static void main(String[] args) throws NoSuchFieldException {
        int[] intArray = (int[]) Array.newInstance(int.class, 5);
        System.out.println(intArray.getClass());

    }

}
class StoreWrapper<T> {

    private Store<T> variable;

    public StoreWrapper(Store<T> variable){
        this.variable = variable;
    }
}

class Store<T> {

    private T variable;

    public Store(T variable){
        this.variable = variable;
    }
}

