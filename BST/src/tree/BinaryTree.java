// Name: Steven Qian
// Computing ID: uen9ke
// Homework Name: HW9-BST
// Resources used: None

package tree;


public class BinaryTree<T> {

    // The root of the binary tree
    protected TreeNode<T> root = null;

    /* Tree Traversal methods */

    // HINT for three traversal methods: you can call toString() on the node's
    // data when you are executing the "root" command on a given node
    // (e.g. curNode.data.toString() + " ";) // Note the space added at the end

    /**
     * Perform an in-order traversal starting from the root.
     *
     * @return The in-order traversal result as a space-separated string.
     */
    public String getInOrder() {
        return getInOrder(root); // call getInOrder starting at the root!
    }

    /**
     * Helper method for in-order traversal.
     *
     * @param curNode The current node in the traversal.
     * @return The in-order traversal result as a space-separated string.
     */
    private String getInOrder(TreeNode<T> curNode) {
        String result = "";

        if (curNode != null) {
            // Traverse left subtree
            result += getInOrder(curNode.left);

            // Process current node
            result += curNode.data.toString() + " ";

            // Traverse right subtree
            result += getInOrder(curNode.right);
        }

        return result;
    }

    /**
     * Perform a pre-order traversal starting from the root.
     *
     * @return The pre-order traversal result as a space-separated string.
     */
    public String getPreOrder() {
        return getPreOrder(root); // call getPreOrder starting at the root!
    }

    /**
     * Helper method for pre-order traversal.
     *
     * @param curNode The current node in the traversal.
     * @return The pre-order traversal result as a space-separated string.
     */
    private String getPreOrder(TreeNode<T> curNode) {
        String result = "";

        if (curNode != null) {
            // Process current node
            result += curNode.data.toString() + " ";

            // Traverse left subtree
            result += getPreOrder(curNode.left);

            // Traverse right subtree
            result += getPreOrder(curNode.right);
        }

        return result;
    }

    /**
     * Perform a post-order traversal starting from the root.
     *
     * @return The post-order traversal result as a space-separated string.
     */
    public String getPostOrder() {
        return getPostOrder(root);  // call getPostOrder starting at the root!
    }

    /**
     * Helper method for post-order traversal.
     *
     * @param curNode The current node in the traversal.
     * @return The post-order traversal result as a space-separated string.
     */
    private String getPostOrder(TreeNode<T> curNode) {
        String result = "";

        if (curNode != null) {
            // Traverse left subtree
            result += getPostOrder(curNode.left);

            // Traverse right subtree
            result += getPostOrder(curNode.right);

            // Process current node
            result += curNode.data.toString() + " ";
        }

        return result;
    }


    //------------------------------------------------------------------------
    //EVERYTHING BELOW THIS POINT IS IMPLEMENTED FOR YOU
    //YOU SHOULD STILL LOOK AT THIS CODE
    //------------------------------------------------------------------------

    /* A somewhat more pretty print method for debugging */
    public void printTree() {
        printTree(this.root, 0);
        System.out.println("\n\n");
    }

    private void printTree(TreeNode<T> curNode, int indentLev) {
        if (curNode == null) return;
        for (int i = 0; i < indentLev; i++) {
            if (i == indentLev - 1) System.out.print("|-----");
            else System.out.print("      ");
        }
        System.out.println(curNode.data);
        printTree(curNode.left, indentLev + 1);
        printTree(curNode.right, indentLev + 1);
    }

    //TODO: Look at these methods and think about how they might be useful for this assignment
    public int height() {
        return height(root);
    }

    /* Computes the height of the tree on the fly */
    protected int height(TreeNode<T> node) {
        if (node == null) return -1;
        return 1 + Math.max(height(node.left), height(node.right));
    }
}
