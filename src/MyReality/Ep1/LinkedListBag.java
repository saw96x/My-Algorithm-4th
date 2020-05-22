package MyReality.Ep1;

import java.util.Iterator;


public class LinkedListBag<T> implements Iterable<T>
{
    /**
     * @Version: V1.0
     * @Author: Saw96x
     * @ClassName: LinkedListBag
     * @Description: 无序，只可入不许出，可迭代的背包类。
     * @Data: 16:41 2020/5/22
     **/
    private class Node
    {
        /**
         * @Version: V1.0
         * @Author: Saw96x
         * @ClassName: Node
         * @Description: 用作链表的结点类。
         * @Data: 16:40 2020/5/22
         **/
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

    public void add(T v)
    {
        var temp = head;
        head = new Node();
        head.next = temp;
        head.value = v;
        size++;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Iterator<T> iterator()
    {
        return new LinkedListIterator();
    }

    private class LinkedListIterator implements Iterator<T>
    {
        /**
         * @Version: V1.0
         * @Author: Saw96x
         * @ClassName: LinkedListIterator
         * @Description: 迭代器实现
         * @Data: 16:59 2020/5/22
         **/
        private Node current = head;

        /**
         * {@inheritDoc}
         */
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
