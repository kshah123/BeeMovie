public Class Debris extends Node{
  public Debris(){
    isDebris = true;
  }
  public boolean collide(Bee b){
    return false;
  }
}
