import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashSet;
//import java.util.HashSet;

public class StringCuts {
     public String[] filter(String[] list, int minLength) {
          ArrayList<String> returnArray=new ArrayList<String>();
          
       
        //loop
         for(String s: list) {
        	 if(s.length() < minLength) {
        		 returnArray.remove(s);
        	 }
        	 else {
        		 returnArray.add(s);  // replace this with your code
        	 }
        	 
         }
         Collection<String> set = new LinkedHashSet<String>(returnArray);
         String [] finalArray = set.toArray(new String[returnArray.size()]);
         return finalArray ; 
     }
 }
