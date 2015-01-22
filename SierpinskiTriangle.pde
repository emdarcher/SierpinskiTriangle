public static final int GLOBAL_BG_COLOR = 242;
public int global_len=512;
public void setup(){
  size(512,512);
  noFill();
//  noLoop();
}
public void draw(){
  sierpinski(0,height,global_len);
}
/* optional */
public void mouseDragged(){
  background(GLOBAL_BG_COLOR);
  global_len += 8;
  System.out.println("global_len = " + global_len);
  redraw();
}
public void sierpinski(int x, int y, int len){
  final int MIN_LEN = 8;
  int len_div_2 = (len>>1);
  if(len>=MIN_LEN){
    //commented-out code makes the triangles always half sized
    //triangle(x,y,x+(len_div_2>>1),y-len_div_2,x+len_div_2,y);
    //sierpinski(x+(len_div_2>>1),y,len_div_2);
    //sierpinski(x+(len_div_2>>2),y-(len_div_2>>1),len_div_2);
    //sierpinski(x,y,len_div_2);
    
    /* draws the surrounding triangle */
    triangle(x,y,x+len_div_2,y-len,x+len,y);
    /* draws the three inner triangles */
    sierpinski(x+(len_div_2>>0),y,len_div_2);
    sierpinski(x+(len_div_2>>1),y-(len_div_2>>0),len_div_2);
    sierpinski(x,y,len_div_2);
  }
}
