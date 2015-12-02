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
	int i;

	// Constructor to assign value to cell
	public Cell(int i){
		taken = 0;
		this.i = i;
	}
	
	public void drawO(){
		if(taken == 0){
			BufferedImage myPicture = null;
			try {
				myPicture = ImageIO.read(new File("/Users/edwin/Documents/CS151-TIcTacToe/O.png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
			JLabel picLabel = new JLabel(new ImageIcon(myPicture));
			add(picLabel,BorderLayout.CENTER);
			taken = 1;
		}else{
			System.out.println("This cell is already taken!");
		}
	}
	
	public void drawX(){
		if(taken == 0){
			BufferedImage myPicture = null;
			try {
				myPicture = ImageIO.read(new File("/Users/edwin/Documents/CS151-TIcTacToe/X.png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
			JLabel picLabel = new JLabel(new ImageIcon(myPicture));
			add(picLabel,BorderLayout.SOUTH);
			taken =1;
		}else{
			System.out.println("This cell is already taken!");
		}
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