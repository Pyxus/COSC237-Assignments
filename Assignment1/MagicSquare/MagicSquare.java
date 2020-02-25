import java.util.*;

public class MagicSquare
{
  public static void main(String [] args)
  {
    boolean run = true;
    boolean validSize = false;
    Scanner scan = new Scanner(System.in);
    do
    {
      int size;
      while(!validSize)
      {
        size = getInt(scan, "Enter the size of magic square (positive & odd)", "Not an Integer! Try Again!");
        if (size % 2 == 0)
        {
          System.out.println("INPUT ERROR!!! Invalid size.");
        }
        else
        {
          System.out.println("The magic square with sinze = 3 is:");
          printMatrix(genMagicSquare(size));
          System.out.println("The " + size + "x" + size + "magic square adds up to " + (size * (size * size + 1) / 2));
          System.out.println();
          validSize = true;
        }
      };
      System.out.print("Do you want to continue (Y/N): ");
      char input = scan.next().toUpperCase().charAt(0);
      if (input == 'Y')
       validSize = false;
      else if (input == 'N')
        run = false;
    } while (run);
  }

  public static int[][] genMagicSquare(int size)
  {
    int[][] magicSquare = new int[size][size];
    int i = 0;
    int j = size / 2;
    int prevI = i;
    int prevJ = j;
    for (int k = 1; k <= size * size; k++)
    {
      if (i < 0)
        i = size - 1;
      if (j > size - 1)
        j = 0;
      if (magicSquare[i][j] != 0 || (prevI == 0 && prevJ == size - 1))
      {
        i = prevI + 1;
        j = prevJ;
      }
      magicSquare[i][j] = k;
      prevI = i;
      prevJ = j;
      i--; j++;
    }

    return magicSquare;
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