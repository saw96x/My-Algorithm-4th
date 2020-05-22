package MyReality.Ep2;

import edu.princeton.cs.algs4.StdOut;

import java.util.Scanner;

public class SelectionSort
{
    /**
     * @Version: V1.0
     * @Author: Saw96x
     * @ClassName: SelectionSort
     * @Description: 选择排序。
     * @Data: 17:49 2020/5/22
     **/
    public static void sort(Comparable[] a)
    {//升序排列
        int n = a.length;
        for (int i = 0; i < n; i++)
        {
            int min = i;         //最小元素的索引
            for (int j = i + 1; j < n; j++)                 //筛选出最小的元素。
                if (less(a[j], a[min]))
                    min = j;
            swap(a, i, min);               //交换当前的元素与最小的元素。
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
        String[] b = a.split(" ");
        sort(b);
        assert isSorted(b);
        show(b);
    }
}
