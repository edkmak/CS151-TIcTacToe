package Project;

import java.awt.BorderLayout;
import java.awt.Button;
import java.io.File;

import javax.swing.*;

public class Scoreboard extends JPanel{
	private int playerOWins;
	private int playerXWins;
	private int tieCount;
	private JLabel playerO;
	private JLabel playerX;
	private JLabel tie;
	private JLabel currentPlayer;
	
	public Scoreboard(){
		//initialize count and create labels
		playerOWins = 0;
		playerXWins = 0;
		tieCount = 0;
		playerO = new JLabel("Player O: " + playerOWins);
		playerX = new JLabel("Player X: " + playerXWins);
		tie = new JLabel("Ties: " + tieCount);
		currentPlayer = new JLabel();

		
		//set panel layout
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		
		//add labels
		add(playerO, BorderLayout.WEST);
		add(playerX, BorderLayout.WEST);
		add(tie, BorderLayout.WEST);
		tie.setBorder(BorderFactory.createEmptyBorder(0, 0, 200, 0));
		add(currentPlayer);
		currentPlayer.setBorder(BorderFactory.createEmptyBorder(0, 0, 200, 0));

	}
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
	public void addTie(){
		tieCount++;
		tie.setText("Ties: " + tieCount);
	}
	public void updateTurn(int player){
		if(player == 0)
			currentPlayer.setText("Player X's turn!");
		else
			currentPlayer.setText("Player O's turn!");
	}

}
