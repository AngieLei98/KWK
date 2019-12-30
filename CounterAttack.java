
public class CounterAttack {
	public int[] analyze(String str, String[] words) {
		String[] splitString = str.split(" ") ; //split method already gives an array so don't need to create a new one.
		//Tell split that you want to split after every instance of the white space. 
		int[] returnArray = new int[words.length]; //need to create array to store counted numbers outside loop
		for (int k = 0 ; k < words.length ; k+= 1) { //only need parentheses in length() when calling a method
			//, words is not an object it's primitive so just asking for property
			int sum1 = 0; //keep count to add to return Array
			for(String split : splitString) { 
				if (words[k].equals(split)) { //split is a string so an object need .equals 
					//want (split) and not all array splitstring
					sum1 += 1;
				}
				returnArray[k] = sum1 ; // sum1 updates itself because changes every loop
			}
		}
		return returnArray;
	}
}

