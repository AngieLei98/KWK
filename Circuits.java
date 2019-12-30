
import java.util.LinkedList;
import java.util.Queue;

public class Circuits {
	int mySize;
	int myGraph[][];
	int myIn[];

	public int howLong(String[] connects, String[] costs){
		buildGraph(connects, costs);
		return search();
	}

	public void buildGraph(String[] connects, String[] costs){
		mySize = connects.length;
		myGraph = new int[mySize][mySize];
		myIn = new int[mySize];
		for(int fromV = 0; fromV < mySize; fromV++){
			if(!connects[fromV].equals("")){
				String[] edges = connects[fromV].split(" ");
				String[] weights = costs[fromV].split(" ");
				for(int i = 0; i < edges.length; i++){
					int toV = Integer.parseInt(edges[i]);
					myGraph[fromV][toV] = Integer.parseInt(weights[i]);
					myIn[toV]++;
				}
			}
		}
		return;
	}

	public int search(){
		int[] distance = new int[mySize];
		Queue<Integer> q = new LinkedList<Integer>();
		for(int v = 0; v < mySize; v++){
			if(myIn[v] == 0){
				q.add(v);
			}
		}
		while(!q.isEmpty()){
			int fromV = q.poll();
			for(int toV = 0; toV < mySize; toV++){
				int weight = myGraph[fromV][toV];
				if(weight > 0){
					distance[toV] = Math.max(distance[toV], distance[fromV] + weight);
					myIn[toV]--;
					if(myIn[toV] == 0){
						q.add(toV);
					}
				}
			}
		}
		int max = 0;
		for(int i : distance){
			max = Math.max(max, i);
		}
		return max;
	}
}

