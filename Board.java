package Project;

import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;
import java.awt.event.*;

public class Board extends JFrame{
	public static final int WINDOW_HEIGHT = 600;
	public static final int WINDOW_WIDTH = 600;

	private JPanel cellArray[];
	private JPanel ticTacToeBoard;
	private Scoreboard sb;
	
	class GPanel extends JPanel{
		public GPanel() {
			setPreferredSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));
		}

		@Override
		public void paintComponent(Graphics g) {
			// Draw a simple line using the Graphics2D draw() method.
			Graphics2D g2 = (Graphics2D) g;
			g2.setStroke(new BasicStroke(2f));
			g2.setColor(Color.RED);

			//Vertical Lines
			g2.draw(new Line2D.Double(WINDOW_WIDTH/3, 0,WINDOW_WIDTH/3, WINDOW_HEIGHT));
			g2.draw(new Line2D.Double(WINDOW_WIDTH/3 * 2, 0,WINDOW_WIDTH/3 * 2, WINDOW_HEIGHT));

			//Horizontal Lines
			g2.draw(new Line2D.Double(0, WINDOW_HEIGHT/3, WINDOW_WIDTH, WINDOW_HEIGHT/3));
			g2.draw(new Line2D.Double(0, WINDOW_HEIGHT/3 * 2,WINDOW_WIDTH, WINDOW_HEIGHT/3 * 2));
		}
	}
	public Board(){
		super("Tic Tac Toe");
		setLocation(500,200);
		setSize(1000, 1000);
		getContentPane().setLayout(new BorderLayout());

		//create the playing board
		ticTacToeBoard = new GPanel();
		ticTacToeBoard.setLocation(0,0);
		ticTacToeBoard.setBorder(BorderFactory.createLineBorder(Color.black));

		cellArray = new Cell[9];

		ticTacToeBoard.setLayout(new GridLayout(3,3));
		for(int i= 0; i < 9; i++){
			Cell c = new Cell();
			c.addMouseListener(new MouseAdapter(){
				public void mousePressed(MouseEvent e){
					if(c.getTaken() == 0){
						//do drawing here
					}
					else{
						//give error
					}
				}
			});
			cellArray[i] = c;
		}

		for(int i = 0; i < 9; i++)
			ticTacToeBoard.add(cellArray[i]);

		add(ticTacToeBoard, BorderLayout.WEST);
		sb = new Scoreboard();
		add(sb,BorderLayout.EAST);

		pack();
		setDefaultCloseOperation(EXIT_ON_CLOSE); 
		setVisible(true);

	}
	public void resetCells(){
		
	}
	public Scoreboard getScoreboard(){
		return sb;
	}
}



