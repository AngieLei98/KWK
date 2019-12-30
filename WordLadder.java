import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class WordLadder {

	HashMap<String, HashSet<String>> myMap = new HashMap<String, HashSet<String>>();
	
	public void setGraph(String[] words, String from, String to){
		ArrayList<String> allWords = new ArrayList<String>(Arrays.asList(words));
		allWords.add(0, from);
		allWords.add(allWords.size() - 1, to);
		for (String word : allWords) {
			if(!myMap.containsKey(word)){
				myMap.put(word, new HashSet<String>());
			}
			for(int i = 0; i < allWords.size(); i++){
				if(allWords.get(i) != word && isNext(allWords.get(i), word)){
					myMap.get(word).add(allWords.get(i));
				}
			}
		}
		myMap.get(from).remove(to);
		myMap.get(to).remove(from);
	}
	
	private boolean isNext(String from, String to) {
		if(from.length() - to.length() >= 2 || to.length() - from.length() >= 2){
			return false;
		}
		int numDifferent = 0;
		for (int i = 0; i < Math.min(from.length(), to.length()); i++) {
			if (from.charAt(i) != to.charAt(i)) {
				numDifferent++;
			}
		}
		if (numDifferent != 1) {
			return false;
		}
		return true;
	}

	public String ladderExists(String[] words, String from, String to) {
		setGraph(words, from, to);
		HashMap<String, Integer> dist = new HashMap<String, Integer>();
		HashMap<String, Integer> shortestPaths = new HashMap<String, Integer>();
		dist.put(from, 0);
		Queue<String> q = new LinkedList<String>();
		HashSet<String> visited = new HashSet<String>();
		q.add(from);
		while (!q.isEmpty()) {
			String curr = q.poll();
			if (visited.contains(curr)) {
				continue;
			}
			else{
				visited.add(curr);
			}
			int sum;
			if(curr.equals(from)) {
				sum = 1;
			}
			else {
				sum = 0;
			}
			for(String word : myMap.get(curr)){
				if(!dist.containsKey(word)){
					dist.put(word, dist.get(curr) + 1);
				}
				if(dist.get(word) == dist.get(curr) - 1){
					sum += shortestPaths.get(word);
				}
				q.add(word);
			}
			shortestPaths.put(curr, sum);
		}
		if(!shortestPaths.containsKey(to)){
			return "none";
		}
		if(shortestPaths.get(to) > 0){
			return "ladder";
		}
		else{
			return "none";
		}
	}
}


