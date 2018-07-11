/**
 *   Name:      Arellano, Josue
 *   File:      TrapezoidRule.java
 *   Project:   HW #5
 *   Due:       May 8, 2018
 *   Course:    cs301-s18
 *
 *   Description:   Using the trapezoid rule to estimate the definite integral
 *              of several functions.
 *
 */
package hw5;

public class TrapezoidRule
{
    interface Function {
        double func(double a);
    }
    
    public static double TrapezoidUniform(double a,double  b,int n, Function op)
    {
        double h = (double)(b - a) / n;
        double x = 0;
        double sum = (op.func(a) + op.func(b)) / 2;
        for(int i = 1; i < n; i++)
        {
            x = a + (i * h);
            sum += op.func(x);
        }
        sum *= h;
        System.out.printf("sum = %.8f\n", sum);
        return sum;
    }
    
    public static void Si(int n)
    {
        double sum = 0;
        for(int i = 0; i < n; i++)
        {
            double a = Math.pow(-1, i);
            double den = factorial((2 * i) + 1) * ((2 * i) + 1);
            sum += a / den;
        }
        System.out.printf("sum = %.8f\n", sum);
    }
    
    public static double factorial(int n)
    {
        if(n == 0) return 1;
        return factorial(n - 1) * n;
    }
    
    public static void main(String[] args)
    {
        Function f = (x) -> {
            if(x == 0) return  1;
            return (double) Math.sin(x) / x;
        };
        Function g = (x) -> Math.atan(x);
        Function h = (x) -> Math.exp(x);
        Function i = (x) -> Math.sin(x);
        System.out.print("integral of arctan(x) from 0 to 1: ");
        TrapezoidUniform(0, 1, 1000, g);
        System.out.print("integral of e^(x) from 0 to 1: ");
        TrapezoidUniform(0, 1, 1000, h);
        System.out.print("integral of sin(x) from 0 to pi: ");
        TrapezoidUniform(0, Math.PI, 1000, i);
        
        System.out.print("f(x) = sin(x)/x: ");
        TrapezoidUniform(0, 1, 800, f);
        Si(800);
    }
}
