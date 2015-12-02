package Project;

public class Player {
	private boolean win;
	private boolean current_Turn;
	private int XorO;  //0 if O, 1 if X
	
	//a player that plays tic tac toe and determines if he/she is the X or O character. 
	public Player(String x) throws Exception{
		if(!x.toUpperCase().equals("X") && !x.toUpperCase().equals("O")){
			throw new Exception("Must input either X or O");
		}
		win = false;
		current_Turn = false;
	}
	public void setPlayer(int player){
		XorO = player;
	}
	public int getPlayer(){
		return XorO;
	}
	public void setTurn(boolean turn){
		current_Turn = turn;
	}
	public boolean getTurn(){
		return current_Turn;
	}
	public void setWin(boolean win){
		this.win = win;
	}
	public boolean getWin(){
		return win;
	}
}