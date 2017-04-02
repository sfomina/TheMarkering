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
	_size ++;
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
	    _size --;
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
    public boolean removeFirstOccurrence(Object O){
	E search = (E) O;
	DLLNode<E> temp = _front;
	while (temp.getNext() != null){
	    if (temp.getNext().getCargo().equals(search)){
		System.out.println(temp.getNext().getCargo());
		temp.setNext(temp.getNext().getNext());
		//System.out.println(temp.getNext().getCargo());
		temp.getNext().setPrev(temp);
		_size --;
		return true;
	    }
	    temp = temp.getNext();
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
	sasha.removeFirstOccurrence("b");
	
	

    }
    
}
