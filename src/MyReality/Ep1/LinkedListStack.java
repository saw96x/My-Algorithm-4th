package MyReality.Ep1;

import java.util.Iterator;

public class LinkedListStack<T> implements Iterable<T>
{
    /**
     * @Version: V1.0
     * @Author: Saw96x
     * @ClassName: LinkedListStack
     * @Description: 链表实现的栈。
     * @Data: 17:13 2020/5/22
     **/
    private class Node
    {
        T value;
        Node next;
    }

    private int size;
    private Node head;

    public boolean isEmpty()
    {
        return size == 0;
    }

    public int getSize()
    {
        return size;
    }

    public T pop()
    {
        T temp = head.value;
        head = head.next;
        size--;
        return temp;
    }

    public void push(T v)
    {
        var temp = head;
        head = new Node();
        head.next = temp;
        head.value = v;
        size++;
    }

    public T top()
    {
        return head.value;
    }

    @Override
    public Iterator<T> iterator()
    {
        return new LinkedListIterator();
    }

    private class LinkedListIterator implements Iterator<T>
    {
        private Node current = head;

        @Override
        public boolean hasNext()
        {
            return current != null;
        }

        @Override
        public T next()
        {
            T temp = current.value;
            current = current.next;
            return temp;
        }
    }
}
