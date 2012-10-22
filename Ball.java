package Japplet3;
import java.awt.Graphics;
import java.awt.Point;
import java.util.Vector;


public class Ball {

	
//int cs;
int x;
int y;
boolean collision;
Vector coOrdinates;
int xinc;
int yinc;
	
	public Ball(int xt, int yt){
		x = xt;
		y= yt;
		coOrdinates = new Vector();
		yinc = 1;
		xinc = 1;
		
	}
	
	
	
	public void update(){
		x = x + xinc;
		y = y + yinc;
		getCoOrd();
		
	}
	
	
	public void collisionHandle(){
		System.out.println("Crash!");
		//cs = coOrdinates.capacity();
		point1 =  
		
		
		
		yinc = yinc * -1;
		xinc = xinc * -1;
		
	}
	
	public void getCoOrd(){
		if (coOrdinates.size() >= 4){
			coOrdinates.removeElementAt(0);
		}
		
		coOrdinates.addElement(new Point(x,y));
		for ( int j = 1; j < coOrdinates.size(); ++j ) {
			Point a = (Point)(coOrdinates.elementAt(j));
			System.out.println(a);
		}
	  }
	
	
	
	
	public void draw(Graphics g){
		
		g.drawOval(x, y, 20, 20);
		collision = g.hitClip(x, y, 40, 40);
		if (!collision){
			collisionHandle();
		}
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
