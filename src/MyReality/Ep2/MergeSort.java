package MyReality.Ep2;

import edu.princeton.cs.algs4.StdOut;

import java.util.Scanner;

public class MergeSort
{
    private static Comparable[] aux;

    public static void sort(Comparable[] a)
    {
        aux = new Comparable[a.length];
        sort(a, 0, a.length - 1);
    }

    private static void merge(Comparable[] a, int lo, int mid, int hi)
    {
        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++)
        {
            aux[k] = a[k];
        }
        for (int k = lo; k <= hi; k++)
        {
            if (i > mid)
                a[k] = aux[j++];
            else if (j > hi)
                a[k] = aux[i++];
            else if (less(aux[j], aux[i]))
                a[k] = aux[j++];
            else
                a[k] = aux[i++];
        }
    }

    private static void sort(Comparable[] a, int lo, int hi)
    {
        if (hi <= lo)
            return;
        int mid = lo + (hi - lo) / 2;
        sort(a, lo, mid);
        sort(a, mid + 1, hi);
        if (!(less(a[mid], a[mid + 1]) || a[mid].equals(a[mid + 1])))
            merge(a, lo, mid, hi);
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
