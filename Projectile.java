import java.awt.Color;
import java.awt.Graphics;

public class Projectile{

	private int x;
	private int y;
	
	private int width;
	private int height;
	
	private Color red;

	private boolean fire;
	
	public Projectile(int x, int y){
		
		this.x = x;
		this.y = y;
		
		this.width = 10;
		this.height = 10;
		
		this.red = new Color(255,0,0);
		
		this.fire = false;

	}
	

	public void drawMe(Graphics g){
		
		g.setColor(red);
		g.fillOval(x,y,width,height);
		
	}
	
	public int getX(){
		return x;
	}
	
	public void moveUp(){
		if (fire == false){
			y-=15;
		}
	}
	
	public void moveDown(){
		if (fire == false){
			y+=15;	
		}
	}
	
	public void move(){
		if (fire)
			x+=20;
	}
	
	public void fire(){
		fire = true;
	}
	
	public boolean checkProjColl(Enemy e){
		
		if(e.isAlive()){
			int pX = x;
			int pY = y;
			int pWidth = width;
			int pHeight = height;
			int tX = e.getX();
			int tY = e.getY();
			int tWidth = e.getWidth();
			int tHeight = e.getHeight();
			
			
			if( pX+pWidth >= tX && pX <= tX + tWidth  &&  pY+pHeight >= tY && pY <= tY + tHeight ){
				//System.out.println("Collision");	
				e.kill();
				return true;
			}
		}
		return false;
	}

	public void reset(int shipX, int shipY){
		x = shipX;
		y = shipY+20;
		fire = false;
	}
	
}