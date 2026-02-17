// This class implements a Binary Search Tree (BST) data structure that stores
// elements in sorted order. It provides efficient insertion, search, and traversal
// operations. The BST maintains the ordering property where all values in the left
// subtree are less than the node's value, and all values in the right subtree are
// greater than the node's value. This class implements the Dictionary interface.

public class BST<E extends Comparable<E>> implements Dictionary<E> {
    private TreeNode root;

    // This inner class represents a single node in the binary search tree.
    // Each node stores a value and references to its left and right children.
    // The toString method provides a string representation of the node's value.
    private class TreeNode {
        private E value;
        private TreeNode left;
        private TreeNode right;

        @Override
        public String toString() {
            return String.format("%s", value);
        }

        // Behavior: Constructs a new TreeNode with the given value and null children
        // Parameters: value - the value to store in this node
        public TreeNode(E value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }
    
    // Behavior: Constructs an empty Binary Search Tree with no nodes.
    // Parameters: none
    // Returns: none (constructor)
    // Exceptions: none
    public BST () {
        this.root = null;
    }

    // Behavior: Inserts a new value into the BST in its correct sorted position,
    //           maintaining the BST ordering property.
    // Parameters: value - the value to insert into the tree
    // Returns: none (void method)
    // Exceptions: IllegalArgumentException if value is null
    // public insert method
    public void insert(E value) {
        if (value == null) {
            throw new IllegalArgumentException("Cannot insert null value");
        }
        root = insertHelper(root, value);
    }

    // Behavior: Recursively finds the correct position for the value and inserts
    //           a new TreeNode. Returns the (possibly new) root of the subtree.
    // Parameters: node - the current node in the recursive traversal
    //             value - the value to insert
    // Returns: the root of the modified subtree
    // Exceptions: none
    // private insert helper
    private TreeNode insertHelper(TreeNode node, E value) {
        if (node == null) {
            return new TreeNode(value);
        }
        if (value.compareTo(node.value) > 0) {
            node.right = insertHelper(node.right, value);
        }
        else if (value.compareTo(node.value) < 0) {
            node.left = insertHelper(node.left, value);
        }

        return node;
    }

    // Behavior: Searches the BST to determine if the given value is present.
    // Parameters: value - the value to search for in the tree
    // Returns: true if the value is found in the tree, false otherwise
    // Exceptions: IllegalArgumentException if value is null
    // public search method
    public boolean contains(E value) {
        if (value == null) {
            throw new IllegalArgumentException("Cannot search for null value");
        }
        return containsHelper(root, value);
    }

    // Behavior: Recursively searches the BST for the given value by comparing
    //           values and traversing left or right based on the comparison.
    // Parameters: node - the current node in the recursive traversal
    //             value - the value to search for
    // Returns: true if the value is found, false if not found (node is null)
    // Exceptions: none
    // private search helper
    private boolean containsHelper(TreeNode node, E value) {
        if (node == null) {
            return false;
        }
        if (value.compareTo(node.value) == 0) {
            return true;
        }
        if (value.compareTo(node.value) > 0) {
            return containsHelper(node.right, value); // ensure the recursive method call is returned somehow
        }
        else {
            return containsHelper(node.left, value);
        }
    }

    // Behavior: Prints all values in the BST in sorted (ascending) order using
    //           an in-order traversal (left subtree, root, right subtree).
    // Parameters: none
    // Returns: none (void method)
    // Exceptions: none
    // public print
    public void printInOrder() {
        printHelper(root);
    }

    // Behavior: Recursively performs an in-order traversal, printing each node's
    //           value in sorted order.
    // Parameters: node - the current node in the recursive traversal
    // Returns: none (void method)
    // Exceptions: none
    //private print helper
    private void printHelper(TreeNode node) {
        if (node == null) {
            return;
        }
        printHelper(node.left);
        System.out.println(node.value);
        printHelper(node.right);
    }

    // Behavior: Counts and returns the total number of nodes in the BST.
    // Parameters: none
    // Returns: the number of nodes in the tree
    // Exceptions: none
    //public size counter
    public int size() {
        return sizeHelper(root);
    }
    
    // Behavior: Recursively counts nodes by summing the sizes of the left subtree,
    //           right subtree, and the current node (1).
    // Parameters: node - the current node in the recursive traversal
    // Returns: the number of nodes in the subtree rooted at node
    // Exceptions: none
    // private size helper
    private int sizeHelper(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftSize = sizeHelper(node.left);
        int rightSize = sizeHelper(node.right);

        return leftSize + rightSize + 1;
    }
}