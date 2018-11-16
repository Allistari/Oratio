public class Node<T> {
    private Node<T> parent;
    private Node<T> leftChild;
    private Node<T> rightChild;

    private T item;

    Node(T item, Node<T> parent) {
        this.parent = parent;
    }
}
