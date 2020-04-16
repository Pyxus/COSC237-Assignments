public class UnorderedArrayList < T > extends ArrayListClass < T > {
	//Default constructor
	public UnorderedArrayList() {
		super();
	}
	//Alternate Constructor
	public UnorderedArrayList(int size) {
		super(size);
	}
	//Bubble Sort
	public void bubbleSort() {
		for (int pass = 0; pass < length - 1; pass++) {
			for (int i = 0; i < length - 1; i++) {
				Comparable < T > listElem = (Comparable < T > ) list[i];
				if (listElem.compareTo(list[i + 1]) > 0) {
					T temp = list[i];
					list[i] = list[i + 1];
					list[i + 1] = temp;
				}
			}
		}
	}
	//implementation for abstract methods defined in ArrayListClass
	//unordered list --> linear search
	public int search(T searchItem) {
		for (int i = 0; i < length; i++)
		if (list[i].equals(searchItem)) return i;
		return - 1;
	}
	public void insertAt(int location, T insertItem) {
		if (location < 0 || location >= maxSize) System.err.println("The position of the item to be inserted is out of range.");
		else if (length >= maxSize) System.err.println("Cannot insert in a full list.");
		else {
			for (int i = length; i > location; i--)
			list[i] = list[i - 1]; //shift right
			list[location] = insertItem;
			length++;
		}
	}
	public void insertEnd(T insertItem) {
		if (length >= maxSize) System.err.println("Cannot insert in a full list.");
		else {
			list[length] = insertItem;
			length++;
		}
	}
	public void replaceAt(int location, T repItem) {
		if (location < 0 || location >= length) System.err.println("The location of the item to be replaced is out of range.");
		else list[location] = repItem;
	}
	public void remove(T removeItem) {
		int i;
		if (length == 0) System.err.println("Cannot delete from an empty list.");
		else {
			i = search(removeItem);
			if (i != -1) removeAt(i);
			else System.out.println("Cannot delete! The item to be deleted is not in the list.");
		}
    }
    
    public UnorderedArrayList<T> merge(UnorderedArrayList<T> uaList) {
        int insertPos = 0;
        UnorderedArrayList<T> ual = new UnorderedArrayList<T>(length + uaList.length);
        
        for (int i = 0; i < length; i++, insertPos++) 
            ual.insertAt(insertPos, retrieveAt(i));
        
        for (int i = 0; i < uaList.length; i++, insertPos++)
            ual.insertAt(insertPos, uaList.retrieveAt(i));

        return ual;
    }

    public void split(UnorderedArrayList<T> list1, UnorderedArrayList<T> list2, T key) {
        list1.clearList();
        list2.clearList();
        for (int i = 0, j = 0, k = 0; i < length; i++) {
            Comparable<T> value = (Comparable<T>) retrieveAt(i);
            if (value.compareTo(key) <= 0) {
                list1.insertAt(j, retrieveAt(i));
                j++;
            }
            else {
                list2.insertAt(k, retrieveAt(i));
                k++;
            }
        }
    }
}