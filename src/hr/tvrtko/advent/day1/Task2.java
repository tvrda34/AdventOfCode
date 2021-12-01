package hr.tvrtko.advent.day1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Task2 {

	public static void main(String[] args) {

		InputStream inputStream = Task1.class.getResourceAsStream("input.txt");
		ArrayList<Integer> depths = new ArrayList<>();

		try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
			String line;
			while ((line = br.readLine()) != null) {
				depths.add(Integer.parseInt(line));
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		int countIncreased = tripletsCountIncreased(depths);
		System.out.println("Number of increases: " + countIncreased);
	}

	private static int tripletsCountIncreased(ArrayList<Integer> depths) {
		int counter = 0;
		int size = depths.size();

		Map<Integer, Integer> tripletsMap = new HashMap<>();
		for (int i = 0; i < size; i++) {
			if (i < size - 2)
				tripletsMap.put(i, depths.get(i));
			if (i - 1 >= 0 && i != size - 1)
				tripletsMap.replace(i - 1, tripletsMap.get(i - 1) + depths.get(i));
			if (i - 2 >= 0)
				tripletsMap.replace(i - 2, tripletsMap.get(i - 2) + depths.get(i));
			if (i >= 3) {
				int j = i - 2;
				if (tripletsMap.get(j) > tripletsMap.get(j - 1))
					counter++;
			}

		}

		return counter;
	}

}
