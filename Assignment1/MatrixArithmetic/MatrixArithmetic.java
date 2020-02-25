import java.util.Random;
import java.util.Scanner;

public class MatrixArithmetic
{
  public static void main (String[] args)
  {
    boolean run = true;
    Scanner scan = new Scanner(System.in); 
    String[] menuOptions = {
      "Add 2 matrices",
      "Subtract 2 matrices",
      "Multiply 2 matrices",
      "Multiply matrix by a constant", 
      "Transpose matrix", 
      "Matrix trace"
    };

    do
    {
      int selection = menu(menuOptions);
      
      int size;
      int[][] matrix1, matrix2;
      switch(selection)
      {
        case 0:
          run = false;
          break;
          
        case 1:
          size = getInt(scan,"Enter the size of the square matrices: ", "Not an Integer! Try Again!");
          matrix1 = genMatrix(size,1,10);
          matrix2 = genMatrix(size,1,10);
          
          System.out.println("First matrix is:");
          printMatrix(matrix1);
          
          System.out.println("Second matrix is:");
          printMatrix(matrix2);
          
          System.out.println("The resulting matrix is:");
          printMatrix(addMatrix(matrix1, matrix2));
          break;
          
        case 2:
          size = getInt(scan,"Enter the size of the square matrices: ", "Not an Integer! Try Again!");
          matrix1 = genMatrix(size,1,10);
          matrix2 = genMatrix(size,1,10);
          
          System.out.println("First matrix is:");
          printMatrix(matrix1);
          
          System.out.println("Second matrix is:");
          printMatrix(matrix2);
          
          System.out.println("The resulting matrix is:");
          printMatrix(subtractMatrix(matrix1,matrix2));
          break;
          
        case 3:
          size = getInt(scan,"Enter the size of the square matrices: ", "Not an Integer! Try Again!");
          matrix1 = genMatrix(size,1,10);
          matrix2 = genMatrix(size,1,10);
          
          System.out.println("First matrix is:");
          printMatrix(matrix1);
          
          System.out.println("Second matrix is:");
          printMatrix(matrix2);
          
          System.out.println("The resulting matrix is:");
          printMatrix(multiplyMatrix(matrix1,matrix2));
          break;
          
        case 4:
          size = getInt(scan,"Enter the size of the square matrix: ", "Not an Integer! Try Again!");
          matrix1 = genMatrix(size,1,10);
          int constant = getInt(scan, "Enter the multiplication constant", "Not an Integer! Try Again!");
          
          System.out.println("The matrix is:");
          printMatrix(matrix1);
          
          System.out.println("The original matrix multiplied by " + constant + " is:");
          printMatrix(multiplyMatrix(matrix1,constant));
          break;
          
        case 5:
          size = getInt(scan,"Enter the size of the square matrix: ", "Not an Integer! Try Again!");
          matrix1 = genMatrix(size,1,10);
          
          System.out.println("The matrix is:");
          printMatrix(matrix1);
          
          System.out.println("The transposed matrix is:");
          printMatrix(transposeMatrix(matrix1));
          break;
          
        case 6:
          size = getInt(scan,"Enter the size of the square matrix: ", "Not an Integer! Try Again!");
          matrix1 = genMatrix(size,1,10);
          
          System.out.println("The matrix is:");
          printMatrix(matrix1);
          
          System.out.print("The trace for this matrix is: ");
          System.out.println(traceMatrix(matrix1));
          break;
      }
      if (selection != 0)
      {
        System.out.printf("%64s\n" ,"Command Number " + selection + " completed. ");
        System.out.println();
      }
    } while (run);
    System.out.println("Testing complete");
  }
  
  public static int[][] genMatrix(int size, int minVal, int maxVal)
  {
    Random rand = new Random();
    int[][] matrix = new int[size][size];
    
    for (int i = 0; i < matrix.length; i++)
    {
      for (int j = 0; j < matrix[i].length; j++)
      {
        matrix[i][j] = rand.nextInt(maxVal - minVal + 1) + minVal;
      }
    }
    
    return matrix;
  }
  
  public static int[][] addMatrix(int[][] matrix1, int[][] matrix2)
  {
    int[][] sumMatrix = new int[matrix1.length][matrix1.length];
    if (matrix1.length == matrix2.length)
    {
      for (int i = 0; i < matrix1.length; i++)
      {
        for(int j = 0; j < matrix1[i].length; j++)
        {
          sumMatrix[i][j] = matrix1[i][j] + matrix2[i][j];
        }
      }
    }
    return sumMatrix;
  }
  
  public static int[][] subtractMatrix(int[][] matrix1, int[][] matrix2)
  {
    int[][] diffMatrix = new int[matrix1.length][matrix1.length];
    if (matrix1.length == matrix2.length)
    {
      for (int i = 0; i < matrix1.length; i++)
      {
        for(int j = 0; j < matrix1[i].length; j++)
        {
          diffMatrix[i][j] = matrix1[i][j] - matrix2[i][j];
        }
      }
    }
    return diffMatrix;
  }
  
  public static void printMatrix(int[][] matrix)
  {
    for(int i = 0; i < matrix.length; i++)
    {
      for (int j = 0; j < matrix[i].length; j++)
      {
        System.out.printf("%5d", matrix[i][j]);
      }
      System.out.println();
    }
  }
  
  public static int[][] transposeMatrix(int[][] matrix1)
  {
    int[][] movedMatrix = new int[matrix1.length][matrix1.length];
    for(int i = 0; i < matrix1.length; i++)
    {
      for(int j = 0; j < matrix1.length; j++)
      {
        movedMatrix[j][i] = matrix1[i][j];
      }
    }
    return movedMatrix;
  }
  
  public static int[][] multiplyMatrix(int[][] matrix1, int[][] matrix2)
  {
    int[][] productMatrix = new int[matrix1.length][matrix1.length];
    int length = matrix1.length;
    int sum = 0;
    for (int i = 0; i < length; i++)
    {
      for (int j = 0; j < length; j++)
      {
        for (int l = 0; l < length; l++)
        {
          sum += matrix1[i][l] * matrix2[l][j]; 
        }
        productMatrix[i][j] = sum;
        sum = 0; 
      }
    }
    return productMatrix;
  }
  
  public static int traceMatrix(int[][] matrix)
  {
    int sum = 0;
    for (int i = 0; i < matrix.length; i++)
    {
      sum += matrix[i][i];
    }
    return sum;
  }
  
  public static int[][] multiplyMatrix(int[][] matrix, int constant)
  {
    int[][] newMatrix = new int[matrix.length][matrix.length];
    for (int i = 0; i < matrix.length; i++)
    {
      for (int j = 0; j < matrix.length; j++)
      {
        newMatrix[i][j] = constant * matrix[i][j];
      }
    }
    return newMatrix;
  }
  
  public static int menu(String[] options)
  {
    int selection;
    boolean validOption = false;
    Scanner scan = new Scanner(System.in);
    do
    {
      System.out.println("Your options are:");
      System.out.println("-----------------");
      
      for (int i = 0; i < options.length; i++)
        System.out.printf("\t%s\n", (i + 1) + ") " + options[i]);
      System.out.printf("\t%s\n", "0) EXIT");
      
      selection = getInt(scan, "Please enter your option: ", "Not an integer! Try again! Please enter your option:");
      if (selection > -1 && selection <= options.length)
        validOption = true;
      else
        System.out.println();
      
    } while(!validOption);
    
    return selection;
  }
  
  public static int getInt(Scanner scan, String promptMsg, String invalidMsg)
  {
    System.out.print(promptMsg);
    while(!scan.hasNextInt())
    {
      scan.next();
      System.out.print(invalidMsg);
    }
    
    return scan.nextInt();
  }
  
  
}