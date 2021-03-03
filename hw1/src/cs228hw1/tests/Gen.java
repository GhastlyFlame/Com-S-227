package cs228hw1.tests;

import java.util.*;

public class  Gen  {
	
	@SuppressWarnings("unchecked")
	public static <T extends Number> ArrayList<T> generate(int length) {
		
		Random rand = new Random(1);
		
		
		
		ArrayList<T> arr = new ArrayList<>();
		
		for (int i = 0; i < length/4; i++) {
			arr.add( (T) (Long) rand.nextLong());
			arr.add( (T) (Double) rand.nextDouble());
			arr.add( (T) (Float) rand.nextFloat());
			arr.add( (T) (Integer) rand.nextInt());
		}
		
		if(length %2 == 1) {
			arr.add( (T) (Integer) rand.nextInt());
		}
		
		return arr;

	}

	@SuppressWarnings("unchecked")
	public static <T extends Number> ArrayList<T> generate() {

		// .generate().Random rand = new Random(1);

		ArrayList<T> arr = new ArrayList<>();

		for (int i = 0; i < 10; i++) {
			arr.add((T) ((Number) (i + .5)));

		}

		return arr;

	}
}