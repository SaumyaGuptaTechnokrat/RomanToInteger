package Roman;

import java.util.HashMap;
import java.util.Scanner;
public class RomanToInteger {
    public static void main(String[] args) {
        Scanner inputString = new Scanner(System.in);
        System.out.print("Enter the input Roman Numeral:");
        String romanNumeral = inputString.nextLine();// Replace with your Roman numeral input
        int integerValue = convertRomanToInteger(romanNumeral);
        System.out.println("Integer representation of " + romanNumeral + " is: " + integerValue);
    }

    public static int convertRomanToInteger(String romanNumeral) {
        // Create a HashMap to store Roman numeral values
        HashMap<Character, Integer> romanValueMap = new HashMap<>();
        romanValueMap.put('I', 1);
        romanValueMap.put('V', 5);
        romanValueMap.put('X', 10);
        romanValueMap.put('L', 50);
        romanValueMap.put('C', 100);
        romanValueMap.put('D', 500);
        romanValueMap.put('M', 1000);

        int result = 0;
        int previousValue = 0; // Store the previous Roman numeral value

        // Iterate through the Roman numeral string from right to left
        for (int i = romanNumeral.length() - 1; i >= 0; i--) {
            char currentCharacter = romanNumeral.charAt(i);
            int currentValue = romanValueMap.get(currentCharacter);

            // If the current value is less than the previous value, subtract it
            if (currentValue < previousValue) {
                result -= currentValue;
            } else {
                result += currentValue;
            }

            // Update the previous value for the next iteration
            previousValue = currentValue;
        }

        return result;
    }
}
