import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class SierpinskiTriangle extends PApplet {

public static final int GLOBAL_BG_COLOR = 242;
public static final int GLOBAL_LEN_INC = 8;
public int global_len=512;

public void setup(){
  size(512,512); //set size
  noFill(); //set to no fill so the triangles won't cover each other
}
public void draw(){
  sierpinski(0,height,global_len); //call sierpinski function once
}
/* optional */
public void mouseDragged(){
  background(GLOBAL_BG_COLOR); //erase the display by setting the background
  global_len += GLOBAL_LEN_INC; //increment the global length value
  System.out.println("global_len = " + global_len); //print the value
  redraw(); //call draw() again to re-trigger the sierpinksi recursion
}
public void sierpinski(int x, int y, int len){
  final int MIN_LEN = 8; //set the minimum length allowed here
  int len_div_2 = (len>>1); //stores value of len divided by two
  /* checks to make sure the len value is within the allowed zone */ 
  if(len>=MIN_LEN){
    //commented-out code makes the triangles always half sized
    //triangle(x,y,x+(len_div_2>>1),y-len_div_2,x+len_div_2,y);
    //sierpinski(x+(len_div_2>>1),y,len_div_2);
    //sierpinski(x+(len_div_2>>2),y-(len_div_2>>1),len_div_2);
    //sierpinski(x,y,len_div_2);
    
    /* draws the surrounding triangle */
    triangle(x,y,x+len_div_2,y-len,x+len,y);
    /* draws the three inner triangles */
    sierpinski(x+len_div_2,y,len_div_2);
    sierpinski(x+(len_div_2>>1),y-len_div_2,len_div_2);
    sierpinski(x,y,len_div_2);
  }
}
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "SierpinskiTriangle" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
