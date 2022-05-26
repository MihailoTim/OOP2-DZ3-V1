import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Simulator extends Frame{
	
	private final int windowWidth = 200;
	private final int windowHeight = 400;
	private Button start = new Button("Pokreni!");
	private Space space = new Space();
	private Generator generator = new Generator(space);
	private Panel buttonPanel = new Panel();
	
	public Simulator(){
		setBounds(700, 200, windowWidth, windowHeight);
		
		setResizable(false);
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				dispose();
			}
		});
		
		populateWindow();
		
		setVisible(true);
	}
	
	private void populateWindow() {
		
		start.addActionListener((ae) ->{
			start.setEnabled(false);
			space.start();
			generator.start();
		});
			
		buttonPanel.add(start);
		space.setBackground(Color.BLACK);
		add(buttonPanel, BorderLayout.SOUTH);
		add(space, BorderLayout.CENTER);
	}
	
	public static void main(String[] args) {
		new Simulator();
	}
}
