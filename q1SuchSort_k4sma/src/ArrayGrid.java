import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class ArrayGrid extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int counterx = 0;
	private int countery = 0;
	private int showlines = 1;
	private Dimension d = new Dimension(0,0);
	/**
	 * Create the panel.
	 */
	public ArrayGrid() {
		this.setLayout(null);
	}
	
	public void addarray(int[] array) {
		if(counterx==0){
			for(int i=0; i <array.length; i++) {
				JLabel label = new JLabel(String.valueOf(i)+":");
				label.setFont(new Font("Arial", Font.BOLD, 9));
				label.setBounds(5+17*this.counterx, 5+this.showlines*22+22*i, 15, 20);
				label.setHorizontalAlignment(JLabel.CENTER);
				this.add(label);
			}
		}
		
		if(showlines==1){
			JLabel label1 = new JLabel(String.valueOf(counterx)+":");
			label1.setBounds(25+85*this.counterx, 5, 80, 20);
			label1.setFont(new Font("Arial", Font.BOLD, 9));
			label1.setHorizontalAlignment(JLabel.CENTER);
			this.add(label1);
		}
	
		for(int i=0; i <array.length; i++) {
			JLabel label = new JLabel(String.valueOf(array[i]));
			label.setFont(new Font("Arial", Font.BOLD, 9));
			label.setBounds(25+85*this.counterx, 5+this.showlines*22+22*i, 80, 20);
			label.setOpaque(true);
			label.setBackground(new Color(255, 255, 255));
			label.setHorizontalAlignment(JLabel.CENTER);
			this.add(label);
			if(i >= countery)
				countery = i+1;	
		}
		counterx++;
		update();	
	}
	
	public void setarray(int[] array) {
		reset();
		addarray(array);
		update();
	}
	
	public void showlines(boolean b){
		this.showlines = b? 1 : 0;
	}
	
	private void update() {
		d = new Dimension(5+this.showlines*18+85*counterx,5+25*countery);
		setSize(d);
		setPreferredSize(d);
	}
	
	public void reset() {
		this.removeAll();
		counterx = 0;
		countery = 0;
		this.d = new Dimension(0,0);
		update();
	}
	
}