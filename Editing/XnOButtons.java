package Project;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.ImageIcon;

public class XnOButtons extends JButton implements ActionListener{

	ImageIcon X;
	ImageIcon O;
	int number =0;
	
	// Creating X and O buttons by importing image of X and O from source path using ImageIcon
	public XnOButtons(){
		
		X = new ImageIcon(this.getClass().getResource("X.png"));
		O = new ImageIcon(this.getClass().getResource("O.png"));
		
		this.addActionListener(this);
		
		
	}

	// when button is clicked, number increment but never surpass value of 3
	// first clicked, X will appear
	// second click, O will appear
	// 3rd click, O will diasspear, 
	@Override
	public void actionPerformed(ActionEvent e) {
		number++;
		number %=3;
		
		switch (number) {
		
		case 0:
			setIcon(null);
			break;
			
		case 1: 
			setIcon(X);
			break;
			
		case 2:
			setIcon(O);
			break;
			
		}
		
	}
	
	
	
	
}
