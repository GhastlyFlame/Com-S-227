package cs228hw1.tests;

import org.junit.Test;

import cs228hw1.stats.Average;
import cs228hw1.stats.IParser;
import cs228hw1.stats.Parser;
import cs228hw1.stats.StatObject;
import cs228hw1.stats.StatisticsShell;
import cs228hw1.stats.Statistics.DATA;

import static org.junit.Assert.*;
import java.util.ArrayList;

public class ShellTests {

	@Test
	public void p1() {
		@SuppressWarnings("unchecked")
		IParser<Double> parse = new Parser();
		StatisticsShell<Double> x = new StatisticsShell<Double>(parse);
		StatObject<Double> stat = new Average<Double>();
		x.AddStatObject(stat);
		assertEquals(stat, x.GetStatObject(0));
	}

//	@Test
//	public void p2() {
//		@SuppressWarnings("unchecked")
//		IParser<Double> parse = new Parser();
//		StatisticsShell<Double> x = new StatisticsShell<Double>(parse);
//		StatObject<Double> stat = new Average<Double>();
//		StatObject<Double> other = new Average<>();
//		ArrayList<Double> stats = new ArrayList<>();
//		stats.add(23.76);
//		ArrayList<Double> others = new ArrayList<>();
//		others.add(57.86);
//		stat.SetData(stats);
//		other.SetData(others);
//		x.AddStatObject(stat);
//		x.AddStatObject(other);
//		ArrayList<Double> correctResult = new ArrayList<Double>();
//		correctResult.add(23.76);
//		correctResult.add(57.86);
//		assertEquals(correctResult, x.GetDataSet());
//
//	}

	@Test
	public void p3() {
		@SuppressWarnings("unchecked")
		IParser<Double> parse = new Parser();
		StatisticsShell<Double> x = new StatisticsShell<Double>(parse);
		assertEquals(0, x.Count());
		StatObject<Double> stat = new Average<Double>();
		StatObject<Double> other = new Average<>();
		ArrayList<Double> stats = new ArrayList<>();
		stats.add(23.76);
		stats.add(793.4);
		ArrayList<Double> others = new ArrayList<>();
		others.add(57.86);
		others.add(-9.2);
		stat.SetData(stats);
		other.SetData(others);
		x.AddStatObject(stat);
		x.AddStatObject(other);
		ArrayList<ArrayList<Double>> correctResult = new ArrayList<>();
		ArrayList<Double> average1 = new ArrayList<>();
		average1.add(408.58);
		ArrayList<Double> ave2 = new ArrayList<>();
		ave2.add(24.33);
		correctResult.add(average1);
		correctResult.add(ave2);
		// assertEquals(correctResult, x.MapCar()); IGNORE
		assertEquals(2, x.Count());
		assertEquals(other, x.GetStatObject(1));
		// x.AddStatObject(stat, 2, 3); IGNORE
		// assertEquals(stats, stat.GetData()); IGNORE
		// assertEquals(others, x.GetStatObject(2).GetData()); IGNORE
	}

	@Test
	public void p4() {
		@SuppressWarnings("unchecked")
		IParser<Double> parse = new Parser();
		StatisticsShell<Double> x = new StatisticsShell<Double>(parse);
		StatObject<Double> stat = new Average<Double>();
		x.AddStatObject(stat, 0, 5);
		assertEquals(stat, x.GetStatObject(0));
	}

	@Test
	public void fileStuff() {
		String path = "\\Users\\haadi\\Desktop\\COM S 228\\hw1\\src\\cs228hw1\\stats\\911427995710dat.txt"; // insert path here
		@SuppressWarnings("unchecked")
		IParser<Double> parse = new Parser();
		StatisticsShell<Double> x = new StatisticsShell<Double>(parse);
		x.ReadFile(path, DATA.USAF);
		assertEquals((Integer) 725472, x.GetDataSet().get(0));
		@SuppressWarnings("unchecked")
		IParser<Integer> yparse = new Parser();
		StatisticsShell<Integer> y = new StatisticsShell<Integer>(yparse);
		y.ReadFile(path, DATA.SPD);
		assertEquals((Integer) 11, y.GetDataSet().get(3));
	}
}
