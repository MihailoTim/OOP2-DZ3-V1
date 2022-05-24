
public class Generator implements Runnable{
	Thread thread;
	private int sleepTime = 900;
	Svemir svemir;
	
	Generator(Svemir s){
		thread = new Thread(this);
		svemir = s;
	}

	@Override
	public void run() {
		try {
			while(true) {
				int xcoord = (int)(Math.random()*200);
				int radius = (int)(Math.random()*20) + 10;
				svemir.dodaj(new Kometa(xcoord, 0, radius));
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
