import java.util.Scanner;

public class MatrixClient
{
  public static void main(String [] args)
  {
    int size;
    boolean run = true;
    boolean validSize = false;
    int commandCount = 0;
    String[] menuOptions = {
      "Add 2 matricies",
      "Subtract 2 matricies",
      "Multiply 2 matricies",
      "Multiply matrix by a constant",
      "Transpose matrix",
      "Matrix trace",
      "Make a copy",
      "Test for equality"
    };
    
    do
    {
      size = getInt("Enter the sie of the square matrix: ", "INPUT ERROR!!! Invalid size. Positive and <= 20.");
      if (size > 0 && size <= 20)
      {
        validSize = true;
      } 
      else
      {
        System.out.println("INPUT ERROR!!! Invalid size. Positive and <= 20.");
      }
      
    } while(!validSize);
    
    Matrix mat1 = new Matrix(size);
    Matrix mat2 = new Matrix(size);
    while (run)
    {
      commandCount++;
      int selection = menu(menuOptions);
      System.out.println();
      switch (selection)
      {
        case 1:
          mat1.init(1, 10);
          mat2.init(1, 10);
          System.out.println("First Matrix is: ");
          mat1.print();
          
          System.out.println("First Matrix is: ");
          mat2.print();
          
          System.out.println("The resulting matrix is: ");
          mat1.add(mat2).print();
          break;
          
        case 2:
          mat1.init(1, 10);
          mat2.init(1, 10);
          System.out.println("First Matrix is: ");
          mat1.print();
          
          System.out.println("First Matrix is: ");
          mat2.print();
          
          System.out.println("The resulting matrix is: ");
          mat1.subtract(mat2).print();
          break;
          
        case 3:
          mat1.init(1, 10);
          mat2.init(1, 10);
          System.out.println("First Matrix is: ");
          mat1.print();
          
          System.out.println("First Matrix is: ");
          mat2.print();
          
          System.out.println("The resulting matrix is: ");
          mat1.multiply(mat2).print();
          break;
          
        case 4: 
          int constant = getInt("Enter the multiplication constant", "Invalid input, ");
          mat1.init(1, 10);
          
          System.out.println("The original matrix is: ");
          mat1.print();
          
          System.out.println("The resulting matrix is: ");
          mat1.multiplyConst(constant).print();
          break;
          
        case 5:
          mat1.init(1, 10);
          
          System.out.println("The original matrix is: ");
          mat1.print();
          
          System.out.println("The resulting matrix is: ");
          mat1.transpose().print();
          break;
          
        case 6:
          mat1.init(1, 10);
          
          System.out.println("The original matrix is: ");
          mat1.print();
          
          System.out.println("The trace for this matrix is: " + mat1.trace());
          break;
          
        case 7:
          mat1.init(1, 10);
          
          System.out.println("The original matrix is: ");
          mat1.print();
          
          System.out.println("The copy of this matrix is: ");
          Matrix copyMat = mat1.getCopy(); 
          copyMat.print();
          
          System.out.println("Testing for equality. Should be equal!!");
          System.out.printf("The matricies are %s", mat1.equals(copyMat) ? "equal!!" : "not equal!!");
          break;
         
        case 8:
                    mat1.init(1, 10);
          mat2.init(1, 10);
          System.out.println("First Matrix is: ");
          mat1.print();
          
          System.out.println("First Matrix is: ");
          mat2.print();
          
          System.out.printf("The matricies are %s", mat1.equals(mat2) ? "equal!!" : "not equal!!");
          break;
          
        case 0: 
          run = false;
          System.out.println("Testing completed.");
          break;
      }
      System.out.printf("\nCommand number %d completed\n\n", commandCount);
    }
  }
  public static int menu(String[] options)
  {
    int selection;
    boolean validOption = false;
    do
    {
      System.out.println("Your options are:");
      System.out.println("-----------------");
      
      for (int i = 0; i < options.length; i++)
        System.out.printf("\t%d) %s\n", i + 1, options[i]);
      System.out.println("\t" + "0) EXIT");
      
      selection = getInt("Please enter your option: ", "Not an integer! Try again! Please enter your option:");
      if (selection > -1 && selection <= options.length)
        validOption = true;
      else
        System.out.println();
      
    } while(!validOption);
    
    return selection;
  }
  
  public static int getInt(String promptMsg, String invalidInputMsg)
  {
    Scanner cin = new Scanner(System.in);
    System.out.print(promptMsg);
    while(!cin.hasNextInt())
    {
      cin.next();
      System.out.print(invalidInputMsg);
    }
    
    return cin.nextInt();
  }
}