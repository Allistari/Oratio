/**
 * OratioNode.java
 * Node
 */
public class OratioNode<E> {
    private E item;
    private OratioNode<E> next;

    public OratioNode(E item) {
        this.item=item;
        this.next=null;
    }

    public OratioNode(E item, OratioNode<E> next) {
        this.item=item;
        this.next=next;
    }

    public OratioNode<E> getNext(){

        return this.next;
    }

    public void setNext(OratioNode<E> next){
        this.next = next;
    }

    public E getItem(){
        return this.item;
    }

}
