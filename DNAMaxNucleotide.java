public class DNAMaxNucleotide {
	public String max(String[] strands, String nuc) { //user gives an array of strings and a string
		int max=-1 ; //initialize to -1 to account for the nuc never being there so 0
		String ret = ""; //initialize both to keep track
		for (String S: strands) { // identify array it's going through object String // strands is an instance 
			//of an array holding strings, and S equals an existing instance
			//wanna keep track of the maximum seem so far to replace it if necessary and strings, 
			int maximum = Counter(S, nuc) ; //S is only one string of array of strands, call array
			if (maximum == 0) { // problem is if the two had non of the nuc it shouldn't be updating max
				continue; //do it in loops and will automatically go to the next one
			}
			else if (maximum > max) {
				ret = S; // S is for loop variable that is changing and ret is the past one before new loop
				max = maximum; //update the initialized variables
			}
			else if (maximum == max) { // else if because added an if inside it
				int retLength = ret.length();
				int Slength = S.length();
				if (Slength > retLength) {
					ret = S ;
				}
			}
		}
		return ret; //the string you want back.
	} //for loop keeps track of some variable that needs to be updated. 
	//make a new method to count occurences of nuc in string 
	public int Counter(String dna, String nuc) { //String is the type of the object
		// these two parameters are different ot te ones in method String max
		int sum1 = 0; //initialize sum1
		for ( int k =0 ; k< dna.length() ; k+= 1) { //length has no paremeters
			String counted = String.valueOf(dna.charAt(k)); //goes through string and gives every character and index 
			//and gives you the letter. 
			if (counted.equals(nuc)) { //counted is an object so need .equals; counted==nuc gives memory position 
				sum1 += 1; //java comes with .equals method in every class
			}
		}
		return sum1 ; // always outside the for loop
	}
}