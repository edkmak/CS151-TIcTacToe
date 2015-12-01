/* Cell class */
package Project;

public class Cell {

  public static final int MIN = 1;
  public static final int MAX = 3;
  private int x, y;
  boolean taken;

  // Constructor to assign value to cell
  public Cell(int x, int y){

    if( x<MIN | x >MAX | y<MIN | y>MAX ){
      throw new IllegalArgumentException();
    }

    this.x = x;
    this.y = y;
    taken = true;
  }

  public getX(){ return x; }
  public getY() { return y; }
  public isEmpty() {return taken; }

}