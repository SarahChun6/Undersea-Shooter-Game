import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Dimension;


public class Runner {
  
	private static int shipLives = 3;
		
	public static void main(String[] args) {
		

		boolean isEndgame = false;
		int stage = 0;
		int level;
		Screen sc;
		JFrame frame;
		System.out.println();
		System.out.println("Game Guidelines:");
		System.out.println("	Shoot the black fish!");
		System.out.println("	If they hit either submarine...");
		System.out.println("	... or they reach the right side of the screen...");
		System.out.println("	... you lose one of your three lives!");
		System.out.println("	When you lose all three lives the game restarts.");
		System.out.println("Controls:");
		System.out.println("	top submarine up --> w");
		System.out.println("	top submarine down --> s");
		System.out.println("	top submarine fire --> d");
		System.out.println("	bottom submarine up --> up arrow");
		System.out.println("	bottom submarine down --> down arrow");
		System.out.println("	bottom submarine fire --> right arrow");
		
		while(!isEndgame){
			
			level = stage + 1;
			frame = new JFrame("Level "+level);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			//Create panel and add it to the frame
			sc = new Screen(stage, shipLives);
			frame.add(sc);
			frame.pack();
			frame.setVisible(true);
			frame.setResizable(false);
			sc.animate();
		
			if(stage==0 && sc.areAllEnemiesDead()){
				stage++;
			}else if(stage==1 && sc.areAllEnemiesDead()){
				isEndgame = true;
			}else{
				shipLives--;
				if(shipLives == 0){
					shipLives = 3;
					stage = 0;
				}
			}	
		}
		frame = new JFrame("End Screen");

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//Create panel and add it to the frame
		
		stage = 2;
		sc = new Screen(stage, shipLives);
		
		frame.add(sc);
		frame.pack();
		frame.setVisible(true);
		frame.setResizable(false);
		
    }
	

}