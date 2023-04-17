package com.datastructure;

import java.util.NoSuchElementException;

/**
 * 队列（链式存储）
 * 栈是一种特殊的线性表，是一种满足 FIFO(First In, First Out) 特性的数据结构
 * @param <T> 所存放的元素类型
 */
public class LinkedQueue<T> {
    private final Node<T> head = new Node<>(null); // 队首
    private final Node<T> tail = new Node<>(null); // 队尾

    /**
     * 结点类
     */
    private static class Node<T> {
        T element;
        Node<T> next;

        public Node(T element) {
            this.element = element;
        }
    }

    /**
     * 入队
     * @param element 待入队的元素
     */
    public void offer(T element) {
        Node<T> newNode = new Node<>(element);
        if (head.next == null) {
            head.next = newNode;
        } else {
            tail.next.next = newNode;
        }
        tail.next = newNode;
    }

    /**
     * 出队
     * @return 被出队的元素
     */
    public T poll() {
        T element = peek();
        head.next = head.next.next;
        if (head.next == null) {
            tail.next = null;
        }
        return element;
    }

    /**
     * 获得队首元素
     */
    public T peek() {
        checkEmpty();
        return head.next.element;
    }

    public boolean isEmpty() {
        return head.next == null;
    }

    private void checkEmpty() {
        if (isEmpty()) {
            throw new NoSuchElementException("The queue is empty.");
        }
    }
}
