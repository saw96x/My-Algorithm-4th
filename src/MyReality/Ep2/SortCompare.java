package MyReality.Ep2;

import edu.princeton.cs.algs4.Selection;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

import java.util.Scanner;

public class SortCompare
{
    public static double time(String alg, Comparable[] a)
    {
        Stopwatch timer = new Stopwatch();
        switch (alg)
        {
            case "Insertion":
                InsertionSort.sort(a);
            case "Selection":
                Selection.sort(a);
        }
        return timer.elapsedTime();
    }

    public static double timeRandomInput(String alg, int N, int T)
    {
        double total = 0.0;
        Double[] a = new Double[N];
        for (int i = 0; i < T; i++)
        {
            for (int j = 0; j < N; j++)
            {
                a[j] = StdRandom.uniform();
            }
            total += time(alg, a);
        }
        return total;
    }

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        String alg1 = in.next();
        String alg2 = in.next();
        int N = in.nextInt();
        int T = in.nextInt();
        double t1 = timeRandomInput(alg1, N, T);
        double t2 = timeRandomInput(alg2, N, T);
        System.out.printf("For %d random Doubles\n      %s is", N, alg1);
        System.out.printf("%.1f  times faster than %s \n", t2 / t1, alg2);
    }
}
