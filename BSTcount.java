import java.util.HashMap;

public class BSTcount {

	HashMap <Integer, Long> hm = new HashMap <Integer, Long>();

	public long howMany(int[] values) {
		return howMany(values.length);
	}
	private long howMany(int size) {
		if(hm.containsKey(size)){
			return hm.get(size);
		}
		if(size == 0) {
			return 1;
		} else {
			long count = 0;
			for (int leftsize = 0; leftsize < size; leftsize++ ) {
				int rightsize = size - leftsize - 1;
				count += howMany(leftsize) * howMany(rightsize);
			}
			hm.put(size, count);
			return count;
		}
	}
}


