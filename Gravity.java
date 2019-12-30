public class Gravity {
	public Gravity() {
		System.out.println("Constructed a new Gravity instance");
	}
	public void canWeSeeFalling(double time, double velo) {
		System.out.println(time * velo);
	}
	private double falling(double time, double velo){ //given by user
		double distance = (velo * time) + (0.5 * 9.8 * (time * time));// fill in code here
		return distance;
	}
	}

