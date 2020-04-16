import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

// TO BE SUBMITTED
public class ClientProblem4 {
    public static void main(String[] args) {
        ArrayList<Integer> list_1 = readIntegersFromFile(30, "Please input the name of the file to be opened for first list: ");
        ArrayList<Integer> list_2 = readIntegersFromFile(30, "Please input the name of the file to be opened for second list: ");

        System.out.println("The first list is: " + list_1);
        System.out.println("The second list is: " + list_2);

        ArrayList<Integer> result = merge(list_1, list_2);
        bubbleSort(result);
        System.out.println("The merged list sorted is: " + result);

        int splitKey = getInt("Enter key for split: ", "Error! Not an integer! Enter key for split: ");
        split(result, list_1, list_2, splitKey);
        System.out.println("The first list after split is: " + list_1);
        System.out.println("The second list after split is: " + list_2);
    }

    public static void bubbleSort(ArrayList<Integer> list) {
        int size = list.size();
        for (int i = 0; i < size-1; i++) {
            for(int j = 0; j < size-i-1; j++) {
                if(list.get(j) > list.get(j + 1)) {
                    int cache = list.get(j + 1);
                    list.set(j + 1, list.get(j));
                    list.set(j, cache);
                }
            }
        }
    }

    public static void split(ArrayList<Integer> sourceList, ArrayList<Integer> list1, ArrayList<Integer> list2, int key) {
        list1.clear();
        list2.clear();
        int size = sourceList.size();
        for (int i = 0, j = 0, k = 0; i < size; i++) {
            int value = sourceList.get(i);
            if (value <= key ) {
                list1.add(j, value);
                j++;
            }
            else {
                list2.add(k, value);
                k++;
            }
        }
    }

    public static ArrayList<Integer> merge(ArrayList<Integer> list1, ArrayList<Integer> list2) {
        ArrayList<Integer> result = new ArrayList<Integer>(); 
        result.addAll(list1);
        result.addAll(list2);
        return result;
    }

    public static ArrayList<Integer> readIntegersFromFile(int maxSize, String prompt) {
        Scanner cin = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<Integer>(maxSize);
        boolean fileFound;
        int i = 0;

        do {
            fileFound = true;
            try {
                System.out.print(prompt);
                Scanner scan = new Scanner(new File(cin.next()));
                while (scan.hasNext()) {
                    if (scan.hasNextInt()) {
                        list.add(scan.nextInt());
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