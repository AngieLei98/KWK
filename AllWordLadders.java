import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class AllWordLadders {

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
		boolean oneDiff = false;
		for(int i = 0; i < Math.min(from.length(), to.length()); i++){
			if(from.charAt(i) != to.charAt(i)){
				if(!oneDiff){
					oneDiff = true;
				}
				else if(oneDiff){
					return false;
				}
			}
		}
		return oneDiff;
	}

	public int[] solve(String[] words, String from, String to) {
		setGraph(words, from, to);
		HashMap<String, Integer> dist = new HashMap<String, Integer>();
		HashMap<String, Integer> shortestPaths = new HashMap<String, Integer>();
		dist.put(from, 0);
		Queue<String> q = new LinkedList<String>();
		HashSet<String> visited = new HashSet<String>();
		q.add(from);
		while (!q.isEmpty()) {
			String curr = q.poll();
			if(visited.contains(curr)){
				continue;
			}
			visited.add(curr);
			int sum;
			if(curr.equals(from)){
				sum = 1;
			}
			else{
				sum = 0;
			}
			for(String item : myMap.get(curr)){
				if(!dist.containsKey(item)){
					dist.put(item, dist.get(curr) + 1);
				}
				if(dist.get(item) == dist.get(curr) - 1){
					sum += shortestPaths.get(item);
				}
				q.add(item);
			}
			shortestPaths.put(curr, sum);
		}
		if(!dist.containsKey(to)){
			int[] a = new int[2];
			a[0] = 0;
			a[1] = 0;
			return a;
		}
		int[] ret = new int[2];
		ret[0] = dist.get(to) + 1;
		ret[1] = shortestPaths.get(to);
		return ret;
	}
}

