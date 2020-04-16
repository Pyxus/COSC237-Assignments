public interface ArrayListADT < T > extends Cloneable {
	public boolean isEmpty(); //determines whether the list is empty.
	public boolean isFull(); //determines whether the list is full.
	public int listSize(); //returns the number of elements in the list.
	public int maxListSize(); //returns the maximum size of the list.
	public void print(); //outputs the elements of the list.
	public Object clone(); //returns a copy of objects data in store. Clones only the references, not the objects
	public boolean isItemAtEqual(int location, T item); //determines whether item is the same as the item in the list at location.
	public void insertAt(int location, T insertItem); //inserts insertItem in the list at that location
	public void insertEnd(T insertItem); //inserts insertItem at the end of the list.
	public void removeAt(int location); //removes from list the item at location.
	public T retrieveAt(int location); //retrieves the element from the list at location.
	public void replaceAt(int location, T repItem); //replaces the element in the list at location with repItem.
	public void clearList(); //removes all the elements from the list.
	public int search(T searchItem); //determines whether searchItem is in the list.
	public void remove(T removeItem); //removes an item from the list.
}