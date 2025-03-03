# Dice Game

## Overview
There is a game that is played with 5 dice. The objective of the game is to
obtain the lowest possible score. To that end, the rules of the game are as
follows: - All dice are thrown on a board.

## Game Rules
- On the first roll you throw the following: 3,1,3,6,6
o Since there are two 3’s, they are removed and your total is currently 0.
- On the second roll (with 3 dice now – since the 3’s have been removed) you
have the following: 2, 5, 5
o You now remove the 2, giving you a total of 2 and there are two dice
remaining.
- You now roll 6,6
o You remove one 6 giving you a total of 8 and have one dice left.
-
You now roll 3.
o This scores 0 for this roll. This game is now finished and your game
score is 8.

## Files
- **src/main/java/com/example/dicegame/DiceGame.java**: Contains the main logic of the game, managing the game flow and score calculations.
- **src/main/resources/application.properties**: Configuration settings for the application.

## How to Run the Game
1. Ensure you have Java and Maven installed on your machine.
2. Clone the repository or download the project files.
3. Navigate to the project directory in your terminal.
4. Run the following command to build the project:
   ```
   mvn clean install
   ```
5. After the build is successful, run the game using:
   ```
   mvn exec:java -Dexec.mainClass="com.example.dicegame.DiceGame"
   ```

Enjoy the game and may the best player win!