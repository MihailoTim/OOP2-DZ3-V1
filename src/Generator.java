
public class Generator implements Runnable{
	Thread thread;
	private int sleepTime = 900;
	Space space;
	
	Generator(Space s){
		thread = new Thread(this);
		thread.setDaemon(true);
		space = s;
	}

	@Override
	public void run() {
		try {
			while(true) {
				int xcoord = (int)(Math.random()*200);
				int radius = (int)(Math.random()*20) + 10;
				space.add(new Comet(xcoord, 0, radius));
				thread.sleep(900);
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
	
	
}
