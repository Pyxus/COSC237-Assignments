import java.util.Random;

public class Matrix 
{
    public final int MAX = 20;

    private int size;
    private int[][] table = new int[MAX][MAX];

    public Matrix()
    {
        size = MAX;
        table = new int[MAX][MAX];
    }

    public Matrix(int s)
    {
        size = s;
        table = new int[s][s];
    }

    public int getSize()
    {
        return size;
    }

    public int getElement(int r, int c)
    {
        return table[r][c];
    }

    public void setElement(int r, int c, int value)
    {
        table[r][c] = value;
    }

    public void init(int low, int up)
    {
        Random rand = new Random();
        
        for (int i = 0; i < size; i++)
        {
          for (int j = 0; j < size; j++)
          {
            table[i][j] = rand.nextInt(up - low + 1) + low;
          }
        }
    }

    public void print()
    {
        for(int i = 0; i < size; i++)
        {
          for (int j = 0; j < size; j++)
          {
            System.out.printf("%5d", table[i][j]);
          }
          System.out.println();
        }
    }

    

}