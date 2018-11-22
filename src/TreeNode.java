public class TreeNode<T> {

    private T item;
    private String name;
    private TreeNode<T> leftChild;
    private TreeNode<T> rightChild;


    @Deprecated
    public TreeNode(T item) {
        this.item = item;

    }

    /**
     * constructs a TreeNode
     * @param item the item
     * @param name the name of the node
     */
    public TreeNode(T item, String name) {
        this.item = item;
        this.name = name;
    }


    /**
     * adds a node that branches off to the left
     * @param item the item the node will store
     * @param name the name of the node
     */
    public void addLeftChild(T item, String name) {
        leftChild = new TreeNode(item, name);
    }


    /**
     * adds a node that branches off to the right
     * @param item the item the node will store
     * @param name the name of the node
     */
    public void addRightChild(T item, String name) {
        rightChild = new TreeNode(item, name);
    }


    /**
     * gets the left child of the node
     * @return the left child of the node
     */
    public TreeNode<T> getLeftChild() {
        return leftChild;
    }


    /**
     * gets the right child of the node
     * @return the right child of the node
     */
    public TreeNode<T> getRightChild() {
        return rightChild;
    }

    /**
     * gets the item the node stores
     * @return the item
     */
    public T getItem() {
        return item;
    }

    /**
     * gets the name of the item
     * @return the name
     */
    public String getName() {
        return name;
    }
}
