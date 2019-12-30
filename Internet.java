import java.util.HashMap;
import java.util.HashSet;

public class Internet {

    //String s = String.valueOf(integer) => converts an integer to a string
    //int i = Integer.valueOf(string) => converts string to an Integer

    HashMap<Integer, HashSet<Integer>> myGraph;

    public int articulationPoints(String[] routers) {

        myGraph = setGraph(routers);
        int totalArticulationPoints = 0;
        for (int routerToRemove : myGraph.keySet()) { //one we are removing
            int start;

            if (routerToRemove == 0) {
                start = 1;
            } else {
                start = 0;
            }
            int numRoutersReachable = reachFromSkip(start, routerToRemove);
            if (numRoutersReachable < routers.length - 1) { //if you can't reach all broken
                totalArticulationPoints += 1;
            }
        }
        return totalArticulationPoints;
    }

    public int reachFromSkip(int start, int skipVertex) {
        Stack<String> stack = new Stack<Integer>();
        stack.add(start);
        int numRoutersReachable = 0; //repre
        while(!stack.isEmpty()) {
            int router = stack.pop();
            if (router == skipVertex) {
                numRoutersReachable--;
            }
            HashSet<String> neighbors = myGraph.get(router);
            for (String s : neighbors) {
                stack.add(s); //This is adding Strings to an Integer Stack - so
                numRoutersReachable++;
            }
        }
        return numRoutersReachable;
    }

	public HashMap<String, HashSet<String>> setGraph(String[] routers){
		HashMap<String, HashSet<String>> myGraph = new HashMap<String, HashSet<String>>();
		for(int i = 0; i < routers.length; i++){
			String[] neighbors = routers[i].split(" ");
            HashSet<String> s = new HashSet<String>(Arrays.asList(neighbors));
            myGraph.put(String.valueOf(i), s);
		}
	}
}
