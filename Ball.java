package Japplet3;
import java.awt.Graphics;
import java.awt.Point;
import java.util.Vector;
import java.lang.Math;
import java.util.Random;

public class Ball implements Runnable{

	
private static final Object[] Vector = null;
int cs;
protected int x;
protected int y;
Thread t;
private int xInc;
private int yInc;


private int height, width;
private int radius;



MainC master;
	
	public Ball(int xt, int yt, MainC c){
		Random rand = new Random();
		master = c;
		
		x = xt;
		y= yt;
		t = new Thread( this );        
		t.start();
		
		width = master.getWidth();
		height = master.getHeight();
		radius = (rand.nextInt(30)+20);
		
		yInc = (rand.nextInt(6)-3);
		xInc = (rand.nextInt(6)-3);
		
		
		
	}
	
	
	
	public void update(){
		x = x + xInc;
		y = y + yInc;
		
		checkCollision();
	}
	
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
	
	public void setXInc(int xTemp){
		xInc = xTemp;
	}
	
	public void setYInc(int yTemp){
		yInc = yTemp;
		
	}
	
	
	public void setX(int xTemp){
		x = xTemp;
	}
	
	public void setY(int yTemp){
		y = yTemp;
		
	}
	
	
	public int getXInc(){
		return xInc;
	}
	
	public int getYInc(){
		return yInc;
	}
	
	
	
	
	
	
	
	
	
	
	public void draw(Graphics g){
		boolean collision;
		g.drawOval(x, y, radius, radius);
		collision = g.hitClip(x, y, height, width);
		if (!collision){
			this.setX(0);
			this.setY(0);
		}
		
		
	}



	public void run() {
		
		
		
		try {
			
			Thread.sleep(500);
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
	}
	
	
	
	public void checkCollision(){	
		
		
			
			if (getX() < 0){			//collided with left wall
				setXInc(-(getXInc()));
			}else if (getX() > width - radius){	//collided with the right
				setXInc(-(getXInc()));
			}else if (getY() < 0){		//collided with top
				setYInc(-(getYInc()));
			}else if (getY() > height - radius){	//COLLIDED WITH BOTTOM
				setYInc(-(getYInc()));
			}
					
	}
	
	
	public int getRadius(){
		return radius;
	}
	
	
	
	
	public void ballBounce(Ball k){
		//int yTemp;
		//int xTemp;
		
		
		
		/*int psi =(int) (180 - (this.getAngle()+k.getAngle())/2);
		
		double cartesian = Math.pow(x, 2) + Math.pow(y, 2);
		yTemp = (int) (Math.sin(psi)*Math.sqrt(cartesian));
		xTemp = (int) Math.sqrt(cartesian - Math.pow(y , 2));
		y = (yTemp - yInc);
		xInc = (xTemp - xInc);
		
		*/
		
		k.setXInc(-k.getXInc());
		k.setXInc(-k.getXInc());
		
		
		this.setXInc(-this.getXInc());
		this.setYInc(-this.getYInc());
		
		
		
	}

}	
	
	
	
	
	
	
	
	
	
	

