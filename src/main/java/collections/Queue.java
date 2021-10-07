package collections;

public interface Queue<E> {

    void add(E obj);

    E peek();

    E remove();

    boolean isEmpty();

    String queueToString();
}
