import java.util.Arrays;
import java.util.HashSet;
public class SandwichBar 
{public int whichOrder(String[] available, String[] orders){
	HashSet<String> set = new HashSet<String>(Arrays.asList(available)); //declare variable to be a hash
	//HashSet calls constructor, initialize w default. Arrays.asList make array into list(collection)
	for (int k=0 ; k< orders.length ; k+= 1 ) { //orders(k) would go through each element like 'chesse ham'   			
		String[]option1 = orders [k].split(" "); //splits string after every space "".  
		HashSet<String> set2 = new HashSet<String>(Arrays.asList(option1));//make user pref array a diff set
		boolean Init  = set.containsAll(set2); //returns either true or false comparison
		if (Init == true) { //there's no order in a set it just compares everything to everything
			return k; //don't need an else bc if false just skips to next one
		} //if it exits the for loop without return we know there's nothing matching
	}
	return -1 ; //if exits for loop just return -1 //option 1 changes everytime throuhg loop so make set
}
} 
