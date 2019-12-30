import java.util.Arrays;

public class SandwichBar2 {
	public int whichOrder(String[] available, String[] orders) {
		
		for(int k=0; k < orders.length ; k+=1) {
			if (canMake(orders[k], available)) {
				return k;
			}
		}
	}
	//return true if the ingredients of sandwich in available and false otherwise

	private boolean canMake(String sandwich, String[] available) { //firt and second parameter correspond to public int above
		// TODO Auto-generated method stub
		
		for(String s: sandwich.split("")) { //need to split the string into differnt sections
			if (! Arrays.asList(available).contains(s)) {
				//if (! isIn(s, available)) {
					return false;
				}
			}
			
		}
		return true;
	}
	/**private isIn(String s, String[] list) {
		for(String t: list) {
			if (t.equals (s))  {
				return true;
			}
		}
	}
	return false;
}
**/ }