import java.util.Scanner;

public class Client
{
    public static int menu(String[] options)
    {
        int selection;
        boolean validOption = false;
        do
        {
            System.out.println("Your options are:");
            System.out.println("-----------------");
            
            for (int i = 0; i < options.length; i++)
                System.out.printf("\t%d\n) %s", i + 1, options[i]);
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