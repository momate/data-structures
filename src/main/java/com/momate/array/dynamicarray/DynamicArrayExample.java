package com.momate.array.dynamicarray;

public class DynamicArrayExample {

    public static void main(String[] args) {
        DynamicArray<Integer> data = new DynamicArray<>();
        data.add(1);
        data.add(2);
        System.out.println("Size: " + data.size());
        data.add(3);
        data.add(4);
        System.out.println("Size: " + data.size());

        data.forEach(System.out::println);
        data.add(9,2);
        System.out.println("Size: " + data.size());
        data.forEach(System.out::println);

        data.remove(0);
        data.remove(0);
        System.out.println("Size: " + data.size());
        data.forEach(System.out::println);



    }
}
