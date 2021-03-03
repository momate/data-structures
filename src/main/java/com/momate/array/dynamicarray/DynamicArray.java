package com.momate.array.dynamicarray;

import java.util.Iterator;

public class DynamicArray <T> implements Iterable<T>{

    private T[] arr;
    private int len = 0;
    private int capacity = 0;

    public DynamicArray(int capacity) {
        if(capacity < 0) throw new IllegalArgumentException("Wrong Capacity: " + capacity);
        this.capacity = capacity;
        arr = (T[]) new Object[capacity];
    }

    public DynamicArray(){
        this(16);
    }

    public int size(){
        return len;
    }

    public boolean isEmpty(){
        return size() == 0;
    }

    public T get(int index){
        return arr[index];
    }

    public void set(int index, T element){
        arr[index] = element;
    }

    public void clear(){
        for (int i = 0; i< capacity; i++){
            arr[i] = null;
        }
        len = 0;
    }

    public void add(T element){
        if(len+1 >= capacity){
            if(capacity == 0){
                capacity = 1;
            }else {
                capacity *= 2;
            }
            T[] newArr = (T[]) new Object[capacity];
            for (int i = 0; i < len; i++){
                newArr[i] = arr[i];
            }
            arr = newArr;
        }

        arr[len++] = element;

    }

    public void add(T element, int index){
        if(index < 0) throw new ArrayIndexOutOfBoundsException();

            for (int i = len; i > index; i--) {
                arr[i] = arr[i - 1];
            }
            arr[index] = element;
            len++;
    }

    public T remove(int index){
        if(index >= len || index < 0) throw new ArrayIndexOutOfBoundsException();
        T data = arr[index];
        T[] newArr = (T[]) new Object[len-1];
        for (int i=0, j = 0; i < len; i++, j++){
            if(i == index){
                j--;
            }else{
                newArr[j] = arr[i];
            }
        }
        arr = newArr;
        capacity = --len;
        return data;
    }

    public boolean remove(Object o){
        for (int i = 0; i < len; i++) {
            if(arr[i].equals(o)){
                remove(i);
                return true;
            }
        }
        return false;
    }

    public int indexOf(Object o){
        for (int i = 0; i < len; i++) {
            if(arr[i].equals(o)){
                return i;
            }
        }
        return -1;
    }

    public boolean contains(Object o){
        return indexOf(o) != -1;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int index = 0;

            @Override
            public boolean hasNext() {
                return index < len;
            }

            @Override
            public T next() {
                return arr[index++];
            }
        };
    }

}
