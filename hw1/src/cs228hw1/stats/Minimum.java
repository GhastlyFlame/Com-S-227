/**
 *
 */
package cs228hw1.stats;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author haadi
 *
 */
public class Minimum<T extends Number> extends AbstractData<Number> {

	public Minimum() {

	}

	public Minimum(ArrayList<Number> input) {
		super.SetData(input);
	}

	@Override
	public ArrayList<Number> GetResult() throws RuntimeException {
		ArrayList<Number> output = new ArrayList<>();
		super.check();
		super.sort();
		Number min = data.get(0);
		for (int i = 0; i < data.size(); i++) {
			if (min.doubleValue() > data.get(i).doubleValue()) {
				min = data.get(i);
			}
		}
		output.add(min);
		return output;
	}
}
