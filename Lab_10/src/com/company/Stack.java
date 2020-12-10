package com.company;

public class Stack<T> {

    private final int maxSize;
    private final T[] stack;
    private int top;

    @SuppressWarnings("unchecked")
    public Stack(int size) {
        this.maxSize = size;
        this.stack = (T[]) new Object[maxSize];
        this.top = -1;
    }

    public void push(T x) throws StackOverflowException {
        if (this.isFull()) {
            throw new StackOverflowException("Stack overflow: ", maxSize, top + 1);
        }
        System.out.println("Added: " + x);
        stack[++top] = x;
    }

    public T pop() throws StackUnderflowException {
        if (this.isEmpty()) {
            throw new StackUnderflowException("Stack is empty. Can not remove element: ", top);
        }
        T out = stack[top--];
        System.out.println("Removed: " + out);
        return out;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == maxSize - 1;
    }
}

//public class Stack<T> {
//
//    private Object[] stack;
//    private int[] a;
//    private int top;
//    private final int maxSize;
//
//    public Stack(int maxSize, Class<T[]> classT) {
//        this.top = -1;
//        this.maxSize = maxSize;
////        final T[] stack = (T[]) new Object[5];
//        final T[] stack = classT.cast(Array.newInstance(classT.getComponentType(), maxSize));
//        for (int i = 0; i < maxSize; i++) {
//            stack[i] = new Object();
//        }
//    }
//
//    public void incrementSize() {
//        ++top;
//    }
//
//    public void decrementSize() {
//        --top;
//    }
//
//    public boolean isEmpty() {
//        return top == -1;
//    }
//
//    public boolean isFull() {
//        return top == maxSize - 1;
//    }
//
//    public void push(T x) {
//        stack[++top] = x;
//    }
//
////    public T pop() {
////        T tmp = stack[top];
////        stack[top] = null;
////        decrementSize();
////        return tmp;
////    }
//}
