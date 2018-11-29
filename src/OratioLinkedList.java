/**
 * OratioLinkedList
 * Stores items via nodes linked to each other
 * @author Eric Ke
 * Created: 2018-11-16
 * Last Modified: 2018-11-20
 */
public class OratioLinkedList<T> {
    private LinkedListNode<T> head;

    public OratioLinkedList() {

    }

    /**
     * Adds an item to the end of list
     * @param item the item to add to the list
     */
    public void add(T item) {
        LinkedListNode<T> tempNode = head;

        if (head==null) {
            head=new LinkedListNode<T>(item,null);
            return;
        }

        while(tempNode.getNext()!=null) {
            tempNode = tempNode.getNext();
        }

        tempNode.setNext(new LinkedListNode<T>(item,null));
    }

    /**
     * Adds an item to a specific index on the list
     * @param item the item to be added
     * @param index the index to add the item to
     */
    public void add(T item, int index) {

        int counter = 0;
        LinkedListNode<T> tempNode = head;
        LinkedListNode<T> tempNode2;

        if (head==null) {
            head=new LinkedListNode<T>(item,null);
            return;
        }

        else if(index == 0) {
            tempNode2 = new LinkedListNode(item, head);
            head = tempNode2;
            return;
        }

        while(tempNode.getNext()!=null && counter <= index) {
            tempNode = tempNode.getNext();
            counter++;
        }

        tempNode2 = tempNode.getNext();
        tempNode.setNext(new LinkedListNode<T>(item,null));
        tempNode.getNext().setNext(tempNode2);
    }


    /**
     * gets an object
     * @param index index of the item
     * @return an object
     */
    public T get(int index) {
        LinkedListNode<T> tempNode = head;

        for(int i = 0; i < index; i++) {
            tempNode = tempNode.getNext();

        }

        return tempNode.getItem();
    }

    /**
     * gets index of a specific item
     * @param item the item
     * @return index of item
     */
    public int indexOf(T item) {
        LinkedListNode<T> tempNode = head;
        int counter = 0;

        while(tempNode.getNext()!= null) {
            tempNode = tempNode.getNext();
            if(tempNode.getItem().equals(item)) {
                return counter;
            }
            counter++;
        }

        return -1;
    }

    /**
     * Removes whatever's in the specified index
     * @param index index of object
     * @return the object that was removed
     */
    public T remove(int index) {
        LinkedListNode<T> tempNode = head;
        T item;

        if(index == 0) {
            item = head.getItem();
            head = head.getNext();
            return item;
        }

        for(int i = 0; i < index-1; i++) {
            tempNode = tempNode.getNext();
        }


        item = tempNode.getNext().getItem();
        tempNode.setNext(tempNode.getNext().getNext()); //lol
        return item;
    }

    /**
     * clear the whole list
     */
    public void clear() {
        this.head.setNext(null);
    }

    /**
     * gets size of list
     * @return the size of the list
     */
    public int size() {

        LinkedListNode<T> tempNode = head;

        int counter = 0;

        while(tempNode != null) {
            tempNode = tempNode.getNext();
            counter++;
        }

        return counter;
    }

    /**
     * returns the contents of the list as an array
     * @return list as an array
     */
    public String[] toArray() {
        String[] array = new String[this.size()];

        for (int i = 0; i < this.size(); i++) {
            array[i] = (String) this.get(i);
        }

        return array;
    }
}
