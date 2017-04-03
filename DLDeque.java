/*
TheMarkering - Jack Cruse, Sasha Fomina, Daniel Ju
APCS2 pd4
Lab02 -- All Hands on Deque! (Not Schenectady; rather, synecdoche.)
2017-04-02
*/

import java.util.Iterator;
import java.util.NoSuchElementException;

public class DLDeque<E> {
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

    public boolean offerFirst (E e){
	if (_size == _capacity){
	    return false;
	}
	if (_size == 0){
	    DLLNode<E> addition = new DLLNode<E> (e,null,_front);
	    _front = addition;
	    _end = addition;
	}
	else {
	    DLLNode<E> addition = new DLLNode<E> (e,null,_front);
	    _front.setPrev(addition);
	    _front = addition;
	}
	_size++;
	return true;
    }

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
	    DLLNode<E> addition = new DLLNode<E> (e, _end, null);
	    _end.setNext(addition);
	    _end = addition;
	}
	_size++;
	return true;
    }

    public E pollFirst(){
	if (_size == 0){
	    return null;
	}
	else {
	    DLLNode<E> temp = _front;
	    _front = _front.getNext();
	    _front.setPrev(null);
	    _size--;
	    return temp.getCargo();
	}
    }

    public E pollLast(){
	if (_size == 0){
	    return null;
	}
	else {
	    DLLNode<E> temp = _end;
	    _end = _end.getPrev();
	    _end.setNext(null);
	    _size--;
	    return temp.getCargo();
	}
    }

    public E peekFirst(){
	if (_size ==0){
	    return null;
	}
	return _front.getCargo();
    }

    public E peekLast(){
	if(_size ==0){
	    return null;
	}
	return _end.getCargo();
    }
    
    //DOESN'T WORK
    //fixed that ting yuhknow
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
			return true;
		    }
		temp = temp.getPrev();
	    }
	return false;
    }
    
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

    
    public Iterator<E> iterator()
    {
	return new MyIterator();
    }

    
    public Iterator<E> descendingIterator()
    {
	return new MyDescendingIterator();
    }

    
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
	    _dummy = _dummy.getNext();
	    E ret = _dummy.getCargo();
	    _okToRemove = true;
	    return ret;
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
		_dummy.setNext( _front );
	    }
	    
	    //if removing first node...
	    else if ( _dummy.equals( _front ) ) {
		_dummy = _dummy.getPrev();

		_front = _front.getNext();
		_front.setPrev( null );

		_dummy.setNext( _front );
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
	    _dummy = _dummy.getPrev();
	    E ret = _dummy.getCargo();
	    _okToRemove = true;
	    return ret;
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
		_front = _end = null;
		_dummy.setPrev( _end );
	    }
	    
	    //if removing first node...
	    else if ( _dummy.equals( _end ) ) {
		_dummy = _dummy.getNext();

		_end = _end.getPrev();
		_end.setNext( null );

		_dummy.setPrev( _end );
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
    }
    
}
