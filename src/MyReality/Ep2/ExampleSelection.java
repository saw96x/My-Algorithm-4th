package MyReality.Ep2;

import edu.princeton.cs.algs4.StdOut;

import java.util.Scanner;

public class ExampleSelection
{
    public static void sort(Comparable[] a)
    {

    }

    private static boolean less(Comparable v, Comparable t)
    {
        return v.compareTo(t) < 0;
    }

    private static void swap(Comparable[] a, int i, int j)
    {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    private static void show(Comparable[] a)
    {
        for (int i = 0; i < a.length; i++)
        {
            StdOut.print(a[i] + " ");
        }
        StdOut.println();
    }

    public static boolean isSorted(Comparable[] a)
    {
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
