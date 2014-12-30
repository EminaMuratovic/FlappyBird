import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Stack;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;


public class GameGraphics extends JPanel implements ActionListener{

	private Timer animation;
	private Body [] elements;
	private int elementsCounter;
	private Body player;
	private Date start;
	
	
	public GameGraphics (int width, int height){
		super();
		animation = new Timer(1000/60, this);
		elements = new Body[10];
		elementsCounter = 0;
		//Ovo smo stavili samo radi debugginga
		elementsCounter = 0;
		//elements[0] = new Oval(450, 370, randomRadius(), randomRadius(), Color.RED, randomSpeed(), 0, 0, 0, 500, 500-100);
		for(int i = 0; i < 10; i++) {
			elements[i] = addOval();
			elementsCounter++;
		}
		player = new Oval(100, height - 100 - 40, 40, 40, Color.BLUE, 0, 0, 0, 0, width, height - 100);
		animation.start();
		start = new Date();
		addKeyListener(new KeyHandler());
	}
	public Oval addOval() {
		Oval oval = new Oval(randomPlace(), 370, randomRadius(), randomRadius(), Color.RED, randomSpeed(), 0, 0, 0, 500, 500-100);
		return oval;
		
	}
	
	public int randomPlace() {
		int place = (int)(500 + Math.random() * 1000);
		return place;
	}
	
	public int randomRadius() {
		int radius = (int)(10 + Math.random() * 25);
		return radius;
	}
	
	public int randomSpeed() {
		int speed = (int) (1 + Math.random() * 2);
		return -speed;
	}
	
	
	@Override
	public void paintComponent(Graphics g){
		Date end = new Date();
		long points = end.getTime() - start.getTime();
				
		super.paintComponent(g);
		this.setBackground(new Color(184,242,245));
		g.setColor(new Color(54, 140, 22));
		g.fill3DRect(0, 400, 500, 100, true);
		for(int i=0; i<elementsCounter;i++){
			elements[i].draw(g);
			if(player.checkCollision(elements[i]) == true) {
				animation.stop();
				JOptionPane.showMessageDialog(null, "Izgubio si");
				break;
			}
			//elements[i].jump();
		}
		player.draw(g);
		g.drawString(Long.toString(points), 50, 50);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		repaint();
	}
	
	private class KeyHandler extends KeyAdapter {
		
		public void keyTyped(KeyEvent e) {
			player.jump();
		}
	}
}
