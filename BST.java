public class BST<E extends Comparable<E>> implements Dictionary<E> {
    private TreeNode root;

    private class TreeNode {
        private E value;
        private TreeNode left;
        private TreeNode right;

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
    public void insert(E value) {
        root = insertHelper(root, value);
    }

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

    // public search method
    public boolean contains(E value) {
        return containsHelper(root, value);
    }

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

    // public print
    public void printInOrder() {
        printHelper(root);
    }

    //private print helper
    private void printHelper(TreeNode node) {
        if (node == null) {
            return;
        }
        printHelper(node.left);
        System.out.println(node.value);
        printHelper(node.right);
    }

    //public size counter
    public int size() {
        return sizeHelper(root);
    }
    
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