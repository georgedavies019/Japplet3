package Japplet3;

import java.lang.Math;







public class BallCollision{
	
private int ballCount;
MainC master;


	public BallCollision(MainC c) {
		master = c;
			
	}
	
	public void ballCheck() {
		ballCount = master.getBallCount();		
		for (int i = 0;i < ballCount; i++){
			for (int k = i+1;k < ballCount; k++){
				int a = master.getBallArray(i).getX();
				int b = master.getBallArray(k).getX();
				int c = master.getBallArray(i).getY();
				int d = master.getBallArray(k).getY();
				if (Math.sqrt( (a - b)*(a - b) + (c - d)*(c - d)) <= 
						(master.getBallArray(i).getRadius()+master.getBallArray(k).getRadius()))
								
				{
				
									
					int bTemp = master.getBallArray(i).getXInc();
					int cTemp =	master.getBallArray(i).getYInc();
					
					master.getBallArray(i).setXInc(master.getBallArray(k).getXInc());
					master.getBallArray(i).setYInc(master.getBallArray(k).getYInc());
					master.getBallArray(k).setXInc(bTemp);
					master.getBallArray(k).setYInc(cTemp);
					
					
					
					
				}
				else{
					//System.out.println("lulz cant catch me!");
				}
			}
		}
	}


	
	public boolean spawnCheck(int x, int y, int r){
		ballCount = master.getBallCount();
		
		
		
		
		for (int t = 0;t < ballCount; t++){
		int a2 = master.getBallArray(t).getX();
		int b2 = master.getBallArray(t).getY();


		if (Math.sqrt( (a2 - x)*(a2 - x) + (b2 - y)*(b2 - y)) <= 
				(master.getBallArray(t).getRadius()+r+30))
				
		{
			System.out.println("collide");
	
			return true;

		}	
		
		
		}
		
		System.out.println(" no collide");
		return false;
	}

	
	public void run() {
		
		
	}	
}








