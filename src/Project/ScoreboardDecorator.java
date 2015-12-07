package Project;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JPanel;

public class ScoreboardDecorator extends JPanel {

   /**
	 * Returns a JPanel object that is placed inside of the Board class.
	 * The JPanel sent from the concrete class JPanel, is altered to display
	 * a yellow background. Additionally, an offset of 5 is given to margionally
	 * center the element on the right.
	 * 
	 * @param component any JPanel object
	 */
	// Decorated component
   protected JPanel child;
   
   // Constructor
   public ScoreboardDecorator(JPanel component) {
      child = component;
      this.setLayout(new BorderLayout());
      this.add(child);
      child.setBackground(Color.YELLOW);
      child.setAlignmentX((float) 5.0);
   }
   // Used to return the altered element
   public JPanel getChild() {return this.child;}
}