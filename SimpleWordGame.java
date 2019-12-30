import java.util.HashSet;
import java.util.Arrays;
public class SimpleWordGame {
	public int points(String[] player, String[] dictionary) {
	HashSet<String> remembers = new HashSet<String> ();
	remembers.addAll(Arrays.asList(player)) ; // you write code here
	 int sum1 = 0;
	for (String given : remembers) {
		for (String inside : dictionary) {
			if (inside .equals (given)) { // == is for primitives (ints,chargs, booleans) 
				// two Strings (not primitive) use .equals
			 int length = (inside.length() * inside.length());
			 sum1 += length ; // adds length to sum //for loop can be down through array
			 //.size() is for a collection
			}
		}
	}
	return sum1 ; 
	}
}
