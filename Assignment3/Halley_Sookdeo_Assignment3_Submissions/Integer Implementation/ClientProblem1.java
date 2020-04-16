import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

// TO BE SUBMITTED
public class ClientProblem1 {
    public static void main(String[] args) {
        UnorderedArrayList list_1 = readIntegersFromFile(30, "Please input the name of the file to be opened for first list: ");
        UnorderedArrayList list_2 = readIntegersFromFile(30, "Please input the name of the file to be opened for second list: ");

        System.out.println("The first list is: ");
        list_1.print();

        System.out.println("The second list is: ");
        list_2.print();

        System.out.println("The merged list is: ");
        UnorderedArrayList result = list_1.merge(list_2);
        result.print();

        int splitKey = getInt("Enter key for split: ", "Error! Not an integer! Enter key for split: ");
        result.split(list_1, list_2, splitKey);

        System.out.println("The first list after split is: ");
        list_1.print();

        System.out.println("The second list after split is: ");
        list_2.print();
    }

    public static UnorderedArrayList readIntegersFromFile(int maxSize, String prompt) {
        Scanner cin = new Scanner(System.in);
        UnorderedArrayList list = new UnorderedArrayList(maxSize);
        boolean fileFound;
        int i = 0;

        do {
            fileFound = true;
            try {
                System.out.print(prompt);
                Scanner scan = new Scanner(new File(cin.next()));
                while (scan.hasNext()) {
                    if (scan.hasNextInt()) {
                        list.insertAt(i, scan.nextInt());
                        if (i > maxSize)
                            return list;
                        i++;
                    }
                    else {
                        scan.next();
                    }
                }
            }
            catch(FileNotFoundException e) {
                System.out.println("Error! File not found! ");
                fileFound = false;
            }
        } while(!fileFound);
        return list;
    }

    public static int getInt(String promptMsg, String invalidMsg)
    {
      Scanner cin = new Scanner(System.in);
      System.out.print(promptMsg);
      while(!cin.hasNextInt())
      {
        cin.next();
        System.out.print(invalidMsg);
      }
      
      return cin.nextInt();
    }
}