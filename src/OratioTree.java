

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

}
