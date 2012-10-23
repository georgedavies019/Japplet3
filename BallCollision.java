package Japplet3;

import java.lang.Math;
import java.util.Random;






public class BallCollision  implements Runnable{
private int ballCount;
MainC master;
boolean ballCollisionEnabled;
Thread t;

	public BallCollision(MainC c) {
		master = c;
		t = new Thread( this );        
		t.start();
	}
	
	public void ballCheck() {
		ballCount = master.getBallCount() ;
		
		
		
		for (int i = 0;i < ballCount; i++){
			for (int k = i+1;k < ballCount; k++){
				if (Math.sqrt( Math.pow(((master.getBallArray(i).getX()) - (master.getBallArray(k).getX())) ,2) +
						Math.pow(((master.getBallArray(i).getY()) - (master.getBallArray(k).getY())) ,2)) <= 
						(master.getBallArray(i).getRadius()+master.getBallArray(k).getRadius())
						
						
					
						
						
						)
				
					
				
				
				{
					
					if (ballCollisionEnabled){
					Random rand = new Random();
					int a=rand.nextInt(6)-3;
					int b=rand.nextInt(6)-3;
					
					master.getBallArray(i).setXInc(a);
					master.getBallArray(i).setXInc(b);
					
					
					master.getBallArray(k).setXInc(-a);
					master.getBallArray(k).setYInc(-b);
					}
										
				}
				else{
					//System.out.println("lulz cant catch me!");
				}
				
			}
		}
		
		
		
		
	}

	@Override
	public void run() {
		while (true){
		try {
			ballCollisionEnabled = true;
			Thread.sleep(100);
			ballCollisionEnabled = false;
			Thread.sleep(200);
			System.out.println("fdsfffhh55");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	}
	
}