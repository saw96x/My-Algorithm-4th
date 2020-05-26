package MyReality.Ep2;

import edu.princeton.cs.algs4.Insertion;
import edu.princeton.cs.algs4.Quick;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class QuickSort
{
    public static void sort(Comparable[] a)
    {
        StdRandom.shuffle(a);//确保随机性
        sort(a, 0, a.length - 1);
    }

    private void max(Comparable[] a)
    {
        int max = 0;
        int n = a.length;
        for (int j = 1; j < n; j++)
        {
            if (less(a[max], a[j]))
                max = j;
        }
        swap(a, max, a.length - 1);
    }

    private static void sort(Comparable[] a, int lo, int hi)
    {
        if (hi <= lo + 10)
        {
            Insertion.sort(a);
            return;
        }
        int j = partition(a, lo, hi);
        sort(a, lo, j - 1);
        sort(a, j + 1, hi);
    }

    private static int partition(Comparable[] a, int lo, int hi)
    {
        int i = lo, j = hi + 1;
        Comparable v = a[lo];
        while (true)
        {
            while (less(a[++i], v)) ;
            while (less(v, a[--j]));
            if (i >= j)
                break;
            swap(a, i, j);
        }
        swap(a, lo, j);
        return j;
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
