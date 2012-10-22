package Japplet3;
import java.applet.*;
import java.awt.*;
import java.util.Vector;
import java.awt.Point;

public class MainC extends Applet implements Runnable {

   int width, height;
   int x, y;
   Ball ball1;
  
   boolean drawOnce = true;
   Thread t = null;
   
   
   

   
   public void init() {
      
      width = getSize().width;
      height = getSize().height;
      setBackground( Color.black );
      x = 0;
	   y = 1;
      
      ball1 = new Ball(0,0, height, width);
     
   }

   
   public void destroy() {
      System.out.println("destroy()");
   }

   
   public void start() {
	   
	   
	   
	   
      if ( t == null ) {
         
         t = new Thread( this );        
         t.start();
         
      }
      else {
         
            ;
            
            synchronized( this ) {
               notify();
            
         }
      }
     
   }

 
   public void stop() {
      System.out.println("stop(): begin");
     
   }

   
   public void run() {
     
      try {
         while (true) {
            

            
            
          
               
            
           
            update();
            repaint();
            
            t.sleep( 50 );  
         }
      }
      catch (InterruptedException e) { }
      
   }

  
   
   
   
   
   
   
   
   
   public void update(){
	   ball1.update();
   }
   
   
   
   
   
   public void paint( Graphics g ) {
	   g.setColor( Color.green );
	   if (drawOnce){
		   g.drawRect(0, 0, width - 3, height - 3);
		   g.setClip(0, 0, width, height);
	   }
	   
      
	   ball1.draw(g);
	   
      
      
   }
}