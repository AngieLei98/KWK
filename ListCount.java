
  public class ListCount {
      public int count (ListNode list) { //list is the first node you get so next will be list.next
          int sum1 = 0;
          while(list!= null) { //while loop needs to go to the next node. But won't be counting the last one. SO
        	  list = list.next; // will update list everytime it goes through //don't want to get the next one, just do list!=null to count all of them. 
        	  sum1+=1;// replace statement below with code you write
          }
	  return sum1;
      }
  
    /**  public class ListNode { //now java knows what node is
    	    int info;
    	    ListNode next; //next is an instance variable
    	    ListNode(int x){ //constructor doesn't assign anything to next so use this when want next node to be null(so the end).
    	        info = x;
    	    }
    	    ListNode(int x, ListNode node){
    	        info = x;
    		next = node;
    	    }
    	}
    	**/
  }
