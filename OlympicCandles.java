import java.util.ArrayList;
import java.util.Collections;

public class OlympicCandles {
	public int numberOfNights(int[] candles) {
		ArrayList<Integer> Candles = new ArrayList<Integer>();
		for (int c : candles) {
			Candles.add(c);
		}
		for (int n = 1;; n++) {
			if (Candles.size() < n) {
				return n - 1;
			}
			Collections.sort(Candles);
			for (int i = Candles.size() - 1; i >= Candles.size()
					- n; i--) {
				Candles.set(i, Candles.get(i) - 1);
			}
			for (int i = 0; i < Candles.size(); i++) {
				if (Candles.get(i) == 0) {
					Candles.remove(i);
					i--;
				}
			}
		}
	}
}
