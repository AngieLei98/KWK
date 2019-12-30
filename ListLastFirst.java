
public class ListLastFirst {
      public ListNode move(ListNode list) {
          ListNode current = list; //you want to keep track of the first node which is list
                                   //so to be able to move along the list without changing the first one
                                   //you want to create a new ListNode called current which will be updated with the while loop
                                   //linked lists readjust themselves so if you set current pointer(node) to point to list(i.e. the first one)
                                   //current will move to the front of the list. BUT NOW you want to keep track of the node before your current bc
                                   //to know the order of the list, call this node PREVIOUS
         /**
          * to deal with previous you need an if statement. Initially set previous to null, it points to nothing
          * the first time it goes through while loop, it'll execute the first if statement and set previous equal to current
          * current is then gonna move on to the next node bc current.next executes regardless of whther if statement executes or not
          * so current is already one step ahead of previous. 2nd time it runs through previous will move on the next and so so.
          * by the end current.next will point back to list(1st node) to jump from the last position to the first one,
          * and previous.next will be set to null because it is now the new last node since the previous last node moved to the front. 
          */
          if(list==null) { //what if there are no nodes, if it's empty!
        	  return null;
          }
          ListNode previous = null;
          while(current.next!= null) {
        	  if(previous == null ) {
        		  previous = current;
        	  }
        	  else {
        		  previous = previous.next;
        	  }
        	  current = current.next;// replace statement below with code you write
          } //by the time you exit the while loop, currnen points to the last node, 
            // and previous point to the second to last node -> YOU WANT TO UPDATE THEM TO THE ACTUAL VALUE
          current.next = list;  //you want current.next and not current bc you want the POINTER to point to list, you don't want to change current to list.
          
         if(previous == null) {
        	 current.next = null; //tell it there's onyl one node, otherwise pointer points to itself 
        	 return current; //previous.next gives a null pointer exception, 
          }
         else {
        	 previous.next = null; //to avoid circle, still need it!
         }
          /** If you have only one node list is the first one and previous is null, and current.next
           * null so don't execute while. previous.next doesn't exist
           * if previous is null (bc never got into while loop) then just return current(your one node). 
           **/
          // if don't set it to be null, 3 will still point to 4 and you get a circular list, never ends//reached the end of the list
          return current; //return the updated first node which contains everything else in list in it
      } //trying to use something tha tis null that can't be used give. 
  }