package collections;

public interface Stack<E> {

    void push(E obj);

    E peek();

    E pop();

    boolean isEmpty();

    String stackToString();
}
