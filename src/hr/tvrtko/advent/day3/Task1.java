package hr.tvrtko.advent.day3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Task1 {

	public static void main(String[] args) {
		InputStream inputStream = Task1.class.getResourceAsStream("input.txt");
		Map<Integer, List<Integer>> bisMap = new HashMap<>();

		try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
			String line;
			int position = 0;
			while ((line = br.readLine()) != null) {
				for(int i = 0; i < line.length(); i++) {
					if(bisMap.containsKey(i)) {
						if(line.charAt(i) == '0') 
							position = 0;
						else
							position = 1;
						bisMap.get(i).set(position, bisMap.get(i).get(position) + 1);
					}
					else {
						bisMap.put(i, Arrays.asList(new Integer[2]));
						if(line.charAt(i) == '0') {
							bisMap.get(i).set(0, 1);
							bisMap.get(i).set(1, 0);
						}else {
							bisMap.get(i).set(1, 1);
							bisMap.get(i).set(0, 0);
						}
					}
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		StringBuilder sb = new StringBuilder();

		for(Map.Entry<Integer, List<Integer>> entry : bisMap.entrySet()) {
			if(entry.getValue().get(0) > entry.getValue().get(1))
				sb.append(0);
			else
				sb.append(1);
		}
		
		String gama = sb.toString();
		String epsilon = gama.replaceAll("0", "x").replaceAll("1", "0").replaceAll("x", "1");
		
		int gamaRate = Integer.parseInt(gama, 2);
		int epsilonRate = Integer.parseInt(epsilon, 2);

		System.out.println("Submarine power consumption: " + gamaRate * epsilonRate);

	}

}
