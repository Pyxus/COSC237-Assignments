import java.util.Scanner;

public class ComplexNumberClient
{
  public static void main(String [] args)
  {
    boolean run = true;
    ComplexNumber cn1 = new ComplexNumber();
    ComplexNumber cn2 = new ComplexNumber();
    int commandCount = 0;
    String[] menuOptions = {
      "Add 2 complex numbers",
      "Subtracts 2 complex numbers",
      "Multiply 2 complex numbers",
      "Divide 2 complex numbers",
      "Absolute value of a complex number",
      "Compare 2 complex numbers"
    };
    
    while (run)
    {
      commandCount++;
      int selection = menu(menuOptions);
      System.out.println();
      switch (selection)
      {
        case 1: 
          cn1.read();
          cn2.read();
          
          System.out.println("First complex number is: " + cn1);
          System.out.println("Second complex number is: " + cn2);
          System.out.printf("Result %s + %s = %s", cn1, cn2, cn1.add(cn2));
          break;
          
        case 2: 
          cn1.read();
          cn2.read();
          
          System.out.println("First complex number is: " + cn1);
          System.out.println("Second complex number is: " + cn2);
          System.out.printf("Result %s - %s = %s", cn1, cn2, cn1.subtract(cn2));
          break;
          
        case 3: 
          cn1.read();
          cn2.read();
          
          System.out.println("First complex number is: " + cn1);
          System.out.println("Second complex number is: " + cn2);
          System.out.printf("Result %s * %s = %s", cn1, cn2, cn1.multiply(cn2));
          break;
          
        case 4: 
          cn1.read();
          cn2.read();
          
          System.out.println("First complex number is: " + cn1);
          System.out.println("Second complex number is: " + cn2);
          System.out.printf("Result %s / %s = %s", cn1, cn2, cn1.divide(cn2));
          break;
          
        case 5: 
          cn1.read();
          System.out.println("First complex number is: " + cn1);
          System.out.printf("Result |%s| = %s", cn1, cn1.cAbs());
          break;
          
        case 6: 
          cn1.read();
          cn2.read();
          
          System.out.println("First complex number is: " + cn1);
          System.out.println("Second complex number is: " + cn2);
          System.out.printf("The complex numbers are %s", cn1.equals(cn2) ? "equal" : "not equal");
          break;
          
        case 0: 
          run = false;
          System.out.println("Testing completed.");
          break;
      }
      if (run)
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