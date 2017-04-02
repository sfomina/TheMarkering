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
	    _front = addition;
	}
	_size ++;
	return true;
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
	sasha.offerFirst("a");
	sasha.offerFirst("b");
	sasha.offerFirst("c");
	sasha.offerFirst("d");
	System.out.println(sasha);

    }
    
}
