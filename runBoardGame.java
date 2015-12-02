package Project;

import java.util.Random;

/*
 * Runs a game of tic tac toe. Contains game logic (win condition, illegal moves, etc.).
 *  Initializes the board, score board, and players. 
 *  Upon winning display a �gPlayer X won!�h  May include �gnew game�h button. 
 */
public class runBoardGame{
	private Player players[];
	private Board gameBoard;
	private int currentTurn;

	public runBoardGame(){
		players = new Player[2];
		try{
			players[0] = new Player("X");
			players[1] = new Player("O");
			gameBoard = new Board();
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	public void play(){
		//play while neither player has won
		boolean win = false; 
		int i = 0;
		while(!players[0].getWin() && !players[1].getWin()){
			int player = players[0].getPlayer();
			Scoreboard sb = gameBoard.getScoreboard();
			sb.addWin(player);
			sb.updateTurn(player);
			//alternate player
			//check win
			//boolean check = checkWin(array, 1);
		}
		if(!win)
			;
		else
			;
	}
	public void reset(){
		//reset all conditions
		players[0].setWin(false);
		players[1].setWin(false);
		//gameBoard.resetCells();
	}
	
	public int getCurrentTurn(){
		return currentTurn;
	}
	
	public  void setCurrentTurn(int i){
		this.currentTurn = i;
	}
		
	
	
	public boolean checkWin(Cell cellArray[], int player){
		return((cellArray[0].getTaken() == player && cellArray[1].getTaken() == player && cellArray[2].getTaken() == player) || //first row
				(cellArray[3].getTaken() == player && cellArray[4].getTaken() == player && cellArray[5].getTaken() == player) || //second row
				(cellArray[6].getTaken() == player && cellArray[7].getTaken() == player && cellArray[8].getTaken() == player) || //third row
				(cellArray[0].getTaken() == player && cellArray[3].getTaken() == player && cellArray[6].getTaken() == player) || //first column
				(cellArray[1].getTaken() == player && cellArray[4].getTaken() == player && cellArray[7].getTaken() == player) || //second column
				(cellArray[2].getTaken() == player && cellArray[5].getTaken() == player && cellArray[8].getTaken() == player) || //third column
				(cellArray[0].getTaken() == player && cellArray[4].getTaken() == player && cellArray[8].getTaken() == player) || //diagonal
				(cellArray[2].getTaken() == player && cellArray[4].getTaken() == player && cellArray[6].getTaken() == player)); //diagonal
	}
}
