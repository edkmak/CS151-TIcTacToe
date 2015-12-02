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
			/*	c.addMouseListener(new MouseAdapter(){
				public void mousePressed(MouseEvent e){
					if(c.getTaken() == 0){
						//do drawing here
					}
					else{
						//give error
					}
				}
			});*/
			cellArray[i] = c;
			ticTacToeBoard.add(cellArray[i]);
		}
		//create New Game button
		newGame = new Button("New Game");
		newGame.setEnabled(false); //change when game state is finished
		newGame.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				newGame.setEnabled(false);
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
	public void play(){
		//play while neither player has won
		int win = 0;

		//randomize who is going first
		Random rand = new Random();
		int first = (int) (rand.nextInt(2) + 1);
		System.out.println(first);
		if(first == 1)
			players[0].setTurn(true);
		else
			players[1].setTurn(true);

		int currentPlayer = first;
		for(int i = 0; i < 9; i++){
			Cell c = cellArray[i];
			c.addMouseListener(new MouseAdapter(){
				public void mousePressed(MouseEvent e){
					if(c.getTaken() == 0){
						//do drawing here
						turn(currentPlayer);
					}
					else{
						//give error
					}
				}
			});
		}
		win = 2;
		if(win == 0 || win == 1)
			sb.addWin(currentPlayer);
		else
			sb.addTie();

		newGame.setEnabled(true);
	}
	public void turn(int currentPlayer){
		System.out.println(currentPlayer);
		sb.updateTurn(currentPlayer);
		//set up for next player
		if(currentPlayer == 1)
			currentPlayer++;
		else if(currentPlayer == 2)
			currentPlayer--;
		
		if(checkWin(cellArray, currentPlayer) == true)
			players[currentPlayer].setWin(true);
	}
	public void reset(){
		//reset all conditions
		players[0].setWin(false);
		players[1].setWin(false);
		//resetCells();
	}
	public boolean checkWin(Cell cellArray[], int player){
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



