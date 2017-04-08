//Arif Roktim, Tim Wang, Allan Wang
//fluffy-octo-eureka
//APCS2 pd04 
 
public class DequeTester2{ 
  
    public static void main( String[] args ){
	Deque<String> test; 

 
	System.out.println( "==========Testing as a Deque==========" ); 
	System.out.println( "Adding to end: bob, dog, test" ); 
	test = new DLDeque<String>(); 
	//Deque should be: FRONT -> bob -> END 
	test.offerLast( "bob" ); 
	//Deque should be: FRONT -> bob -> dog -> END 
	test.offerLast( "dog" ); 
	//Deque should be: FRONT -> bob -> dog -> test -> END 
	test.offerLast( "test" ); 
	System.out.println( "Printing: " + test ); 

	System.out.println( "Adding to beginning: jake, alan, nodes" ); 
	//Deque should be: FRONT -> jake -> bob -> dog -> test -> END 
	test.offerFirst( "jake" ); 
	//Deque should be: FRONT -> alan -> jake -> bob -> dog -> test -> END 
 
 
	test.offerFirst( "alan" ); 
	//Deque should be: FRONT -> nodes -> alan -> jake -> bob -> dog -> test -> END 
	test.offerFirst( "nodes" ); 
	System.out.println( "Printing: " + test ); 
 
	//Deque should be: FRONT -> alan -> jake -> bob -> dog -> test -> END 
	System.out.println( "Removed from first: " + test.pollFirst() ); 
	//Deque should be: FRONT -> jake -> bob -> dog -> test -> END 
	System.out.println( "Removed from first: " + test.pollFirst() ); 
	System.out.println( test ); 
	//Deque should be: FRONT -> jake -> bob -> dog -> END 
	System.out.println( "Removed from last: " + test.pollLast() ); 
	//Deque should be: FRONT -> jake -> bob -> END 
	System.out.println( "Removed from last: " + test.pollLast() ); 
	//System.out.println( "Printing: " + test ); 
	//Printing Deque after removing things throws an exception 
 
	System.out.println( "\n==========Testing as a FILO============" ); 
	System.out.println( "Pushed: bob, dog, test" ); 
	test = new DLDeque<String>(); 
	test.offerFirst( "bob" ); 
	test.offerFirst( "dog" ); 
	test.offerFirst( "test" ); 
	/* If Deque ends up as: 
	 *      FRONT -> test -> dog -> bob -> END 
	 * then pushing adds to the front of the Deque and popping should remove from the front too. 
	 * If Deque reads as: 
	 *      FRONT -> bob -> dog -> test -> END 
	 * then pushing adds to the end of the Deque and popping should remove from the end too. 
	 */ 
	System.out.println( test ); 
 	 
	System.out.println( "\n==========Testing as a FIFO============" ); 
	System.out.println( "Added: bob, dog, test" ); 
        test = new DLDeque<String>(); 
	test.offerLast( "bob" ); 
	test.offerLast( "dog" ); 
	test.offerLast( "test" ); 
	/* If Deque ends up as: 
	 *      FRONT -> bob -> dog -> test -> END 
	 * then adding adds to the end of the Deque and removing should happen at the beginning of the Deque. 
	 * If Deque ends up as: 
	 *      FRONT -> test -> dog -> bob -> END 
	 * then adding adds to the beginning of the Deque and removing should happen at the end of the Deque. 
	 */ 
	System.out.println( "Printing: " + test ); 
 
	System.out.println( "\nTesting exception handling." ); 
	// If a NullPointerException is thrown, the remove methods aren't checking that Deque isn't empty before removing. 
	test.pollFirst(); 
 	 
    } 
} 
