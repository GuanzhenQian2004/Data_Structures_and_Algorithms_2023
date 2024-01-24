// Name: Steven Qian
// Computing ID: uen9ke
// Homework Name: HW10-AVL
// Resources used: https://www.geeksforgeeks.org/introduction-to-avl-tree/ AVL tree rotations

package tree;

/**
 * Self-balancing AVL Tree
 *
 * @param <T>
 * @author CS 2100 Team
 */

public class AVLTree<T extends Comparable<T>> extends BinarySearchTree<T> {

    @Override
    public void insert(T data) {
        this.root = insert(data, this.root);
    }

    // Protected method to insert a node into the AVL tree
    protected TreeNode<T> insert(T data, TreeNode<T> curNode) {

        // Perform standard BST insertion
        curNode = super.insert(data, curNode);

        // Balance the tree after insertion
        curNode = this.balance(curNode);

        return curNode;
    }

    @Override
    public void remove(T data) {
        // Call remove starting at the root of the tree
        this.root = remove(data, this.root);
    }

    // Protected method to remove a node from the AVL tree
    protected TreeNode<T> remove(T data, TreeNode<T> curNode) {
        // Call BST remove before balancing, use "super" to achieve this
        curNode = super.remove(data, curNode);

        // Handle the case when remove returns null
        if (curNode == null) return null;

        // Update the height of this node if necessary (if no change, that’s OK)
        curNode.height = Math.max(height(curNode.left), height(curNode.right)) + 1;

        // Rotate if necessary (call balance() method to balance the node)
        curNode = this.balance(curNode);

        return curNode;
    }

    /**
     * Balances the given node. Assumes it is the lowest unbalanced node if unbalanced.
     *
     * @param curNode The node to balance.
     * @return The new root of the balanced subtree.
     */
    private TreeNode<T> balance(TreeNode<T> curNode) {
        // Check if the tree is left heavy
        if (balanceFactor(curNode) > 1) {  // left heavy
            // Check if the left subtree is right heavy
            if (balanceFactor(curNode.left) < 0) {
                // Perform a left rotation on the left subtree
                curNode.left = rotateLeft(curNode.left);
            }
            // Perform a right rotation on the current node
            return rotateRight(curNode);
        }
        // Check if the tree is right heavy
        else if (balanceFactor(curNode) < -1) {  // right heavy
            // Check if the right subtree is left heavy
            if (balanceFactor(curNode.right) > 0) {
                // Perform a right rotation on the right subtree
                curNode.right = rotateRight(curNode.right);
            }
            // Perform a left rotation on the current node
            return rotateLeft(curNode);
        }

        // No balancing needed, return the current node
        return curNode;
    }

    /**
     * Performs a right rotation on the given node.
     *
     * @param curNode The node to rotate.
     * @return The new root of the rotated subtree.
     */
    private TreeNode<T> rotateRight(TreeNode<T> curNode) {
        // Store the new root after the right rotation
        TreeNode<T> newRoot = curNode.left;
        // Update the left subtree of the current node
        curNode.left = newRoot.right;
        // Update the right subtree of the new root
        newRoot.right = curNode;

        // Update heights of the current node and the new root
        curNode.height = Math.max(height(curNode.left), height(curNode.right)) + 1;
        newRoot.height = Math.max(height(newRoot.left), height(newRoot.right)) + 1;

        // Return the new root of the rotated subtree
        return newRoot;
    }

    /**
     * Performs a left rotation on the given node.
     *
     * @param curNode The node to rotate.
     * @return The new root of the rotated subtree.
     */
    private TreeNode<T> rotateLeft(TreeNode<T> curNode) {
        // Store the new root after the left rotation
        TreeNode<T> newRoot = curNode.right;
        // Update the right subtree of the current node
        curNode.right = newRoot.left;
        // Update the left subtree of the new root
        newRoot.left = curNode;

        // Update heights of the current node and the new root
        curNode.height = Math.max(height(curNode.left), height(curNode.right)) + 1;
        newRoot.height = Math.max(height(newRoot.left), height(newRoot.right)) + 1;

        // Return the new root of the rotated subtree
        return newRoot;
    }

    /**
     * Calculates the balance factor for the given node.
     *
     * @param node The node to calculate the balance factor for.
     * @return The balance factor (height of left subtree - height of right subtree).
     */
    private int balanceFactor(TreeNode<T> node) {
        // Check if the node is null
        if (node == null) {
            return 0;
        } else {
            // Calculate and return the balance factor
            return height(node.left) - height(node.right);
        }
    }
}