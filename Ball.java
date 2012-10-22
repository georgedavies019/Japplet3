package Japplet3;
import java.awt.Graphics;
import java.awt.Point;
import java.util.Vector;
import java.lang.Math;

public class Ball {

	
int cs;
int x;
int y;
boolean collision;
Vector coOrdinates;
int xinc;
int yinc;
Point point1;
Point point2;
double angle;
double x1;
double x2;
double y1;
double y2;
int dx;
int dy;
int height;
int width;
Point lastE ;
	
	public Ball(int xt, int yt, int h, int w){
		x = xt;
		y= yt;
		coOrdinates = new Vector();
		yinc = 1;
		xinc = 1;
		height = h;
		width = w;
		
	}
	
	
	
	public void update(){
		x = x + xinc;
		y = y + yinc;
		getCoOrd();
		
	}
	
	
	public void collisionHandle(){
		
		System.out.println("Crash!");
		lastE = (Point) coOrdinates.lastElement();
		cs = coOrdinates.lastIndexOf(lastE);
		System.out.println(cs);
		point1 =  (Point) coOrdinates.elementAt(cs - 1);
		point2 =  (Point) coOrdinates.elementAt(cs);		
		
		
		
		dx = (int) ((x2 = point2.getX()) - (x1 = point1.getX()));
		dy = (int) ((y2 = point2.getY()) - (y1 = point1.getY()));
		double wv = 0; //working value used for trig calc
		
		
		if (dx > 0 && dy > 0){
		// going right and up
			wv = (dx / dy);
			
		}else if (dx > 0 && dy < 0){
		//going right and down
			wv = (dy / dx);
			
		}else if (dx < 0 && dy > 0){
		//going left and up
			wv = (dx / dy);
			
		}else if (dx < 0 && dy < 0){
		//going left and down
			wv = (dy / dx);
			
		}
			
		angle = Math.atan(wv);
		System.out.println(angle);
		
		
		
		
		//if (wall detection TODO)
		
		
		
		
		
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
