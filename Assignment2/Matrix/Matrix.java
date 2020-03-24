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
  
  public Matrix add(Matrix m)
  {
    Matrix sum = new Matrix(size);
    for (int i = 0; i < size; i++)
    {
      for (int j = 0; j < size; j++)
      {
        sum.table[i][j] = table[i][j] + m.table[i][j];
      }
    }
    return sum;
  }
  
  public Matrix subtract(Matrix m)
  {
    Matrix diff = new Matrix(size);
    for (int i = 0; i < size; i++)
    {
      for (int j = 0; j < size; j++)
      {
        diff.table[i][j] = table[i][j] - m.table[i][j];
      }
    }
    return diff;
  }
  
  public Matrix multiply(Matrix m)
  {
    Matrix product = new Matrix(size);
    int sum = 0;
    for(int i = 0; i < size; i++)
    {
      for(int j = 0; j < size; j++)
      {
        for (int l = 0; l < size; l++)
        {
          sum += table[i][l] * m.table[i][l];
        }
        product.table[i][j] = sum;
        sum = 0;
      }
    }
    return product;
  }
  
  public Matrix multiplyConst (int whatConst)
  {
    Matrix mat = new Matrix(size);
    for (int i = 0; i < size; i++)
    {
      for (int j = 0; j < size; j++)
      {
        mat.table[i][j] = table[i][j] * whatConst;
      }
    }
    return mat;
  }
  
  public Matrix transpose()
  {
    Matrix mat = new Matrix(size);
    for(int i = 0; i < size; i++)
    {
      for(int j = 0; j < size; j++)
      {
        mat.table[j][i] = table[i][j];
      }
    }
    return mat;
    
  }
  
  public int trace() 
  {
    int sum = 0;
    for (int i = 0; i < size; i++)
    {
      sum += table[i][i];
    }
    return sum;
  }
  
  public boolean equals(Matrix m)
  {
    for (int i = 0; i < size; i++)
    {
      for (int j = 0; j < size; j++)
      {
        if (table[i][j] != m.table[i][j])
          return false;
      }
    }
    return true;
  }
  
  public void copy(Matrix m)
  {
    for (int i = 0; i < size; i++)
    {
      for (int j = 0; j < size; j++)
      {
        table[i][j] = m.table[i][j];
      }
    }
  }
  
  public Matrix getCopy()
  {
    Matrix mat = new Matrix(size);
    for (int i = 0; i < size; i++)
    {
      for (int j = 0; j < size; j++)
      {
        mat.table[i][j] = table[i][j];
      }
    }
    return mat;
  }
}