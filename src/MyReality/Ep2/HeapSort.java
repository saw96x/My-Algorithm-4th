package MyReality.Ep2;

import edu.princeton.cs.algs4.StdOut;
import java.util.Scanner;

public class HeapSort
{
    public static void sort(Comparable[] a)
    {
        int N = a.length;
        for (int k = N / 2; k >= 1; k--)
        {
            sink(a, k, N);
        }
        while (N > 1)
        {
            swap(a, 1, N--);
            sink(a, 1, N);
        }
    }

    private static void swap(Comparable[] a, int i, int j)
    {
        Comparable temp = a[i - 1];
        a[i - 1] = a[j - 1];
        a[j - 1] = temp;
    }

    private static boolean less(Comparable[] c, int a, int b)
    {
        return c[a - 1].compareTo(c[b - 1]) < 0;
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

    private static void sink(Comparable[] a, int k, int n)
    {
        while (2 * k <= n)
        {
            int j = 2 * k;
            if (j < n && less(a, j, j + 1))
                j++;
            if (!less(a, k, j))
                break;
            swap(a, k, j);
            k = j;
        }
    }

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        String a = in.nextLine();
        String[] b = a.split("");
        sort(b);
        show(b);
    }
}
