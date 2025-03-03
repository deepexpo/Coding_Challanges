package com.example.dicegame;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class DiceGame {
    private int numberOfDice; // Number of dice used in the game
    private List<Integer> diceValues; // List to store the values of the dice
    private int totalScore; // Total score of the game
    private int ignoreDiceValue = 3; // Value of the dice to ignore, in this case 3

    // Constructor to initialize the game with a specified number of dice
    public DiceGame(int numberOfDice) {
        this.numberOfDice = numberOfDice;
        this.diceValues = new ArrayList<>();
        this.totalScore = 0;
    }

    // Method to roll the dice and populate the diceValues list with random values between 1 and 6
    public void rollDice() {
        diceValues.clear();
        Random random = new Random();
        for (int i = 0; i < numberOfDice; i++) {
            diceValues.add(random.nextInt(6) + 1); // Roll a die (1-6)
        }
    }

    // Method to calculate the score based on the current dice values
    public int calculateScore() {
        if (diceValues.contains(ignoreDiceValue)) {
            // If there are any 3's, remove all 3's and return a score of 0
            diceValues.removeIf(die -> die == ignoreDiceValue);
            return 0;
        } else {
            // If there are no 3's, find the lowest die, remove it, and return its value as the score
            int minDie = diceValues.stream().min(Integer::compareTo).orElse(0);
            diceValues.remove(Integer.valueOf(minDie));
            return minDie;
        }
    }

    // Method to simulate the game for a specified number of simulations
    public void simulateGames(int numberOfSimulations) {
        Map<Integer, Integer> scoreCounts = new HashMap<>(); // Map to keep track of score frequencies
        long startTime = System.currentTimeMillis(); // Start time for the simulation

        for (int i = 0; i < numberOfSimulations; i++) {
            totalScore = 0;
            diceValues.clear();
            rollDice();
            while (!diceValues.isEmpty()) {
                totalScore += calculateScore();
            }
            scoreCounts.put(totalScore, scoreCounts.getOrDefault(totalScore, 0) + 1);
        }

        long endTime = System.currentTimeMillis(); // End time for the simulation
        double duration = (endTime - startTime) / 1000.0; // Duration of the simulation in seconds

        // Print the results of the simulation
        System.out.println("Number of simulations was " + numberOfSimulations + " using " + numberOfDice + " dice.");
        for (Map.Entry<Integer, Integer> entry : scoreCounts.entrySet()) {
            double frequency = entry.getValue() / (double) numberOfSimulations;
            System.out.println("Total " + entry.getKey() + " occurs " + frequency + " occurred " + entry.getValue() + " times.");
        }
        System.out.println("Total simulation took " + duration + " seconds.");
    }

    // Getter for diceValues
    public List<Integer> getDiceValues() {
        return diceValues;
    }

    // Setter for diceValues
    public void setDiceValues(List<Integer> diceValues) {
        this.diceValues = diceValues;
    }

    // Main method to run the simulation
    public static void main(String[] args) {
        int numberOfDice = 5; // Change this value to use a different number of dice
        int numberOfSimulations = 10000; // Change this value to use a different number of simulations
        DiceGame game = new DiceGame(numberOfDice);
        game.simulateGames(numberOfSimulations);
    }
}