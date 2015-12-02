/* Cell class */
package Project;

import javax.swing.JPanel;

public class Cell extends JPanel{

	public static final int MIN = 1;
	public static final int MAX = 3;
	private int x, y;
	private int taken;

	// Constructor to assign value to cell
	public Cell(/*int x, int y*/){

	/*	if( x<MIN | x >MAX | y<MIN | y>MAX ){
			throw new IllegalArgumentException();
		}

		this.x = x;
		this.y = y;*/
		taken = 0;
	}

	public int getX(){
		return x;
	}
	public int getY(){
		return y;
		}
	public int getTaken(){
		return taken; 
	}
	public void setTaken(int player){
		taken = player;
	};
}