package Project;

import java.awt.BorderLayout;
import javax.swing.*;

public class Scoreboard extends JPanel{
	/**
	 * Creates the scoring elements for the TicTacToe game.
	 * Includes the number of wins for the X and O players.
	 * Displays 'New game' button
	 */
	private int playerOWins;
	private int playerXWins;
	private int tieCount;
	private JLabel playerO;
	private JLabel playerX;
	private JLabel tie;
	private JLabel currentPlayer;
	private JLabel result;
	
	public Scoreboard(){
		//initialize count and create labels
		playerOWins = 0;
		playerXWins = 0;
		tieCount = 0;
		playerO = new JLabel("Player O: " + playerOWins);
		playerX = new JLabel("Player X: " + playerXWins);
		tie = new JLabel("Ties: " + tieCount);
		currentPlayer = new JLabel();
		result = new JLabel();
		
		//set panel layout
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		
		//add labels
		add(playerO, BorderLayout.WEST);
		add(playerX, BorderLayout.WEST);
		add(tie, BorderLayout.WEST);
		tie.setBorder(BorderFactory.createEmptyBorder(0, 0, 200, 0));
		add(currentPlayer);
		currentPlayer.setBorder(BorderFactory.createEmptyBorder(0, 0, 100, 0));
		add(result);

	}
	
	// Increment number of wins to player
	public void addWin(int player){
		if(player == 1){
			playerOWins++;
			playerO.setText("Player O: " + playerOWins);
		}
		else{
			playerXWins++;
			playerX.setText("Player X: " + playerXWins);
		}
	}
	
	// Increment Tie running total
	public void addTie(){
		tieCount++;
		tie.setText("Ties: " + tieCount);
	}
	
	// Change Player's turn
	public void updateTurn(int player){
		if(player == 0)
			currentPlayer.setText("Player X's turn!");
		else
			currentPlayer.setText("Player O's turn!");
	}
	
	// Display winner of game or if tie
	public void updateResult(int player){
		if(player == 0)
			result.setText("Player X has won!");
		else if(player == 1)
			result.setText("Player O has won!");
		else
			result.setText("Draw!");
		
		currentPlayer.setText(null);
	}

}
