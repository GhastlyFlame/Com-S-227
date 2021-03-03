package cs228hw1.stats;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class StatisticsShell<T extends Number> implements Statistics<T> {
	private ArrayList<T> dataLines = new ArrayList<>();
	private ArrayList<StatObject<T>> dataObjs = new ArrayList<>();
	private IParser<T> parser;

	public StatisticsShell(IParser<T> parser) {
		this.parser = parser;
	}

	@Override
	public boolean ReadFile(String path, DATA d) {
		File file = new File(path);
		int dataPos = d.ordinal();

		String[] lineByLine = new String[33]; // number of data values
		String[] splicedLine = new String[33]; // Separated data values

		try {
			Scanner scan = new Scanner(file);
			scan.nextLine(); // move past the labels on line 0
			while (scan.hasNextLine()) {
				lineByLine = scan.nextLine().split(" ");
				int count = 0; // place the values in sequence
				for (int i = 0; i < lineByLine.length; i++) {
					if (!lineByLine[i].equals("")) {
						splicedLine[count] = lineByLine[i];
						count++;
					}
				}
				try {
					dataLines.add(parser.parse(splicedLine[dataPos])); // add the data correlated to d.ordinal to the
																		// class's data list
				} catch (IllegalArgumentException e) {
					scan.close();
					return false;
				}
			}
			scan.close();

		} catch (FileNotFoundException e) {
			return false;
		}
		return true;

//		File file = new File(path);
//		int dataPos = d.ordinal();
//		Scanner scan;
//		try {
//			scan = new Scanner(file);
//			scan.nextLine(); // move past the labels on line 0
//
//		} catch (Exception e) {
//
//			return false;
//		}
//		while (scan.hasNextLine()) {
//
//			for (int i = 0; i < dataPos-1; i++) {
////				if(scan.hasNextLine())
//				scan.next();
////				System.out.println(i);
//			}
//			try {
//			dataLines.add((T) parser.parse(scan.next()));
//			}
//			catch (NumberFormatException e) {
//				dataLines.add(null);
//			}
//		}
//		scan.close();
//		return true;

//		parser.parse(str);

//		try {
//			ArrayList<T> dataReadFromFile = new ArrayList<>();
//			
//			dataReadFromFile.add(parser.parse("string"));
//			
//			Scanner in = new Scanner(data = new File(path));
//			while (in.hasNextLine()) {
//				dataLines.add(in.nextLine());
//			}
//			for (int i = 0; i < dataLines.size(); i++) {
//				String[] result = dataLines.get(i).split("\\s");
//				years.add(new ArrayList<ArrayList<Number>>());
////                List<List<Number>> year = new ArrayList<List<Number>>();
//			}
//		} catch (FileNotFoundException e) {
//			return false;
//		}
//		return true;
//

		

//		try {
//			Scanner in = new Scanner(new File(path));
//			while (in.hasNextLine()) {
//				dataLines.add(parser.parse(in.nextLine()));
//
//			}
//			in.close();
//			return true;
//		} catch (FileNotFoundException e) {
//			return false;
//		}
	}

	@Override
	public void AddStatObject(StatObject<T> so) {
		so.SetData(dataLines);
		dataObjs.add(so);
	}

	@Override
	public void AddStatObject(StatObject<T> so, int first, int last) {
		AddStatObject(so);
		if (last < dataLines.size()) {
			so.SetData(new ArrayList<T>(dataLines.subList(first, last)));
		}
		else {
			so.SetData(new ArrayList<T>(dataLines.subList(first, dataLines.size())));
		}
	}

	@Override
	public StatObject<T> GetStatObject(int i) {
		return dataObjs.get(i);
	}

	@Override
	public StatObject<T> RemoveStatObject(int i) {
		if (i < dataObjs.size())
			return dataObjs.remove(i);
		return null;
	}

	@Override
	public int Count() {
		return dataObjs.size();
	}

	@Override
	public ArrayList<T> GetDataSet() {
		ArrayList<T> output = new ArrayList<>();
		output.addAll(dataLines);
		return output;
	}

	@Override
	public ArrayList<ArrayList<Number>> MapCar() {
		ArrayList<ArrayList<Number>> output = new ArrayList<>();
		dataObjs.forEach(x -> output.add(x.GetResult()));
		return output;
	}
}
