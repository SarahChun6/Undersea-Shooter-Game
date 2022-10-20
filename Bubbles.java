import java.awt.Color;
import java.awt.Graphics;


public class Bubbles {
	private int x;
	private int y;
	private Color white;
	

	
	public Bubbles(){
		x = (int)(Math.random()*800);
		y = (int)(Math.random()*598);
		white = new Color(255,255,255);

		

	}
	
	public void drawMe(Graphics g){
		g.setColor(white);
		g.fillRect(x,y,3,3);
	}
	
	public void move(){
		x--;

		if( x < -3){
			x = 800;
			y = (int)(Math.random()*598);
		}

	}

	
}