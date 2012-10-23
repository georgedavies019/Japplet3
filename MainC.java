package Japplet3;
import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Vector;

public class MainC extends Applet implements Runnable,MouseListener {

   /**
	 * Author: George Davies
	 */
	private static final long serialVersionUID = 1L;
	int width, height;
  
	Image buffer;
   
	Thread t = null;
	private int ballCount = 0;
	private int max =10;
	public Ball[] balls = new Ball[max];
	Ball ball1;
	BallCollision ballCollision;
	public Vector[] coOrdArray = new  Vector[max];

	public void init() {
		width = 800;
		height = 600;
		setSize(height, width);
      
		ballCollision = new BallCollision(this);
		buffer = createImage(width, height);
      
		setBackground( Color.black );
         
		addMouseListener( this );
		
		 
		  
		 
	  
	
	}

	public void mousePressed( MouseEvent e ){
	
		if (ballCount < max){
			int mx = e.getX();
			int my = e.getY();
			spawnCircle(mx, my);
	   }else{
		   System.out.println("too many balls");
	   }
	}
   
   
   
   
	public void destroy() {
		System.out.println("destroy()");
	}

   
	public void start() {
		if ( t == null ) {
			t = new Thread( this );        
			t.start();
		}else {
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
				Thread.sleep( 10 );  
			}
		}
      catch (InterruptedException e) { }
		}


   
	public void update(){
		for(int i = 0; i < ballCount; i++){
			balls[i].update();
				
			
		}
		ballCollision.ballCheck();
		
	   
	}
   
  
   
	public void paint( Graphics g ) {
		Graphics bg = buffer.getGraphics();
	    //draw backgound
		bg.setColor(Color.black);
		bg.fillRect(0, 0, getWidth(), getHeight());
	    //draw border
		bg.setColor( Color.green );
		bg.drawRect(2, 2, width - 3, height - 3);
		bg.setClip(0, 0, width, height);
	   
	   
	   //System.out.println(ballCount);
		for(int i = 0; i < ballCount; i++){
			balls[i].draw(bg);
		}
 	   
		g.drawImage(buffer, 0, 0, null);
		g.dispose();
	
	}
   
	public Ball getBallArray(int i){
		Ball temp1 = balls[i];
		return temp1;
	}
   
	public int getBallCount(){
		return ballCount;
	}
   
   
	public int getHeight(){
		return height;
	}
   
	public int getWidth(){
		return width;
	}
   
   
	public void spawnCircle(int x, int y){
		ball1 = new Ball(x,y, this);
		balls[ballCount] = ball1;
		ballCount++;  
	}
	
	public int getRadius(int i){
		return balls[i].getRadius();
	}
	
	public void ballCrash(int i, int k){
		
		balls[i].ballBounce(balls[k]);
	}

	public void mouseClicked(MouseEvent e) {
	
}

	public void mouseReleased(MouseEvent e) {

}

	public void mouseEntered(MouseEvent e) {
	
}

	public void mouseExited(MouseEvent e) {

}
   
}