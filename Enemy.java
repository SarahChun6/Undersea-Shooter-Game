import java.awt.Color;
import java.awt.Graphics;

public class Enemy{
	
	private int x;
	private int y;
	private int moveY;
	private int speed;
	
	private int width;
	private int height;
	
	private Color black;
	private Color orange;
	private boolean alive;
	
	public Enemy(int x, int y, int s){
		
		this.speed = s;
		this.x = x;
		this.y = y;
		this.moveY = 0;
		
		this.width = 35;
		this.height = 25;
		
		this.black = new Color(0,0,0);
		this.orange = new Color(255,140,0);
		this.alive = true;
	
	}
	

	public void drawBad(Graphics g){
		if(alive){	
			int[] tailX = {25+x,50+x,50+x};
			int[] tailY = {12+y,y,25+y};
			g.setColor(black);
			g.fillOval(x,y,width,height);
			g.fillPolygon(tailX,tailY,3);
		}
	}	
	
	
	public void kill(){
		alive = false;
	}
		
	public boolean isAlive(){
		return alive;
	}
	
	public void move(int i){
		
		if(x<1001 && alive){
			x-=speed;
			if(x==700||x==701){
				y+=20;
			}else if(x==500||x==501){
				y-=20;
			}else if(x==300||x==301){
				y+=20;
			}
		}
	}
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
	
	public int getWidth(){
		return width;
	}
	
	public int getHeight(){
		return height;
	}

}
