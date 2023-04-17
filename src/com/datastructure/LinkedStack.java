package com.datastructure;

import java.util.NoSuchElementException;

/**
 * 栈（链式存储）
 * 栈是一种特殊的线性表，是一种满足 LIFO(Last In, First Out) 特性的数据结构
 * @param <T> 所存放的元素类型
 */
public class LinkedStack<T> {
    private final Node<T> head = new Node<>(null); // 头结点，其指向栈顶

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
     * 将元素压栈
     * @param element 待压栈的元素
     */
    public void push(T element) {
        Node<T> node = new Node<>(element);
        node.next = head.next;
        head.next = node;
    }

    /**
     * 将栈顶元素出栈
     * @return 被出栈的元素
     */
    public T pop() {
        T element = peek();
        head.next = head.next.next;
        return element;
    }

    /**
     * 获取栈顶元素
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
            throw new NoSuchElementException("The stack is empty.");
        }
    }
}
