package com.momate.array.stack;

import com.momate.array.linkedlist.DoublyLinkedList;

import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.LinkedList;

public class Stack<T> implements Iterable<T>{

    //In this case I use my implementation
    DoublyLinkedList<T> list = new DoublyLinkedList<>();

    public Stack() {
    }

    public Stack(T firstElement){
        push(firstElement);
    }



    public boolean empty(){
        return list.isEmpty();
    }

    public T peek(){
        if(empty()) throw new EmptyStackException();
        return this.list.getLast();
    }

    public T pop(){
        if(empty()) throw new EmptyStackException();
        return this.list.removeLast();
    }

    public T push(T element){
        this.list.add(element);
        return element;
    }

    public int search(Object obj){
        if(empty()) return -1;
       DoublyLinkedList tmp = this.list;
       Object o = tmp.removeLast();
       int size = this.list.size();
       while(o != null){
           if(o.equals(obj)){
               return size;
           }
           o = tmp.removeLast();
           size--;
       }

       return -1;
    }


    @Override
    public Iterator<T> iterator() {
        return this.list.iterator();
    }
}
