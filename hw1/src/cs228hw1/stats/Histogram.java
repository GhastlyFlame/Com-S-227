/**
 *
 */
package cs228hw1.stats;

import java.util.ArrayList;

/**
 * @author haadi
 *
 */
public class Histogram<T extends Number> extends AbstractData<Number> {
	private int binNumber = 10;
	private double minRange = Double.NEGATIVE_INFINITY;
	private double maxRange = Double.POSITIVE_INFINITY;
//	private final static double minFallBack = -999999999.99999999999;
//	private final static double maxFallBack = 999999999.99999999999;

	public Histogram() {

	}

	public Histogram(ArrayList<Number> input) {
		super.data.addAll(input);
	}

	@Override
	public ArrayList<Number> GetResult() throws RuntimeException {
		ArrayList<Number> output = new ArrayList<>();
		super.check();

		double binRange = (maxRange - minRange) / binNumber;
		double bottom = minRange;
		int counter = 0;
		for (int i = 0; i < binNumber; i++) {
			counter = 0;
			for (int j = 0; j < data.size(); j++) {
				if (data.get(j) == null) {
					continue;
				}
				if ((data.get(j).doubleValue() >= bottom) && (data.get(j).doubleValue() < bottom + binRange)) {
					counter++;
				}
			}
			output.add(counter);
			bottom += binRange;
		}
		return output;

		/*
		 * double increment = (Math.min(maxRange.doubleValue(), maxFallBack) -
		 * Math.max(minRange.doubleValue(), minFallBack)) / binNumber; double leftWall =
		 * minRange.doubleValue(); double rightWall = leftWall + increment; int leftOff
		 * = 0; // System.out.println(increment);
		 * 
		 * // for (Number a : super.data) { // if (a == null) { // throw new
		 * RuntimeException("Invalid data point"); // } // }
		 * 
		 * if (minRange.doubleValue() > maxRange.doubleValue()) { throw new
		 * RuntimeException("Minimum is larger than Maximum"); } sort(); if
		 * (sortedDoubleClone.size() != 0) {
		 * 
		 * while (rightWall <= maxRange.doubleValue()) { int counter = 0; for (int i =
		 * leftOff; i < sortedDoubleClone.size(); i++) { if (sortedDoubleClone.get(i) >=
		 * leftWall && sortedDoubleClone.get(i) < rightWall) { counter++; } } leftOff =
		 * counter; output.add(counter); leftWall = rightWall; rightWall += increment; }
		 * } else { for (int i = 0; i < binNumber; i++) { output.add(0); } }
		 * 
		 */
//		System.out.println(increment);
//		System.out.println(output);

	}

	public void SetNumberBins(int num) {
		binNumber = num;
	}

	public int GetNumberBins() {
		return binNumber;
	}

	public Number getMinRange() {
		return minRange;
	}

	public void SetMinRange(double minRange) {
		this.minRange = minRange;
	}

	public Number getMaxRange() {
		return maxRange;
	}

	public void SetMaxRange(double maxRange) {
		this.maxRange = maxRange;
	}

}
