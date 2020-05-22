package MyReality.Ep1;

import java.util.Iterator;

public class ResizingArrayStack<T> implements Iterable<T>
{
    /**
     * @Version: V1.0
     * @Author: Saw96x
     * @ClassName: ResizingArrayStack
     * @Description: 用数组实现的栈。
     * @Data: 17:14 2020/5/22
     **/
    private T[] values;
        private int size;

    public ResizingArrayStack(int a)
        {
            values = (T[]) new Object[a];
            size = a;
        }

        private void resize(int max)
        {
            var temp = (T[]) new Object[max];
            for (int i = 0; i < size; i++)
                temp[i] = values[i];
            values = temp;
        }

        public boolean isEmpty()
        {
            return size == 0;
    }

    public int getSize()
    {
        return size;
    }

    public void push(T v)
    {
        if (size == values.length)
            resize(values.length << 1);
        values[size++] = v;
    }

    public T pop()
    {
        var temp = values[--size];
        values[size] = null;
        if ((values.length >> 2) > size && size > 0)
            resize(values.length >> 1);
        return temp;
    }

    public Iterator<T> iterator()
    {
        return new ReverseArrayIterator();
    }

    private class ReverseArrayIterator implements Iterator<T>
    {
        private int i = size;

        public boolean hasNext()
        {
            return i > 0;
        }

        public T next()
        {
            return values[--i];
        }

        public void remove()
        {
        }
    }
}
