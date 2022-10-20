import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Dimension;

import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class Screen extends JPanel implements KeyListener{

	private Projectile p1;
	private Ship s1;
	private Projectile p2;
	private Ship s2;
	private Background b;
	public int totalEnemiesAlive;
	private Enemy[] eneb;
	private int[] randXb;
	private int[] randYb;
	private int[] speedb;
	private Enemy[] eneg;
	private int[] randXg;
	private int[] randYg;
	private int[] speedg;
	private int stage;
	private int shipLives;
	private int restart;
	private int speed;
	private int eneNum;
	private int backX;
	private Bubbles[] bub;
	private Color water;
	private Color white;
	
	public Screen(int stage, int shipLives){
		
		this.backX = 0;
		this.restart = 0; // when enemies hits wall --> 1
		this.stage = stage;
		this.shipLives = shipLives;
		white = new Color (255,255,255);
		
		if (stage == 0){
			water = new Color (128,222,255);
			eneNum = 3;
			speed = 1;
			totalEnemiesAlive = 3;
		} else if (stage ==1){
			water = new Color (32,178,170);
			eneNum = 5;
			speed = 2;
			totalEnemiesAlive = 5;
		} else if (stage ==2){
			water = new Color (0,0,0);
		}
		b = new Background();
		s1 = new Ship(50,300);
		p1 = new Projectile(50,320);
		s2 = new Ship(50,200);
		p2 = new Projectile(50,220);
	
		randXb = new int[eneNum];
		for(int i=0; i<randXb.length; i++){
			randXb[i] = (int)(Math.random()*201+800);
		}
		randYb = new int[eneNum];
		for(int i=0; i<randYb.length; i++){
			randYb[i] = (int)(Math.random()*325+100);
		}
		eneb = new Enemy[eneNum];
		for(int i=0; i<eneb.length;i++){
			eneb[i] = new Enemy(randXb[i], randYb[i], speed);
		}
		bub = new Bubbles[50];
		for(int i=0; i < bub.length; i++){
			bub[i] = new Bubbles();
		}

        setFocusable(true);
		addKeyListener(this);
	}

	public Dimension getPreferredSize() {
		//Sets the size of the panel
        	return new Dimension(800,600);
	}
	
	public void paintComponent(Graphics g) {
        super.paintComponent(g);
	
		if(stage==2){
			g.setColor(water);
			g.fillRect(0, 0, 800, 600);
			g.setColor(white);
			g.drawString("You Win!", 400, 300);
			return;
		}

		g.setColor(water);
		g.fillRect(0, 0, 1800, 600);
		
		for(int i=0; i < bub.length; i++){
			bub[i].drawMe(g);
		}
		b.drawSand(g, stage, backX);
		b.drawSeaweed(g, stage, backX);
	
		//Draw ship
		s1.drawMe(g);
		s2.drawMe(g);
		
		for(int i = 0; i < shipLives; i++){
			s1.drawHeart(g,i*50);
		}
		
		//Draw Projectile
		p1.drawMe(g);
		p2.drawMe(g);

		//Draw enemies
		for(int i=0; i<eneb.length; i++)
			eneb[i].drawBad(g);
			
	} 


	public void animate(){
		
		while(true){
			
			//move projectile
			p1.move();
			p2.move();
			
			//reset projectile 
			//when proj is offscreen
				//bring back to ship
				//change fire to false
			if(p1.getX()>800){
				p1.reset(s1.getX(),s1.getY());
			}
			if(p2.getX()>800){
				p2.reset(s2.getX(),s2.getY());
			}
			
			
			
			//detect how many enemies are dead (score?)
			//create a total var set to 0
			//go thru ene array
				//if isAlive() == false
					//total++
			//if total == 3?
				//move to next level
				
				
			
			//check collision w each enemy
			for(int i=0; i<eneb.length; i++){
				if(p1.checkProjColl(eneb[i])){
					totalEnemiesAlive--; 
				}
				if(p2.checkProjColl(eneb[i])){
					totalEnemiesAlive--; 
				}
				if(s1.checkShipColl(eneb[i])){
					restart = 1;
					break; 
				}
				if(s2.checkShipColl(eneb[i])){
					restart = 1;
					break; 
				}
				eneb[i].move(i);
				if(eneb[i].getX()<= 0){// enemies hit the wall
					restart = 1;
					break;
				}
			}
			if(restart == 1){ 
				break;
			}
			
			backX--;
			for(int i=0; i<bub.length; i++){
				bub[i].move(); 
			}
			
			//wait for .01 second
			try {
			    Thread.sleep(10);
			} catch(InterruptedException ex) {
			    Thread.currentThread().interrupt();
			}
			
			//repaint the graphics drawn
			repaint();
			
			if(areAllEnemiesDead()){
				break;
			}
		}
	}
	
	public void keyPressed(KeyEvent e){
		//System.out.println(e.getKeyCode());
		
		if(e.getKeyCode()==38){ // up
			s1.moveUp(); 
			p1.moveUp();
		}else if (e.getKeyCode()==40){ // down
			s1.moveDown(); 
			p1.moveDown();
		}else if(e.getKeyCode()==39){ // right
			p1.fire();
		}else if (e.getKeyCode()==87){ // w
			s2.moveUp(); 
			p2.moveUp();
		}else if (e.getKeyCode()==83){ // s
			s2.moveDown(); 
			p2.moveDown();
		}else if (e.getKeyCode()==68){ // d
			p2.fire();
		}else if (e.getKeyCode()==80){ // p
			totalEnemiesAlive = 0;
		}
		
	}
	
	public boolean areAllEnemiesDead(){
		return (totalEnemiesAlive == 0);
	}
	
	
	public void keyReleased(KeyEvent e){}
	public void keyTyped(KeyEvent e){}

}