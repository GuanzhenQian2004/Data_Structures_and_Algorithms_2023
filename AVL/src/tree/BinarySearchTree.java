// Name: Steven Qian
// Computing ID: uen9ke
// Homework Name: HW10-AVL
// Resources used: None

package tree;

public class BinarySearchTree<T extends Comparable<T>> extends BinaryTree<T> implements Tree<T> {

    @Override
    public void insert(T data) {
        this.root = insert(data, root);
    }

    /**
     * Helper method for inserting recursively
     *
     * @param data
     * @param curNode
     * @return a reference to the new root of the subtree
     */
    protected TreeNode<T> insert(T data, TreeNode<T> curNode) {
        // If the current node is null, create a new node with the given data
        if (curNode == null) {
            return new TreeNode<>(data);
        }

        // If the data is equal to the current node's data, do nothing (no duplicates allowed)
        if (curNode.data.compareTo(data) == 0) {
            return curNode;
        } else if (curNode.data.compareTo(data) < 0) {
            // If the data is greater than the current node's data, insert in the right subtree
            curNode.right = insert(data, curNode.right);
        } else if (curNode.data.compareTo(data) > 0) {
            // If the data is less than the current node's data, insert in the left subtree
            curNode.left = insert(data, curNode.left);
        }

        // Return the current node (no changes made to the root of the subtree)
        return curNode;
    }


    /**
     * Returns a boolean (true or false) if the element was found in a BST
     */
    @Override
    public boolean find(T data) {
        return find(data, root);
    }

    // Helper method
    private boolean find(T data, TreeNode<T> curNode) {
        // If the current node is null, the element is not found
        if (curNode == null) {
            return false;
        }

        // If the data is equal to the current node's data, the element is found
        if (curNode.data.compareTo(data) == 0) {
            return true;
        } else if (curNode.data.compareTo(data) < 0) {
            // If the data is greater than the current node's data, search in the right subtree
            return find(data, curNode.right);
        } else if (curNode.data.compareTo(data) > 0) {
            // If the data is less than the current node's data, search in the left subtree
            return find(data, curNode.left);
        }

        // Element not found
        return false;
    }


    /**
     * Returns the max item in the given subtree
     */
    public T findMax() {
        return findMax(this.root);
    }

    // Helper method
    private T findMax(TreeNode<T> curNode) {
        // If the right child is null, the current node has the maximum value
        if (curNode.right == null) {
            return curNode.data;
        }

        // Continue searching in the right subtree for the maximum value
        return findMax(curNode.right);
    }


    //-----------------------------------------------------------------------------
    //EVERYTHING BELOW THIS POINT IS IMPLEMENTED FOR YOU: (Don't change anything!)
    //WE HAVE IMPLEMENTED THE REMOVE METHOD FOR YOU
    //YOU SHOULD STILL LOOK AT THIS CODE AND TRY YOUR BEST TO UNDERSTAND IT
    //-----------------------------------------------------------------------------

    @Override
    public void remove(T data) {
        this.root = remove(data, root); // Call remove at the root of the tree
    }

    protected TreeNode<T> remove(T data, TreeNode<T> curNode) {
        /* Note the use of compareTo() in the solution! */

        if (curNode == null) return curNode;
            // if item I want to remove is smaller than the data of the current node...
        else if (data.compareTo(curNode.data) < 0) {
            curNode.left = remove(data, curNode.left); // recursively call remove on LEFT subtree
        }
        // if item I want to remove is larger than the data of the current node...
        else if (data.compareTo(curNode.data) > 0) {
            curNode.right = remove(data, curNode.right); // recursively call remove on RIGHT subtree
        } else { /* Found it, time to remove */
            if (curNode.left == null && curNode.right == null) return null;
            else if (curNode.left != null && curNode.right == null) return curNode.left;
            else if (curNode.left == null && curNode.right != null) return curNode.right;
            else {
                T toDel = findMax(curNode.left);
                curNode.data = toDel;
                curNode.left = remove(toDel, curNode.left);
                return curNode;
            }
        }
        return curNode;
    }


}
