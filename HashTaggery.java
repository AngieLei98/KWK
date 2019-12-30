import java.util.*;

public class HashTaggery {
	public String maxTag(String[] tags, String[] messages) {
	HashSet<String> taggy = new HashSet<String>();
	for (String s: tags) {
		if(s.charAt(0) == '#') {
			taggy.add(s);
		}
	}
	int count = 0;
	for(String m: messages) {
		if (covered(m, taggy)) {
			count+= 1;
		}
	}
	if(count *1.0 / messages.length >= 0.75) {
		return "tagged" ; 
	}
	return "missed"; 
	}
	private boolean covered(String p, HashSet<String> set) {
		for (String s : p.split(" ")) {
			if(set.contains(s)) return true;
			}
			return false;
		}
	}


	

