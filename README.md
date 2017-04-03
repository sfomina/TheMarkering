# TheMarkering
Method Selections:

  As a group, we decided to implement the following methods:
  1. offerFirst. 
  This method takes an input of generic type and adds it to the front of the queue. The method will return false if the capacity is reached, meaning no additional elements can be added since the queue is full. Otherwise, a temporary storage LLNode named addition is created. Addition is set as _front's previous node, and then we set the instance variable _front to be addition so that the queue is ready for another addition. 
  2. offerLast
  Similar to offerFirst, this method takes an input of generic type and adds it to the end of the queue. The method will return false if the capacity is reached, meaning no additional elements can be added since the queue is full. Otherwise, a temporary storage LLNode named addition is created. Addition is set as _end's next node, and then we set the instance variable _end to be addition so that the queue is ready for another addition. 
  3. pollFirst
  This method removes an element from the front of the queue. 
  
  
  
  
  
  
