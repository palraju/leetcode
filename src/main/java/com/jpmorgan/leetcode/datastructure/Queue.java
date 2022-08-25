package com.jpmorgan.leetcode.datastructure;

import java.util.Arrays;

public class Queue <E> {

    private Object[] elementArray;

    private int elementCount;

    public Queue (final int size) {
        elementArray = new Object[size];
        elementCount = 0;
    }

    public Queue () {
        this(10);
    }

    public synchronized E pop () {
       return removeElement ();
    }

    public synchronized E push (E element) {
        return addElement(element);
    }

    public synchronized int size () {
        return elementCount;
    }

    public synchronized boolean isEmpty() {
        if(elementCount == 0) return true;
        return false;
    }

    private synchronized E addElement (E element) {
        elementArray[elementCount ++] = element;
        return  element ;
    }

    private synchronized E removeElement () {
        if(elementCount == 0) {
            new RuntimeException("No element in Queue");
        }
        E object = (E) elementArray[0];
        elementArray[0] = null;
        for(int i=0 ; i <elementCount -1 ; i++ ) {
            elementArray[i] = elementArray[i+1];
        }
        elementArray[elementCount -1 ] = null;
        elementCount --;
        return object;
    }

    @Override
    public String toString() {
        return  Arrays.toString(elementArray);
    }

    public static void main (String[] args) {
        Queue<Integer> myQueue = new Queue();
        myQueue.push(new Integer(1));
        myQueue.push(new Integer(2));
        System.out.println(myQueue);
        System.out.println(myQueue.pop());
        System.out.println(myQueue);
    }

}

