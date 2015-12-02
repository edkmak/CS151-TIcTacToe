package Project;

import java.awt.*;
import java.awt.geom.*;
import java.util.Random;

import javax.swing.*;
import java.awt.event.*;

public class Board extends JFrame{
	public static final int WINDOW_HEIGHT = 600;
	public static final int WINDOW_WIDTH = 600;

	private Cell cellArray[];
	private JPanel ticTacToeBoard;
	private Player players[];
	private Scoreboard sb;
	private Button newGame;
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

		//create players
		players = new Player[2];
		try{
			players[0] = new Player("X");
			players[1] = new Player("O");
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		cellArray = new Cell[9];

		ticTacToeBoard.setLayout(new GridLayout(3,3));
		for(int i= 0; i < 9; i++){
			Cell c = new Cell();
			c.addMouseListener(new MouseAdapter(){
				public void mousePressed(MouseEvent e){
					currentTurn = currentTurn * -1 + 1;
					if(currentTurn == 0){
						c.drawO();
						sb.updateTurn(currentTurn);
						if(checkWin('O'))
							sb.addWin(1);
						else if(checkTie() && !checkWin('O'))
							sb.addTie();
					}else{
						c.drawX();
						sb.updateTurn(currentTurn);
						if(checkWin('X'))
							sb.addWin(0);
						else if(checkTie() && !checkWin('X'))
							sb.addTie();
					}
				}
			});
			cellArray[i] = c;
			ticTacToeBoard.add(cellArray[i]);
		}
		//create New Game button
		newGame = new Button("New Game");
		newGame.setEnabled(true); //change when game state is finished
		newGame.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				reset();
			}
		});

		add(ticTacToeBoard, BorderLayout.WEST);
		sb = new Scoreboard();
		sb.add(newGame);
		add(sb,BorderLayout.EAST);


		pack();
		setDefaultCloseOperation(EXIT_ON_CLOSE); 
		setVisible(true);
	}
	public void reset(){
		//reset all conditions
		for(Cell c: cellArray){
			c.setToken(' ');
			c.removeCell();
		}
		repaint();
	}
	public boolean checkTie(){
		for(Cell c: cellArray){
			if(c.getToken() == ' ')
				return false;
		}
		return true;
	}
	public boolean checkWin(char player){
		return((cellArray[0].getToken() == player && cellArray[1].getToken() == player && cellArray[2].getToken() == player) || //first row
				(cellArray[3].getToken() == player && cellArray[4].getToken() == player && cellArray[5].getToken() == player) || //second row
				(cellArray[6].getToken() == player && cellArray[7].getToken() == player && cellArray[8].getToken() == player) || //third row
				(cellArray[0].getToken() == player && cellArray[3].getToken() == player && cellArray[6].getToken() == player) || //first column
				(cellArray[1].getToken() == player && cellArray[4].getToken() == player && cellArray[7].getToken() == player) || //second column
				(cellArray[2].getToken() == player && cellArray[5].getToken() == player && cellArray[8].getToken() == player) || //third column
				(cellArray[0].getToken() == player && cellArray[4].getToken() == player && cellArray[8].getToken() == player) || //diagonal
				(cellArray[2].getToken() == player && cellArray[4].getToken() == player && cellArray[6].getToken() == player)); //diagonal
	}
}



