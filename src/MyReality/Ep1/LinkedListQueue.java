package MyReality.Ep1;

public class LinkedListQueue<T>
{
    private class Node
    {
        T value;
        Node next;
    }

    private Node head;
    private Node tail;
    private int size;

    public boolean isEmpty()
    {
        return size == 0;
    }

    public int getSize()
    {
        return size;
    }

    public void enqueue(T value)
    {
        var temp = new Node();
        temp.value = value;
        if (size == 0)
            head = temp;
        else
            tail.next = temp;

        tail = temp;
        size++;
    }

    public T dequeue()
    {
        var temp = head.value;
        head = head.next;
        if (size == 0)
            tail = null;
        size--;
        return temp;
    }
}
