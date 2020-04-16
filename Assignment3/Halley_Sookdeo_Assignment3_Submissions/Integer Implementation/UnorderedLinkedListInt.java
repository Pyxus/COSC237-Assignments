//Class: UnorderedLinkedListInt extends
//Class: LinkedListIntClass
// TO BE SUBMITTED
public class UnorderedLinkedListInt extends LinkedListIntClass {
    //Default constructor
    public UnorderedLinkedListInt() {
        super();
    }

    public boolean search(int searchItem)  {
        LinkedListNode current; //variable to traverse the list
        current = first;
        while (current != null)
            if (current.info == searchItem)
                return true;
            else
               current = current.link;
        return false;
    }

    public void insertFirst(int newItem) {
        LinkedListNode newNode;  //variable to create the new node
        //create and insert newNode before first
        newNode = new LinkedListNode(newItem, first);
        first = newNode;
        if (last == null)
            last = newNode;
        count++;
    }

    public void insertLast(int newItem)  {
        LinkedListNode newNode; //variable to create the new node
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

    public void deleteNode(int deleteItem) {
        LinkedListNode current; //variable to traverse the list
        LinkedListNode trailCurrent; //variable just before current
        boolean found;
        //Case 1; the list is empty
        if ( first == null)
            System.err.println("Cannot delete from an empty list.");
        else {
            //Case 2: the node to be deleted is first
            if (first.info == deleteItem) {
                first = first.link;
                if (first == null)  //the list had only one node
                    last = null;
                count--;
            }
            else {  //search the list for the given info
                found = false;
                trailCurrent = first; //trailCurrent points to first node
                current = first.link; //current points to second node
                while (current != null && !found) {
                    if (current.info == deleteItem)
                        found = true;
                    else {
                        trailCurrent = current;
                        current = current.link;
                    }
                }
                //Case 3; if found, delete the node
                if (found) {
                    count--;
                    trailCurrent.link = current.link;
                    if (last == current)  //node to be deleted was the last node
                       last = trailCurrent;
                }
                else
                   System.out.println("Item to be deleted is not in the list.");
            }
        }
    }

    public void merge1(UnorderedLinkedListInt list) {
        LinkedListNode nextNode = list.first;

        while (nextNode != null) {
            insertLast(nextNode.info);
            nextNode = nextNode.link;
        }
    }

    public UnorderedLinkedListInt merge2(UnorderedLinkedListInt list) {
        UnorderedLinkedListInt mergedLinkedList = new UnorderedLinkedListInt();
        LinkedListNode nextNode = first;
        boolean continueLoop = true;

        while (nextNode != null) {
            mergedLinkedList.insertLast(nextNode.info);
            nextNode = nextNode.link;
            if (nextNode == null && continueLoop) {
                continueLoop = false;
                nextNode = list.first;
            }
        }

        
        while (nextNode != null) {
            mergedLinkedList.insertLast(nextNode.info);
            nextNode = nextNode.link;
        }

        return mergedLinkedList;
    }
    public void split(UnorderedLinkedListInt list1, UnorderedLinkedListInt list2, int key) {
        list1.first = null;
        list1.last = null;
        list2.first = null;
        list2.last = null;
        LinkedListNode nextNode = first;
        
        while (nextNode != null) {
            if (nextNode.info <= key) {
                list1.insertLast(nextNode.info);
            }
            else {
                list2.insertLast(nextNode.info);
            }
            nextNode = nextNode.link;
        }

    }
}