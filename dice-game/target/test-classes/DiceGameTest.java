package com.example.dicegame;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.List;

public class DiceGameTest {

    @Test
    public void testRollDice() {
        DiceGame game = new DiceGame(5);
        game.rollDice();
        List<Integer> diceValues = game.getDiceValues();
        assertEquals("The number of dice rolled should be 5", 5, diceValues.size());
        for (int value : diceValues) {
            assertTrue("Each die value should be between 1 and 6", value >= 1 && value <= 6);
        }
    }

    @Test
    public void testCalculateScoreWithThrees() {
        DiceGame game = new DiceGame(5);
        game.setDiceValues(List.of(3, 3, 3, 3, 3));
        int score = game.calculateScore();
        assertEquals("The score should be 0 when there are threes", 0, score);
        assertTrue("All threes should be removed from the dice values", game.getDiceValues().isEmpty());
    }

    @Test
    public void testCalculateScoreWithoutThrees() {
        DiceGame game = new DiceGame(5);
        game.setDiceValues(List.of(1, 2, 4, 5, 6));
        int score = game.calculateScore();
        assertEquals("The score should be the value of the lowest die when there are no threes", 1, score);
        assertFalse("The lowest die should be removed from the dice values", game.getDiceValues().contains(1));
    }

    @Test
    public void testSimulateGames() {
        DiceGame game = new DiceGame(5);
        game.simulateGames(100);
        // Since the output is printed, we can't assert the exact values, but we can ensure the method runs without errors
        assertTrue("The simulateGames method should run without errors", true);
    }
}