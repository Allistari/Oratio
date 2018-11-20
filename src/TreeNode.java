public class TreeNode<T> {

    private T item;
    private TreeNode<T> leftChild;
    private TreeNode<T> rightChild;

    public TreeNode(T item) {
        this.item = item;

    }

    public void addLeftChild(T item) {
        leftChild = new TreeNode(item);
    }

    public void addRightChild(T item) {
        rightChild = new TreeNode(item);
    }

    public TreeNode<T> getLeftChild() {
        return leftChild;
    }

    public TreeNode<T> getRightChild() {
        return rightChild;
    }

    public T getItem() {
        return item;
    }
}
