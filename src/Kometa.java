import java.awt.Color;
import java.awt.Graphics;

public class Kometa extends NebeskoTelo {
	
	private double rotationAngle = 72 * 2 * Math.PI / 360;
	private int referencePointX = this.centerX;
	private int referencePointY = this.centerY + this.radius;
	private int[] xpoints = new int[5];
	private int[] ypoints = new int[5];
	
	public Kometa(int x, int y, int r) {
		super(x, y, Color.GRAY, r);
		double randAngle = Math.random() * 360;
		int newRefX = rotateX(referencePointX, referencePointY, randAngle);
		int newRefY = rotateY(referencePointX, referencePointY, randAngle);
		referencePointX = newRefX;
		referencePointY = newRefY;
		generatePoints();
	}
	
	public static Color getColor() {
		return Color.GRAY;
	}
	
	private int rotateX(int refX, int refY, double angle) {
		double x1 = refX - centerX;
		double y1 = refY - centerY;
		
		double x2 = x1 * Math.cos(angle) - y1 * Math.sin(angle);
		
		return (int)(x2 + centerX);
	}
	
	private int rotateY(int refX, int refY, double angle) {
		double x1 = refX - centerX;
		double y1 = refY - centerY;
		
		double y2 = x1 * Math.sin(angle) + y1 * Math.cos(angle);
		
		return (int)(y2 + centerY);
	}

	private void generatePoints() {
		xpoints[0] = referencePointX;
		ypoints[0] = referencePointY;
		for(int i=1;i<5;i++) {
			xpoints[i] = rotateX(xpoints[i-1], ypoints[i-1], rotationAngle);
			ypoints[i] = rotateY(xpoints[i-1], ypoints[i-1], rotationAngle);
		}
	}
	
	public void paint(Graphics g) {
		g.fillPolygon(xpoints, ypoints, 5);
	}
	
	@Override
	public void setCenterY(int delta) {
		centerY+=delta;
		for(int i=0;i<5;i++)
			ypoints[i]+=delta;
	}
}
