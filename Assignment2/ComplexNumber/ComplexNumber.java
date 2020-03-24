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
    return new ComplexNumber((real * cn.real + imaginary * cn.imaginary) / (cn.real * cn.real + cn.imaginary * cn.imaginary), (imaginary * cn.real - real * cn.imaginary) / (cn.real * cn.real + cn.imaginary * cn.imaginary));
  }
  
  public double cAbs()
  {
    return Math.sqrt(real * real + imaginary * imaginary);
  }
  
  public void print()
  {
    System.out.printf("(%f %f)", real, imaginary);
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
    return String.format("(%f, %f)", real, imaginary);
  }
  
  public void read()
  {
    Scanner cin = new Scanner(System.in);
    boolean run = true;
    
    while (run)
    {
      System.out.print("Enter complex number (real imaginary): ");
      String[] tokens = cin.nextLine().split(" ");
      if (tokens.length > 1)
      {
        try 
        {
          real = Double.parseDouble(tokens[0]);
          imaginary = Double.parseDouble(tokens[1]);
          run = false;
        }
        catch (NumberFormatException e)
        {
          System.out.print("Invalid input, ");
        }
      }
      else
      {
        System.out.print("Invalid input, ");
      }
    }
  }
}