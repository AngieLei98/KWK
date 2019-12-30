
public class ListStretch { // need nested loops, first to go from 1 to 2 and other within 1
      public ListNode stretch (ListNode list, int amount){
    	  ListNode current = list ; //floating when created, point to list!
    	  if(list == null) { //check if list is nothing before everything otherwise line 5 gives null pointer error
    		  return list;
    	  }
    	  ListNode after = list.next; 
    	  // the 2 after the initial first node
    	  while(current!= null) { //don't want current.next bc still want current to run, the last one!. 
    		  for(int k=0; k < amount-1 ; k++) { //if do k<= amount-1 you are executing an extra time 
    			                                  //because you started index at k=0. so need only <
    			ListNode other = new ListNode(current.info, null ); 
    			/**ListNode constructor from ListNode class needs two parameters( x info, next pointer)
    			 * other is not pointing to anything so just null. Means can get rid of line 13.
    			 * Otherwise gives error ListNode no arguments
    			 */
    			//other.info = current.info; //to tell it to differ between a 1 and 2, they have diff info
    			current.next = other; 
    			current = other; //need to make new current the other to then point to other the next node
    			
    		  }
    		  current.next = after; //return the pointer to follow the line towards 2
    		  current = after;// to make it go to the 2 and then go through the iterations for the 2 to go through for loop
    		  
    		  if (after == null) {
    				  return list ; //need to make 2 go to 3 after looping through for loop. Keep track of the next one. 
    		  }
    		  after = current.next; //need after to move to 3, the next one. Want it after the if
    		                        //because still want to iterate through the last element of the list
    		                        //because by time get to after = current.next it will still iterate through while one more time
    		  }                          //otherwise loose track of original list, and after and current point to 2
      
          return list; //return front of list to get whole thing
      }
  }

/** If create a whole new node ListNode current = new ListNode() it will have 
a different memory storage number than list, but you want it to point to the exact
same thing (i.e. list) so don't need to create a whole new object, just create pointer'
ListNode current = list**/
/** Null pointer exception means trying to access something in something that is already null, so if after = after.next
in line 22, and current is the last node, then meaning after is already null so need if statement **/
/** Check if list is null, so if they give you nothing initially, you will return nothing with return list**/