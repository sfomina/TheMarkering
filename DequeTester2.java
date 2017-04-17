// Marcus Ng
// APCS2 pd4
// HW #29: Stress is the Best
// 2017-4-4

public class DequeTester2<T> {

    public static void main(String[] args) {

	DequeTester2<String> a = new Deque<String>();

	System.out.println("==============DEQUE a==============");

	/*
	// addFirst(E e) and addLast(E e)
	System.out.println("\nEnqueuing...(addFirst(E e) and addLast(E e))");
	// I
	a.addFirst("I");
	// I am
	a.addLast("am");
	// Hello I am
	a.addFirst("Hello");
	// bob Hello I am bob
	a.addLast("bob");
	*/
	
	//======================= OR =======================
	
	// offerFirst(E e) and offerLast(E e)
	System.out.println("\nEnqueuing...(offerFirst(E e) and offerLast(E e))");
	// true
	System.out.println(a.offerFirst("I")); // I
	// true
	System.out.println(a.offerLast("am")); // am
	// true
	System.out.println(a.offerFirst("Hello")); // Hello
	// true
	System.out.println(a.offerLast("bob")); // bob
	
	//==================================================

	
	// toString()
	System.out.println("\nPrint Deque...");
	// Hello I am bob
	System.out.println(a);


	// size()
	System.out.println("\nsize()");
	// 4
	System.out.println(a.size());

	// isFull()
	System.out.println(a.isFull());
	
	// contains(Object o)
	System.out.println("\nContains...");
	// true
	System.out.println(a.contains("an"));
	// false
	System.out.println(a.contains("o.O"));

	/*
	// Element()
	System.out.println("\nRetrieve first element");
	// Hello
	System.out.println(a.element);


	// getFirst() and getLast()
	System.out.println("\ngetFirst() and getLast()");
	// Hello
	System.out.println(a.getFirst());
	// bob
	System.out.println(a.getLast());
	*/
	
	// peekFirst() and peekLast()
	System.out.println("\npeekFirst() and peekLast()");
	// Hello
	System.out.println(a.peekFirst());
	// bob
	System.out.println(a.peekLast());

	
	// pollFirst() and pollLast()
	System.out.println("\nDequeuing...(pollFirst() and pollLast())");
	// Hello
	System.out.println(a.pollFirst());
	// bob
	System.out.println(a.pollLast());
	// I
	System.out.println(a.pollFirst());
	// am
	System.out.println(a.pollLast());
	
	// Empty deque
	System.out.println("\nEmpty Deque Dequeue (return null)...");
	// null
	System.out.println(a.pollFirst());
	// null
	System.out.println(a.pollLast());
	
	//======================= OR =======================
	/*
	// removeFirst() and removeLast()
	System.out.println("\nDequeuing...(removeFirst() and removeLast())");
	// Hello
	System.out.println(a.removeFirst());
	// bob
	System.out.println(a.removeLast());
	// I
	System.out.println(a.removeFirst());
	// am
	System.out.println(a.removeLast());

	// Empty deque
	System.out.println("\nEmpty Deque Dequeue (return null)...");
	try {
	    a.removeFirst();
	} catch (NoSuchElementException e) {
	    System.out.println("Error: No such element!")
	}
	
	try{
	    a.removeFirst();
	} catch (NoSuchElementException e) {
	    System.out.println("Error: No such element!")
	}
	*/
	//==================================================

	// Empty deque
	System.out.println("\npeekFirst() and peekLast() (null)");
	// null
	System.out.println(a.peekFirst());
	// null
	System.out.println(a.peekLast());

	/*
	// getFirst() and getLast()
	System.out.println("\nEmpty Deque (Exceptions)...");
	try {
	    a.getFirst();
	} catch (NoSuchElementException e) {
	    System.out.println("Error: No such element!");
	}
	
	try {
	    a.getLast();
	} catch (NoSuchElementException e) {
	    System.out.println("Error: No such element!");
	}
	*/
	
    }
    
}
