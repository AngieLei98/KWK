
public class RemoveMin {
      public ListNode remove (ListNode list) {
      ListNode current = list;
      ListNode previous = null;
      ListNode globalMin = list;
      ListNode globalPrev = null;
      ListNode globalNext = list;
      if(list == null) {
    	  return list;
      }
      while(current != null) {
    	  if(previous == null) {
    		  previous=current;
    	  }
    	  else {
    		  previous = previous.next();
    	  }
    	  if(current.info < globalMin.info) {
    		  globalMin = current;
    		  globalPrev= current.previous();
    		  globalNext = current.next();
    	  }
    	  current = current.next();
    	  globalNext = globalMin.next();
    	  
      }
	  return list;
      }
  }
