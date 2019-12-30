import java.util.*;

public class ErdosNumber {

	static HashMap<String, HashSet<String>> myGraph;

	public String[] calculateNumbers(String[] pubs) {
		setGraph(pubs);
		HashMap<String, Integer> dist = new HashMap<String, Integer>();
		dist.put("ERDOS", 0);
		Queue<String> q = new LinkedList<String>();

//queue just works fort the BFS, order doesn't matter here so could do DFS too. Shortest distance would make sense to do BFS. 

		HashSet<String> visited = new HashSet<String>();
		q.add("ERDOS");     //for every author want to find the lowerst number of any author you have co-authored with
		while(!q.isEmpty()){
			String current = q.poll();//take it out
			if(visited.contains(current)){
				continue;
			}
			visited.add(current); //item goes through all that have coauthored with the node (i.e erdos for the start). 
			for(String item : myGraph.get(current)){ //.get gives s, the set of coauthors. Start with Erdos and build up from there
				if(!dist.containsKey(item)){
					dist.put(item, dist.get(current) + 1);
				} 
				q.add(item);// will add hte next node to gothrough( and goes through all those next to Erdos that only have one distance). 
			}
		}
		ArrayList<String> ret = new ArrayList<String>(); //goes through key of graph, and if not in the distance graph then add it. 
		for(String item : myGraph.keySet()){
			if(!dist.keySet().contains(item)){
				ret.add(item);
			}
		}
		for(String item : dist.keySet()){
			ret.add(item + " " + dist.get(item));
		}
		String[] ret1 = new String[ret.size()];
		for(int i = 0; i < ret.size(); i++){
			ret1[i] = ret.get(i);
		}
		Arrays.sort(ret1);
		return ret1;
	}

	public static void setGraph(String[] pubs){
		myGraph = new HashMap<String, HashSet<String>>();
		for(int i = 0; i < pubs.length; i++){
			String[] authors = pubs[i].split(" ");
			for(int j = 0; j < authors.length; j++){
				if(!myGraph.containsKey(authors[j])){
					myGraph.put(authors[j], new HashSet<String>()); //each key is the author(node of the graph)
				}
				HashSet<String> s = myGraph.get(authors[j]); 
				s.addAll(Arrays.asList(authors));
				myGraph.put(authors[j], s);
			} //value is the se tof all authors that you co-authored with 
		}
	}

	/**public static void main(String[] args){
		String [] s = {"ERDOS B", "A B C", "B A E", "D F"};
		setGraph(s);
	}**/
}

