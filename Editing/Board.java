package Project;
import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.geom.Line2D;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JFrame;

public class Board extends JFrame {
	
	public static final int WINDOW_HEIGHT = 600;
	public static final int WINDOW_WIDTH = 600;
	
	Button c [];
	JPanel p;
	
	public Board(){
		super("Tic Tac Toe");
		setLocation(500,200);
		setSize(1000, 1000);
		getContentPane().setLayout(new BorderLayout());
		
		p = new GPanel();
		p.setLocation(0,0);
		p.setBorder(BorderFactory.createLineBorder(Color.black));

		c = new Cell[8];
		
		/*p.setLayout(new GridLayout(3,3));
		for(int i= 0; i < 8; i++){
			c[i] = new Cell();
		}
		
		for(int i = 0; i < 8; i++){
			p.add(c[i]);
		}*/
		
		add(p, BorderLayout.WEST);
		Scoreboard sb = new Scoreboard();
		add(sb.getScoreboard(),BorderLayout.EAST);
		
		pack();
		setDefaultCloseOperation(EXIT_ON_CLOSE); 
		setVisible(true);
		
	}
    
	
	public static void main (String[] args){
		Board b = new Board();
	}
	
	class GPanel extends JPanel {
        public GPanel() {
            setPreferredSize(new Dimension(600, 600));
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
	
}
	
	

