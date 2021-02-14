import java.util.HashMap;
import java.util.Map;

public class StringDuplicateCount {

	public static void countDuplicateCharacters(String STR) {
		Map<Character, Integer> map = new HashMap<Character, Integer>();

		char[] charArray = STR.toLowerCase().toCharArray();

		for (char c : charArray) {

			if (map.containsKey(c)) {
				map.put(c, map.get(c) + 1);
			} else {
				map.put(c, 1);
			}
		}
		
		for (Map.Entry<Character, Integer> entry: map.entrySet()) {
			if(entry.getValue()>1) {
				System.out.println("Duplicate Characters for the given String : ");
				System.out.println(entry.getKey() + " : " + entry.getValue());
			}
		}

	}

	public static void main(String[] args) {
		
		String STR = "Royal Babu "
				+ "Gandi";
		
		countDuplicateCharacters(STR);

	}

}
