package com.momate.array.linkedlist;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SinglyLinkedList<T> implements Iterable<T> {

    private Node<T> head = null;
    private int size;

    public SinglyLinkedList() {
        this.size = 0;
    }

    public static class Node<T>{
        private T data;
        private Node<T> next;

        public Node(T data){
            this.data = data;
            this.next = null;
        }
    }

    public boolean add(T element){
        addLast(element);
        return true;
    }


    public void addLast(T element){
        Node<T> newNode = new Node(element);
        if(this.head == null){
            this.head = newNode;
        }else{
            Node last = this.head;
            while(last.next != null){
                last = last.next;
            }
            last.next = newNode;
        }
        ++this.size;

    }

    public void addFirst(T element){
        Node<T> newNode = new Node(element);

        if (this.head != null) {
            newNode.next = this.head;
        }
            this.head = newNode;
            ++this.size;
    }

    public T get(int index){
        Node<T> current = this.head;
        while (current.next != null && index >0){
            current = current.next;
            index--;
        }
        return current.data;
    }

    public T getLast(){
        if(this.size < 2){
            return this.head.data;
        }
        return get(this.size-1);

    }

    public T getFirst(){
        if(this.head == null) throw new NoSuchElementException();
        return this.head.data;
    }

    public T removeFirst(){
        if(this.head == null) throw new NoSuchElementException();
        T remove = this.head.data;
        this.head = this.head.next;
        return remove;
    }

    public int size(){
        return this.size;
    }

    public boolean isEmpty(){
        return size() == 0;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node<T> trav = head;
            @Override
            public boolean hasNext() {
                return trav != null;
            }

            @Override
            public T next() {
               T data = trav.data;
               trav = trav.next;
               return data;
            }
        };
    }

}
