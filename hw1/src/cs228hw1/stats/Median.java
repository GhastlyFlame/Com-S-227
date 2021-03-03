/**
 *
 */
package cs228hw1.stats;

import java.util.ArrayList;

/**
 * @author haadi
 *
 */
public class Median<T extends Number>  extends AbstractData<Number> {

	public Median() {
		
	}
	
    public Median(ArrayList<Number> input) throws RuntimeException {
        super.SetData(input);
    }

    @Override
    public ArrayList<Number> GetResult() throws RuntimeException {
        ArrayList<Number> output = new ArrayList<>();
        super.check();
        super.sort();
        if (super.data.size() == 1) {
            output.add(super.data.get(0));
        } else {
            int midPoint = (super.data.size() - 1) / 2;

            if (super.sortedDoubleClone.size() % 2 == 0) {
                output.add((super.sortedDoubleClone.get(midPoint) + super.sortedDoubleClone.get(midPoint + 1)) / 2.0);
            } else {
                output.add(super.sortedDoubleClone.get(midPoint));
            }

        }
        return output;
    }


}

