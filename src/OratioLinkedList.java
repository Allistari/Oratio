public class OratioLinkedList<E> {
    private OratioNode<E> head;
    private int sizeOfList;

    public OratioLinkedList() {

    }

    public boolean add(E item) {
        OratioNode<E> tempNode = head;

        if (head==null) {
            head=new OratioNode<E>(item,null);
            return true;
        }

        while(tempNode.getNext()!=null) {
            tempNode = tempNode.getNext();
        }

        tempNode.setNext(new OratioNode<E>(item,null));
        return true;

    }

    public boolean add(E item, int index) {

        int counter = 0;
        OratioNode<E> tempNode = head;
        OratioNode<E> tempNode2;

        if (head==null) {
            head=new OratioNode<E>(item,null);
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
        tempNode.setNext(new OratioNode<E>(item,null));
        tempNode.getNext().setNext(tempNode2);
        return true;
    }

    public E get(int index) {
        OratioNode<E> tempNode = head;

        for(int i = 0; i < index; i++) {
            tempNode = tempNode.getNext();

        }

        return tempNode.getItem();
    }

    public int indexOf(E item) {
        OratioNode<E> tempNode = head;
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

    public E remove(int index) {
        OratioNode<E> tempNode = head;
        E item;

        for(int i = 0; i < index-1; i++) {
            tempNode = tempNode.getNext();
        }


        item = tempNode.getNext().getItem();
        tempNode.setNext(tempNode.getNext().getNext()); //lol
        return item;
    }

    //  public boolean remove(E) {
    //  }

    public void clear() {
        this.head.setNext(null);
    }

    public int size() {

        OratioNode<E> tempNode = head;

        int counter = 0;

        while(tempNode != null) {
            tempNode = tempNode.getNext();
            counter++;
        }

        return counter;
    }

}
