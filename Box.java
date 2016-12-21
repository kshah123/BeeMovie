public Class Box extends Node{
  public int x, y, z;
  public Box parent;
  public final int gCost, hCost;
  public boolean seen, visited = false;
  int lr, fb, ud;
  public Box(int a, int b, int c, Hive h){
    x = a;
    y = b;
    z = c;
    lr = distToHive(h)[0];
    fb = distToHive(h)[1];
    ud = distToHive(h)[2]
    hCost = distToHive(h)[3];
    isDebris = false;
  }
  public int[] distToHive(Hive h){
    int[] a = {1, 1, 1, 0};
    int dX = x - h.x();
    int dY = y - h.y();
    int dZ = z - h.z();
    if(dX == 0)
      a[0] = 0;
    else if(dX < 0)
      a[0] = -1;
    if(dY == 0)
      a[1] = 0;
    else if(dY < 0)
      a[1] = -1;
    if(dZ == 0)
      a[2] = 0;
    else if(dZ < 0)
      a[2] = -1;
    dX = Math.abs(dX);
    dY = Math.abs(dY);
    dZ = Math.abs(dZ);
    int moves = 0;
    while(true){
      if((dX == 0 && dY == 0) || (dX == 0 && dZ == 0) || (dY == 0 && dZ == 0))
        break;
      if(dX > 0 && dY > 0 && dZ > 0)
        move++;
        dX--;
        dY--;
        dZ--;
      else if (dZ == 0){
        moves++;
        dX--;
        dY--;
      }
      else if(dY == 0){
        moves++;
        dX--;
        dZ--;
      }
      else if(dX == 0){
        moves++;
        dY--;
        dZ--;
      }
      moves += dX + dY + dZ;
      a[3] = moves;
      return a;
    }
  }
  public int[] getPos(){
    return {x, y, z};
  }
  public boolean collide(Bee b){
    visited = true;
    return true;
    gCost = gCost(b, b.start)[3];
  }
  public Box[] visible(Node[][][] cube){
    ArrayList<Box> seen = new ArrayList();
    if(lr != 0){
      //adds 9 boxes on one side (l or r side)
      seen.addAll(allLR(cube));
      if(fb != 0)
        seen.addAll(someFB(cube));
      if(ud != 0)
        seen.addAll(someUD(cube));
    }
    else if(lr != 0){
      seen.addAll(allFB(cube));
      if(ud != 0)
        seen.addAll(someUD(cube));
    }
    else if(ud != 0)
      seen.addAll(allUD(cube));
      Box[] b = seen.toArray(new Box[seen.size()]);
    return b;
  }
  public ArrayList<Box> allLR(Node[][][] cube){
    ArrayList<Box> a = new ArrayList();
    for(int i = -1; i <= 1; i++){
      for(int j = -1; j <= 1; j++){
        if(cube[x+lr][y+i][z+j].isDebris == false)
          a.add(cube[x+lr][y+i][z+j]);
      }
    }
    for(Box x : a)
      x.seen = true;
    return a;
  }
  public ArrayList<Box> someFB(Node[][][] cube){
    ArrayList<Box> a = new ArrayList();
    for(int i = -1; i <= 1; i++){
      if(cube[x][y+fb][z+i].isDebris == false)
        a.add(cube[x][y+fb][z+i]);
      if(cube[x-lr][y+fb][z+i].isDebris == false)
        a.add(cube[x-lr][y+fb][z+i]);
    }
    return a;
  }
  public ArrayList<Box> someUD(Node[][][] cube){
    ArrayList<Box> a = new ArrayList();
    for(int i = -1; i <= 1; i++){
      if(cube[x][y+i][z+ud].isDebris == false)
        a.add(cube[x][y+i][z+ud]);
      if(cube[x-lr][y+i][z+ud].isDebris == false)
        a.add(cube[x-lr][y+i][z+ud]);
    }
    return a;
  }
  public ArrayList<Box> allFB(Node[][][] cube){
    ArrayList<Box> a = new ArrayList();
    for(int i = -1; i <= 1; i++){
      for(int j = -1; j <= 1; j++){
        if(cube[x+i][y+fb][z+j].isDebris == false)
          a.add(cube[x+i][y+fb][z+j]);
      }
    }
    return a;
  }
  public ArrayList<Box> allUD(Node[][][] cube){
    ArrayList<Box> a = new ArrayList();
    for(int i = -1; i <= 1; i++){
      for(int j = -1; j <= 1; j++){
        if(cube[x+i][y+j][z+ud].isDebris == false)
          a.add(cube[x+i][y+j][z+ud]);
      }
    }
    return a;
  }
  public int gCost(Bee b, Box start){
    int dX = Math.abs(x - start.x());
    int dY = Math.abs(y - start.y());
    int dZ = Math.abs(z - start.z());
    int moves = 0;
    while(true){
      if((dX == 0 && dY == 0) || (dX == 0 && dZ == 0) || (dY == 0 && dZ == 0))
        break;
      if(dX > 0 && dY > 0 && dZ > 0)
        move++;
        dX--;
        dY--;
        dZ--;
      else if (dZ == 0){
        moves++;
        dX--;
        dY--;
      }
      else if(dY == 0){
        moves++;
        dX--;
        dZ--;
      }
      else if(dX == 0){
        moves++;
        dY--;
        dZ--;
      }
      moves += dX + dY + dZ;
      a[3] = moves;
      return a;
  }
}
