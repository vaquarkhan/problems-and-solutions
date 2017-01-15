package hackerearth2.java.vaquar.com.tictactoe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Play {

	public static void main(String[] args) {
		playGame();
	}

	public static void playGame() {

		// nested class
		TicTacToe game = new TicTacToe();

		System.out.println("Welcome! Tic Tac Toe is a two player game.");
		System.out.print("Enter player one's name: ");
		game.setPlayer1(game.getPrompt());
		System.out.print("Enter player two's name: ");
		game.setPlayer2(game.getPrompt());
		boolean markerOk = false;
		while (!markerOk) {
			System.out.print("Select any letter as " + game.getPlayer1()
					+ "'s marker: ");
			String marker = game.getPrompt();
			// assign the alphabetic char reference to player1.
			if (marker.length() == 1
					&& Character.isLetter(marker.toCharArray()[0])) {
				markerOk = true;
				game.setMarker1(marker.toCharArray()[0]);
			} else {
				System.out.println("Invalid marker, try again");
			}
		}
		markerOk = false;
		while (!markerOk) {
			System.out.print("Select any letter as " + game.getPlayer2()
					+ "'s marker: ");
			String marker = game.getPrompt();
			// assign the alphabetic char reference to player2.
			if (marker.length() == 1
					&& Character.isLetter(marker.toCharArray()[0])) {
				markerOk = true;
				game.setMarker2(marker.toCharArray()[0]);
			} else {
				System.out.println("Invalid marker, try again");
			}
		}

		boolean continuePlaying = true;
		while (continuePlaying) {
			game.init();
			System.out.println();
			System.out.println(game.getRules());
			System.out.println();
			System.out.println(game.drawBoard());
			System.out.println();

			String player = null;
			while (!game.winner() && game.getPlays() < 9) {
				player = game.getCurrentPlayer() == 1 ? game.getPlayer1()
						: game.getPlayer2();
				boolean validPick = false;
				while (!validPick) {
					System.out.print("It is " + player
							+ "'s turn. Pick a square: ");
					String square = game.getPrompt();
					if (square.length() == 1
							&& Character.isDigit(square.toCharArray()[0])) {
						int pick = 0;
						try {
							pick = Integer.parseInt(square);
						} catch (NumberFormatException e) {
							// Do nothing here, it'll evaluate as an invalid
							// pick on the next row.
						}
						validPick = game.placeMarker(pick);
					}
					if (!validPick) {
						System.out.println("Square can not be selected. Retry");
					}
				}
				game.switchPlayers();
				System.out.println();
				System.out.println(game.drawBoard());
				System.out.println();
			}
			if (game.winner()) {
				System.out.println("Game Over - " + player + " WINS!!!");
			} else {
				System.out.println("Game Over - Draw");
			}
			System.out.println();
			System.out.print("Play again? (Y/N): ");
			String choice = game.getPrompt();
			if (!choice.equalsIgnoreCase("Y")) {
				continuePlaying = false;
			}
		}
	}

	/**
	 * A nested class for the rules, player turns and winner decision.
	 * 
	 */
	public static class TicTacToe {

		private char[][]		board	= new char[3][3];
		private String			player1;
		private String			player2;
		private int				currentPlayer;
		private char			marker1;
		private char			marker2;
		private int				plays;
		private BufferedReader	reader	= new BufferedReader(
												new InputStreamReader(System.in));

		/**
		 * This method is used to create an array format for the game board.
		 */
		protected void init() {
			int counter = 0;
			for (int i = 0; i < 3; i++) {
				for (int i1 = 0; i1 < 3; i1++) {
					board[i][i1] = Character.forDigit(++counter, 10);
				}
			}
			currentPlayer = 1;
			plays = 0;
		}

		/**
		 * This method is used to switch the players, once a player has been
		 * played it successful move.
		 */
		protected void switchPlayers() {
			if (getCurrentPlayer() == 1) {
				setCurrentPlayer(2);
			} else {
				setCurrentPlayer(1);
			}
			setPlays(getPlays() + 1);
		}

		protected boolean placeMarker(int play) {
			for (int i = 0; i < 3; i++) {
				for (int i1 = 0; i1 < 3; i1++) {
					if (board[i][i1] == Character.forDigit(play, 10)) {
						board[i][i1] = (getCurrentPlayer() == 1) ? getMarker1()
								: getMarker2();
						return true;
					}
				}
			}
			return false;
		}

		/**
		 * This method is used to check the winner status by matching the row,
		 * columns and diagonals.
		 * 
		 * @return boolean
		 */
		protected boolean winner() {
			// Checking rows
			char current = ' ';
			for (int i = 0; i < 3; i++) {
				int i1 = 0;
				for (i1 = 0; i1 < 3; i1++) {
					if (!Character.isLetter(board[i][i1])) {
						break;
					}
					if (i1 == 0) {
						current = board[i][i1];
					} else if (current != board[i][i1]) {
						break;
					}
					if (i1 == 2) {
						// Found winner
						return true;
					}
				}
			}
			// Checking columns
			for (int i = 0; i < 3; i++) {
				current = ' ';
				int i1 = 0;
				for (i1 = 0; i1 < 3; i1++) {
					if (!Character.isLetter(board[i1][i])) {
						break;
					}
					if (i1 == 0) {
						current = board[i1][i];
					} else if (current != board[i1][i]) {
						break;
					}
					if (i1 == 2) {
						// Found winner
						return true;
					}
				}
			}
			// Checking diagonals
			current = board[0][0];
			if (Character.isLetter(current) && board[1][1] == current
					&& board[2][2] == current) {
				return true;
			}
			current = board[2][0];
			if (Character.isLetter(current) && board[1][1] == current
					&& board[0][2] == current) {
				return true;
			}
			return false;
		}

		/**
		 * This method is used to show the rules to both the player once they
		 * have set the marker.
		 * 
		 * @return rules
		 */
		protected String getRules() {
			StringBuilder builder = new StringBuilder();
			builder.append("Players take turns marking a square. Only squares \n");
			builder.append("not already marked can be picked. Once a player has \n");
			builder.append("marked three squares in a row, the player wins! If all squares \n");
			builder.append("are marked and no three squares are the same, a tie game is declared.\n");
			builder.append("Have Fun! \n\n");
			return builder.toString();
		}

		/**
		 * This method is used to read the input from console.
		 * 
		 * @return prompt
		 */
		protected String getPrompt() {
			String prompt = "";
			try {
				prompt = reader.readLine();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
			return prompt;
		}

		/**
		 * This method is used to draw the game board by the multidimensional
		 * array.
		 * 
		 * @return builder
		 */
		protected String drawBoard() {
			StringBuilder builder = new StringBuilder("Game board: \n");
			for (int i = 0; i < 3; i++) {
				for (int i1 = 0; i1 < 3; i1++) {
					builder.append("[" + board[i][i1] + "]");
				}
				builder.append("\n");
			}
			return builder.toString();
		}

		public int getCurrentPlayer() {
			return currentPlayer;
		}

		public void setCurrentPlayer(int currentPlayer) {
			this.currentPlayer = currentPlayer;
		}

		public char getMarker1() {
			return marker1;
		}

		public void setMarker1(char marker1) {
			this.marker1 = marker1;
		}

		public char getMarker2() {
			return marker2;
		}

		public void setMarker2(char marker2) {
			this.marker2 = marker2;
		}

		public int getPlays() {
			return plays;
		}

		public void setPlays(int plays) {
			this.plays = plays;
		}

		public String getPlayer1() {
			return player1;
		}

		public void setPlayer1(String player1) {
			this.player1 = player1;
		}

		public String getPlayer2() {
			return player2;
		}

		public void setPlayer2(String player2) {
			this.player2 = player2;
		}
	}
}
