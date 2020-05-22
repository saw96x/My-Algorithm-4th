package practice_1_3;

public class Forteen
{
    public class ResizingArrayQueue<T>
    {
        private T[] value;
        private int size;
        private int head;

        private void resize(int max)
        {
            var temp = (T[]) new Object[max];
            for (int i = 0; i < size; i++)
                temp[i] = value[i + head];
            head = 0;
            value = temp;
        }

        public ResizingArrayQueue(int a)
        {
            value = (T[]) new Object[a];
            size = a;
            head = 0;
        }

        public int getSize()
        {
            return size;
        }

        public boolean isEmpty()
        {
            return size == 0;
        }

        public T dequeue()
        {
            T temp = value[head];
            value[head++] = null;
            if (head > value.length >> 2)
                resize(value.length >> 1);
            size--;
            return temp;
        }

        public void enqueue(T v)
        {
            if (size == value.length)
                resize(value.length << 1);
            value[size++] = v;
        }
    }
}
