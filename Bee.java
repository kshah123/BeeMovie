import java.util.ArrayList;
public Class Bee{
  private int x, y, z;
  private int moves = 0;
  public boolean inHive = false;
  public Box start;
  public Bee(int a , int b, int c, Box s){
    x = a;
    y = b;
    z = c;
    start = s;
  }
  public void move(int lr, int fb, int ud){
    x += lr;
    y += fb;
    z += ud;
  }
  public void makeMove(){
    moves++;
  }
  public int[] getPos(){
    return {x, y, z};
  }
}
