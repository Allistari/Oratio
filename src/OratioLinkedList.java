public class OratioLinkedList<T> {
    private OratioNode<T> head;

    public OratioLinkedList() {

    }

    public boolean add(T item) {
        OratioNode<T> tempNode = head;

        if (head==null) {
            head=new OratioNode<T>(item,null);
            return true;
        }

        while(tempNode.getNext()!=null) {
            tempNode = tempNode.getNext();
        }

        tempNode.setNext(new OratioNode<T>(item,null));
        return true;

    }

    public boolean add(T item, int index) {

        int counter = 0;
        OratioNode<T> tempNode = head;
        OratioNode<T> tempNode2;

        if (head==null) {
            head=new OratioNode<T>(item,null);
            return true;
        }

        else if(index == 0) {
            tempNode2 = new OratioNode(item, head);
            head = tempNode2;
            return true;
        }

        while(tempNode.getNext()!=null && counter <= index) {
            tempNode = tempNode.getNext();
            counter++;
        }

        tempNode2 = tempNode.getNext();
        tempNode.setNext(new OratioNode<T>(item,null));
        tempNode.getNext().setNext(tempNode2);
        return true;
    }

    public T get(int index) {
        OratioNode<T> tempNode = head;

        for(int i = 0; i < index; i++) {
            tempNode = tempNode.getNext();

        }

        return tempNode.getItem();
    }

    public int indexOf(T item) {
        OratioNode<T> tempNode = head;
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

    public T remove(int index) {
        OratioNode<T> tempNode = head;
        T item;

        for(int i = 0; i < index-1; i++) {
            tempNode = tempNode.getNext();
        }


        item = tempNode.getNext().getItem();
        tempNode.setNext(tempNode.getNext().getNext()); //lol
        return item;
    }

    //  public boolean remove(T) {
    //  }

    public void clear() {
        this.head.setNext(null);
    }

    public int size() {

        OratioNode<T> tempNode = head;

        int counter = 0;

        while(tempNode != null) {
            tempNode = tempNode.getNext();
            counter++;
        }

        return counter;
    }

}
