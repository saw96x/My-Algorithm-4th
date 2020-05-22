package MyReality.Ep1;

import java.util.Iterator;

public class LinkedListBag<T> implements Iterable<T>
{
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

    public void add(T v)
    {
        var temp = head;
        head = new Node();
        head.next = temp;
        head.value = v;
        size++;
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
