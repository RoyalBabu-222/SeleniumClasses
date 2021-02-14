import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DuplicateCharacterInString {

	public static void main(String[] args) {

		System.out.println("Please enter a String: ");
		String input = null;

		while (!"EXIT".equals(input)) {
			Scanner reader = new Scanner(System.in);

			input = reader.nextLine();

			char[] chArr = input.toLowerCase().toCharArray();

			Map<Character, Integer> duplicates = new HashMap<Character, Integer>();

			for (char ch : chArr) {
				Integer oldcount = duplicates.get(ch);

				if (oldcount == null) {

					duplicates.put(ch, (1));

				} else {
					duplicates.put(ch, ++oldcount);
				}

			}

			for (Map.Entry<Character, Integer> entry : duplicates.entrySet()) {

				if (entry.getValue() > 1) {
					System.out.printf("Duplicate Character : %s, Count %d %n", entry.getKey(), entry.getValue());
				}

			}

		}

	}

}
