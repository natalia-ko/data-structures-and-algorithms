package collections;

public interface List<E> {

    int size();

    boolean contains(E obj);

    void add(E obj);

    String listToString();

    void removeByKey(E obj);

    void removeByIndex(int index);

    boolean isEmpty();

    E get(int index);

    boolean set(E obj, int index);

}
