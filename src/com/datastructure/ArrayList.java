package com.datastructure;

/**
 * 顺序表
 * @param <T> 顺序表中存放的元素类型
 */
public class ArrayList<T> {
    private int capacity = 10; // 顺序表的容量，默认为 10
    private int size = 0; // 顺序表的有效元素长度
    private Object[] elementData = new Object[capacity]; // 用于存放顺序表的元素

    /**
     * 获取位置 index 处的元素
     */
    @SuppressWarnings("unchecked")
    public T get(int index) {
        rangeCheck(index);
        return (T) elementData[index];
    }

    /**
     * 在顺序表末尾插入元素
     * @param element 待插入的元素
     */
    public void add(T element) {
        checkGrow();
        elementData[size] = element;
        size++;
    }

    /**
     * 在顺序表中的 index 处插入一个元素，并且该位置之后（包括该位置）的元素全部后移一个位置
     * @param element 待插入的元素
     * @param index 插入位置
     */
    public void add(T element, int index) {
        rangeCheck(index);
        checkGrow();
        System.arraycopy(elementData, index, elementData, index + 1, size - index);
        elementData[index] = element;
        size++;
    }

    /**
     * 删除位置 index 处的元素
     * @return 被删除的元素
     */
    public T remove(int index) {
        rangeCheck(index);
        @SuppressWarnings("unchecked") T oldElement = (T) elementData[index];
        fastRemove(index);
        return oldElement;
    }

    public boolean remove(Object o) {
        int i = 0;
        if (o == null) {
            for (; i < size; i++) {
                if (elementData[i] == null) break;
            }
        } else {
            for (; i < size; i++) {
                if (o.equals(elementData[i])) break;
            }
        }
        fastRemove(i);
        return true;
    }

    /**
     * 顺序表是否为空
     */
    public boolean isEmpty() {
        return size == 0;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < size; i++) builder.append(elementData[i]).append(" ");
        return builder.toString();
    }

    /**
     * 检查当前顺序表是否需要扩容，如果需要，则进行扩容
     */
    private void checkGrow() {
        if (size == capacity) grow();
    }

    /**
     * 顺序表扩容
     * 当原顺序表容量不够的时候，进行扩容
     */
    private void grow() {
        int newCapacity = capacity << 1; // 扩容为原来的 2 倍
        Object[] newElementData = new Object[newCapacity];
        System.arraycopy(elementData, 0, newElementData, 0, size);
        elementData = newElementData;
        capacity = newCapacity;
    }

    /**
     * 删除顺序表中位置为 index 的元素，并且将 size - 1
     */
    private void fastRemove(int index) {
        int newSize = size - 1;
        if (size - 1 > index) {
            System.arraycopy(elementData, index + 1, elementData, index, size - index);
        }
        elementData[newSize] = null;
        size--;
    }

    /**
     * 检查当前访问的 index 是否超过数组的 size
     */
    private void rangeCheck(int index) {
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
