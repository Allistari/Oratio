/**
 * OratioNode.java
 * Node
 */
public class OratioNode<T> {
    private T item;
    private OratioNode<T> next;

    public OratioNode(T item) {
        this.item=item;
        this.next=null;
    }

    public OratioNode(T item, OratioNode<T> next) {
        this.item=item;
        this.next=next;
    }

    public OratioNode<T> getNext(){

        return this.next;
    }

    public void setNext(OratioNode<T> next){
        this.next = next;
    }

    public T getItem(){
        return this.item;
    }

}
