/**
 * LinkedListNode.java
 * Node
 */
public class LinkedListNode<T> {
    private T item;
    private LinkedListNode<T> next;

    public LinkedListNode(T item) {
        this.item=item;
        this.next=null;
    }

    public LinkedListNode(T item, LinkedListNode<T> next) {
        this.item=item;
        this.next=next;
    }

    public LinkedListNode<T> getNext(){

        return this.next;
    }

    public void setNext(LinkedListNode<T> next){
        this.next = next;
    }

    public T getItem(){
        return this.item;
    }

}
