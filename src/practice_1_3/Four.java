package practice_1_3;

import MyReality.Ep1.LinkedListStack;

import java.util.Scanner;

public class Four
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        String brakets = in.nextLine();
        System.out.print(isValid(brakets));
    }

    public static boolean isValid(String brakets)
    {
        if (brakets.isEmpty())
            return true;
        LinkedListStack<Character> s = new LinkedListStack<>();
        int i = 0;
        s.push(brakets.charAt(i++));
        while (i < brakets.length())
        {
            if (brakets.charAt(i) == '(' || brakets.charAt(i) == '[' || brakets.charAt(i) == '{')
                s.push(brakets.charAt(i));
            else if (brakets.charAt(i) == ')')
            {
                if (s.top() == '(')
                    s.pop();
                else
                    return false;
            } else if (brakets.charAt(i) == ']')
            {
                if (s.top() == '[')
                    s.pop();
                else
                    return false;
            } else if (brakets.charAt(i) == '}')
            {
                if (s.top() == '{')
                    s.pop();
                else
                    return false;
            }
            i++;
        }
        if (s.isEmpty())
            return true;
        else
            return false;
    }
}
