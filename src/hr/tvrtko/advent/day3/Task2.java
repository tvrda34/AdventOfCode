package hr.tvrtko.advent.day3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Task2 {

	public static void main(String[] args) {
		InputStream inputStream = Task1.class.getResourceAsStream("input.txt");
		List<String> inputs = new ArrayList<>();

		try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
			String line;
			while ((line = br.readLine()) != null) {
				inputs.add(line);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		
		int oxygenGeneratorRating = Integer.parseInt(resolveNumber(inputs, 0, 0, ""), 2);
		int CO2ScrubberRating = Integer.parseInt(resolveNumber(inputs, 0, 1, ""), 2);

		System.out.println("Life support rating: " + oxygenGeneratorRating * CO2ScrubberRating);

	}

	public static String resolveNumber(List<String> inputList, int position, int type, String prefix) {
		if (inputList.size() == 1)
			return inputList.get(0);
		else {
			int highBite = 0;
			int lowBite = 0;
			for (String el : inputList) {
				if(el.charAt(position) == '1')
					++highBite;
				else
					++lowBite;
			}
			String prefix2 = getPrefix(highBite, lowBite, type, prefix);
			
			return resolveNumber(inputList.stream().filter(it -> it.startsWith(prefix2)).collect(Collectors.toList()), ++ position, type, prefix2);
		}
	}
	
	public static String getPrefix(int high, int low, int type, String prefix) {
		int rez = Integer.compare(high, low);
		if(type == 0) {
			if(rez == 0 || rez > 0)
				return prefix + "1";
			else
				return  prefix + "0";
		}else {
			if(rez == 0 || rez > 0)
				return prefix + "0";
			else
				return prefix + "1";
		}
		
	}
}
