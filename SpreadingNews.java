import java.util.ArrayList;
import java.util.Collections;

public class SpreadingNews {
	public int minTime(int[] supervisors) {
		return minBoss(0, supervisors);
	}
	private int minBoss(int boss, int[] supervisors) {
		ArrayList<Integer> subTime = new ArrayList<Integer>();
		for (int subord = 0; subord < supervisors.length; subord++){
			if(boss == supervisors[subord]){
				subTime.add(minBoss(subord, supervisors));
			}
		}
		if(subTime.size() == 0){
			return 0;
		}
		Collections.sort(subTime, Collections.reverseOrder());
		int max = subTime.get(0) + 1;
		for(int i = 1; i < subTime.size(); i++){
			if(subTime.get(i) + i + 1 > max){
				max = subTime.get(i) + i + 1;
			}
		}
		return max;
	}
}

