package hr.tvrtko.advent.day1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Task1 {

	public static void main(String[] args) {

		InputStream inputStream = Task1.class.getResourceAsStream("input.txt");
		int counter = 0;

		try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
			String line;
			int i = 0;
			int previous = 0;
			while ((line = br.readLine()) != null) {
				if (i > 0) {
					if (Integer.parseInt(line) > previous)
						++counter;
				}
				previous = Integer.parseInt(line);
				++i;
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Number of increases: " + counter);
		
	}

}
