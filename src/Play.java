import javax.swing.JFrame;


public class Play {
public static void main(String[] args) {
	
	JFrame game = new JFrame("JUMPER");
	game.setSize(500,500);
	game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	GameGraphics graphicElements = new GameGraphics(500, 500);
	
	game.setContentPane(graphicElements);
	game.setVisible(true);
	graphicElements.requestFocus(false); 
}
}
