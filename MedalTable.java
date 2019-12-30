import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class MedalTable {
	//create Country class within here so APT will like it, but could access if publi in a separate class

	public class Country{
	String countryCode=""; //wanna keep bundle together
	int gold=0;
	int silver=0;
	int bronze=0;
}
	
	HashMap<String,Country>myMap= new HashMap<String, Country>(); //makes sure don't repeat countries, 
	/**Map to class country objects that will contian all gold, silver, and bronze info to keep it all bundled**/
	public String[] generate(String[] results) {

		for(int i=0;i<results.length;i++) { //.length for an array, String.length(), .size() everything else
			String[]countries= results[i].split(" ");//array is each string of results
			for(int j=0;j<countries.length;j++) {
				if(!myMap.containsKey(countries[j])) {
					Country c= new Country(); //crete new ocountry bject to then assign it the country code
					c.countryCode= countries[j];
					myMap.put(countries[j],c); //new Country object constructor call
				}
				if(j==0) {
					myMap.get(countries[j]).gold+=1; //to add to the gold primitive in Country class just with a dot!
				}
				else if(j==1) {
					myMap.get(countries[j]).silver+=1;
				}
				else {
					myMap.get(countries[j]).bronze+=1;
				}
			}

		}
		ArrayList<Country>finalList= new ArrayList<Country>(); //SHIFT CONTROL+O imports everything you need
		finalList.addAll(myMap.values()); //put all the map values into an array
		Collections.sort(finalList, new Comparator<Country>() {

			@Override //put in to override the default compareTo memory address in Comparator
			public int compare(Country arg0, Country arg1) {
				// TODO Auto-generated method stub
				return compareCountry(arg0, arg1); //calling method written below
			}
			
		});
		//now just need to get the already sorted ArrayList into an Array
		String[] finalArray = new String[finalList.size()]; //don't go write a toString method, just do it by parts
		//to add into an array need an index (unlike arraylist) so need a for loop instead of for each
		for(int i=0; i<finalList.size();i++) { //arraylist still has indexes get it with.get
			String info = finalList.get(i).countryCode+" "+ finalList.get(i).gold+ " "+ finalList.get(i).silver+" "+finalList.get(i).bronze;
			finalArray[i] = info;
		}
		return finalArray;
	}
	
	public int compareCountry(Country A, Country B) {
		if(A.gold!= B.gold) {
			return B.gold-A.gold; //if - then A goes first, if + then B goes first.
		}
		else if(A.silver!=B.silver) {
			return B.silver-A.silver;
		}
		
		else if(A.bronze!=B.bronze) {
			return B.bronze- A.bronze;
		}
		else if(A.gold==B.gold && A.silver==B.silver && A.bronze==B.bronze) {
			return A.countryCode.compareTo(B.countryCode); //if all tie sort lexiographically w compareTo
		}
		else {
		  return 1; //B comes first
		}
	}
	
}
