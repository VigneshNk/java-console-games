package Games;

import java.util.Scanner;

public class Checkers {

	/**
	 * Check if move is valid
	 */
	static int check = 0;

	/**
	 * Print checkerboard array.
	 */
	public static void PrintArray(String[][] board) {
		// Row Number
		int c = 1;

		// Column Number
		System.out.println("  1 2 3 4 5 6 7 8");

		for (int y = 1; y < 9; y++) {

			// Row Number
			System.out.print(c + " ");

			for (int x = 1; x < 9; x++) {
				System.out.print(board[x][y] + " ");
			}

			// Next Line
			System.out.println("");
			c++;
		}
	}

	/**
	 * Print game rules.
	 */
	public static void PrintRules() {
		System.out.println("1. You and your opponent will each start with 12 checkers pieces on your respective side.");
		System.out.println("2. Player 1 will be r, Player 2 will be b.");
		System.out.println(
				"3. You will each take turns moving your pieces 1 space diagonally forward to free spaces on the board.");
		System.out.println("4. If you diagonally jump over an opponent's piece and land in a straight line, you capture"
				+ "your opponent's piece removing it from the game.");
		System.out.println("5. If one of your pieces reaches the opposite side of the board, your piece will become a "
				+ "king, and have the ability to move diagonally forward and backward.");
		System.out.println(
				"6. A king piece will will be represented by a Capatilized letter, R for Player 1, and B for Player 2");
		System.out.println(
				"7. When a player has no pieces left or they are unable to make a move, the opposing player wins.");
	}

	/**
	 * Checks array to see if chosen piece is movable.
	 */
	public static int CheckPiece(String[][] board, int x, int y, int move) {
		// Player 1
		if (move == 1) {

			// Regular Piece
			if (board[x][y].equals("r")) {

				// Move Piece 1 Space Forward
				if (board[x - 1][y - 1].equals(".") || board[x + 1][y - 1].equals(".")) {
					System.out.println("Piece can be moved.");
					check = 1;
				}

				// Jump Over Black Piece to the Left
				if (board[x - 1][y - 1].equals("b") || board[x - 1][y - 1].equals("B")) {
					if (board[x - 2][y - 2].equals(".")) {
						System.out.println("Piece can be moved.");
						check = 1;
					}
				}

				// Jump over Black Piece to the Right
				if (board[x + 1][y - 1].equals("b") || board[x + 1][y - 1].equals("B")) {
					if (board[x + 2][y - 2].equals(".")) {
						System.out.println("Piece can be moved.");
						check = 1;
					}
				}

				// Piece Cannot Be Moved
				if (check == 0) {
					System.out.println("Piece cannot be moved.");
					System.out.println("Please try again.");
				}
			}

			// King Piece
			else if (board[x][y].equals("R")) {

				// Move Piece 1 Space in Any Direction
				if (board[x - 1][y - 1].equals(".") || board[x + 1][y - 1].equals(".")
						|| board[x - 1][y + 1].equals(".") || board[x + 1][y + 1].equals(".")) {
					System.out.println("Piece can be moved.");
					check = 1;
				}

				// Jump Over Black Piece to the Top Left
				if (board[x - 1][y - 1].equals("b") || board[x - 1][y - 1].equals("B")) {
					if (board[x - 2][y - 2].equals(".")) {
						System.out.println("Piece can be moved.");
						check = 1;
					}
				}

				// Jump over Black Piece to the Top Right
				if (board[x + 1][y - 1].equals("b") || board[x + 1][y - 1].equals("B")) {
					if (board[x + 2][y - 2].equals(".")) {
						System.out.println("Piece can be moved.");
						check = 1;
					}
				}

				// Jump Over Black Piece to the Bottom Left
				if (board[x - 1][y + 1].equals("b") || board[x - 1][y + 1].equals("B")) {
					if (board[x - 2][y + 2].equals(".")) {
						System.out.println("Piece can be moved.");
						check = 1;
					}
				}

				// Jump over Black Piece to the Bottom Right
				if (board[x + 1][y + 1].equals("b") || board[x + 1][y + 1].equals("B")) {
					if (board[x + 2][y - +2].equals(".")) {
						System.out.println("Piece can be moved.");
						check = 1;
					}
				}

				// Piece Cannot Be Moved
				if (check == 0) {
					System.out.println("Piece cannot be moved.");
					System.out.println("Please try again.");
				}
			}

			// No Piece
			else {
				System.out.println("There is no red piece at the coordinates entered.");
				System.out.println("Please try again.");
				check = 0;
			}
		}

		// Player 2
		if (move == 2) {

			// Regular Piece
			if (board[x][y].equals("b")) {

				// Move Piece 1 Space Forward
				if (board[x - 1][y + 1].equals(".") || board[x + 1][y + 1].equals(".")) {
					System.out.println("Piece can be moved.");
					check = 1;
				}

				// Jump Over Red Piece to the Left
				if (board[x - 1][y + 1].equals("r") || board[x - 1][y + 1].equals("R")) {
					if (board[x - 2][y + 2].equals(".")) {
						System.out.println("Piece can be moved.");
						check = 1;
					}
				}

				// Jump over Red Piece to the Right
				if (board[x + 1][y + 1].equals("r") || board[x + 1][y + 1].equals("R")) {
					if (board[x + 2][y + 2].equals(".")) {
						System.out.println("Piece can be moved.");
						check = 1;
					}
				}

				// Piece Cannot Be Moved
				if (check == 0) {
					System.out.println("Piece cannot be moved.");
					System.out.println("Please try again.");
				}
			}

			// King Piece
			else if (board[x][y].equals("B")) {

				// Move Piece 1 Space in Any Direction
				if (board[x - 1][y - 1].equals(".") || board[x + 1][y - 1].equals(".")
						|| board[x - 1][y + 1].equals(".") || board[x + 1][y + 1].equals(".")) {
					System.out.println("Piece can be moved.");
					check = 1;
				}

				// Jump Over Red Piece to the Top Left
				if (board[x - 1][y - 1].equals("r") || board[x - 1][y - 1].equals("R")) {
					if (board[x - 2][y - 2].equals(".")) {
						System.out.println("Piece can be moved.");
						check = 1;
					}
				}

				// Jump over Red Piece to the Top Right
				if (board[x + 1][y - 1].equals("r") || board[x + 1][y - 1].equals("R")) {
					if (board[x + 2][y - 2].equals(".")) {
						System.out.println("Piece can be moved.");
						check = 1;
					}
				}

				// Jump Over Red Piece to the Bottom Left
				if (board[x - 1][y + 1].equals("r") || board[x - 1][y + 1].equals("R")) {
					if (board[x - 2][y + 2].equals(".")) {
						System.out.println("Piece can be moved.");
						check = 1;
					}
				}

				// Jump over Red Piece to the Bottom Right
				if (board[x + 1][y + 1].equals("r") || board[x + 1][y + 1].equals("R")) {
					if (board[x + 2][y - +2].equals(".")) {
						System.out.println("Piece can be moved.");
						check = 1;
					}
				}

				// Piece Cannot Be Moved
				if (check == 0) {
					System.out.println("Piece cannot be moved.");
					System.out.println("Please try again.");
				}
			}

			// No Piece
			else {
				System.out.println("There is no black piece at the coordinates entered.");
				System.out.println("Please try again.");
				check = 0;
			}
		}

		// Space
		System.out.println("");

		// Return
		return check;
	}

	/*
	 * Changes board array based on player move for regular piece.
	 */
	public static void RegularPiece(String[][] board, int x, int y, int move) {
		// Coordinate of Space Player Moves To
		int x2 = 0;
		int y2 = 0;

		// Loops Method Until Correct Coordinates Entered
		int loop = 0;

		// Swaps 2 Elements in Array
		String swap;

		// Scanner
		Scanner Input = new Scanner(System.in);

		// Player 1
		if (move == 1) {

			// Loop Until Coordinates Entered Are Correct
			while (loop == 0) {

				// Enter X Coordinate of Piece
				System.out.println("Enter the x coordinate of the space you would like to move to.");
				x2 = Input.nextInt();

				// Number Not Valid
				while (x2 > 8 || x2 < 1) {
					System.out.println("The number you entered is not valid.");
					System.out.println("Enter a coordinate between 1 and 8.");

					// Enter X Coordinate of Piece
					System.out.println("Enter the x coordinate of the space you would like to move to.");
					x2 = Input.nextInt();
				}

				// Enter Y Coordinate of Piece
				System.out.println("Enter the y coordinate of the space you would like to move to.");
				y2 = Input.nextInt();

				// Number Not Valid
				while (y2 > 8 || y2 < 1) {
					System.out.println("The number you entered is not valid.");
					System.out.println("Enter a coordinate between 1 and 8.");

					// Enter X Coordinate of Piece
					System.out.println("Enter the y coordinate of the space you would like to move to.");
					y2 = Input.nextInt();
				}

				// Move One Space Forward Left
				if (x2 == x - 1 && y2 == y - 1) {
					if (board[x2][y2].equals(".")) {

						// Move Piece to New Square
						swap = board[x][y];
						board[x][y] = board[x2][y2];
						board[x2][y2] = swap;

						// Stop Loop
						loop = 1;
					}
				}

				// Move One Space Forward Right
				if (x2 == x + 1 && y2 == y - 1) {
					if (board[x2][y2].equals(".")) {

						// Move Piece to New Square
						swap = board[x][y];
						board[x][y] = board[x2][y2];
						board[x2][y2] = swap;

						// Stop Loop
						loop = 1;
					}
				}

				// Jump Over Black Piece to the Left
				if (x2 == x - 2 && y2 == y - 2) {
					if (board[x - 1][y - 1].equals("b") || board[x - 1][y - 1].equals("B")) {
						if (board[x2][y2].equals(".")) {

							// Move Piece to New Square
							swap = board[x][y];
							board[x][y] = board[x2][y2];
							board[x2][y2] = swap;

							// Capture Piece
							board[x2 + 1][y2 + 1] = ".";

							// Stop Loop
							loop = 1;
						}
					}
				}

				// Jump Over Black Piece to the Right
				if (x2 == x + 2 && y2 == y - 2) {
					if (board[x + 1][y - 1].equals("b") || board[x + 1][y - 1].equals("B")) {
						if (board[x2][y2].equals(".")) {

							// Move Piece to New Square
							swap = board[x][y];
							board[x][y] = board[x2][y2];
							board[x2][y2] = swap;

							// Capture Piece
							board[x2 - 1][y2 + 1] = ".";

							// Stop Loop
							loop = 1;
						}
					}
				}

				// Piece Cannot Be Moved
				if (loop == 0) {
					System.out.println("Piece cannot be moved.");
					System.out.println("Please try again.");
				}
			}
		}

		// Player 2
		if (move == 2) {

			// Loop Until Coordinates Entered Are Correct
			while (loop == 0) {

				// Enter X Coordinate of Piece
				System.out.println("Enter the x coordinate of the space you would like to move.");
				x2 = Input.nextInt();

				// Number Not Valid
				while (x2 > 8 || x2 < 1) {
					System.out.println("The number you entered is not valid.");
					System.out.println("Enter a coordinate between 1 and 8.");

					// Enter X Coordinate of Piece
					System.out.println("Enter the x coordinate of the space you would like to move.");
					x2 = Input.nextInt();
				}

				// Enter Y Coordinate of Piece
				System.out.println("Enter the y coordinate of the space you would like to move.");
				y2 = Input.nextInt();

				// Number Not Valid
				while (y2 > 8 || y2 < 1) {
					System.out.println("The number you entered is not valid.");
					System.out.println("Enter a coordinate between 1 and 8.");

					// Enter X Coordinate of Piece
					System.out.println("Enter the y coordinate of the space you would like to move.");
					y2 = Input.nextInt();
				}

				// Move One Space Forward Left
				if (x2 == x - 1 && y2 == y + 1) {
					if (board[x2][y2].equals(".")) {

						// Move Piece to New Square
						swap = board[x][y];
						board[x][y] = board[x2][y2];
						board[x2][y2] = swap;

						// Stop Loop
						loop = 1;
					}
				}

				// Move One Space Forward Right
				if (x2 == x + 1 && y2 == y + 1) {
					if (board[x2][y2].equals(".")) {

						// Move Piece to New Square
						swap = board[x][y];
						board[x][y] = board[x2][y2];
						board[x2][y2] = swap;

						// Stop Loop
						loop = 1;
					}
				}

				// Jump Over Red Piece to the Left
				if (x2 == x - 2 && y2 == y + 2) {
					if (board[x - 1][y + 1].equals("r") || board[x - 1][y + 1].equals("R")) {
						if (board[x2][y2].equals(".")) {

							// Move Piece to New Square
							swap = board[x][y];
							board[x][y] = board[x2][y2];
							board[x2][y2] = swap;

							// Capture Piece
							board[x2 + 1][y2 - 1] = ".";

							// Stop Loop
							loop = 1;
						}
					}
				}

				// Jump Over Black Piece to the Right
				if (x2 == x + 2 && y2 == y + 2) {
					if (board[x + 1][y + 1].equals("r") || board[x + 1][y + 1].equals("R")) {
						if (board[x2][y2].equals(".")) {

							// Move Piece to New Square
							swap = board[x][y];
							board[x][y] = board[x2][y2];
							board[x2][y2] = swap;

							// Capture Piece
							board[x2 - 1][y2 - 1] = ".";

							// Stop Loop
							loop = 1;
						}
					}
				}

				// Piece Cannot Be Moved
				if (loop == 0) {
					System.out.println("Piece cannot be moved.");
					System.out.println("Please try again.");
				}
			}
		}

		// Space
		System.out.println("");
	}

	/*
	 * Changes board array based on player move for king piece.
	 */
	public static void KingPiece(String[][] board, int x, int y, int move) {
		// Coordinate of Space Player Moves To
		int x2 = 0;
		int y2 = 0;

		// Loops Method Until Correct Coordinates Entered
		int loop = 0;

		// Swaps 2 Elements in Array
		String swap;

		// Scanner
		Scanner Input = new Scanner(System.in);

		// Player 1
		if (move == 1) {

			// Loop Until Coordinates Entered Are Correct
			while (loop == 0) {

				// Enter X Coordinate of Piece
				System.out.println("Enter the x coordinate of the space you would like to move to.");
				x2 = Input.nextInt();

				// Number Not Valid
				while (x2 > 8 || x2 < 1) {
					System.out.println("The number you entered is not valid.");
					System.out.println("Enter a coordinate between 1 and 8.");

					// Enter X Coordinate of Piece
					System.out.println("Enter the x coordinate of the space you would like to move to.");
					x2 = Input.nextInt();
				}

				// Enter Y Coordinate of Piece
				System.out.println("Enter the y coordinate of the space you would like to move to.");
				y2 = Input.nextInt();

				// Number Not Valid
				while (y2 > 8 || y2 < 1) {
					System.out.println("The number you entered is not valid.");
					System.out.println("Enter a coordinate between 1 and 8.");

					// Enter X Coordinate of Piece
					System.out.println("Enter the y coordinate of the space you would like to move to.");
					y2 = Input.nextInt();
				}

				// Move One Space Forward Top Left
				if (x2 == x - 1 && y2 == y - 1) {
					if (board[x2][y2].equals(".")) {

						// Move Piece to New Square
						swap = board[x][y];
						board[x][y] = board[x2][y2];
						board[x2][y2] = swap;

						// Stop Loop
						loop = 1;
					}
				}

				// Move One Space Forward Top Right
				if (x2 == x + 1 && y2 == y - 1) {
					if (board[x2][y2].equals(".")) {

						// Move Piece to New Square
						swap = board[x][y];
						board[x][y] = board[x2][y2];
						board[x2][y2] = swap;

						// Stop Loop
						loop = 1;
					}
				}

				// Move One Space Forward Bottom Left
				if (x2 == x - 1 && y2 == y + 1) {
					if (board[x2][y2].equals(".")) {

						// Move Piece to New Square
						swap = board[x][y];
						board[x][y] = board[x2][y2];
						board[x2][y2] = swap;

						// Stop Loop
						loop = 1;
					}
				}

				// Move One Space Forward Bottom Right
				if (x2 == x + 1 && y2 == y + 1) {
					if (board[x2][y2].equals(".")) {

						// Move Piece to New Square
						swap = board[x][y];
						board[x][y] = board[x2][y2];
						board[x2][y2] = swap;

						// Stop Loop
						loop = 1;
					}
				}

				// Jump Over Black Piece to the Top Left
				if (x2 == x - 2 && y2 == y - 2) {
					if (board[x - 1][y - 1].equals("b") || board[x - 1][y - 1].equals("B")) {
						if (board[x2][y2].equals(".")) {

							// Move Piece to New Square
							swap = board[x][y];
							board[x][y] = board[x2][y2];
							board[x2][y2] = swap;

							// Capture Piece
							board[x2 + 1][y2 + 1] = ".";

							// Stop Loop
							loop = 1;
						}
					}
				}

				// Jump Over Black Piece to the Top Right
				if (x2 == x + 2 && y2 == y - 2) {
					if (board[x + 1][y - 1].equals("b") || board[x + 1][y - 1].equals("B")) {
						if (board[x2][y2].equals(".")) {

							// Move Piece to New Square
							swap = board[x][y];
							board[x][y] = board[x2][y2];
							board[x2][y2] = swap;

							// Capture Piece
							board[x2 - 1][y2 + 1] = ".";

							// Stop Loop
							loop = 1;
						}
					}
				}

				// Jump Over Black Piece to the Bottom Left
				if (x2 == x - 2 && y2 == y + 2) {
					if (board[x - 1][y + 1].equals("b") || board[x - 1][y + 1].equals("B")) {
						if (board[x2][y2].equals(".")) {

							// Move Piece to New Square
							swap = board[x][y];
							board[x][y] = board[x2][y2];
							board[x2][y2] = swap;

							// Capture Piece
							board[x2 + 1][y2 - 1] = ".";

							// Stop Loop
							loop = 1;
						}
					}
				}

				// Jump Over Black Piece to the Bottom Right
				if (x2 == x + 2 && y2 == y + 2) {
					if (board[x + 1][y + 1].equals("b") || board[x + 1][y + 1].equals("B")) {
						if (board[x2][y2].equals(".")) {

							// Move Piece to New Square
							swap = board[x][y];
							board[x][y] = board[x2][y2];
							board[x2][y2] = swap;

							// Capture Piece
							board[x2 - 1][y2 - 1] = ".";

							// Stop Loop
							loop = 1;
						}
					}
				}

				// Piece Cannot Be Moved
				if (loop == 0) {
					System.out.println("Piece cannot be moved.");
					System.out.println("Please try again.");
				}
			}
		}

		// Player 2
		if (move == 2) {

			// Loop Until Coordinates Entered Are Correct
			while (loop == 0) {

				// Enter X Coordinate of Piece
				System.out.println("Enter the x coordinate of the space you would like to move to.");
				x2 = Input.nextInt();

				// Number Not Valid
				while (x2 > 8 || x2 < 1) {
					System.out.println("The number you entered is not valid.");
					System.out.println("Enter a coordinate between 1 and 8.");

					// Enter X Coordinate of Piece
					System.out.println("Enter the x coordinate of the space you would like to move to.");
					x2 = Input.nextInt();
				}

				// Enter Y Coordinate of Piece
				System.out.println("Enter the y coordinate of the space you would like to move to.");
				y2 = Input.nextInt();

				// Number Not Valid
				while (y2 > 8 || y2 < 1) {
					System.out.println("The number you entered is not valid.");
					System.out.println("Enter a coordinate between 1 and 8.");

					// Enter X Coordinate of Piece
					System.out.println("Enter the y coordinate of the space you would like to move to.");
					y2 = Input.nextInt();
				}

				// Move One Space Bottom Left
				if (x2 == x - 1 && y2 == y + 1) {
					if (board[x2][y2].equals(".")) {

						// Move Piece to New Square
						swap = board[x][y];
						board[x][y] = board[x2][y2];
						board[x2][y2] = swap;

						// Stop Loop
						loop = 1;
					}
				}

				// Move One Space Bottom Right
				if (x2 == x + 1 && y2 == y + 1) {
					if (board[x2][y2].equals(".")) {

						// Move Piece to New Square
						swap = board[x][y];
						board[x][y] = board[x2][y2];
						board[x2][y2] = swap;

						// Stop Loop
						loop = 1;
					}
				}

				// Move One Space Top Left
				if (x2 == x - 1 && y2 == y + 1) {
					if (board[x2][y2].equals(".")) {

						// Move Piece to New Square
						swap = board[x][y];
						board[x][y] = board[x2][y2];
						board[x2][y2] = swap;

						// Stop Loop
						loop = 1;
					}
				}

				// Move One Space Top Right
				if (x2 == x + 1 && y2 == y + 1) {
					if (board[x2][y2].equals(".")) {

						// Move Piece to New Square
						swap = board[x][y];
						board[x][y] = board[x2][y2];
						board[x2][y2] = swap;

						// Stop Loop
						loop = 1;
					}
				}

				// Jump Over Red Piece to the Bottom Left
				if (x2 == x - 2 && y2 == y + 2) {
					if (board[x - 1][y + 1].equals("r") || board[x - 1][y + 1].equals("R")) {
						if (board[x2][y2].equals(".")) {

							// Move Piece to New Square
							swap = board[x][y];
							board[x][y] = board[x2][y2];
							board[x2][y2] = swap;

							// Capture Piece
							board[x2 + 1][y2 - 1] = ".";

							// Stop Loop
							loop = 1;
						}
					}
				}

				// Jump Over Black Piece to the Bottom Right
				if (x2 == x + 2 && y2 == y + 2) {
					if (board[x + 1][y + 1].equals("r") || board[x + 1][y + 1].equals("R")) {
						if (board[x2][y2].equals(".")) {

							// Move Piece to New Square
							swap = board[x][y];
							board[x][y] = board[x2][y2];
							board[x2][y2] = swap;

							// Capture Piece
							board[x2 - 1][y2 - 1] = ".";

							// Stop Loop
							loop = 1;
						}
					}
				}

				// Jump Over Red Piece to the Top Left
				if (x2 == x - 2 && y2 == y - 2) {
					if (board[x - 1][y - 1].equals("r") || board[x - 1][y - 1].equals("R")) {
						if (board[x2][y2].equals(".")) {

							// Move Piece to New Square
							swap = board[x][y];
							board[x][y] = board[x2][y2];
							board[x2][y2] = swap;

							// Capture Piece
							board[x2 + 1][y2 + 1] = ".";

							// Stop Loop
							loop = 1;
						}
					}
				}

				// Jump Over Black Piece to the Top Right
				if (x2 == x + 2 && y2 == y - 2) {
					if (board[x + 1][y - 1].equals("r") || board[x + 1][y - 1].equals("R")) {
						if (board[x2][y2].equals(".")) {

							// Move Piece to New Square
							swap = board[x][y];
							board[x][y] = board[x2][y2];
							board[x2][y2] = swap;

							// Capture Piece
							board[x2 - 1][y2 + 1] = ".";

							// Stop Loop
							loop = 1;
						}
					}
				}

			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Random Number to Decide Which Player Goes First
		int ran = 0;

		// Stores Player Turn
		int n1 = 0;
		int n2 = 0;

		// Number of Black Pieces Left on Board
		int blackNum;
		int redNum;

		// Coordinates of Piece Player Movees
		int x1 = 0;
		int y1 = 0;

		int methods = 0; // Controls Which Player the Method Runs For

		// Player Names
		String name1;
		String name2;

		// Array Declaration
		String[][] board = new String[10][10];

		// Scanner
		Scanner Input = new Scanner(System.in);

		// Welcome Statement
		System.out.println("Hello, welcome to Checkers!!");

		// Space
		System.out.println("");

		// Output Rules
		PrintRules();

		// Space
		System.out.println("");

		// Enter Names
		System.out.println("Enter name for player 1:");
		name1 = Input.next();
		System.out.println("Enter name for player 2:");
		name2 = Input.next();

		// Space
		System.out.println("");

		// Randomly Select Player To Move First
		ran = (int) (Math.random() * 10 + 1);

		// Player 1 Move First
		if (ran <= 5) {
			n1 = 1;
			n2 = 0;
			System.out.println(name1 + " has been randomly chosen to move first.");
			System.out.println("");
		}

		// Player 2 Move First
		if (ran > 5) {
			n2 = 1;
			n1 = 0;
			System.out.println(name2 + " has been randomly chosed to move first.");
			System.out.println("");
		}

		// Column Number
		for (int y = 0; y < 10; y++) {

			// Row Number
			for (int x = 0; x < 10; x++) {

				// Blank Squares
				board[x][y] = ".";

				// Black Pieces
				if (y == 1 || y == 2 || y == 3) {

					// Column
					if (y == 1) {

						// Row
						if (x == 2 || x == 4 || x == 6 || x == 8) {
							board[x][y] = "b";
						}
					}

					// Column
					if (y == 2) {

						// Row
						if (x == 1 || x == 3 || x == 5 || x == 7) {
							board[x][y] = "b";
						}
					}

					// Column
					if (y == 3) {

						// Row
						if (x == 2 || x == 4 || x == 6 || x == 8) {
							board[x][y] = "b";
						}
					}
				}

				// Red Pieces
				if (y == 6 || y == 7 || y == 8) {

					// Column
					if (y == 6) {

						// Row
						if (x == 1 || x == 3 || x == 5 || x == 7) {
							board[x][y] = "r";
						}
					}

					// Column
					if (y == 7) {

						// Row
						if (x == 2 || x == 4 || x == 6 || x == 8) {
							board[x][y] = "r";
						}
					}

					// Column
					if (y == 8) {

						// Row
						if (x == 1 || x == 3 || x == 5 || x == 7) {
							board[x][y] = "r";
						}
					}
				}

				// Edge Space Fillers
				if (y == 0 || y == 9 || x == 0 || x == 9) {
					board[x][y] = "X";
				}
			}
		}

		// Number of Black Pieces
		blackNum = 12;

		// Number of Red Pieces
		redNum = 12;

		// Print Board
		PrintArray(board);

		// Space
		System.out.println("");

		// Loop Game Until Player Has No Pieces
		while (blackNum != 0 && redNum != 0) {

			// Set Check Back to 0
			check = 0;

			// Player 1 Turn
			if (n1 == 1) {
				System.out.println("It is now " + name1 + "'s turn to make a move.");

				// Space
				System.out.println("");

				// Change Methods to Player 1
				methods = 1;

				// Piece Cannot Be Moved
				while (check == 0) {

					// Enter X Coordinate of Piece
					System.out.println("Enter the x coordinate of the piece you would like to move.");
					x1 = Input.nextInt();

					// Number Not Valid
					while (x1 > 8 || x1 < 1) {
						System.out.println("The number you entered is not valid.");
						System.out.println("Enter a coordinate between 1 and 8.");

						// Enter X Coordinate of Piece
						System.out.println("Enter the x coordinate of the piece you would like to move.");
						x1 = Input.nextInt();
					}

					// Enter Y Coordinate of Piece
					System.out.println("Enter the y coordinate of the piece you would like to move.");
					y1 = Input.nextInt();

					// Number Not Valid
					while (y1 > 8 || y1 < 1) {
						System.out.println("The number you entered is not valid.");
						System.out.println("Enter a coordinate between 1 and 8.");

						// Enter X Coordinate of Piece
						System.out.println("Enter the y coordinate of the piece you would like to move.");
						y1 = Input.nextInt();
					}

					// Check If Move Can Be Made
					check = CheckPiece(board, x1, y1, methods);
				}

				// Regular Piece
				if (board[x1][y1].equals("r")) {
					RegularPiece(board, x1, y1, methods);
				}

				// King Piece
				if (board[x1][y1].equals("R")) {
					KingPiece(board, x1, y1, methods);
				}

				// Print Board
				PrintArray(board);

				// Change Regular to King
				for (int x = 1; x < 9; x++) {
					if (board[x][1].equals("r")) {
						board[x][1] = "R";
					}
				}
			}

			// Player 2 Turn
			if (n2 == 1) {
				System.out.println("It is now " + name2 + "'s turn to make a move.");

				// Space
				System.out.println("");

				// Change Methods to Player 2
				methods = 2;

				// Piece Cannot Be Moved
				while (check == 0) {

					// Enter X Coordinate of Piece
					System.out.println("Enter the x coordinate of the piece you would like to move.");
					x1 = Input.nextInt();

					// Number Not Valid
					while (x1 > 8 || x1 < 1) {
						System.out.println("The number you entered is not valid.");
						System.out.println("Enter a coordinate between 1 and 8.");

						// Enter X Coordinate of Piece
						System.out.println("Enter the x coordinate of the piece you would like to move.");
						x1 = Input.nextInt();
					}

					// Enter Y Coordinate of Piece
					System.out.println("Enter the y coordinate of the piece you would like to move.");
					y1 = Input.nextInt();

					// Number Not Valid
					while (y1 > 8 || y1 < 1) {
						System.out.println("The number you entered is not valid.");
						System.out.println("Enter a coordinate between 1 and 8.");

						// Enter X Coordinate of Piece
						System.out.println("Enter the x coordinate of the piece you would like to move.");
						y1 = Input.nextInt();
					}

					// Check If Move Can Be Made
					check = CheckPiece(board, x1, y1, methods);
				}

				// Regular Piece
				if (board[x1][y1].equals("b")) {
					RegularPiece(board, x1, y1, methods);
				}

				// King Piece
				if (board[x1][y1].equals("B")) {
					KingPiece(board, x1, y1, methods);
				}

				// Print Board
				PrintArray(board);

				// Change Regular to King
				for (int x = 1; x < 9; x++) {
					if (board[x][8].equals("b")) {
						board[x][8] = "B";
					}
				}
			}

			// Player 2 Move Next
			if (n1 == 1) {
				n1 = 0;
				n2 = 1;

				// Player 1 Move Next
			} else if (n2 == 1) {
				n1 = 1;
				n2 = 0;
			}

			// Number of Black Pieces
			blackNum = 0;

			for (int y = 0; y < 10; y++) {
				for (int x = 0; x < 10; x++) {

					// Regular Piece
					if (board[x][y].equals("b")) {
						blackNum++;
					}

					// King Piece
					if (board[x][y].equals("B")) {
						blackNum++;
					}
				}
			}

			// Number of Red Pieces
			redNum = 0;

			for (int y = 0; y < 10; y++) {
				for (int x = 0; x < 10; x++) {

					// Regular Piece
					if (board[x][y].equals("r")) {
						redNum++;
					}

					// King Piece
					if (board[x][y].equals("R")) {
						redNum++;
					}
				}
			}

			// Space
			System.out.println("");

			// Total Number of Pieces After Round
			System.out.println("Number of Red Pieces: " + redNum);
			System.out.println("Number of Black Pieces: " + blackNum);

			// Space
			System.out.println("");
		}

		// Space
		System.out.println("");

		// Close Input
		Input.close();

		// End Screen Player 1 Wins
		if (blackNum == 0) {
			System.out.println(name2 + " has no more pieces left.");
			System.out.println("Congradulations " + name1 + ". You have won!");
			System.out.println("Thank you for playing checkers.");
			System.out.println("By: Vignesh.N");
		}

		// End Screen Player 2 Wins
		if (redNum == 0) {
			System.out.println(name1 + " has no more pieces left.");
			System.out.println("Congradulations " + name2 + ". You have won!");
			System.out.println("Thank you for playing checkers.");
			System.out.println("By: Vignesh.N");
		}
	}
}