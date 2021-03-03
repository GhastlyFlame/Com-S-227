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
public class Maximum<T extends Number> extends AbstractData<Number> {

	public Maximum() {

	}

	public Maximum(ArrayList<Number> input) {
		super.SetData(input);
	}

	@Override
	public ArrayList<Number> GetResult() throws RuntimeException {
		super.check();
		ArrayList<Number> output = new ArrayList<>();

//        super.preCheck();
		super.sort();
		Number max = data.get(0);
		for (int i = 0; i < data.size(); i++) {
			if (max.doubleValue() < data.get(i).doubleValue()) {
				max = data.get(i);
			}
		}
		output.add(max);
		return output;
	}
}
