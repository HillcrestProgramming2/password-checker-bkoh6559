// src/main/java/org/hillcrest/chapter6/password/CriteriaChecker.java
package org.hillcrest.chapter6.password;

public final class CriteriaChecker {

    private static final char[] SPECIALS = "!@#$%^&*()-+=".toCharArray();

    private CriteriaChecker() {}

    // Returns how many criteria are met (0–5).
    public static int evaluateCriteria(String password) {
        if (password == null) password = "";

        boolean hasLength = password.length() >= 8;
        boolean hasUpper = false;
        boolean hasLower = false;
        boolean hasDigit = false;
        boolean hasSpecial = false;

        for (int i = 0; i < password.length(); i++) {
            char ch = password.charAt(i);

            if (!hasUpper && Character.isUpperCase(ch)) hasUpper = true;
            else if (!hasLower && Character.isLowerCase(ch)) hasLower = true;
            else if (!hasDigit && Character.isDigit(ch)) hasDigit = true;

            if (!hasSpecial) {
                for (char s : SPECIALS) {
                    if (ch == s) {
                        hasSpecial = true;
                        break;
                    }
                }
            }

            if (hasUpper && hasLower && hasDigit && hasSpecial) break;
        }

        int score = 0;
        if (hasLength) score++;
        if (hasUpper) score++;
        if (hasLower) score++;
        if (hasDigit) score++;
        if (hasSpecial) score++;
        return score;
    }

    // Maps score to strength label.
    public static String determineStrength(int score) {
        if (score <= 2) return "Weak";
        if (score == 3) return "Moderate";
        return "Strong";
    }

    // Helpers used by FeedbackGenerator.
    public static boolean containsUppercase(String password) {
        if (password == null) return false;
        for (int i = 0; i < password.length(); i++) {
            if (Character.isUpperCase(password.charAt(i))) return true;
        }
        return false;
    }

    public static boolean containsLowercase(String password) {
        if (password == null) return false;
        for (int i = 0; i < password.length(); i++) {
            if (Character.isLowerCase(password.charAt(i))) return true;
        }
        return false;
    }

    public static boolean containsDigit(String password) {
        if (password == null) return false;
        for (int i = 0; i < password.length(); i++) {
            if (Character.isDigit(password.charAt(i))) return true;
        }
        return false;
    }

    public static boolean containsAllowedSpecial(String password) {
        if (password == null) return false;
        for (int i = 0; i < password.length(); i++) {
            char ch = password.charAt(i);
            for (char s : SPECIALS) {
                if (ch == s) return true;
            }
        }
        return false;
    }
}
