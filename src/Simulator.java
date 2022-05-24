import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Simulator extends Frame{
	
	private int windowWidth = 200;
	private int windowHeight = 400;
	private Button start = new Button("Pokreni!");
	private Svemir svemir = new Svemir();
	private Generator generator = new Generator(svemir);
	private Panel buttonPane = new Panel();
	
	private void populateWindow() {
		
		start.addActionListener((ae) ->{
			start.setEnabled(false);
			svemir.start();
			generator.start();
		});
			
		buttonPane.add(start);
		svemir.setBackground(Color.BLACK);
		add(buttonPane, BorderLayout.SOUTH);
		add(svemir, BorderLayout.CENTER);
		svemir.dodaj(new Kometa(100,100,20));
	}
	
	public Simulator(){
		setBounds(700, 200, windowWidth, windowHeight);
		
		setResizable(false);
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				// setVisible(false);
				dispose();
			}
		});

		
		populateWindow();
	
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Simulator();
	}
}
