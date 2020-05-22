package MyReality.Ep1;

import edu.princeton.cs.algs4.*;

import java.util.Scanner;

public class DoubleStackToCalExpression_1
{
    public static void main(String[] args)
    {
        String expression1="( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) )";
        System.out.print(Cal(expression1));
    }

    public static double Cal(String s)
    {
        String[] StringArray = s.split(" ");
        var ops = new Stack<String>();
        var values = new Stack<Double>();
        for (String read : StringArray)
        {
            if (read.equals("("))
                ;
            else if (read.equals("+") || read.equals("-") || read.equals("*") || read.equals("/") || read.equals(
                    "sqrt"))
                ops.push(read);
            else if (read.equals(")"))
            {
                String op = ops.pop();
                double v = values.pop();
                if (op.equals("+"))
                    v = values.pop() + v;
                else if (op.equals("-"))
                    v = values.pop() - v;
                else if (op.equals("*"))
                    v = values.pop() * v;
                else if (op.equals("/"))
                    v = values.pop() / v;
                else if (op.equals("sqrt"))
                    v = Math.sqrt(v);
                values.push(v);
            } else
                values.push(Double.valueOf(read));
        }
        return values.pop();
    }
}
