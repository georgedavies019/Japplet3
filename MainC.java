package Japplet3;
import java.applet.*;
import java.awt.*;
import java.awt.event.*;



public class MainC extends Applet implements Runnable,MouseListener, KeyListener {

   /**
	 * Author: George Davies
	 */
	private static final long serialVersionUID = 1L;
	int width, height;
  
	Image buffer;
	Graphics bufferG;
	int refresh = 10;
	Thread t = null;
	private int ballCount = 0;
	private int max;
	public Ball[] balls = new Ball[100];
	Ball ball1;
	BallCollision ballCollision;
	
	private boolean adminMode = false;
	

	public void init() {
		width = 900;
		height = 900;
		max = (height*width/30000);
		setSize(height, width);
		ballCollision = new BallCollision(this);
		buffer = createImage(width, height);
		bufferG = buffer.getGraphics();
		setBackground( Color.black );
		addMouseListener( this );
		addKeyListener(this);
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

	public void destroy() {
	}
	
	
	
	public void run() {
		try {
			while (true) {
				update();
				repaint();
				Thread.sleep( refresh);  
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
   
	public void update(Graphics g){
		paint(g);
	}
   
	public void paint( Graphics g ) {

		bufferG.clearRect(0,0,width,height); 
	    //draw backgound
		bufferG.setColor(Color.black);
		bufferG.fillRect(0, 0, getWidth(), getHeight());
	    //draw border
		bufferG.setColor( Color.green );
		bufferG.drawRect(2, 2, width - 3, height - 3);
		bufferG.setClip(0, 0, width, height);
		for(int i = 0; i < ballCount; i++){
			balls[i].draw(bufferG);
		}
 	   
		g.drawImage(buffer, 0, 0, this);
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
   
	public int getRadius(int i){
		return balls[i].getRadius();
	}
	
	
	public void spawnCircle(int x, int y){
		ball1 = new Ball(x,y, this);
		if (ballCount < 2){
			balls[ballCount] = ball1;
			ballCount++; 
		}
		
		
		else if (ballCount >= 2){
			if (!ballCollision.spawnCheck(x,y,ball1.getRadius())){
				balls[ballCount] = ball1;
				ballCount++; 
		
			}
		}
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
	
	
	public void keyTyped( KeyEvent e ) {
	      char c = e.getKeyChar();
	      if ( c == 'r' ) {
	    	  {
	    		  refresh++;
	    		  System.out.println(refresh);
	    	  
	    	  }
	    		  
	    			  
	    			  
	    		  
	    	  
	      }else if  ( c == 'e' ) {
	    	  if (refresh != 0){
	    		  if (!adminMode){
	    			  if(refresh >1){
	    				  refresh--;
	    				  System.out.println(refresh);
	    			  }
	    			  
	    		  }else if(adminMode){
	    			  refresh--;
    				  System.out.println(refresh);
	    		  }
	    	  }  
	 	  }else if (c== 't'){
	 		  if (adminMode){
	 			  if (max > 1){
	 				max--;
	 				System.out.println("max balls:" + max);
	 			}
	 		 }
	 	  }else if (c == 'y'){
	 		  if (adminMode){
	 			 if (max < 100){
	 				 max++;
	 				 System.out.println("max balls:" + max);
	 			 }
	 		  }
	 	  }
	 }
	
	
	
	
	

	public void mouseClicked(MouseEvent e) {
	
	}

	public void mouseReleased(MouseEvent e) {

	}

	public void mouseEntered(MouseEvent e) {
	
	}

	public void mouseExited(MouseEvent e) {

	}
   
	public void keyPressed(KeyEvent e) {
	
		char c = e.getKeyChar();
		if (c == 'b'){
			adminMode = true;
		}
		
	}

	
	public void keyReleased(KeyEvent e) {
		char c = e.getKeyChar();
		if (c == 'b'){
			adminMode = false;
		}
	}
	
	
}