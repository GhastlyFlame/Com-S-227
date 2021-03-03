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
public abstract class AbstractData<T extends Number> implements StatObject<T> {
	protected ArrayList<T> data = new ArrayList<>();
	protected ArrayList<Double> sortedDoubleClone = new ArrayList<>();
	private String desc;

	/**
	 * @param d is the description to set for this statistics object.
	 *
	 */
	@Override
	public void SetDescription(String d) {
		desc = d;
	}

	/**
	 * @return the currently set description.
	 */
	@Override
	public String GetDescription() {
		return desc;
	}

	/**
	 * Returns the result of this statistical function in an ArrayList. Null values
	 * in the data set are ignored for purposes of calculation. If the result is a
	 * single value, it should be the sole element of the array. If the result
	 * consists of multiple values, order is important.
	 *
	 * @throws RuntimeException Thrown if the data in this StatObject is null or
	 *                          empty. Note that null values are not the same as the
	 *                          entire data set being null.
	 */
	@Override
	public ArrayList<Number> GetResult() throws RuntimeException {
		return null;
	}

	/**
	 * Changes the data to be used in the calculations for this StatObject. A deep
	 * copy of all the data will be made.
	 *
	 * @param data The new data.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public void SetData(ArrayList data) {
		this.data.clear();
		sortedDoubleClone.clear();
		if (data == null)
			return;
		for(int i = 0; i < data.size(); i++) {
			this.data.add((T) data.get(i));
		}
	}

	/**
	 * Returns a list of the data used in the calculations for this StatObject. The
	 * returned list should not allow modification of any values inside this
	 * Statistics object.
	 *
	 *
	 */
	@Override
	public ArrayList<T> GetData() {
		
		ArrayList<T> out = new ArrayList<>();
		for(T x : data) {
			out.add(x);
		}
		return out;

	}
	public void check() {
		if (data == null || data.isEmpty())
			throw new RuntimeException("Data is invalid");
	}
	protected void sort() {
		for (int i = 0; i < data.size(); i++) {
			if (data.get(i) != null)
				sortedDoubleClone.add(data.get(i).doubleValue());
		}
//		System.out.println(sortedDoubleClone);
		Collections.sort(this.sortedDoubleClone);
	}

}
