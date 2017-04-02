
public interface Deque<E> {
    boolean offerFirst(E e);
    boolean offerLast(E e);
    E pollFirst();
    E pollLast();
    E peekFirst();
    E peekLast();
    boolean removeFirstOccurrence(Object O);
    boolean contains(Object O);
    int size();
    //Iterator<E> iterator();
    
}
