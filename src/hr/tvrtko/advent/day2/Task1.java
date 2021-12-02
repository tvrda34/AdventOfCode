package hr.tvrtko.advent.day2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Task1 {

	public static void main(String[] args) {
		InputStream inputStream = Task1.class.getResourceAsStream("input.txt");
		Map<String, Integer> commandsMap = new HashMap<>();
		commandsMap.put("forward", 0);
		commandsMap.put("up", 0);
		commandsMap.put("down", 0);
		
		try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
			String line;
			while ((line = br.readLine()) != null) {
				String[] command = line.split(" ");
				commandsMap.replace(command[0], Integer.parseInt(command[1]) + commandsMap.get(command[0]));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		int result = (commandsMap.get("down") - commandsMap.get("up")) * commandsMap.get("forward");
		System.out.println("Final position: " + result);

	}

}
