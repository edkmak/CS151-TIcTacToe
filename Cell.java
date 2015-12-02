/* Cell class */
package Project;

import java.awt.BorderLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Cell extends JPanel{

	public static final int MIN = 1;
	public static final int MAX = 3;
	private int x, y;
	private int taken;
	private JLabel picLabel;
	// Constructor to assign value to cell
	public Cell(/*int x, int y*/){

	/*	if( x<MIN | x >MAX | y<MIN | y>MAX ){
			throw new IllegalArgumentException();
		}

		this.x = x;
		this.y = y;*/
		taken = 2;
		picLabel = new JLabel();
	}
	public void drawO(){
		if(taken == 2){
			BufferedImage myPicture = null;
			try {
				myPicture = ImageIO.read(new File("D:/Homework/CS151/src/Project/O.png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
			picLabel = new JLabel(new ImageIcon(myPicture));
			add(picLabel,BorderLayout.CENTER);
			taken = 1;
		}else{
			System.out.println("This cell is already taken!");
		}
	}
	
	public void drawX(){
		if(taken == 2){
			BufferedImage myPicture = null;
			try {
				myPicture = ImageIO.read(new File("D:/Homework/CS151/src/Project/X.png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
			picLabel = new JLabel(new ImageIcon(myPicture));
			add(picLabel,BorderLayout.SOUTH);
			taken =1;
		}else{
			System.out.println("This cell is already taken!");
		}
	}
	public void removeCell(){
		this.remove(picLabel);
		this.repaint();
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