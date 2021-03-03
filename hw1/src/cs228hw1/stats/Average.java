/**
 *
 */
package cs228hw1.stats;

import java.util.ArrayList;

/**
 * @author haadi
 *
 */
public class Average<T extends Number>  extends AbstractData<T> {

    public Average(){

    }

    @SuppressWarnings("rawtypes")
	public Average(ArrayList input) throws RuntimeException {
        super.SetData(input);
    }

    @Override
    public ArrayList<Number> GetResult() throws RuntimeException {
        double sum = 0;
        ArrayList<Number> output = new ArrayList<>();

        for (Number a : data) {
            sum += a.doubleValue() * 1.0;
        }

        Number out = sum / super.data.size();
        output.add(out);
        return output;
    }

}
