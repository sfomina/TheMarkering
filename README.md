# TheMarkering
Method Selections:

  As a group, we decided to implement the following methods:
  1. offerFirst. 
  
  This method takes an input of generic type and adds it to the front of the queue. The method will return false if the capacity is reached, meaning no additional elements can be added since the queue is full. Otherwise, a temporary storage LLNode named addition is created. Addition is set as _front's previous node, and then we set the instance variable _front to be addition so that the queue is ready for another addition. The variable _size is then incremented by one. 
  2. offerLast
  
  Similar to offerFirst, this method takes an input of generic type and adds it to the end of the queue. The method will return false if the capacity is reached, meaning no additional elements can be added since the queue is full. Otherwise, a temporary storage LLNode named addition is created. Addition is set as _end's next node, and then we set the instance variable _end to be addition so that the queue is ready for another addition. The variable _size is then incremented by one. 
  3. pollFirst
  
  This method removes an element from the front of the queue. If the size of the queue is 0, then null is returned since the queue is empty. Otherwise, a temporary LLNode named temp is created and its value is set to _front. The value of _front is then set to _front's next node. Since we wish to remove what's in the front, _front's previous node is set to null. Then the size is decremented by one and the cargo of temp is returned since we wish to return the deleted value. 
  
4. pollLast

 Similar to pollFirst, this method removes an element from the end of the queue. If the size of the queue is 0, then null is returned since the queue is empty. Otherwise, a temporary LLNode named temp is created and its value is set to _end. The value of _end is then set to _end's  previous node. Since we wish to remove what's in the back, _end's next node is set to null. Then the size is decremented by one and the cargo of temp is returned since we wish to return the deleted value. 
 
 5. peekFirst
 
 This method returns the cargo of the first node in the queue. If the size of the queue is 0, then null is returned since the queue is empty. Otherwise, the cargo of _front is returned. 
 
 6. peekLast
 
  This method returns the cargo of the last node in the queue. If the size of the queue is 0, then null is returned since the queue is empty. Otherwise, the cargo of _end is returned. 
  
  7. removeFirstOccurrence
  
  
  
  
  
  


