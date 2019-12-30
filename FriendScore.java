import java.util.HashMap;
import java.util.HashSet;

public class FriendScore {

	char[][] myGrid;
	HashMap<Integer, HashSet<Integer>> myMap = new HashMap<Integer, HashSet<Integer>>();
	HashMap<Integer, Integer> firstfriendScores = new HashMap<Integer, Integer>();
	HashMap<Integer, HashSet<Integer>> twoFriendScores = new HashMap<Integer, HashSet<Integer>>();

	public int highestScore(String[] s){
		setGrid(s);
		setMaps();
		setTwoFriends();
		for(int i : myMap.keySet()){
			@SuppressWarnings("unchecked")
			HashSet<Integer> a = (HashSet<Integer>) myMap.get(i).clone();
			a.addAll(twoFriendScores.get(i));
			firstfriendScores.put(i, a.size());
		}
		int max = 0;
		for(int i : firstfriendScores.keySet()){
			if(firstfriendScores.get(i) > max){
				max = firstfriendScores.get(i);
			}
		}
		return max;
	}

	public void setGrid(String[] s){
		myGrid = new char[s.length][s.length];
		for(int i = 0; i < s.length; i++){
			for(int j = 0; j < s[i].length(); j++){
				myGrid[i][j] = s[i].charAt(j);
			}
		}
	}

	public void setMaps(){
		for(int i = 0; i < myGrid.length; i++){
			for(int j = 0; j < myGrid.length; j++){
				if(!firstfriendScores.containsKey(i)){
					firstfriendScores.put(i, 0);
					twoFriendScores.put(i, new HashSet<Integer>());
				}
				if(myGrid[i][j] == 'Y'){
					if(!myMap.containsKey(i)){
						HashSet<Integer> a = new HashSet<Integer>();
						a.add(j);
						myMap.put(i, a);
					}
					else{
						HashSet<Integer> a = myMap.get(i);
						a.add(j);
						myMap.put(i, a);
					}
				}
			}
		}
	}
	public void setTwoFriends(){
		for(int i : myMap.keySet()){
			HashSet<Integer> b = new HashSet<Integer>();
			for(int j : myMap.get(i)){
				for(int k : myMap.get(j)){
					b.add(k);
				}
				b.remove(i);
				b.remove(j);
				twoFriendScores.put(i, b);
			}
		}
	}
}