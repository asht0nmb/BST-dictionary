
// This interface defines the contract for a Dictionary data structure that stores
// comparable elements. Implementing classes must provide methods to insert values,
// check if values are contained in the dictionary, and report the total number of
// elements stored. This interface is implemented by the BST class to provide
// dictionary functionality backed by a binary search tree, and could also be used
// with other implementations such as a linked list, etc..

public interface Dictionary<E> {
    // Behavior: Inserts the given value into the dictionary
    // Parameters: value - the element to insert
    void insert(E value);

    // Behavior: Checks whether the given value exists in the dictionary
    // Parameters: value - the element to search for
    // Returns: true if the value is found, false otherwise
    boolean contains(E value);

    // Behavior: Counts the total number of elements in the dictionary
    // Returns: the number of elements stored
    int size();
}
