import java.awt.Color;
import java.awt.Graphics;

public class Background{
	
	public void drawSeaweed(Graphics g, int stage, int x){
		
		Color seaweed = new Color (50,205,50);
		Color water = new Color (128,222,255);
		if (stage ==1){
			seaweed = new Color (34,139,34);
			water = new Color (32,178,170);
		}
		
		for(int i = 0; i < 1601; i += 320){
			for(int j = 50; j < 150; j+=49){
				g.setColor(seaweed);
				g.fillOval(0+i+x,540-j,25,50);
				if(j%2==1){	
					g.setColor(water);
					g.fillRect(12+i+x,540-j,13,50);
				}
				if(j%2==0){	
					g.setColor(water);
					g.fillRect(0+i+x,540-j,13,50);
				}
			}
			for(int j = 30; j < 150; j+=49){
				g.setColor(seaweed);
				g.fillOval(160+i+x,540-j,25,50);
				if(j%2==1){	
					g.setColor(water);
					g.fillRect(160+i+x,540-j,13,50);
				}
				if(j%2==0){	
					g.setColor(water);
					g.fillRect(172+i+x,540-j,13,50);
				}
			}
		}
	}
	
	public void drawSand(Graphics g, int stage, int x){
		
		Color sand = new Color (238,232,170);
		Color water = new Color (128,222,255);
		if (stage ==1){
			sand = new Color (240,230,140);
			water = new Color (32,178,170);
		}
		g.setColor(sand);
		g.fillRect(0,550,1800, 50);
		for(int i = -50; i < 1600; i+=320)
			g.fillOval(0+i+x,540,200,50);
			
		g.setColor(water);
		for(int i = 110; i < 1800; i+=320)
			g.fillOval(0+i+x,510,200,50);
	}
	
}