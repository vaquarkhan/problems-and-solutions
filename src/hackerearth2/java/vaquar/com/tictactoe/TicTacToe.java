package hackerearth2.java.vaquar.com.tictactoe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TicTacToe {

	private char[][]		board	= new char[3][3];
	private String			player1;
	private String			player2;
	private int				currentPlayer;
	private char			marker1;
	private char			marker2;
	private int				plays;
	private BufferedReader	reader	= new BufferedReader(new InputStreamReader(
											System.in));

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

	protected String getRules() {
		StringBuilder builder = new StringBuilder();
		builder.append("Players take turns marking a square. Only squares \n");
		builder.append("not already marked can be picked. Once a player has \n");
		builder.append("marked three squares in a row, the player wins! If all squares \n");
		builder.append("are marked and no three squares are the same, a tie game is declared.\n");
		builder.append("Have Fun! \n\n");
		return builder.toString();
	}

	protected String getPrompt() {
		String prompt = "";
		try {
			prompt = reader.readLine();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return prompt;
	}

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
