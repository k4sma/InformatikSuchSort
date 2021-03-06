import java.awt.EventQueue;

import java.util.Collections;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JCheckBox;


public class GUI {

	private JFrame frmArrays;
	private int[] meinArray = new int[21];
	ArrayGrid grid = new ArrayGrid();
	JScrollPane scrollPane = new JScrollPane(grid);
	private final JButton btn_lineareSuche = new JButton("lineare Suche");
	private final JButton btn_binaeresuche = new JButton("bin\u00E4re Suche");
	private final JTextField tfSuchwert = new JTextField();
	private final JTextField tfAusgabe = new JTextField();
	
	JCheckBox markReset;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.frmArrays.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUI() {
		initialize();
		addarray(meinArray);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		tfAusgabe.setBounds(10, 545, 515, 23);
		tfAusgabe.setColumns(10);
		tfSuchwert.setBounds(391, 443, 134, 23);
		tfSuchwert.setColumns(10);
		frmArrays = new JFrame();
		frmArrays.getContentPane().setForeground(Color.BLACK);
		frmArrays.setTitle("Arrays");
		frmArrays.setResizable(false);
		frmArrays.setBounds(100, 100, 555, 606);
		frmArrays.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmArrays.getContentPane().setLayout(null);
		
		grid.setLocation(0, 0);	
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(10, 10, 358, 524);
		frmArrays.getContentPane().add(scrollPane);

		JLabel lblGesuchtesElement = new JLabel("gesuchte Nummer:");
		lblGesuchtesElement.setHorizontalAlignment(SwingConstants.CENTER);
		lblGesuchtesElement.setBounds(391, 418, 134, 14);
		frmArrays.getContentPane().add(lblGesuchtesElement);	
	
		
		//Button "Array erzeugen" f�llt das Array mit Zufallswerten zwischen 1 und 200 ohne doppelte Werte
		
		JButton btn_newarray = new JButton("Array erzeugen");
		btn_newarray.setBounds(391, 10, 134, 23);
		btn_newarray.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				//definiere ArrayList f�r Integer Objekte 
				ArrayList<Integer> numbers = new ArrayList<Integer>();
				
				//f�ge die Zahlen von 1 bis 200 der Liste hinzu
				for(int i = 1; i < 200; i++)
				{	numbers.add(i);
				}
				
				//mische die Liste zuf�llig
				Collections.shuffle(numbers);
				
				//f�ge die ersten 20 Stellen der Liste dem Array hinzu
				for(int j =0; j < meinArray.length; j++)
				{
					meinArray[j]=numbers.get(j);
				}
				
				//zeige die Werte in Spalte 0 im Ausgabefenster an
				resetgrid();
			}
		});
		frmArrays.getContentPane().add(btn_newarray);
		
		//generiert einen kleinen array
		JButton btnSmolArray = new JButton("smol array");
		btnSmolArray.setBounds(391, 44, 134, 23);
		btnSmolArray.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				
				meinArray = new int[10];
				
				/*
				//f�ge werte dem Array zu
				meinArray[0] = 10;
				meinArray[1] = 9;
				meinArray[2] = 8;
				meinArray[3] = 7;
				meinArray[4] = 6;
				meinArray[5] = 5;
				meinArray[6] = 4;
				meinArray[7] = 3;
				meinArray[8] = 2;
				meinArray[9] = 1;
				//zeige die werte in spalte 0 im ausgabefeld an
				resetgrid();*/
				
				ArrayList<Integer> numbers = new ArrayList<Integer>();
				
				//f�ge die Zahlen von 1 bis 200 der Liste hinzu
				for(int i = 1; i < 200; i++)
				{
					numbers.add(i);
				}
				
				//mische die Liste zuf�llig
				Collections.shuffle(numbers);
				
				//f�ge die ersten 20 Stellen der Liste dem Array hinzu
				for(int j =0; j < meinArray.length; j++)
				{
					meinArray[j]=numbers.get(j);
				}
				
				//zeige die Werte in Spalte 0 im Ausgabefenster an
				resetgrid();
			}
		});
		frmArrays.getContentPane().add(btnSmolArray);

		//erhöht jeden wert um 1
		JButton btnHochzaehlen = new JButton("hochz\u00E4hlen");
		btnHochzaehlen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
								
				// Verarbeitung
				for(int i=0; i<meinArray.length; i++){
					meinArray[i]=meinArray[i]+1;
				}
				
				//Ausgabe
				addarray(meinArray);
				
			}
		});
		btnHochzaehlen.setBounds(391, 78, 134, 23);
		frmArrays.getContentPane().add(btnHochzaehlen);
		
		
		//multipliziert einen wert mit sich selber
		JButton btnQuadrieren = new JButton("quadrieren");
		btnQuadrieren.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(int i=0; i<meinArray.length; i++){
					meinArray[i]=meinArray[i]*meinArray[i];
				}
				
				addarray(meinArray);
				
			}
		});
		btnQuadrieren.setBounds(391, 146, 134, 23);
		frmArrays.getContentPane().add(btnQuadrieren);
		
		
		//mulipliziert den wert mit seinem index
		JButton btnMultiplizierenPosition = new JButton("multiplizieren Position");
		btnMultiplizierenPosition.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(int i=0; i<meinArray.length; i++){
					meinArray[i]=meinArray[i]*i;
				}
				
				addarray(meinArray);
				 
			}
		});
		btnMultiplizierenPosition.setBounds(391, 112, 134, 23);
		frmArrays.getContentPane().add(btnMultiplizierenPosition);
		
		
		//verdoppelt das kleinste element
		JButton btnKleinstesverdoppeln = new JButton("Kleinstes verdoppeln");
		btnKleinstesverdoppeln.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int smallest = meinArray[0];
				int smIndex = 0;
				
				for(int i=0; i<meinArray.length; i++){
					if(smallest > meinArray[i]){
						smallest = meinArray[i];
						smIndex = i;
					}
				}
				meinArray[smIndex] = meinArray[smIndex]*2;
				
				addarray(meinArray);
						
				
			}
		});
		btnKleinstesverdoppeln.setBounds(391, 180, 134, 23);
		frmArrays.getContentPane().add(btnKleinstesverdoppeln);
		
		//tauscht zwei anneinander grenzende werte
		JButton btnTauschen = new JButton("tauschen");
		btnTauschen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int curr;
				
				for(int i = 0; i < meinArray.length; i++){				
					if(i % 2 != 0){
						
						curr = meinArray[i];
						meinArray[i] = meinArray[i - 1];
						meinArray[i - 1] = curr;
						
					}				
				}
				addarray(meinArray);
				
				
				
				
			}
		});
		btnTauschen.setBounds(391, 214, 134, 23);
		frmArrays.getContentPane().add(btnTauschen);
		
		
		JButton btnBubbleSort = new JButton("bubblos sortos");
		btnBubbleSort.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Variablendefinition
				boolean found;
				int curr;
				
				//Verarbeitung
				do{
					found = false;
					for(int i = 1; i < meinArray.length; i++){
						if(meinArray[i] < meinArray[i - 1]){
							found = true;
							curr = meinArray[i];
							meinArray[i] = meinArray[i - 1];
							meinArray[i - 1] = curr;
						}
					}
				} while(found);
				

				//Ausgabe
				addarray(meinArray);
			}
		}); 
		btnBubbleSort.setBounds(391, 248, 134, 23);
		frmArrays.getContentPane().add(btnBubbleSort);
		
		//selection sort
		JButton btnSelctionSort = new JButton("sortos selectos");
		btnSelctionSort.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//variablen
				int curr;
				
				//algorithmus
				for (int i = 0; i < meinArray.length - 1; i++) {
					for (int j = i + 1; j < meinArray.length; j++) {
						if (meinArray[i] > meinArray[j]) {
							curr = meinArray[i];
							meinArray[i] = meinArray[j];
							meinArray[j] = curr;
						}
					}
				}
				
				//array hinzufügen
				addarray(meinArray);
				
			}
		}); 
		btnSelctionSort.setBounds(391, 282, 134, 23);
		frmArrays.getContentPane().add(btnSelctionSort);
		
		//insertion sort
		JButton btnInsertionSort = new JButton("sortos insertus");
		btnInsertionSort.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				
				//variablen
				int curr;
				
				//algorithmus
				for (int i = 1; i < meinArray.length; i++) {
					curr = meinArray[i];
					int j = i;
					while (j > 0 && meinArray[j - 1] > curr) {
						meinArray[j] = meinArray[j - 1];
						j--;
					}
					meinArray[j] = curr;
				}
				
				//array hinzufügen
				addarray(meinArray);
			}
		});
		btnInsertionSort.setBounds(391, 316, 134, 23);
		frmArrays.getContentPane().add(btnInsertionSort);
		
		
		//Button "lineare Suche"
		btn_lineareSuche.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Variablendefinition
				int suchwert = Integer.parseInt(tfSuchwert.getText());
				int ausgabeIndex = -1;
				
				
				//Suchen
				
				for(int i=0; i<meinArray.length; i++){
					if(meinArray[i]==suchwert){
						ausgabeIndex=i;
					}
				}
				
				//Ausgabe
				if(meinArray[ausgabeIndex]==suchwert){
					tfAusgabe.setText("Der Wert "+ suchwert + " befindet sich am Index: "+ausgabeIndex + "!");
				}else{
					tfAusgabe.setText("Der Wert " +suchwert+ " ist nicht vorhanden!");
				}
				
				
			}
		});
		btn_lineareSuche.setBounds(391, 477, 134, 23);
		frmArrays.getContentPane().add(btn_lineareSuche);
		
		//binäre suche (IN BEARBEITUNG)
		btn_binaeresuche.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//SORTIEREN
				//Variablendefinition
				boolean found;
				int curr;
				
				//Verarbeitung
				do{
					found = false;
					for(int i = 1; i < meinArray.length; i++){
						if(meinArray[i] < meinArray[i - 1]){
							found = true;
							curr = meinArray[i];
							meinArray[i] = meinArray[i - 1];
							meinArray[i - 1] = curr;
						}
					}
				} while(found);
				//END SORTIEREN
				
				
				//Variablendefinition
				int search = Integer.parseInt(tfSuchwert.getText());
				int index = meinArray.length / 2;
				int iSize = meinArray.length / 2;
					
				//Suchen
				while(!found){
					if(meinArray[index] != search){
						iSize /= 2;
					} else {
						found = true;
						addarray(meinArray);
					}
					
					if(meinArray[index] > search){				
						index += iSize;
					} else {
						index -= iSize;
					}
				}

				//Ausgabe
				

			}
		}


			);
		btn_binaeresuche.setBounds(391, 511, 134, 23);
		frmArrays.getContentPane().add(btn_binaeresuche);
		
		frmArrays.getContentPane().add(tfSuchwert);
		
		frmArrays.getContentPane().add(tfAusgabe);
		
		markReset = new JCheckBox("Reset?");
		markReset.setBounds(391, 388, 97, 23);
		frmArrays.getContentPane().add(markReset);
		
	}		
		
	private void addarray(int[] array){
		grid.addarray(array);	
		scrollPane.setViewportView(grid);
		
		if(markReset.isSelected()){
			resetgrid();
		}
	}
	
	private void resetgrid(){
		grid.setarray(meinArray);
	}
}