
import java.util.HashSet;

public class FloodRelief {

	char[][] myGrid;
	int rowLength;
	int colLength;
	char[][] visited;
	String[] heights;

	public int minimumPumps(String[] heights){
		this.heights = heights;
		setGrids(heights);
		int count = 0;
		for(char c = 'a'; c <= 'z'; c++){
			for(int i = 0; i < rowLength; i++){
				for(int j = 0; j < colLength; j++){
					if(visited[i][j] != 1 && myGrid[i][j] == c){
						totals(i, j);
						count++;
					}
				}
			}
		}
		return count;
	}

	public void totals(int row, int col){
		visited[row][col] = 1;
		if(isValidMove(row, col, row + 1, col)){
			totals(row + 1, col);
		}
		if(isValidMove(row, col, row - 1, col)){
			totals(row - 1, col);
		}
		if(isValidMove(row, col, row, col + 1)){
			totals(row, col + 1);
		}
		if(isValidMove(row, col, row, col - 1)){
			totals(row, col - 1);
		}
	}

	public int total(int row, int col){
		char current = heights[row].charAt(col);
		int[] curr = {row, col};
		int count = 0;
		for(int[] item : nextMoves(curr)){
			int row1 = item[0];
			int col1 = item[1];
			if(myGrid[row1][col1] < current){
				count += total(row1, col1);
			}
		}
		return count;
	}

	public boolean isValidMove(int row, int col, int newRow, int newCol){
		return newRow < rowLength 
				&& newCol < colLength 
				&& newRow >= 0 && newCol >= 0
				&& visited[newRow][newCol] != 1
				&& heights[row].charAt(col) <= heights[newRow].charAt(newCol);
	}

	public void setGrids(String[] s){
		myGrid = new char[s.length][s[0].length()];
		visited = new char[s.length][s[0].length()];
		rowLength = s.length;
		colLength = s[0].length();
		for(int i = 0; i < s.length; i++){
			char[] temp = s[i].toCharArray();
			for(int j = 0; j < temp.length; j++){
				myGrid[i][j] = temp[j];
				visited[i][j] = 0;
			}
		}
	}

	public int[] findLowest(){
		int[] ret = {0, 0};
		for(int i = 0; i < rowLength; i++){
			for(int j = 0; j < colLength; j++){
				if(myGrid[i][j] < myGrid[ret[0]][ret[1]]){
					ret[0] = i;
					ret[1] = j;
				}
			}
		}
		return ret;
	}
	public HashSet<int[]> nextMoves(int[] current){
		HashSet<int[]> ret = new HashSet<int[]>();
		int row = current[0];
		int col = current[1];
		for(int i = -1; i <= 1; i++){
			for(int j = -1; j <= 1; j++){
				if(row + i < rowLength && row + i > 0 && col + j < colLength && col + j > 0){
					int[] toAdd = {row + i, col + j};
					ret.add(toAdd);
				}
			}
		}
		return ret;
	}
}
