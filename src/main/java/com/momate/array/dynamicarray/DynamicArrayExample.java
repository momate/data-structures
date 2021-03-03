package com.momate.array.dynamicarray;

public class DynamicArrayExample {

    public static void main(String[] args) {
        DynamicArray<Integer> data = new DynamicArray<>();
        data.add(1);
        data.add(2);
        data.add(3);

       data.forEach(System.out::println);
        System.out.println("-----" + data.size());
        data.add(9,19);
        System.out.println("--------------------");
        data.forEach(System.out::println);


    }
}
