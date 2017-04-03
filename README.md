# TheMarkering -- By Jack Cruz, Sasha Fomina, and Daniel Ju
Method Selections:

  As a group, we decided to implement the following methods:
  
  1.   ```boolean offerFirst(E e);```
   
  
  This method takes an input of generic type and adds it to the front of the queue. The method will return false if the capacity is reached, meaning no additional elements can be added since the queue is full. Otherwise, a temporary storage LLNode named addition is created. Addition is set as _front's previous node, and then we set the instance variable _front to be addition so that the queue is ready for another addition. The variable _size is then incremented by one. 
  
  2.  ```boolean offerLast(E e);```
 
  Similar to offerFirst, this method takes an input of generic type and adds it to the end of the queue. The method will return false if the capacity is reached, meaning no additional elements can be added since the queue is full. Otherwise, a temporary storage DLLNode named addition is created. Addition is set as _end's next node, and then we set the instance variable _end to be addition so that the queue is ready for another addition. The variable _size is then incremented by one. 
  
  3.   ``` E pollFirst(); ```
  
  This method removes an element from the front of the queue. If the size of the queue is 0, then null is returned since the queue is empty. Otherwise, a temporary DLLNode named temp is created and its value is set to _front. The value of _front is then set to _front's next node. Since we wish to remove what's in the front, _front's previous node is set to null. Then the size is decremented by one and the cargo of temp is returned since we wish to return the deleted value. 
  
4. ```E pollLast();```

 Similar to pollFirst, this method removes an element from the end of the queue. If the size of the queue is 0, then null is returned since the queue is empty. Otherwise, a temporary DLLNode named temp is created and its value is set to _end. The value of _end is then set to _end's  previous node. Since we wish to remove what's in the back, _end's next node is set to null. Then the size is decremented by one and the cargo of temp is returned since we wish to return the deleted value. 
 
 5.    ```E peekFirst();```
 
 This method returns the cargo of the first node in the queue. If the size of the queue is 0, then null is returned since the queue is empty. Otherwise, the cargo of _front is returned. 
 
 6. ```E peekLast();```
 
  This method returns the cargo of the last node in the queue. If the size of the queue is 0, then null is returned since the queue is empty. Otherwise, the cargo of _end is returned. 
  
  7.    ```boolean removeFirstOccurrence(Object O);```
  
  This method removes the first instance of the given input O. A new DLLNode named temp is created and its value is set to _end. For as long as the cargo of temp is not null, we check to see if the cargo of temp is equal to O. If it isn't, then temp will be set to temp.getPrev(). If the value is equal, then temp's next DLLNode will set its previous DLLNode to be temp's previous Node. It is a roundabout way of setting temp to temp.getPrev(). 
  
  8.  ```boolean contains(Object O);```
 
  This method returns whether or not the input value O is contained inside the queue. A temporary DLLNode named temp is created and its value is set to _end so that the queue can be traversed without upsetting the order. If the cargo of temp is null, then that means the queue is empty and false is returned. Otherwise, we check if the cargo of temp is equal to O. If so, true is returned. The process is repeated by setting temp to temp.getPrev(). 
  
  9. ```String toString()```
  
  This method converts a queue into a String so that it can be visualized. The retstr is set to be "_front -->". A temporary DLLNode temp is created and set to _front. For as long as _front's cargo is not null, a space and temp.toString is added to the restr. Temp is then set to temp.getNext(). 
  
  10. ```int size()```
  
  This method returns the value of the _size variable. 
  
  11. iterator 
   
   This method creates an object of class MyIterator, which allows hasNext(),  next(), 

We've decided to use a DLLNode based approach because the fact that each DLLNode has a previous and a next DLLNode is extremely advantageous for a queue that is double sided. ArrayLists and regular LLNodes do not have the capacity to go backwards, since they're all linked only in a single direction. In our actual implementation, the getPrev function of DLLNodes came in extremely handy. 
  
  
  


