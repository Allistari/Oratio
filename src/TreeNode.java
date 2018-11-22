public class TreeNode<T> {

    private T item;
    private String name;
    private TreeNode<T> leftChild;
    private TreeNode<T> rightChild;


    @Deprecated
    public TreeNode(T item) {
        this.item = item;

    }

    public TreeNode(T item, String name) {
        this.name = name;
    }

    public void addLeftChild(T item, String name) {
        leftChild = new TreeNode(item, name);
    }

    public void addRightChild(T item, String name) {
        rightChild = new TreeNode(item, name);
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
