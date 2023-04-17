package com.datastructure;

import java.util.Objects;

/**
 * 链表
 * @param <T> 链表中存放的元素类型
 */
public class LinkedList<T> {
    private int size = 0; // 链表所存的结点数
    private final Node<T> head = new Node<T>(null); // 头结点

    /**
     * 结点类
     */
    private static class Node<T> {
        T element; // 存放该节点的元素
        Node<T> next; // 存放下一个结点的引用

        public Node(T element) {
            this.element = element;
        }
    }

    /**
     * 获取索引 Index 处的元素
     */
    public T get(int index) {
        Objects.checkIndex(index, size);
        Node<T> cur = findIndexPrev(index + 1);
        return cur.element;
    }

    /**
     * 添加元素到链表
     * @param element 待添加的元素
     * @param index 待插入的位置
     */
    public void add(T element, int index) {
        rangeAddCheck(index);
        Node<T> cur = findIndexPrev(index);
        Node<T> newNode = new Node<>(element);
        newNode.next = cur.next;
        cur.next = newNode;
        size++;
    }

    /**
     * 移除索引 Index 处的结点
     */
    public T remove(int index) {
        Objects.checkIndex(index, size);
        Node<T> cur = findIndexPrev(index);
        Node<T> oldNode = cur.next;
        cur.next = oldNode.next;
        return oldNode.element;
    }

    /**
     * 链表是否为空
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 获取链表大小
     */
    public int size() {
        return size;
    }

    /**
     * 找到索引处结点的前一个结点
     * @param index 索引
     * @return 找到的结点
     */
    private Node<T> findIndexPrev(int index) {
        Node<T> cur = head;
        for (int i = 0; i < index; i++) cur = cur.next;
        return cur;
    }

    /**
     * 检查当前访问的 index 是否超过链表的 size
     */
    private void rangeAddCheck(int index) {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
        }
    }

    /**
     * 生成数组越界的错误字符串信息
     */
    private String outOfBoundsMsg(int index) {
        return "Index: " + index + ", Size: " + size;
    }
}
