/*
TheMarkering - Jack Cruse, Sasha Fomina, Daniel Ju
APCS2 pd4
Lab02 -- All Hands on Deque! (Not Schenectady; rather, synecdoche.)
2017-04-02
*/

import java.util.Iterator;
import java.util.NoSuchElementException;

public class DLDeque<E> implements Deque<E>{
    private DLLNode<E> _end;
    private DLLNode<E> _front;
    int _capacity;
    int _size;
    public DLDeque() {
	_capacity = 10;
	_end = null;
	_front = null;
	_size = 0;
    }

    public DLDeque(int capacity){
	_capacity = capacity;
	_end = null;
	_front = null;
	_size = 0;
    }

    //adds an element to the front if the Deque has not yet reached capacity
    //returns true if addition was successful, false otherwise
    public boolean offerFirst (E e){
	if (_size == _capacity){
	    return false;
	}
	if (_size == 0){
	    DLLNode<E> addition = new DLLNode<E> (e,null,_front); //has a cargo of e and a next of _front
	    _front = addition;
	    _end = addition;
	}
	else {
	    DLLNode<E> addition = new DLLNode<E> (e,null,_front);
	    _front.setPrev(addition);
	    _front = addition;
	}
	_front.setPrev(null); // previous of _front is always null
	_size++; //increments size
	return true;
    }

    //adds an element to the end if the Deque has not yet reached capacity
    //returns true if addition was successful, false otherwise 
    public boolean offerLast(E e){
	if (_size == _capacity){
	    return false;
	}
	if (_size == 0) {
	    DLLNode<E> addition = new DLLNode<E>(e, null,null);
	    _front = addition;
	    _end = addition;
	}
	else {
	    DLLNode<E> addition = new DLLNode<E> (e, _end, null);//value of e, previous of _end and next of null
	    _end.setNext(addition); 
	    _end = addition;
	}
	_front.setPrev(null);
	_end.setNext(null); //next of end should always end up being null
	_size++; //increment size 
	return true;
    }

    //removes an element from the front if size is not 0
    //if size is 0 returns null, otherwise returns item removed
    public E pollFirst(){
	if (_size == 0){
	    return null;
	}
	else {
	    DLLNode<E> temp = _front;
	    _front = _front.getNext();
	    _front.setPrev(null);
	    _size--; //size decremented 
	    return temp.getCargo();
	}
    }

    //removes an element from the front if size is not 0
    //if size is 0 returns null, otherwise returns item removed
    public E pollLast(){
	if (_size == 0){
	    return null;
	}
	else {
	    DLLNode<E> temp = _end;
	    _end = _end.getPrev();
	    _end.setNext(null);
	    _size--; //size decremented 
	    return temp.getCargo();
	}
    }

    //returns the cargo of the _front, if size is 0 returns null
    //doesnt modify Deque
    public E peekFirst(){
	if (_size ==0){
	    return null;
	}
	return _front.getCargo();
    }

    //returns cargo of _end
    public E peekLast(){
	if(_size ==0){
	    return null;
	}
	return _end.getCargo();
    }
    

    //removes first occurrence starting from the end 
    public boolean removeFirstOccurrence( Object O )
    {
	E searchVal = (E) O;
	DLLNode<E> temp = _end;

	while ( temp != null )
	    {
		if ( temp.getCargo().equals( O ) )
		    {
			if ( temp.getNext() != null )
			    {
				temp.getNext().setPrev( temp.getPrev() );
			    }

			if ( temp.getPrev() != null )
			    {
				temp.getPrev().setNext( temp.getNext() );
			    }
			_size --;
			return true;
		    }
		temp = temp.getPrev();
	    }
	return false;
    }

    //returns true if a given object is found within the deque at least once
    //returns false otherwise
    public boolean contains( Object O )
    {
	E searchVal = (E) O;
	DLLNode<E> temp = _end;

	while ( temp != null )
	    {
		if ( temp.getCargo().equals( O ) )
		    {
			return true;
		    }
		temp = temp.getPrev();
	    }
	return false;
    }
			 
    
    public String toString(){
	String retStr = "_front --> ";
	DLLNode<E> temp = _front;
	while(temp != null){
	    retStr += temp.toString() + " ";
	    temp = temp.getNext();
	}
	return retStr;
    }

    public int size()
    {
	return _size;
    }

    //checks to see if deque has reached capacity
    public boolean isFull(){
	return (_capacity == _size);
    }
    
    public Iterator<E> iterator()
    {
	return new MyIterator();
    }

    /*
    public Iterator<E> descendingIterator()
    {
	return new MyDescendingIterator();
    }
    */
    
    private class MyIterator implements Iterator<E> 
    {

	private DLLNode<E> _dummy; // dummy node to tracking pos
	private boolean _okToRemove; //flag indicates next() was called

	//constructor 
	public MyIterator() 
	{
	    //place dummy node in front of head
            //...other housekeeping chores?
	    _dummy = new DLLNode<E>( null, null, _front );
	    _okToRemove = false;
	}

	//--------------v  Iterator interface methods  v-------------
	//return true if iteration has more elements.
	public boolean hasNext() 
	{
            return _dummy.getNext() != null;
	}


	//return next element in this iteration
	public E next() 
	{
	    System.out.println("SIZE: " + _size);
	    if (_size == 1){
		_okToRemove = true;
		return null;
	    }
	    else {
		_dummy = _dummy.getNext();
		E ret = _dummy.getCargo();
		_okToRemove = true;
		return ret;
	    }
	}


	//remove last element returned by this iterator (from last next() call)
	public void remove() 
	{
	    if ( ! _okToRemove )
		throw new IllegalStateException("must call next() beforehand");
	    _okToRemove = false;

	    //If removing only remaining node...
	    //maintain invariant that _dummy always points to a node
	    //   (...so that hasNext() will not crash)
	    if ( _size == 1 ) {
		_dummy = _dummy.getPrev();
		_front = _end = null;
	    }
	    
	    //if removing first node...
	    else if ( _dummy.equals( _front ) ) {
		_dummy = _dummy.getNext();

		_front = _front.getNext();
		_front.setPrev( null );
		
	    }

	    //if removing last node...
	    else if ( _dummy.equals( _end ) ) {
		_dummy = _dummy.getPrev();

		_end = _end.getPrev();
		_end.setNext(null);

		_dummy.setNext( _end );
	    }

	    //if removing an interior node...
	    else {
		_dummy = _dummy.getPrev();		
		_dummy.setNext( _dummy.getNext().getNext() );
		_dummy.getNext().setPrev( _dummy );
	    }		     

	    _size--; //decrement size attribute of outer class LList
	}
	//--------------^  Iterator interface methods  ^--------------
    }//*************** end inner class MyIterator ***************

    /*
    private class MyDescendingIterator implements Iterator<E> 
    {

	private DLLNode<E> _dummy; // dummy node to tracking pos
	private boolean _okToRemove; //flag indicates next() was called

	//constructor 
	public MyDescendingIterator() 
	{
	    //place dummy node in front of head
            //...other housekeeping chores?
	    _dummy = new DLLNode<E>( null, _end, null );
	    _okToRemove = false;
	}

	//--------------v  Iterator interface methods  v-------------
	//return true if iteration has more elements.
	public boolean hasNext() 
	{
            return _dummy.getPrev() != null;
	}


	//return next element in this iteration
	public E next() 
	{
	    System.out.println("SIZE: " + _size);
	    if (_size == 1){
		_okToRemove = true;
		return null;
	    }
	    else {
		_dummy = _dummy.getPrev();
		E ret = _dummy.getCargo();
		_okToRemove = true;
		return ret;
	    }
	}


	//remove last element returned by this iterator (from last next() call)
	public void remove() 
	{
	    if ( ! _okToRemove )
		throw new IllegalStateException("must call next() beforehand");
	    _okToRemove = false;

	    //If removing only remaining node...
	    //maintain invariant that _dummy always points to a node
	    //   (...so that hasNext() will not crash)
	    if ( _size == 1 ) {
		_dummy = _dummy.getNext();
		_end = _front = null;
	    }
	    
	    //if removing first node...
	    else if ( _dummy.equals( _end ) ) {
		_dummy = _dummy.getNext();

		_end = _end.getPrev();
		_end.setNext( _dummy );

	    }

	    //if removing last node...
	    else if ( _dummy.equals( _front ) ) {
		_dummy = _dummy.getNext();

		_front = _front.getNext();
		_front.setPrev(null);

		_dummy.setPrev( _front );
	    }
	    
	    //if removing an interior node...
	    else {
		_dummy = _dummy.getNext();		
		_dummy.setPrev( _dummy.getPrev().getPrev() );
		_dummy.getPrev().setNext( _dummy );
	    }		     

	    _size--; //decrement size attribute of outer class LList
	}
	//--------------^  Iterator interface methods  ^--------------
    }//*************** end inner class MyDescendingIterator ***************
    */
    
    
    public static void main(String[] args){
	DLDeque<String> sasha = new DLDeque<String>();
	sasha.offerLast("a");
	sasha.offerLast("b");
	sasha.offerLast("c");
	sasha.offerFirst("d");
	System.out.println(sasha);
	sasha.pollFirst();
	System.out.println(sasha);
	sasha.pollLast();
	System.out.println(sasha);
	System.out.println(sasha.peekFirst());
	System.out.println(sasha.peekLast());
	sasha.offerFirst("b");
	System.out.println(sasha);
	System.out.println( sasha.contains( "b" ) );
	sasha.removeFirstOccurrence( "b" ) ;
	System.out.println( sasha );
	System.out.println("TESTING ITERATOR");
	Iterator<String> stuff = sasha.iterator();
	stuff.next();
	System.out.println(sasha);	
	stuff.remove();
	System.out.println(sasha);
	stuff.next();
	stuff.remove();
	System.out.println(sasha);
    }
    
}
