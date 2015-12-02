package Project;

public class Player {
	private boolean won;
	private boolean current_Turn;
	private int XorO;  //0 if O, 1 if X
	
	//a player that plays tic tac toe and determines if he/she is the X or O character. 
	public Player(String x) throws Exception{
		if(!x.toUpperCase().equals("X") && !x.toUpperCase().equals("O")){
			throw new Exception("Must input either X or O");
		}
		this.won = false;
		this.current_Turn = true;
		this.XorO = 0;
		
	}
	
	public void makeMove(){
		if(XorO == 0){
			//Board.drawO();
		}else{
			//Board.drawX();
		}
	}
	public int getPlayer(){
		return XorO;
	}
}