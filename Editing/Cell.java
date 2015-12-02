/* Cell class */
package Project;

import java.awt.Button;

public class Cell extends Button{

  public static final int MIN = 1;
  public static final int MAX = 3;
  private int x, y;
  boolean taken;

  // Constructor to assign value to cell
  public Cell(/*int x, int y*/){

    if( x<MIN | x >MAX | y<MIN | y>MAX ){
      throw new IllegalArgumentException();
    }

    this.x = x;
    this.y = y;
    taken = true;
  }

  public int getX(){ return x; }
  public int getY() { return y; }
  public boolean isEmpty() {return taken; }

}