// src/test/java/org/hillcrest/chapter6/password/FeedbackGeneratorTest.java
package org.hillcrest.chapter6.password;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class FeedbackGeneratorTest {

    @Test
    void generateFeedback_strong_password_has_no_suggestions() {
        String feedback = FeedbackGenerator.generateFeedback("Secure@2024");
        assertTrue(feedback.isEmpty());
    }

    @Test
    void generateFeedback_weak_12345_contains_expected_suggestions() {
        String feedback = FeedbackGenerator.generateFeedback("12345");
        assertTrue(feedback.contains("Increase the length to at least 8 characters."));
        assertTrue(feedback.contains("Add at least one uppercase letter."));
        assertTrue(feedback.contains("Add at least one lowercase letter."));
        assertTrue(feedback.contains("Include at least one special character."));
    }

    @Test
    void generateFeedback_moderate_password123() {
        String feedback = FeedbackGenerator.generateFeedback("password123");
        assertTrue(feedback.contains("Add at least one uppercase letter."));
        assertTrue(feedback.contains("Include at least one special character."));
    }

    @Test
    void generateFeedback_null_input_treated_as_empty() {
        String feedback = FeedbackGenerator.generateFeedback(null);
        assertTrue(feedback.contains("Increase the length to at least 8 characters."));
        assertTrue(feedback.contains("Add at least one uppercase letter."));
        assertTrue(feedback.contains("Add at least one lowercase letter."));
        assertTrue(feedback.contains("Add at least one number."));
        assertTrue(feedback.contains("Include at least one special character."));
    }
}
