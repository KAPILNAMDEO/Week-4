/*6️⃣ Extract Dates in dd/mm/yyyy Format
🔹 Example Text:
"The events are scheduled for 12/05/2023, 15/08/2024, and 29/02/2020."
🔹 Expected Output:
12/05/2023, 15/08/2024, 29/02/2020*/
package com.capgeminiTrainingPrograms.week4.day5.regex.extractedproblems;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractsDates {
    public static List<String> extractdates(String text) {
        String regex = "\\b\\d{2}/\\d{2}/\\d{4}\\b"; // Matches dates

        // Compile pattern
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        // List to store extracted dates
        List<String> dates = new ArrayList<>();

        while (matcher.find()) {
            dates.add(matcher.group());
        }

        return dates;
    }

    public static void main(String[] args) {
        String text = "The events are scheduled for 12/05/2023, 15/08/2024, and 29/02/2020.";

        List<String> dates = extractdates(text);

        if (dates.isEmpty()) {
            System.out.println("No Dates  found.");
        } else {
            System.out.println("Extracted Dates are:");
            System.out.println(String.join(", ", dates));
        }
    }
}
