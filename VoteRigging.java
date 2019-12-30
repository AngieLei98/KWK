
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class VoteRigging {
	public int minimumVotes(int[] vote) {
		if (vote.length == 1) {
			return 0;
		}
		int yours = vote[0];
		int[] theOther = Arrays.copyOfRange(vote, 1, vote.length);
		int count = 0;
		
		for (int k =0; k < theOther.length; k++) {
			theOther[k] = theOther[k] * -1;
		}
		Arrays.sort(theOther);
		
		for (int k =0; k< theOther.length; k++) {
			theOther[k] = theOther[k] * -1;
		}
		while(yours<=theOther[0]) {
			theOther[0] = theOther[0] -1;
			yours +=1;
			count+=1;
			for (int k =0; k< theOther.length; k++) {
				theOther[k] = theOther[k] * -1;
			}
			Arrays.sort(theOther);
			
			for (int k =0; k< theOther.length; k++) {
				theOther[k] = theOther[k] * -1;
			}
		}
		return count;
	}

}

