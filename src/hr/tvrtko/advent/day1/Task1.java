package hr.tvrtko.advent.day1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Task1 {

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

		int countIncreased = countIncreased(depths);
		System.out.println("Number of increases: " + countIncreased);
	}

	private static int countIncreased(ArrayList<Integer> depths) {
		int counter = 0;
		int i = 0;
		for (int j = 1; j < depths.size(); j++) {
			if (depths.get(j) > depths.get(i))
				counter++;
			++i;
		}
		return counter;
	}

}
