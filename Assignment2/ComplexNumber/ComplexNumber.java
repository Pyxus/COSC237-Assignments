import java.util.Scanner;

public class ComplexNumber 
{
    private double real;
    private double imaginary;

    public ComplexNumber()
    {
        real = 0;
        imaginary = 0;
    }

    public ComplexNumber(double r, double i)
    {
        real = r;
        imaginary = i;
    }

    public ComplexNumber add(ComplexNumber cn)
    {
        return new ComplexNumber(real + cn.real, imaginary + cn.imaginary);
    }

    public ComplexNumber subtract(ComplexNumber cn)
    {
        return new ComplexNumber(real - cn.real, imaginary - cn.imaginary);
    }

    public ComplexNumber multiply(ComplexNumber cn)
    {
        return new ComplexNumber(real * cn.real - imaginary * cn.imaginary, real * cn.imaginary + imaginary * cn.real);
    }

    public ComplexNumber divide(ComplexNumber cn)
    {
        return new ComplexNumber((real * cn.real + imaginary * cn.imaginary) / (cn.real * cn.real + cn.imaginary * cn.imaginary), (imaginary * cn.real - real * cn.imaginary / (cn.real * cn.real + cn.imaginary * cn.imaginary)));
    }

    public double cAbs()
    {
        return Math.sqrt(real * real + imaginary * imaginary);
    }

    public void print()
    {
        System.out.printf("(%d %d)", real, imaginary);
    }

    public double getReal()
    {
        return real;
    }

    public double getImaginary()
    {
        return imaginary;
    }

    public boolean equals(ComplexNumber cn)
    {
        return real == cn.real && imaginary == cn.imaginary;
    }

    public void copy(ComplexNumber cn)
    {
        real = cn.real;
        imaginary = cn.imaginary;
    }

    public ComplexNumber getCopy()
    {
        return new ComplexNumber(real, imaginary);
    }

    public String toString()
    {
        return String.format("(%d %d)", real, imaginary);
    }

    public void read()
    {
        Scanner cin = new Scanner(System.in);
        System.out.print("Enter complex number (real imaginary)");
        while (!cin.hasNextDouble())
        {
            cin.next();
        }

        real = cin.nextDouble();

        while(!cin.hasNextDouble())
        {
            cin.next();
        }
        imaginary = cin.nextDouble();
    }
}