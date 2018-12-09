/**
 * OratioTree
 * Modular tree data structure for the Oratio program
 * @author Eric Ke
 * Created: 2018-11-16
 * Last Modified: 2018-11-21
 */
public class OratioTree<T> {

    private TreeNode<T> root;

    public OratioTree() {
    }


    /**
     * add an item to the tree
     * @param item the object to be added
     * @param name the name of the object so it can be retrieved
     */
    public void add(T item, String name) {

        OratioDEQueue<TreeNode<T>> queue = new OratioDEQueue<>();

        if(root == null) {
            root = new TreeNode<T>(item, name);
            return;
        } else {

            queue.addLast(root);
            while(!queue.isEmpty()) {
                TreeNode<T> node = queue.pollFirst();
                if(node.getLeftChild() != null && node.getRightChild() != null) {
                    queue.addLast(node.getLeftChild());
                    queue.addLast(node.getRightChild());
                } else {
                    if(node.getLeftChild() == null) {
                        node.addLeftChild(item, name);
                    } else {
                        node.addRightChild(item, name);
                    }
                    break;
                }
            }
        }
    }

    /**
     * Traverses the tree to acquire an item
     * @param nameOfItem the name of the item to get
     * @return the item
     */
    public T get(String nameOfItem) {

        OratioDEQueue<TreeNode<T>> queue = new OratioDEQueue<>();

        if(root == null) {
            return null;
        } else {
            queue.addLast(root);
            while(!queue.isEmpty()) {
                TreeNode<T> node = queue.pollFirst();
                if (node.getName().equalsIgnoreCase(nameOfItem)) {
                    return node.getItem();
                }
                if(node.getLeftChild() != null) {
                    queue.addLast(node.getLeftChild());
                }
                if(node.getRightChild() != null) {
                    queue.addLast(node.getRightChild());
                }
            }
        }

        return null;
    }

    /**
     * Traverses the tree to acquire an item, alternative method
     * @param nameOfItem the name of the item to get
     * @return the item
     */
    public T altGet(String nameOfItem) {
        return recursiveSearch(nameOfItem, root);
    }

    private T recursiveSearch(String nameOfItem, TreeNode<T> node) {

        T theItem;

        if(node.getName().equalsIgnoreCase(nameOfItem)) {
            return node.getItem();
        }

        theItem = recursiveSearch(nameOfItem, node.getLeftChild());
        if(theItem == null) {
            theItem = recursiveSearch(nameOfItem, node.getRightChild());
        }

        return theItem;

    }

}
