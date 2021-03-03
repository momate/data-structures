package com.momate.array.staticarray;

public class StaticArray {

    public static void main(String[] args) {
        //Fixed length container, indexable elements

        // One Dimension

        int[] numbers = new int[5];
        numbers[0] = 1;
        numbers[1] = 2;
        numbers[2] = 3;
        numbers[3] = 4;
        numbers[4] = 5;

        for (int num : numbers)
            System.out.println(num);

        // Two Dimension

        char[][] charArr = new char[3][2];
        charArr[0][0] = 'a';
        charArr[0][1] = 'b';
        charArr[1][0] = 'c';
        charArr[1][1] = 'd';
        charArr[2][0] = 'e';
        charArr[2][1] = 'f';

        for (char[] rows : charArr){
            for (char ch : rows){
                System.out.println(ch);
            }
        }
    }
}