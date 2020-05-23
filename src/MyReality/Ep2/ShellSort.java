package MyReality.Ep2;

import edu.princeton.cs.algs4.StdOut;

import java.util.Scanner;

public class ShellSort
{
    public static void sort(Comparable[] a)
    {
        /**
         * @Name sort
         * @Author Saw96x
         * @Version 1.0
         * @Description 希尔排序
         * @Date 20:29 2020/5/23
         * @Param [a]
         * @Return void
         **/
        int N = a.length;
        int h = 1;
        while (h < N)
            h = h * 3 + 1;
        while (h >= 1)
        {
            for (int i = h; i < N; i++)
            {
                for (int j = i; j >= h && less(a[j], a[j - h]); j -= h)
                {
                    swap(a, j, j - h);
                }
            }
            h = h / 3;
        }
    }

    private static boolean less(Comparable v, Comparable t)
    {
        /**
         * @Name less
         * @Author Saw96x
         * @Version 1.0
         * @Description 比较大小。
         * @Date 17:16 2020/5/22
         * @Param [v, t]
         * @Return boolean
         **/
        return v.compareTo(t) < 0;
    }

    private static void swap(Comparable[] a, int i, int j)
    {
        /**
         * @Name swap
         * @Author Saw96x
         * @Version 1.0
         * @Description 交换数组中的元素。
         * @Date 17:16 2020/5/22
         * @Param [a, i, j]
         * @Return void
         **/
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    private static void show(Comparable[] a)
    {
        /**
         * @Name show
         * @Author Saw96x
         * @Version 1.0
         * @Description 打印数组中的元素。
         * @Date 17:17 2020/5/22
         * @Param [a]
         * @Return void
         **/
        for (int i = 0; i < a.length; i++)
        {
            StdOut.print(a[i] + " ");
        }
        StdOut.println();
    }

    public static boolean isSorted(Comparable[] a)
    {
        /**
         * @Name isSorted
         * @Author Saw96x
         * @Version 1.0
         * @Description 判断数组是否有序。
         * @Date 17:18 2020/5/22
         * @Param [a]
         * @Return boolean
         **/
        for (int i = 0; i < a.length; i++)
        {
            if (less(a[i], a[i + 1]))
                return false;
        }
        return true;
    }

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        String a = in.nextLine();
        String[] b = a.split("");
        sort(b);
        assert isSorted(b);
        show(b);
    }
}
