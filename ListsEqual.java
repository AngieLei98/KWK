
public class ListsEqual {
	public int equal (ListNode a1, ListNode a2) {
		while(a1!=null && a2!=null) { //just the node a1
			if(a1.info!=a2.info) {
				return 0;
			}


			a1 = a1.next; //just the nodes are changing to next not the info inside. 
			a2 = a2.next; //if they have the same length once while loop finished executing a1 and a2 are both null bc there's no next. 
			
		}
		if((a1!= null || a2!=null)) { //if both of them are null then reach the end of lists and they could be equal
			//if either of them if not null, then you know they're not equal. 
			return 0;
		}
		return 1;
	}
}

//you want to check for the whole list not per index. You return 1 when all of them are equal. 
//So first if statement should look for inequality to cut it then. 
//as soon as hits return statement whole thing stops. 
//don't need an else statement bc by time while loops finishes means all is equal so just return 1. 
//BUT WANT TO CHECK FOR LENGTH TO BE EQUAL, but you don't know the lined lists array size so need an if outside the while loop.