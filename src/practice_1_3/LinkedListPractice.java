package practice_1_3;

import MyReality.Ep1.LinkedListStack;

public class LinkedListPractice
{
    public class LinkedList<T>
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

        public T delete(int index)
        {
            if (index >= size)
                return null;
            if (index == 0)
            {
                var ans = head.value;
                head = head.next;
                size--;
                return ans;
            }
            {
                Node temp = head;
                for (int i = 1; i < index; i++)
                {
                    temp = temp.next;
                }
                var ans = temp.next.value;
                temp.next = temp.next.next;
                return ans;
            }
        }
    }

    public static boolean find(LinkedList.Node head, String key)
    {
        var temp = head;
        while (temp != null)
        {
            if (temp.value.toString() == key)
                return true;
            temp = temp.next;
        }
        return false;
    }
}
