public class CirclesCountry {
	public int leastBorders(int[] x, int[] y, int[] r, 
			int x1, int y1, int x2, int y2) {
		int sum1 = 0;       
		for ( int k =0 ; k< x.length ; k+= 1) {
			boolean ifIn1 = (distance (x1, y1, x[k], y[k],r[k]) == true);
			boolean ifIn2 = (distance(x2, y2, x[k], y[k], r[k])== true);
			if ( ifIn1 == true && ifIn2 == true)  { //x1, y1, x2 is x(k) //if statements turns true unless proven 
				//otherwise //calls the method distance down below
				sum1 += 0; //number of circles ie number of borders crossed
			}  // compare the boolean of each and if both true/false then doesn't cross any borders i.e number of circles
			else if (ifIn1== false && ifIn2 == false) {
				sum1 += 0; //same thing for point 2
			}
			else {
				sum1 += 1;
			}
		}
		return sum1; //that's what we want to access from the method      			  
	}
	public boolean distance(int x1, int y1, int x2, int y2, int r ) { //method for distance between points
		double a= ((y2-y1)*(y2-y1)) + ((x2-x1)*(x2-x1));
		double length= Math.sqrt(a);
		if (length < r) {
			return true;
		}
		else {
			return false;
		}
	}

}
