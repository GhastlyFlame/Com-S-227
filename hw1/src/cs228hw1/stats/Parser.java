/**
 * 
 */
package cs228hw1.stats;

import java.util.ArrayList;

/**
 * @author haadi
 *
 */
public class Parser implements IParser {

	@Override
	public Number parse(String str) {
		try {
			System.out.println(str);
			if (!str.contains(".")) {
				return Integer.parseInt(str);
			} else {
				return Double.parseDouble(str);
				
			}
		} catch (Exception e) {
			return null;
		}
	}

}
