public Class Hive{
  public final int x, y, z;
  public Hive(int a, int b, int c){
    isDebris = false;
    x = a;
    y = b;
    z = c;
  }
  public boolean collide(Bee b){
    b.inHive = true;
    return true;
  }
}
