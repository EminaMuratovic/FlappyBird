
public class Point {

	private int x;
	private int y;
	
	public Point ( int x, int y){
		this.x = x;
		this.y = y;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getX() {
		return x;
	}

	
	public int getY() {
		return y;
	}

	public int getDistance(Point other){
		// Formula za racunanje distance dvije tacke.
		return (int) Math.sqrt(Math.pow(other.x - this.x, 2) + Math.pow(other.y - this.y, 2));
	}

	public void move (int speedX, int speedY){
		this.x += speedX;
		this.y += speedY;
	}
	
	
}
