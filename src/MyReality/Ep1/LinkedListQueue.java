package MyReality.Ep1;

public class LinkedListQueue<T>
{
    /**
     * @Version: V1.0
     * @Author: Saw96x
     * @ClassName: LinkedListQueue
     * @Description: 用链表实现的队列
     * @Data: 17:09 2020/5/22
     **/
    private class Node
    {
        /**
         * @Version: V1.0
         * @Author: Saw96x
         * @ClassName: Node
         * @Description: 用作链表的结点类
         * @Data: 17:09 2020/5/22
         **/
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
        /**
         * @Name enqueue
         * @Author Saw96x
         * @Version 1.0
         * @Description  进入队列。
         * @Date 17:10 2020/5/22
         * @Param [value]
         * @Return void
         **/
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
        /**
         * @Name dequeue
         * @Author Saw96x
         * @Version 1.0
         * @Description  出队。
         * @Date 17:12 2020/5/22
         * @Param []
         * @Return T
         **/
        var temp = head.value;
        head = head.next;
        if (size == 0)
            tail = null;
        size--;
        return temp;
    }
}
