/* autogenerated by Processing revision 1293 on 2023-09-29 */
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

public class BallMover extends PApplet {

Mover mover;

public void setup() {
  /* size commented out by preprocessor */;
  /* smooth commented out by preprocessor */;
  mover = new Mover(); 
}

public void draw() {
  background(255);
  
  mover.run();
}
class Mover {

  PVector location;
  PVector velocity;
  PVector acceleration;
  
  Mover() {
    location = new PVector(random(width), random(height));
    velocity = new PVector(random(-2, 2), random(-2, 2));
    acceleration = new PVector(0.1f,-0.3f);
  }
  
  public void run(){
    update();
    checkEdges();
    render(); 
  }

  private void update() {
    location.add(velocity);
    velocity.add(acceleration); 
  }

  private void render() {
    stroke(0);
    strokeWeight(2);
    fill(127);
    ellipse(location.x, location.y, 48, 48);
  }

  private void checkEdges() {

    if (location.x > width) {
      location.x = 0;
    } 
    else if (location.x < 0) {
      location.x = width;
    }

    if (location.y > height) {
      location.y = 0;
    } 
    else if (location.y < 0) {
      location.y = height;
    }
  }
}


  public void settings() { size(800, 200);
smooth(); }

  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "BallMover" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
