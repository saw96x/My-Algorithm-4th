package MyReality.Ep1;

import edu.princeton.cs.algs4.*;

import java.util.Scanner;

/**
 * @Version: V1.0
 * @Author: Saw96x
 * @ClassName: DoubleStackToCalExpression
 * @Description: 双栈计算中缀表达式
 * @Data: 17:08 2020/5/22
 **/
public class DoubleStackToCalExpression
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        String expression1 = in.nextLine();
        System.out.print(Cal(expression1));
    }

    public static double Cal(String s)
    {
        String[] StringArray = s.split("");
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
