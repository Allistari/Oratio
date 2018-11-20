

/**
 * OratioTree.java
 * Modular tree data structure for the Oratio program
 * @author Eric Ke
 * Last Updated: 2018/11/16
 */
public class OratioTree<T> {

    private TreeNode<T> root;

    public OratioTree() {
    }

    public void add(T item) {
        if(root == null) {
            root = new TreeNode<T>(item);
        }
    }

}
