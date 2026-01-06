// src/main/java/org/hillcrest/chapter6/password/PasswordCheckerApp.java
package org.hillcrest.chapter6.password;

import java.util.Scanner;

public class PasswordCheckerApp {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter a password: ");
            String password = scanner.nextLine();

            int score = CriteriaChecker.evaluateCriteria(password);
            String strength = CriteriaChecker.determineStrength(score);

            System.out.println();
            System.out.println("Password Strength: " + strength + " (" + score + "/5)");

            String feedback = FeedbackGenerator.generateFeedback(password);
            if (!feedback.isBlank()) {
                System.out.println();
                System.out.println("Suggestions to improve your password:");
                System.out.println(feedback);
            }
        }
    }
}
