package Project;

import javax.swing.*;

public class Scoreboard {
	private int playerOWins;
	private int playerXWins;
	private int tieCount;
	private JLabel playerO;
	private JLabel playerX;
	private JLabel tie;
	private JPanel scoreboard;
	
	public Scoreboard(){
		//initialize count and create labels
		playerOWins = 0;
		playerXWins = 0;
		tieCount = 0;
		playerO = new JLabel("Player O: " + playerOWins);
		playerX = new JLabel("Player X: " + playerXWins);
		tie = new JLabel("Ties: " + tieCount);
		
		//create panel
		scoreboard = new JPanel();
		scoreboard.setLayout(new BoxLayout(scoreboard, BoxLayout.PAGE_AXIS));
		
		//add labels
		scoreboard.add(playerO);
		scoreboard.add(playerX);
		scoreboard.add(tie);
	}
	public void addWin(Player p){
		int player = p.getPlayer();
		
		if(player == 0){
			playerOWins++;
			tie.setText("Player O: " + playerOWins);
		}
		else{
			playerXWins++;
			tie.setText("Player X: " + playerXWins);
		}
	}
	public void addTie(){
		tieCount++;
		tie.setText("Ties: " + tieCount);
	}
	public JPanel getScoreboard(){
		return scoreboard;
	}
	

}
