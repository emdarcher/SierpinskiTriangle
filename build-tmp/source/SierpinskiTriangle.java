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

public void setup(){
  size(512,512);
  noFill();
}
public void draw(){
  sierpinski(256,256,128);
}
/* optional */
public void mouseDragged(){

}
public void sierpinski(int x, int y, int len){
  final int MIN_LEN = 8;
  int len_div_2 = (len>>1);
  if(len>=MIN_LEN){
    triangle(x,y,x+(len_div_2>>1),y-len_div_2,x+len_div_2,y);
    
    sierpinski(x+(len_div_2>>1),y,len_div_2);
    //sierpinski(x+(    
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
