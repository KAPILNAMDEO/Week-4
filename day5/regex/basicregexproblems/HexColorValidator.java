/*3️⃣ Validate a Hex Color Code
A valid hex color:
Starts with a #
Followed by 6 hexadecimal characters (0-9, A-F, a-f).
🔹 Example Inputs & Outputs
✅ "#FFA500" → Valid
✅ "#ff4500" → Valid
❌ "#123" → Invalid (too short)*/
package com.capgeminiTrainingPrograms.week4.day5.regex.basicregexproblems;


import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HexColorValidator {
    public static boolean isValidHexColor(String colorCode) {
        String regex = "^#([A-Fa-f0-9]{6})$";
        Pattern pattern=Pattern.compile(regex);
        Matcher matcher=pattern.matcher(colorCode);
        return matcher.matches();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Get user input
        System.out.print("Enter a hex color code: ");
        String colorCode = sc.nextLine();

        // Validate and print result
        if (colorCode.length() == 7) {
            if(isValidHexColor(colorCode)){
                System.out.println("Valid!");
            }

            if(!isValidHexColor(colorCode)){
                System.out.println("invalid!");
            }
        }

        sc.close();
    }
}
