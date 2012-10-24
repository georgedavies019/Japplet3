package Japplet3;
import java.awt.Color;
import java.awt.Graphics;

import java.util.Random;

public class Ball implements Runnable{

	

int cs;
protected int x;
protected int y;
Thread t;
private int xInc;
private int yInc;

private int height, width;
private int radius;
Color randColour;


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
		radius = (rand.nextInt(40)+10);
		
		yInc = (rand.nextInt(6)-3);
		xInc = (rand.nextInt(6)-3);
		
		
		float r = rand.nextFloat();
		float g = rand.nextFloat();
		float b = rand.nextFloat();
		
		randColour = new Color(r, g, b);
		
		if (xInc == 0){
			xInc++;
		}
		
		if (yInc == 0){
			yInc++;
		}
	}
	
	
	
	public void update(){
		x = x + xInc;
		y = y + yInc;
		
		checkCollision();
	}
	
	
	public int getX(){
		return x + radius;
	}
	
	public int getY(){
		return y + radius;
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
		
		
		g.setColor(randColour);
		
		g.fillOval(x, y, radius*2, radius*2);
		collision = g.hitClip(x, y, height, width);
		if (!collision){
			this.setX(40);
			this.setY(40);
		}
		
		
	}



	public void run() {
		
		while(true){
		
			try {
				//System.out.println("das shit");
				Thread.sleep(150);
			
				if (this.getX()<=20){
					Thread.sleep(500);
					if (this.getX()<=20){
						this.setX(this.getX() + (2 * radius + 20));
						Thread.sleep(500);
					}						
				}else if (this.getX()>=width - 20){
					Thread.sleep(500);
					if (this.getX()>=width -20){
						this.setX(this.getX() - (2 * radius + 20));
						Thread.sleep(500);
					}
				}else if (this.getY()<=20){
					Thread.sleep(500);
					if (this.getY()<=20){
						this.setY(this.getY() + (2 * radius + 20));
						Thread.sleep(500);
					}
				}else if (this.getY()>=height - 20){
					Thread.sleep(500);
					if (this.getY()>=height -20){
					
						this.setY(this.getY() - (2 * radius + 20));
						Thread.sleep(500);
					}
				}
			
			
			
			}catch (InterruptedException e) {
				e.printStackTrace();
			}
		
		}
		
	}
	
	
	
	public void checkCollision(){	
		
		//System.out.println(height);
			
			if (getX() < 0 + radius){			//collided with left wall
				setXInc(-(getXInc()));
			}else if (getX() > width - radius ){	//collided with the right
				setXInc(-(getXInc()));
			}else if (getY() < 0 + radius){		//collided with top
				setYInc(-(getYInc()));
			}else if (getY()  > height - radius ){	//COLLIDED WITH BOTTOM
				setYInc(-(getYInc()));
			}
					
	}
	
	
	public int getRadius(){
		return radius;
	}
	
	

	

}	
	
	
	
	
	
	
	
	
	
	

