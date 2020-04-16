import java.util.*;
public abstract class LinkedListClass<T> implements LinkedListADT<T> {
    protected class LinkedListNode<T> implements Cloneable {
        public T info;
        public LinkedListNode<T> link;
        //Default constructor
        public LinkedListNode() {
            info = null;
            link = null;
        }

        //Alternate constructor
        public LinkedListNode(T elem, LinkedListNode<T> ptr) {
            info = elem;
            link = ptr;
        }

        public Object clone() {
            LinkedListNode<T> copy = null;
            try {
                copy = (LinkedListNode<T>) super.clone();
            }
            catch (CloneNotSupportedException e) {
                return null;
            }
            return copy;
        }

        public String toString() {
            return info.toString();
        }
    } //end class LinkedListNode

    //Instance variables of the class LinkedListClass
    protected LinkedListNode<T> first;//address of the first node/list
    protected LinkedListNode<T> last; //address of the last node/list
    protected int count;            //number of nodes in the list

    //Default constructor
    public LinkedListClass() {
        first = null;
        last = null;
        count = 0;
    }

    public boolean isEmptyList() {
        return (first == null);
    }

    public void initializeList() {
        first = null;
        last = null;
        count = 0;
    }

    public void print()  {
        LinkedListNode<T> current; //variable to traverse the list
        current = first;
        while (current != null) {//while more data to print
            System.out.print(current.info + " ");
            current = current.link;
        }
    }

    public int length() {
        return count;
    }

    public T front()   {
        return first.info;
    }

    public T back()  {
        return last.info;
    }

    public Object clone() {
        LinkedListClass<T> copy = null;
        try  {
            copy = (LinkedListClass<T>) super.clone();
        }
        catch (CloneNotSupportedException e){
            return null;
        }

        //If the list is not empty clone each node of the list.
        if (first != null) {
            //Clone the first node
            copy.first = (LinkedListNode<T>) first.clone();
            copy.last = copy.first;
            LinkedListNode<T> current;
            if (first != null)
                current = first.link;
            else
                current = null;
            //Clone the remaining nodes of the list
            while (current != null) {
                copy.last.link = (LinkedListNode<T>) current.clone();
                copy.last = copy.last.link;
                current = current.link;
            }
        }
        return copy;
    }

    //abstract methods

    public abstract boolean search(T searchItem);
    public abstract void insertFirst(T newItem);
    public abstract void insertLast(T newItem);
    public abstract void deleteNode(T deleteItem);
}