// src/main/java/org/hillcrest/chapter6/password/FeedbackGenerator.java
package org.hillcrest.chapter6.password;

public final class FeedbackGenerator {

    private FeedbackGenerator() {}

    public static String generateFeedback(String password) {
        if (password == null) password = "";

        StringBuilder sb = new StringBuilder();

        if (password.length() < 8) {
            sb.append("- Increase the length to at least 8 characters.\n");
        }
        if (!CriteriaChecker.containsUppercase(password)) {
            sb.append("- Add at least one uppercase letter.\n");
        }
        if (!CriteriaChecker.containsLowercase(password)) {
            sb.append("- Add at least one lowercase letter.\n");
        }
        if (!CriteriaChecker.containsDigit(password)) {
            sb.append("- Add at least one number.\n");
        }
        if (!CriteriaChecker.containsAllowedSpecial(password)) {
            sb.append("- Include at least one special character.\n");
        }

        return sb.toString().trim();
    }
}
