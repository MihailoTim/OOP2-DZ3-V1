import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Vector;

public class Space extends Canvas implements Runnable{
	
	private Vector<NebeskoTelo> v;
	private int sleepTime = 100;
	Thread thread;
	
	Space(){
		v = new Vector<NebeskoTelo>();
		setBackground(Color.BLACK);
		thread = new Thread(this);
		thread.setDaemon(true);
	}
	
	@Override
	public void paint(Graphics g) {
		g.setColor(Color.GRAY);
		for(NebeskoTelo t:v)
			t.paint(g);
	}


	@Override
	public void run() {
		try {
			while(true) {
				for(NebeskoTelo t:v)
					t.moveCenterY(5);
				repaint();
				thread.sleep(sleepTime);
			}
		}
		catch(InterruptedException e) {}
	}

	public void start() {
		thread.start();
	}
	
	public void stop() {
		thread.interrupt();
	}
	
	public void add(NebeskoTelo t) {
		v.add(t);
	}
	
}
