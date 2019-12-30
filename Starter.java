import java.util.Arrays;
import java.util.HashSet;

public class Starter {

	public int begins(String[] words, String first) {
		 int sum1 = 0;
		 //but can't have repetitions so need to make a hashset first
		 HashSet<String> wordsSet = new HashSet <String>(); //q hashSet is a type of ocllection and doesn't 
		 //know how to interact with a primitive like an array, convert to a list
		 wordsSet.addAll (Arrays.asList(words)) ; // Arrays.asList turns primitive array to collection List. 
		 //.addAll adds all elements in words to list wordsSet
		for (String letter : wordsSet) {
			char character = letter.charAt(0); //returns first letter of string
			
			if (character == first.charAt(0)) { //incompatible char and string can't be compared. Need method 
				//to convert (due first.charAt(0)) 
				sum1 += 1;
			}
		}
		return sum1 ;
	}

}
