package com.datastructure;

import java.util.NoSuchElementException;

/**
 * 栈（链式存储）
 * @param <T> 栈所存放的元素类型
 */
public class LinkedStack<T> {
    private final Node<T> head = new Node<>(null); // 头结点

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
        checkEmpty();
        T element = head.next.element;
        head.next = head.next.next;
        return element;
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
