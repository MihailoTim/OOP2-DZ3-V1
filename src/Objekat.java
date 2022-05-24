import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Shape;

public abstract class Objekat implements Cloneable {
	protected int centerX,centerY;
	protected static Color color;
	
	public Objekat(int x, int y, Color c) {
		this.centerX = x;
		this.centerY = y;
		color = c;
	}

	public int getCenterX() {
		return centerX;
	}

	public void setCenterX(int delta) {
		this.centerX += delta;
	}

	public int getCenterY() {
		return centerY;
	}

	public void setCenterY(int delta) {
		this.centerY += delta;
	}
	
	public static Color getColor() {
		return color;
	}
	
	public Objekat clone() {
		try {
			return (Objekat) super.clone();
		} catch (CloneNotSupportedException e) { return null; }
	}
	
	public abstract void paint(Graphics g);
}
