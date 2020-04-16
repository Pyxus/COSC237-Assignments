public class UnorderedLinkedList < T > extends LinkedListClass < T > {
	//Default constructor
	public UnorderedLinkedList() {
		super();
	}

	public boolean search(T searchItem) {
		LinkedListNode < T > current; //variable to traverse the list
		current = first;
		while (current != null)
		if (current.info.equals(searchItem)) return true;
		else current = current.link;
		return false;
	}

	public void insertFirst(T newItem) {
		LinkedListNode < T > newNode; //variable to create the new node
		//create and insert newNode before first
		newNode = new LinkedListNode < T > (newItem, first);
		first = newNode;
		if (last == null) last = newNode;
		count++;
	}

	public void insertLast(T newItem) {
		LinkedListNode<T> newNode; //variable to create the new node
		//create newNode
		newNode = new LinkedListNode(newItem, null);
		if (first == null) {
			first = newNode;
			last = newNode;
		}
		else {
			last.link = newNode;
			last = newNode;

		}
		count++;
	}

	public void deleteNode(T deleteItem) {
		LinkedListNode < T > current; //variable to traverse the list
		LinkedListNode < T > trailCurrent; //variable just before current
		boolean found;
		//Case 1; the list is empty
		if (first == null) System.err.println("Cannot delete from an empty list.");
		else {
			//Case 2: the node to be deleted is first
			if (first.info.equals(deleteItem)) {
				first = first.link;
				if (first == null) //the list had only one node
				last = null;
				count--;
			}
			else { //search the list for the given info
				found = false;
				trailCurrent = first; //trailCurrent points to first node
				current = first.link; //current points to second node
				while (current != null && !found) {
					if (current.info.equals(deleteItem)) found = true;
					else {
						trailCurrent = current;
						current = current.link;
					}
				}
				//Case 3; if found, delete the node
				if (found) {
					count--;
					trailCurrent.link = current.link;
					if (last == current) //node to be deleted was the last node
					last = trailCurrent;
				}
				else System.out.println("Item to be deleted is not in the list.");
			}
		}
    }
    
    public void merge1(UnorderedLinkedList<T> list) {
        LinkedListNode nextNode = list.first;

        while (nextNode != null) {
            insertLast((T) nextNode.info);
            nextNode = nextNode.link;
        }
    }

    public UnorderedLinkedList<T> merge2(UnorderedLinkedList<T> list) {
        UnorderedLinkedList<T> mergedLinkedList = new UnorderedLinkedList<T>();
        LinkedListNode nextNode = first;
        boolean continueLoop = true;

        while (nextNode != null) {
            mergedLinkedList.insertLast((T) nextNode.info);
            nextNode = nextNode.link;
            if (nextNode == null && continueLoop) {
                continueLoop = false;
                nextNode = list.first;
            }
        }

        
        while (nextNode != null) {
            mergedLinkedList.insertLast((T) nextNode.info);
            nextNode = nextNode.link;
        }

        return mergedLinkedList;
    }
    
    public void split(UnorderedLinkedList<T> list1, UnorderedLinkedList<T> list2, T key) {
        list1.first = null;
        list1.last = null;
        list2.first = null;
        list2.last = null;
        LinkedListNode nextNode = first;
        
        while (nextNode != null) {
            Comparable<T> value = (Comparable<T>) nextNode.info;
            if (value.compareTo(key) <= 0) {
                list1.insertLast((T) nextNode.info);
                System.out.println(nextNode.info);
            }
            else {
                list2.insertLast((T) nextNode.info);
            }
            nextNode = nextNode.link;
        }

    }

}