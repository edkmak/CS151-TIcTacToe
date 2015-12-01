package Project;
import java.awt.Component;
import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JFrame;

public class Board extends JFrame {
	
	
	
	public static void main (String []args){
		JFrame f = new JFrame("Tic Tae Toe xD");
		JPanel p = new JPanel();
		//create new of object of class XnOButtons
		XnOButtons buttons [] = new XnOButtons[9];
		
		f.setSize(500, 500);
		f.setDefaultCloseOperation(EXIT_ON_CLOSE); 
		
		//Add buttons of class XnOButtons to gridlayout
		p.setLayout(new GridLayout(3,3));
		for(int i=0; i < 9; i++){
			buttons [i] = new XnOButtons();
			p.add(buttons[i]);
			
		}
		f.add(p);
		f.setVisible(true);
		
		
		
		
		
		
	}
	
	
		
		
		
		
		
		
	}
	
	

