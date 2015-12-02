package Project;

import java.awt.*;
import java.awt.geom.*;

import javax.swing.*;

import java.awt.event.*;

public class Board extends JFrame{
	public static final int WINDOW_HEIGHT = 600;
	public static final int WINDOW_WIDTH = 600;

	private Cell cellArray[];
	private JPanel ticTacToeBoard;
	private Scoreboard sb;
	private int currentTurn = 0;
	
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
			Cell c = new Cell(i);
			c.addMouseListener(new MouseAdapter(){
					public void mousePressed(MouseEvent e){
						System.out.println(c.i);
						currentTurn = currentTurn * -1 + 1;
						if(currentTurn == 0){
							c.drawO();
							//checkWin(0);
						}else{
							c.drawX();
							//checkWin(1);
						}
					}
				});
			cellArray[i] = c;
		}

		for(int i = 0; i < 9; i++){
			ticTacToeBoard.add(cellArray[i]);
		}

		add(ticTacToeBoard, BorderLayout.WEST);
		sb = new Scoreboard();
		add(sb,BorderLayout.EAST);

		pack();
		setDefaultCloseOperation(EXIT_ON_CLOSE); 
		setVisible(true);

	}
	public void resetCells(){
		for(Cell c: cellArray){
			c.setTaken(0);
		}
	}
	public Scoreboard getScoreboard(){
		return sb;
	}
	
	public boolean checkWin(int player){
		return((cellArray[0].getTaken() == player && cellArray[1].getTaken() == player && cellArray[2].getTaken() == player) || //first row
				(cellArray[3].getTaken() == player && cellArray[4].getTaken() == player && cellArray[5].getTaken() == player) || //second row
				(cellArray[6].getTaken() == player && cellArray[7].getTaken() == player && cellArray[8].getTaken() == player) || //third row
				(cellArray[0].getTaken() == player && cellArray[3].getTaken() == player && cellArray[6].getTaken() == player) || //first column
				(cellArray[1].getTaken() == player && cellArray[4].getTaken() == player && cellArray[7].getTaken() == player) || //second column
				(cellArray[2].getTaken() == player && cellArray[5].getTaken() == player && cellArray[8].getTaken() == player) || //third column
				(cellArray[0].getTaken() == player && cellArray[4].getTaken() == player && cellArray[8].getTaken() == player) || //diagonal
				(cellArray[2].getTaken() == player && cellArray[4].getTaken() == player && cellArray[6].getTaken() == player)); //diagonal
	}
	
}



