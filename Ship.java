import java.awt.Color;
import java.awt.Graphics;

public class Ship{
	
	private int x;
	private int y;
	
	private int width;
	private int height;
	
	private Color yellow;
	private Color window;
	private Color red;
	
	public Ship(int x, int y){
		
		this.x = x;
		this.y = y;
		
		this.width = 75;
		this.height = 50;
		
		this.yellow = new Color(255,255,0);
		this.window = new Color(0,255,255);
		this.red = new Color(220,20,60);

	}
	

	public void drawMe(Graphics g){
		int[] tailX = {x-17,x-6,x-18,x-6};
		int[] tailY = {y+12,y+12,y+37,y+37};
		g.setColor(yellow);
		g.fillOval(x,y,width,height);
		g.fillRect(x+34,y-15,8,20);
		g.fillRect(x+34,y-15,20,8);
		g.fillRect(x-12,y+21,15,8);
		g.fillPolygon(tailX,tailY,4);
		g.fillOval(x-17,y+6,10,10);
		g.fillOval(x-17,y+32,10,10);
		g.setColor(window);
		g.fillOval(x+40,y+12,25,25);
		g.fillOval(x+10,y+12,25,25);
		g.fillOval(x+50,y-20,8,15);
	}
	
	public void drawHeart(Graphics g, int i){
		int[] triY = {62,62,76};
		int[] triX = {50+i,76+i,63+i};
		g.setColor(red);
		g.fillPolygon(triX,triY,3);
		g.fillOval(48+i,50,15,15);
		g.fillOval(62+i,50,15,15);
	}
	
	public boolean checkShipColl(Enemy e){
		
		if(e.isAlive()){
			int sX = x;
			int sY = y;
			int sWidth = width;
			int sHeight = height;
			int tX = e.getX();
			int tY = e.getY();
			int tWidth = e.getWidth();
			int tHeight = e.getHeight();
			
			
			if( sX+sWidth >= tX && sX <= tX + tWidth  &&  sY+sHeight >= tY && sY <= tY + tHeight ){
				//System.out.println("Collision");	
				return true;
			}
		}
		return false;
	}
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
	
	public void moveUp(){
		y-=15;
	}
	
	public void moveDown(){
		y+=15;
	}
	
}