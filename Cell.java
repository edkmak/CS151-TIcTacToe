/* Cell class */
package Project;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class Cell extends JPanel{
	private char token;
	private JLabel picLabel;
	// Constructor to assign value to cell
	public Cell(){
		token = ' ';
		picLabel = new JLabel();
		setBorder(new LineBorder(Color.RED, 1)); // Set cell's border
	}
	public void drawO(){
		if(token == ' '){
			BufferedImage myPicture = null;
			try {
				myPicture = ImageIO.read(new File("D:/Homework/CS151/src/Project/O.png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
			picLabel = new JLabel(new ImageIcon(myPicture));
			add(picLabel,BorderLayout.CENTER);
			token = 'O';
		}else{
			System.out.println("This cell is already taken!");
		}
	}
	
	public void drawX(){
		if(token == ' '){
			BufferedImage myPicture = null;
			try {
				myPicture = ImageIO.read(new File("D:/Homework/CS151/src/Project/X.png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
			picLabel = new JLabel(new ImageIcon(myPicture));
			add(picLabel,BorderLayout.SOUTH);
			token = 'X';
		}else{
			System.out.println("This cell is already taken!");
		}
	}
	public void removeCell(){
		this.remove(picLabel);
		this.repaint();
	}
	public int getToken(){
		return token; 
	}
	public void setToken(char c){
		token = c;
	}
}