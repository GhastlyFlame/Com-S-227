/**
 *
 */
package cs228hw1.stats;

import java.util.ArrayList;

/**
 * @author haadi
 *
 */
public class StdDeviation<T extends Number> extends AbstractData<Number> {

	public StdDeviation() {

	}

	public StdDeviation(ArrayList<Number> input) throws RuntimeException {
		super.SetData(input);
	}

	@Override
	public ArrayList<Number> GetResult() throws RuntimeException {
		super.check();
//		double sum = 0.0;
//		ArrayList<Number> output = new ArrayList<>();
//		Average<Double> avg = new Average<>();
//		avg.SetData(data);
//		double avgVal = (double) avg.GetResult().get(0);
//
//		for (Number i : data) {
//			sum += Math.pow(i.doubleValue() - avgVal, 2);
//		}
////		System.out.println(Math.sqrt(sum/data.size()));
//		double finnal = ((Math.sqrt(sum / data.size())));
////		System.out.println((double)output.get(0));
//		output.add(finnal);
//		return output;

//		double sum = 0.0;
//		double devTotal = 0.0;
//		ArrayList<Number> stdDev = new ArrayList<>();
//		Average<Number> average = new Average<>(data);
//		Number avg = average.GetResult().get(0);
//		
//		for (int i = 0; i < data.size(); i++) {
//			devTotal += (data.get(i).doubleValue() - avg.doubleValue()) * (data.get(i).doubleValue() - avg.doubleValue());
//		}
//		
//		stdDev.add(Math.sqrt(devTotal / data.size()));
//		return stdDev;
		ArrayList<Number> stdDev = new ArrayList<>();
		double SD = 0.0;
		double mean = 0.0;
		for (int i = 0; i < data.size(); ++i) {
			mean += data.get(i).doubleValue();
		}
		mean = mean / data.size();
		double temp = 0;
		double sum = 0;

		for (int i = 0; i < data.size(); ++i) {
			temp = data.get(i).doubleValue() - mean;
			temp *= temp;
			sum += temp;
		}
		SD = Math.sqrt((sum / (data.size()-1)));
		
		stdDev.add(SD);
		return stdDev;
	}
}
