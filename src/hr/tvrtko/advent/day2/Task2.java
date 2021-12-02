package hr.tvrtko.advent.day2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * forward key in map == horizontal position
 * @author Tvrtko
 *
 */
public class Task2 {

	public static void main(String[] args) {
		InputStream inputStream = Task1.class.getResourceAsStream("input.txt");
		Map<String, Integer> commandsMap = new HashMap<>();
		commandsMap.put("forward", 0);
		commandsMap.put("depth", 0);
		int aim = 0;
		
		
		try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
			String line;
			while ((line = br.readLine()) != null) {
				String[] command = line.split(" ");
				if(command[0].equals("forward")) {
					commandsMap.replace(command[0], Integer.parseInt(command[1]) + commandsMap.get(command[0]));
					commandsMap.replace("depth", (Integer.parseInt(command[1]) * aim) + commandsMap.get("depth"));
				}
				else {
					if(command[0].equals("down"))
						aim += Integer.parseInt(command[1]);
					else
						aim -= Integer.parseInt(command[1]);
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("Final position: " + commandsMap.get("depth") * commandsMap.get("forward"));

	}

}
