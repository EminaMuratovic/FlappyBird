import java.awt.Color;
import java.awt.Graphics;

public class Body {
	
	private Point startPoint;
	private Point centerPoint;
	private int width;
	private int heigth;
	private Color color;
	private int speedX;
	private int speedY;
	private int minX;
	private int minY;
	private int maxX;
	private int maxY;
	private int acc;
	
	
	public Body ( int x, int y, int width, int heigth, Color color, int speedX, int speedY, int minX, int minY, int maxX, int maxY){
		
		startPoint = new Point(x, y);
		this.width = width;
		this.heigth = heigth;
		this.color = color;		
		centerPoint = new Point(x+width/2, y+heigth/2); // Centar tacka sa novim x i y koordinatama.		
		this.speedX = speedX;
		this.speedY = speedY;
		this.maxX = maxX;
		this.maxY = maxY;
		this.minX = minX;
		this.minY = minY;
		this.acc = 0;
		
	}
	
	public void draw(Graphics g){
		move();
		g.setColor(color);
		return;
	}
	/**
	 * Funkcija provjerava da li je doslo do sudara dva tijela.
	 * @param other
	 * @return
	 */
	public boolean checkCollision(Body other){
		int d = centerPoint.getDistance(other.centerPoint);
		
		if( d <= width/2 + other.width/2)
			return true;
		
		else if (d <= heigth/2 + other.heigth/2)
			return true;
		
		else return false;
					
	}
	
	private void move (){
		
		speedY += acc;
		//Uslovi za x kordinate, ne dozvoljavamo da se krece van okvira
		if(this.getX() +this.getWidth() + speedX >= maxX  && speedX > 0){
			speedX = 0;
			this.startPoint.setX(maxX -  width);
			this.centerPoint.setX(maxX - width/2);
		}
		System.out.println(this.getX()+speedX + " " + minX  + " " + speedX);
		if(this.getX() + speedX <= minX   && speedX < 0){
			System.out.println("mm");
			speedX = 0;
			this.startPoint.setX(minX);
			this.centerPoint.setX(minX + width/2);
		
		}
		//Uslovi za y kordinate, ne dozvoljavamo da se krece van okvira
		
		if(this.getY() + this.getHeigth() +speedY  >= maxY  && speedY > 0){
			speedY = 0;
			this.startPoint.setY(maxY - heigth);	// postavljamo novu poziciju Y
			this.centerPoint.setY(maxY - heigth/2);	// Postavljamo novu poziciju tacke centar za Y
		}
		
		if(this.getY() + speedY <= minY && speedY < 0){
			speedY = 0;				
			this.startPoint.setY(minY);				// Postavljamo pocetnu poziciju tacke za Y
			this.centerPoint.setY(minY + heigth/2);	// Identicno samo za centralnu tacku
		}
		
		this.startPoint.move(speedX, speedY);
		this.centerPoint.move(speedX, speedY);
		
	}
	
	public int getX(){
		return startPoint.getX();
	}
	
	public int getY(){
		return startPoint.getY();
	}

	public Point getStartPoint() {
		return startPoint;
	}

	
	public Point getCenterPoint() {
		return centerPoint;
	}

	

	public int getWidth() {
		return width;
	}

	

	public int getHeigth() {
		return heigth;
	}

	public void jump() {
		if(startPoint.getY() == maxY - heigth)
			{
			speedY = -20;
			acc = 1;
			}
	}
	
	

	

}
