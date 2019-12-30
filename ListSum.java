
public class ListSum {
	public int sum(ListNode list, int thresh) {
		int sum1 = 0;
		while(list!= null) {

			if(list.info > thresh) { //list is a type ListNode and thresh is int so you want info from ListNode
				//it can access info bc ListNode is a public class, info not defined here
				//our listNode is list so want list.info
				sum1 += list.info; 
			}
			list = list.next ; //update after the if statement to get first one in order. 
		}
		// replace statement below with code you write
		return sum1;
	}
}