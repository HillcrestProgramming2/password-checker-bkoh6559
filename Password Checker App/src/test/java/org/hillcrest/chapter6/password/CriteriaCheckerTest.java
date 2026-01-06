// src/test/java/org/hillcrest/chapter6/password/CriteriaCheckerTest.java
package org.hillcrest.chapter6.password;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class CriteriaCheckerTest {

    @Test
    void evaluateCriteria_weak_example_12345() {
        int score = CriteriaChecker.evaluateCriteria("12345");
        assertEquals(1, score);
    }

    @Test
    void evaluateCriteria_moderate_example_password123() {
        int score = CriteriaChecker.evaluateCriteria("password123");
        assertEquals(3, score);
    }

    @Test
    void evaluateCriteria_strong_example_Secure2024() {
        int score = CriteriaChecker.evaluateCriteria("Secure@2024");
        assertEquals(5, score);
    }

    @Test
    void determineStrength_boundaries() {
        assertEquals("Weak", CriteriaChecker.determineStrength(0));
        assertEquals("Weak", CriteriaChecker.determineStrength(2));
        assertEquals("Moderate", CriteriaChecker.determineStrength(3));
        assertEquals("Strong", CriteriaChecker.determineStrength(4));
        assertEquals("Strong", CriteriaChecker.determineStrength(5));
    }

    @Test
    void helper_checks_work() {
        String pw = "Abc1+xyz";
        assertTrue(CriteriaChecker.containsUppercase(pw));
        assertTrue(CriteriaChecker.containsLowercase(pw));
        assertTrue(CriteriaChecker.containsDigit(pw));
        assertTrue(CriteriaChecker.containsAllowedSpecial(pw));
    }
}
