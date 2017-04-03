import java.util.Iterator;

public interface Deque<E> {
    boolean offerFirst(E e);
    boolean offerLast(E e);
    E pollFirst(); //like remove but doesnt throw an error when size is 0
    E pollLast();
    E peekFirst();
    E peekLast();
    boolean removeFirstOccurrence(Object O);
    boolean contains(Object O);
    int size();
    Iterator<E> iterator();
    Iterator<E> descendingIterator();
    
}
