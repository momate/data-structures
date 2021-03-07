package com.momate.array.queue;

import com.momate.array.linkedlist.DoublyLinkedList;

import java.util.Iterator;

public class LinkedListQueue<T> implements Iterable<T>{

    private DoublyLinkedList<T> list = new DoublyLinkedList<>();

    public LinkedListQueue() {
    }

    public LinkedListQueue(T element){
        offer(element);
    }

    public T peek(){
        if(this.list.isEmpty()) return null;

        return this.list.getFirst();
    }

    public T poll(){
        if(this.list.isEmpty()) return null;

        return this.list.removeFirst();
    }

    public T offer(T element){
        this.list.addLast(element);
        return element;
    }

    @Override
    public Iterator<T> iterator() {
        return this.list.iterator();
    }
}
