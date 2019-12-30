
import java.util.HashMap;

public class HuffmanDecoding {
	HashMap<String, Character> hm;
	public String decode(String archive, String[] dictionary) {
		this.hm = toMap(dictionary);
		String curr = "";
		String ret = "";
		for(int j = 0; j < archive.length(); j++){
			curr += archive.substring(j, j + 1);
			if(isInList(dictionary, curr)){
				ret += hm.get(curr);
				ret += decode(archive.substring(j + 1), dictionary);
				break;
			}
		}

		return ret;
	}
	public HashMap<String, Character> toMap(String[] s){
        HashMap<String, Character> hm = new HashMap<String, Character>();
        String alph = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int i = 0;
        for(String item : s){
        	hm.put(item, alph.charAt(i));
        	i++;
        }
        return hm;
	}
	
	public boolean isInList(String[] s, String k){
		for(String item : s){
			if(item.equals(k)){
				return true;
			}
		}
		return false;
	}
}

