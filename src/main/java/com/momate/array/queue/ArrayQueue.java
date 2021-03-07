package com.momate.array.queue;

public class ArrayQueue<T> {

    private T[] arr;
    private int last;
    private int head;
    private int size;

    public ArrayQueue(int maxSize) {
        this.head = this.last = 0;
        this.size = maxSize+1;
        arr = (T[]) new Object[size];
    }

    public T peek(){
        return arr[head];
    }

    public T poll(){
        T value = arr[head];
        if(++head == size){
            head = 0;
        }
        return value;
    }

    public boolean offer(T element){
        this.arr[last] = element;
        if(++last == size){
            last = 0;
        }
        if(head == last) throw new ArrayIndexOutOfBoundsException("Queue too small");

        return true;
    }

    public boolean isEmpty(){
        return head == last;
    }

}
