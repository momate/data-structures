package com.momate.array.dynamicarray;

import java.util.Iterator;

public class DynamicArray <T> implements Iterable<T>{

    private static final int DEFAULT_CAPACITY = 16;
    private T[] arr;
    private int len = 0;
    private int capacity = 0;

    public DynamicArray(int capacity) {
        if(capacity < 0) throw new IllegalArgumentException("Wrong Capacity: " + capacity);
        this.capacity = capacity;
        arr = (T[]) new Object[capacity];
    }

    public DynamicArray(){
        this(DEFAULT_CAPACITY);
    }

    public int size(){
        return this.len;
    }

    public boolean isEmpty(){
        return size() == 0;
    }

    public T get(int index){
        return this.arr[index];
    }

    public void set(int index, T element){
        this.arr[index] = element;
    }

    public void clear(){
        for (int i = 0; i< this.capacity; i++){
            arr[i] = null;
        }
        len = 0;
    }

    public boolean add(T element){
    ensureCapacity(this.len + 1);
    this.arr[this.len++] = element;
    return true;
    }

    public void add(T element, int index){
            indexCheck(index);
            ensureCapacity(this.len + 1);

            for (int i = this.len; i > index; i--) {
                arr[i] = arr[i - 1];
            }
            arr[index] = element;
            this.len++;
    }

    public T remove(int index){
        indexCheck(index);
        T data = arr[index];
        T[] newArr = (T[]) new Object[this.len-1];
        for (int i=0, j = 0; i < this.len; i++, j++){
            if(i == index){
                j--;
            }else{
                newArr[j] = arr[i];
            }
        }
        arr = newArr;
        capacity = --this.len;
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

    public void ensureCapacity(int minCapacity){
        if(minCapacity >= capacity) {
           int newCapacity = (capacity * 3) / 2;
            T[] newArr = (T[]) new Object[newCapacity];
            for (int i = 0; i < size(); i++){
                newArr[i] = arr[i];
            }
        }
    }

    private void indexCheck(int index){
        if(index < 0 || index > this.size()) throw new IndexOutOfBoundsException();
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
