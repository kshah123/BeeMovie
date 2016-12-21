public abstract Class Node{
  public final boolean isDebris;
  public Node(boolean d){
    isDebris = d;
  }
  public abstract boolean collide(Bee b);
}
