public class BST<E extends Comparable<E>> {
    private TreeNode<E> root;

    private class TreeNode<E> {
        private E value;
        private TreeNode<E> left;
        private TreeNode<E> right;

        @Override
        public String toString() {
            return String.format("%s", value);
        }

        public TreeNode(E value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }
    
    // constructor
    public BST () {
        this.root = null;
    }

    // public insert method
    public void insert (E value) {
        root = insertHelper(root, value);
    }

    // private insert helper
    private TreeNode<E> insertHelper (TreeNode<E> node, E value) {
        if (node == null) {
            return new TreeNode<>(value);
        }
        if (value.compareTo(node.value) > 0) {
            node.right = insertHelper(node.right, value);
        }
        else if (value.compareTo(node.value) < 0) {
            node.left = insertHelper(node.left, value);
        }

        return node;
    }

    // public search method
    public boolean contains (E value) {
        return containsHelper(root, value);
    }

    // private search helper
    private boolean containsHelper(TreeNode<E> node, E value) {
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

    public void printInOrder() {
        printHelper(root);
    }

    private void printHelper(TreeNode<E> node) {
        // String[] valueArray = {}; 
        if (node == null) {
            return;
        }
        printHelper(node.left);
        System.out.println(node.value);
        printHelper(node.right);
    }
}