public interface Dictionary<E> {
    void insert(E value);
    boolean contains(E value);
    int size();
}
