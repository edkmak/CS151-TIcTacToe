/* Cell class */
package Project;

import javax.swing.JButton;
import javax.swing.ImageIcon;

public class Cell {

  public static final int MIN = 1;
  public static final int MAX = 3;
  private ImageIcon xIcon = new ImageIcon("images/x.png"));
  private ImageIcon oIcon = new ImageIcon("images/o.png"));
  
  private int x, y;
  boolean taken;

  // Constructor to create cell
  public Cell(){
    this.x = 0;
    this.y = 0;
    taken = false;
  }

  public int getX(){ return x; }
  public int getY() { return y; }

  // Methods to assign values to cell
  public ImageIcon drawX(int x, int y){
    if (x<MIN | x>MAX | y<MIN | y>MAX){
      throw new Exception("Input outside of alloted range");
    }
    this.x = x;
    this.y = y;
    taken = true;
    return xIcon;
  }
  public ImageIcon drawO(int x, int y){
    if (x<MIN | x>MAX | y<MIN | y>MAX){
      throw new Exception("Input outside of alloted range");
    }
    this.x = x;
    this.y = y;
    taken=true;
    return oIcon
  }

  public isEmpty() {return taken; }

}