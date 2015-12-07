package Project;
/*
 * Class to store player model and assigns X or O
 * MAX of two users per game
 */
public class Player {
	private boolean win;
	private boolean current_Turn;
	private int XorO;  //0 if O, 1 if X
	
	// A player that plays tictactoe and determines if he/she is the X or O character. 
	public Player(String x) throws Exception{
		if(!x.toUpperCase().equals("X") && !x.toUpperCase().equals("O")){
			throw new Exception("Must input either X or O");
		}
		win = false;
		current_Turn = false;
	}
	
	// Sets player
	public void setPlayer(int player){XorO = player;}
	
	// Returns player
	public int getPlayer(){return XorO;}
	
	// Sets player turn
	public void setTurn(boolean turn){current_Turn = turn;}
	
	// Returns player with current turn
	public boolean getTurn(){return current_Turn;}
	
	// Sets winner of game
	public void setWin(boolean win){this.win = win;}
	
	//Returns winner
	public boolean getWin(){return win;}
}