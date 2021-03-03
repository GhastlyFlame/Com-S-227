/**
 * 
 */
package cs228hw1;

import cs228hw1.stats.*;
import cs228hw1.stats.Statistics.DATA;

/**
 * @author hmajeed
 *
 */
public class Weather {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		DATA x = DATA.TEMP;
//		IParser<Double> parseDouble = new IParser<Double>() {
//			@Override
//			public Double parse(String str) {
//				return Double.parseDouble(str);
//			}
//		};
//		
//		IParser<Integer> parseInt = new IParser<Integer>() {
//			@Override
//			public Integer parse(String str) {
//				return Integer.parseInt(str);
//			}
//		};
		IParser parse = new Parser();
		StatisticsShell a = new StatisticsShell(parse);
		System.out.println(a.ReadFile("D:\\_Flashdrive\\COM S 228\\HW 1\\src\\cs228hw1\\stats\\911427995710dat.txt", x));
	}

}
