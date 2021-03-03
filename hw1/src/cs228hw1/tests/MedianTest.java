package cs228hw1.tests;

import static org.junit.Assert.*;
import org.junit.jupiter.api.Test;
//import static org.junit.jupiter.api.Assertions.*;

import cs228hw1.stats.Median;

import java.util.ArrayList;
	class MedianTest {
		
		
		@Test
		void testGetResult() {
			String generatedArray = "[-4964420948893066024, 0.41008081149220166, 0.2077148, 155629808, 6137546356583794141, 0.9677559094241207, 0.006117165, 655996946, -669528114487223426, 0.9398653887819098, 0.9471949, -382464772, -1160629452687687109, 0.3971743421847056, 0.34751803, 684358198, 5424394867226112926, 0.5064836273262351, 0.115967035, -1978864692, -4232865876030345843, 0.65989270869342, 0.15674686, -1023599386, 6976596177944619528, 0.13976268290375116, 0.69494796, 1933673321, -3592913410653813758, 0.005025175992452557, 0.5231351, 100579776, -4722652817683412901, 0.14202270321592614, 0.48172826, 323788111, -8401480976436315613, 0.5771002613742765, 0.2049135, 1177117768, -6947711303906420817, 0.18470709027794863, 0.010684371, -1359243304, 2970725011242582564, 0.17805484663717475, 0.54039705, 543635433]";
			Double errorMargin = .01;
			Double answer = 
					0.372346186
					;
			
			
			ArrayList<Double> inputList = new ArrayList<>();
			
			inputList.addAll(Gen.generate(50));
			
			assertTrue("0",inputList.toString().contentEquals(generatedArray));
			
			Median<Double> ob = new Median<>();
			
			
			
			
			
			assertEquals("test","[]",ob.GetData().toString());
			
			assertNull("2",ob.GetDescription());
			
			ob.SetDescription("test");
			
			assertTrue("2.1", ob.GetDescription().equals("test"));
			
			ob.SetDescription(null);
			assertNull("2.2",ob.GetDescription());

			
			
			
			//no data has been inputed and get results is tried
			//should through RuntimeException
			try {
				ob.GetResult();
				System.out.println(ob.GetResult().toString());
				System.out.println(ob.GetData());
				fail("no error 0");
			} catch (RuntimeException e) {
				
			} catch (Exception e ) {
				fail("unknown error 0");
			}
			
			//attempts to set data to null and then call get results
			//should through RuntimeException
			ob.SetData(null);
			try {
				ob.GetResult();
				System.out.println(ob.GetResult().toString());
				fail("no error 1");
				
			} catch (RuntimeException e) {
				
			} catch (Exception e ) {
				fail("unknown error 1 ");
			}
			
			
			//Sets the data equal to the input list and tests if it can be returned
			ob.SetData(inputList);
			assertTrue("4",ob.GetData().equals(inputList));
			
			
			//System.out.println(ob.GetResult().get(0));
			//gets the results and devides by given results, should be very close to 1
			Double resultAccuracy = ((Double) ob.GetResult().get(0)).doubleValue()/ answer;
			System.out.println(resultAccuracy);
			
			//tests if close to 1
			assertTrue("5", resultAccuracy > 1 - errorMargin && resultAccuracy < 1 + errorMargin);
			
			
			
		}

	


}

