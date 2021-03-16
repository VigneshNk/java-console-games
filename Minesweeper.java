package Games;

import java.util.Scanner;

public class Minesweeper {

  /**
   * Prints mine field array.
   */
  public static void PrintArray(int[][] array) {
    // Row Number
    int c = 1;

    // Print Column Number
    System.out.println("  1 2 3 4 5 6");

    // Print Array
    for (int i = 1; i < 7; i++) {

      // Row Number
      System.out.print(c + " ");

      for (int j = 1; j < 7; j++) {
        System.out.print(array[i][j] + " ");
      }

      // Next Line
      System.out.println("");
      c++;
    }
  }

  /**
   * Reveals the number of mines around a certain coordinate.
   */
  public static int RevealSquare(int x, int y, int[][] player, int[][] hidden) {
    // Number of Mines
    int num = 0;

    // Check if Square Has Been Revealed
    if (player[y][x] == 1 || player[y][x] == 2 || player[y][x] == 3 || player[y][x] == 4
        || hidden[y][x] == 5 || hidden[y][x] == 9 || hidden[y][x] == 8) {

      // Square Already Revealed
      num = 10;
    } else {

      // Initialize Num
      num = 0;

      // Up
      if (hidden[y + 1][x] == 6 || hidden[y + 1][x] == 9) {
        num++;
      }

      // Down
      if (hidden[y - 1][x] == 6 || hidden[y - 1][x] == 9) {
        num++;
      }

      // Right
      if (hidden[y][x + 1] == 6 || hidden[y][x + 1] == 9) {
        num++;
      }

      // Left
      if (hidden[y][x - 1] == 6 || hidden[y][x - 1] == 9) {
        num++;
      }

      // No Mines
      if (num == 0) {

        // Change Hidden Array to Store No Mine at Coordinate
        if (hidden[y][x] == 0) {
          hidden[y][x] = 5;
        }

        // Change Hidden Array to Store No Mine at Coordinate and Mine(6)
        if (hidden[y][x] == 6) {
          hidden[y][x] = 9;
        }

        // Change Hidden Array to Store No Mine at Coordinate and Heart
        if (hidden[y][x] == 7) {
          hidden[y][x] = 8;
        }
      }
    }

    // Return
    return num;
  }

  /**
   * Checks player position to make sure direction is possible.
   */
  public static int checkPlayerPosition(String direction, int x, int y) {
    // Boolean Value if Move is Possible or Not
    int check = 1;

    // No North and West
    if (x == 1 && y == 1) {
      if (direction.equalsIgnoreCase("N") || direction.equalsIgnoreCase("W")) {
        check = 0;
      }
    }

    // No South and West
    else if (x == 1 && y == 6) {
      if (direction.equalsIgnoreCase("S") || direction.equalsIgnoreCase("W")) {
        check = 0;
      }
    }

    // No North and East
    else if (x == 6 && y == 1) {
      if (direction.equalsIgnoreCase("N") || direction.equalsIgnoreCase("E")) {
        check = 0;
      }
    }

    // No South and East
    else if (x == 6 && y == 6) {
      if (direction.equalsIgnoreCase("S") || direction.equalsIgnoreCase("E")) {
        check = 0;
      }
    }

    // No North
    else if (y == 1) {
      if (direction.equalsIgnoreCase("N")) {
        check = 0;
      }
    }

    // No South
    else if (y == 6) {
      if (direction.equalsIgnoreCase("S")) {
        check = 0;
      }
    }

    // No East
    else if (x == 6) {
      if (direction.equalsIgnoreCase("E")) {
        check = 0;
      }
    }

    // No West
    else if (x == 1) {
      if (direction.equalsIgnoreCase("W")) {
        check = 0;
      }
    }

    // Good Move
    else {
      check = 1;
    }

    // Return
    return check;
  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub

    // Print Rules
    System.out.println("Welcome to Minesweeper");
    System.out
        .println("You are presented with a 6 by 6 field that is filled with 8 mines and 3 hearts.");
    System.out.println("You will be given 10 chances to check the field for mines.");
    System.out.println(
        "Checking a specific square will reveal the number of mines around but not including the coorinate(No Diagonals).");
    System.out.println("You are in the square with coordinates (0,0) with 3 lives.");
    System.out.println("You die as soon as you reach 0 lives.");
    System.out.println("Your goal is to reach the last row.");
    System.out.println(
        "Steping on an unrevealed square will once again reveal the number of mines around the square.");
    System.out.println("Steping on a mine will cause you to lose one life.");
    System.out.println("Steping on a heart will grant you an extra life.");
    System.out.println("If you step on a mine and have no lives remaining, you lose.");
    System.out.println("Good Luck!");

    // Space
    System.out.println();
    System.out.println();

    // Declare Hidden Array
    int[][] hiddenField = new int[8][8];

    // Declare Player Array
    int[][] playerField = new int[8][8];

    // Number of Tries to Check Field for Mines
    int count = 1;

    // Randomly Generated Mine Coordinate is Different
    int different = 0;

    // Used for Boolean Decision Making When Generating Mine and Heart Locations
    int x = 1;

    // Coordinates of Square to Reveal
    int xR = 0;
    int yR = 0;

    // Number of Mines Around Square
    int num = 0;

    // Number of Lives
    int health = 3;

    // Check Field out of Bounds
    int wrongCheck = 0;

    // String Direction Does not Match Parameters
    int wrongDirection = 0;

    // Coordinates of Player Position on Grid
    int xP = 1;
    int yP = 1;

    // Check if Direction is Possible
    int checkP = 0;

    // Row Number
    int c = 1;

    // Direction of Movement for Trip
    String direction;

    // Scanner
    Scanner Input = new Scanner(System.in);

    // Arrays For Random Mines and Hearts
    int[] mineX = new int[11];
    int[] mineY = new int[11];

    // Fill Arrays With Zeros
    for (int i = 1; i < 7; i++) {
      for (int j = 1; j < 7; j++) {
        hiddenField[i][j] = 0;
        playerField[i][j] = 0;
      }
    }

    // Generate Coordinates
    for (int i = 0; i < 11; i++) {
      mineX[i] = (int) (Math.random() * 6 + 1);
      mineY[i] = (int) (Math.random() * 6 + 1);

      // Check to see if Different and Make Sure Mine is not on 0,0
      while (different == 0) {
        x = 1;

        // Check to see if Different
        for (int j = 0; j < 11; j++) {
          if (mineX[i] == mineX[j] && mineY[i] == mineY[j] && i != j) {

            // Coordinate is not Unique
            x = 0;
          }
        }

        // Check For Mine at 0,0
        if (i >= 0 && i < 8) {
          if (mineX[i] == 0 && mineY[i] == 0) {

            // Mine at 0,0
            x = 0;
          }
        }

        // Generate New Coordinate
        if (x == 0) {
          mineX[i] = (int) (Math.random() * 6 + 1);
          mineY[i] = (int) (Math.random() * 6 + 1);

          // Coordinate Fits Parameters
        } else {
          different = 1;
        }
      }

      // Next Coordinate
      different = 0;
    }

    // Add Mines to Field Array
    for (int j = 0; j < 8; j++) {
      hiddenField[mineX[j]][mineY[j]] = 6;
    }

    // Add Hearts to Field Array
    for (int j = 8; j < 11; j++) {
      hiddenField[mineX[j]][mineY[j]] = 7;
    }

    // Print Array
    PrintArray(playerField);

    // Space
    System.out.println();
    System.out.println();

    // 10 Tries to Check Field
    while (count <= 10) {

      // Input Coordinate to Check Field
      System.out.println("Enter an x coordinate 1-6 for the square you would like to reveal.");
      xR = Input.nextInt();
      System.out.println("Enter a y coordinate 1-6 for the square you would like to reveal.");
      yR = Input.nextInt();

      // Check to See if Coordinates Fit Grid
      while (wrongCheck == 0) {
        if (xR >= 1 && xR <= 6 && yR >= 1 && yR <= 6) {

          // Input is Correct
          wrongCheck = 1;

        } else {
          // Wrong Input
          System.out
              .println("The numbers inputted does not fit the parmameters, please try again.");
          System.out.println();

          // Input Coordinate to Check Field
          System.out.println("Enter an x coordinate 1-6 for the square you would like to reveal.");
          xR = Input.nextInt();
          System.out.println("Enter a y coordinate 1-6 for the square you would like to reveal.");
          yR = Input.nextInt();
        }
      }

      // Reset Coordinate Check Variable
      wrongCheck = 0;

      // Reveal Square
      num = RevealSquare(xR, yR, playerField, hiddenField);

      // Square Already Revealed
      if (num == 10) {
        System.out.println();
        System.out.println("This square has already been revealed, please try again");
      }

      // Reveal Square
      else {
        playerField[yR][xR] = num;

        // Next Check
        count++;
      }

      // Space
      System.out.println();
      System.out.println();

      // Print Player Array
      PrintArray(playerField);

      // Space
      System.out.println();
      System.out.println();
    }

    // Introduce Trip
    System.out.println(
        "You may now start moving your player through the mine field to attempt to get to the last row.");
    System.out.println("Remember your player is represented by a 6 on the grid.");
    System.out.println();

    // Print Column Number
    System.out.println("  1 2 3 4 5 6");

    // Print Player Field Array
    for (int i = 1; i < 7; i++) {

      // Row Number
      System.out.print(c + " ");

      for (int j = 1; j < 7; j++) {

        // Player Position
        if (i == 1 && j == 1) {
          System.out.print("6 ");
        } else {
          System.out.print(playerField[i][j] + " ");
        }
      }

      // Next Line
      System.out.println("");
      c++;
    }

    // Print Number of Lives
    System.out.println("You have " + health + " lives. You die as soon as you reach 0 lives.");
    System.out.println(
        "Remeber you lose a life if you step on a mine, and gain a life if you find a heart.");
    System.out.println();

    // Heart at Starting Position
    if (hiddenField[1][1] == 7 || hiddenField[1][1] == 8) {
      System.out.println(
          "Wow this is your lucky day, you have found an extra life at the starting position.");
      System.out.println("You now have " + health + " lives.");

      // Add 1 Life
      health++;

      // Remove Heart
      hiddenField[1][1] = 0;
    }

    // Trip
    while (health > 0) {

      // Input Direction
      System.out.println("Enter N to move up 1 space.");
      System.out.println("Enter S to move down 1 space.");
      System.out.println("Enter E to move right 1 space.");
      System.out.println("Enter W to move left 1 space.");
      System.out.println("Remember that you must stay on the 6 by 6 grid and cannot travel off!!");
      direction = Input.next();

      // Space
      System.out.println();

      // Check to See if Direction Fits Parameters
      while (wrongDirection == 0) {

        // Check to See if Move Can Be Made
        checkP = checkPlayerPosition(direction, xP, yP);

        // Correct Letter Input
        if (direction.equalsIgnoreCase("N") || direction.equalsIgnoreCase("S")
            || direction.equalsIgnoreCase("W") || direction.equalsIgnoreCase("E")) {

          // Direction is Possible
          if (checkP == 1) {

            // Input is Correct
            wrongDirection = 1;
          }

          // Direction is not Possible
          else if (checkP == 0) {

            // Wrong Input
            System.out.println("The direction is not possible, please try again.");

            // Input Direction
            System.out.println("Enter N to move up 1 space.");
            System.out.println("Enter S to move down 1 space.");
            System.out.println("Enter E to move right 1 space.");
            System.out.println("Enter W to move left 1 space.");
            System.out
                .println("Remember that you must stay on the 6 by 6 grid and cannot travel off!!");
            direction = Input.next();

            System.out.println();
          }
        } else {
          // Wrong Input
          System.out.println("The letter inputted does not fit the parmameters, please try again.");

          // Input Direction
          System.out.println("Enter N to move up 1 space.");
          System.out.println("Enter S to move down 1 space.");
          System.out.println("Enter E to move right 1 space.");
          System.out.println("Enter W to move left 1 space.");
          System.out
              .println("Remember that you must stay on the 6 by 6 grid and cannot travel off!!");
          direction = Input.next();

          System.out.println();
        }

      }

      // Reset Direction Check Variable
      wrongDirection = 0;

      // Move Up
      if (direction.equalsIgnoreCase("N")) {
        yP--;
      }

      // Move Down
      if (direction.equalsIgnoreCase("S")) {
        yP++;
      }

      // Move Left
      if (direction.equalsIgnoreCase("W")) {
        xP--;
      }

      // Move Right
      if (direction.equalsIgnoreCase("E")) {
        xP++;
      }

      // Space
      System.out.println();

      // Print Column Number
      System.out.println("  1 2 3 4 5 6");

      // Initialize Row Number
      c = 1;

      // Print Player Field Array
      for (int i = 1; i < 7; i++) {

        // Row Number
        System.out.print(c + " ");

        for (int j = 1; j < 7; j++) {
          // Player Position
          if (i == yP && j == xP) {
            System.out.print("6 ");
          } else {
            System.out.print(playerField[i][j] + " ");
          }
        }

        // Next Line
        System.out.println("");
        c++;
      }

      // Space
      System.out.println();

      // Stepped on Mine
      if (hiddenField[yP][xP] == 6 || hiddenField[yP][xP] == 9) {
        System.out.println("Oh no, you have stepped on a mine and lost a life.");

        // Subtract 1 Life
        health--;

        // Remove Mine
        hiddenField[yP][xP] = 0;
      }

      // Stepped on Heart
      if (hiddenField[yP][xP] == 7 || hiddenField[yP][xP] == 8) {
        System.out.println("Congradulations, you have found a heart and gained a life.");

        // Add 1 Life
        health++;

        // Remove Heart
        hiddenField[yP][xP] = 0;
      }

      // Reached Last Row
      if (yP == 6 && health > 0) {
        System.out.println("Congradulations you have reached the last row and have won the game.");

        // End Loop
        health = -100;
      }

      // Lost All Lives
      else if (health == 0) {
        System.out.println("You have lost all your lifes. Game over :(");

        // End Loop
        health = -100;
      }

      // Continue Game
      else {

        // Output Number of Lives
        System.out.println("You have " + health + " lives.");
        System.out.println();
      }
    }

    // End Message
    System.out.println("Thank you for playing minesweeper!");

    // Close Input
    Input.close();
  }
}
