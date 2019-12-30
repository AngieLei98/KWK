import java.util.ArrayList;

public class GridGame {

	char[][] myGrid;

	public int winningMoves(String[] names) {
		//this is to creat double array, first one is number of rows, and second is number of columns
		myGrid = new char[names.length][names[0].length()];
		for (int i = 0; i < names.length; i++) {
			myGrid[i] = names[i].toCharArray(); //takes the input string and turns it into an array of its characters
		} //myGrid is a character array so each row in myGrid is an array, toCharArray distributes
		return recurse();
	}

	public ArrayList<int[]> getNextMoves() {
		ArrayList<int[]> nextMoves = new ArrayList<int[]>();
		for (int i = 0; i < myGrid.length; i++) { // looks at the rows
			for (int j = 0; j < myGrid[i].length; j++) { //looks at the columns of each row
				if (myGrid[i][j] == '.' && areNeighborsClear(i, j) == true) {
					int[] move = new int[2]; //each one of these little int arrays represents the row and column number of a potential move
					move[0] = i;
					move[1] = j;
					nextMoves.add(move);
				}
			}
		}
		return nextMoves;
	}

	private boolean areNeighborsClear(int i, int j) {
		if (i > 0) {
			if (myGrid[i - 1][j] == 'X') { //check if it's not the top array
				return false;
			}
		}
		if (i < myGrid.length - 1) { //index out of bounds error change it bc index starts at 0. So size us 4 but last row is 3.
			if (myGrid[i + 1][j] == 'X') { //check if not the last one
				return false;
			}
		}

		if (j > 0) {
			if (myGrid[i][j - 1] == 'X') { //check the columns
				return false;
			}
		}

		if (j < myGrid[0].length - 1) {
			if (myGrid[i][j + 1] == 'X') {
				return false;
			}
		}
		return true;
	}

	/**
	 *
	 *
	 * @return value is an integer that represents the number of moves from this recursion stack
	 */

	public int recurse() {
		ArrayList<int[]> nextMoves = getNextMoves();
		if (nextMoves.size() == 0) {
			return 0;
		}
		int sum1 = 0;//local
		for (int[] move : nextMoves) {
			int row = move[0];
			int column = move[1];
			myGrid[row][column] = 'X';
			if (recurse() == 0) {
				sum1 += 1;
			}
			myGrid[row][column] = '.';
		}
		return sum1;
	}

}
