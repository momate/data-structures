package com.momate.array.linkedlist;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class DoublyLinkedList<T> implements Iterable<T> {

    private int size;
    private Node<T> head;

    public static class Node<T> {
        private T data;
        private Node<T> prev;
        private Node<T> next;

        public Node(T data, Node<T> prev, Node<T> next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }
    }

    public DoublyLinkedList() {
        this.size = 0;
    }

    public boolean add(T element) {
        addLast(element);
        return true;
    }


    public void addLast(T element) {
        if (isEmpty()) {
            this.head = new Node(element, null, null);
        } else {

            Node last = this.head;
            while (last.next != null) {
                last = last.next;
            }
            last.next = new Node<T>(element, last, null);
        }
        ++this.size;
    }

    public void addFirst(T element) {
        if (isEmpty()) {
            this.head = new Node(element, null, null);
        } else {
            Node<T> newNode = new Node(element, null, head);
            this.head = newNode;
        }
        ++this.size;

    }

    public T get(int index) {
        Node<T> current = this.head;
        while (current.next != null && index > 0) {
            current = current.next;
            index--;
        }
        return current.data;

    }

    public T getLast() {
        isHeadExist();
        if (this.size == 1) {
            return this.head.data;
        } else {
            Node<T> current = this.head;
            while (current.next != null) {
                current = current.next;
            }
            return current.data;
        }
    }

    public T getFirst() {
        isHeadExist();
        return this.head.data;
    }

    public T remove() {
        return removeFirst();
    }

    public T remove(int index) {
        if (index > size - 1 || index < 0) throw new NoSuchElementException();
        Node<T> tmp = this.head;
        for (int i = 0; i < index; i++) {
            tmp = tmp.next;
        }
        return removeNode(tmp);
    }


    public boolean remove(Object obj) {
        Node<T> tmp = head;
        for (tmp = head; tmp != null; tmp = tmp.next) {
            if (obj.equals(tmp.data)) {
                removeNode(tmp);
                return true;
            }
        }
        return false;
    }

    private T removeNode(Node<T> node) {
        if (node.prev == null) return removeFirst();
        if (node.next == null) return removeLast();

        node.next.prev = node.prev;
        node.prev.next = node.next;

        T data = node.data;
        //Cleanup
        node.data = null;
        node = node.prev = node.next = null;
        return data;
    }


    public T removeFirst() {
        isHeadExist();
        T data = this.head.data;
        this.head = this.head.next;
        --size;
        return data;
    }

    public T removeLast() {
        isHeadExist();
        T value;
        if(size == 1){
            value = this.head.data;
            removeFirst();
            return value;
        }else{
            Node<T> last = this.head;
            while(last.next != null){
                last = last.next;
            }
            Node beforeLast= last.prev;
            value = last.data;
            last.prev = null;
            last.data = null;
            beforeLast.next = null;
            --this.size;
        }
        return value;
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    private void isHeadExist() {
        if (this.head == null) throw new NoSuchElementException();
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node<T> tmp = head;

            @Override
            public boolean hasNext() {
                return head != null;
            }

            @Override
            public T next() {
                T data = head.data;
                tmp = tmp.next;
                return data;
            }
        };
    }


}
