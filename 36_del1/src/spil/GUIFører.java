package spil;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.CountDownLatch;

import javax.swing.JButton;

import desktop_board.Board;
import desktop_fields.Field;
import desktop_fields.Street;
import desktop_resources.GUI;

/**
 * Klassen: GUIFører
 * @author gruppe 36
 *
 */
public class GUIFører {
	private String spillerNavn1;
	private String spillerNavn2;
	private Field[] felter = new Field[2];
	private Board board;
	private static GUIFører instance;
	private boolean erSkabt = false;
	
	/**
	 * Den private konstruktør
	 */
	private GUIFører () {
		
	}
	
	/**
	 * Henter singleton instancen
	 * @return GUIFører instancen
	 */
	public static GUIFører getInstance() {
		if(instance == null) {
			instance = new GUIFører();
		}
		return instance;
	}
	
	/**
	 * Tager imod to parametre, af typen Spiller, 'spiller1' og 'spiller2'. 
	 * Henter navnet på begger spiller, via 'getNavn()' metoden, og gemmer den i de to private String 'spillerNavn1' og 'spillerNavn2'.
	 * Felterne til spillet bygges med spillernes navn og point og skaber spillepladen.
	 * @param spiller1 Spiller 1
	 * @param spiller2 Spiller 2
	 */
	public void skabSpillePlade(Spiller spiller1, Spiller spiller2) {
		spillerNavn1 = spiller1.getNavn();
		spillerNavn2 = spiller2.getNavn();
		
		//Tjekker om metoden allerede er kørt før (ved genstart af spil er denne sand).
		//Hvis sand ændres navnet og point bare på de allerede instancieret felter.
		if (erSkabt) {
			felter[0].setTitle(spillerNavn1);
			felter[0].setDescription(spillerNavn1);
			felter[0].setSubText("Point: 0");
			
			felter[1].setTitle(spillerNavn2);
			felter[1].setDescription(spillerNavn2);
			felter[1].setSubText("Point: 0");
		}
		//Ellers hvis falsk instancieres/bygges de to felter vi bruger til at holde på spillernes navn og point.
		else {
			felter[0] = new Street.Builder()
					.setTitle(spillerNavn1)
					.setDescription(spillerNavn1)
					.setSubText("Point: 0")
					.setBgColor(Color.white)
					.build();
			felter[1] = new Street.Builder()
					.setTitle(spillerNavn2)
					.setDescription(spillerNavn2)
					.setSubText("Point: 0")
					.setBgColor(Color.white)
					.build();
			GUI.create(felter);
			
			erSkabt = true;
		}
		
		
		
		String besked = "Velkommen til terning spillet, første spiller som får 40 point vinder! \n Tryk \"Start\" for at begynde.";
		visBesked(besked,"Start");
	}
	
	/**
	 * Tager imod en parameter af typen Spiller 'spiller',
	 * henter spillerens point, via 'getPoint()' metoden, og gemmer dem i en int 'point'.
	 * Dernest tjekkes hvilken spiller der er tale om, via 'getSpiller_nr()' metoden, 
	 * og point opdateres respektivt i feltet.
	 * @param spiller Spilleren
	 */
	public void visSpillerPoint (Spiller spiller) {
		int point = spiller.getPoint();
		
		//Henter spillers nummer.
		switch (spiller.getSpiller_nr()) {
		//Hvis case 1: opdateres point feltet for spiller 1.
		case 1:
			felter[0].setSubText("Point: " + point);
			break;
		//Hvis case 2: opdateres point feltet for spiller 2.
		case 2:
			felter[1].setSubText("Point: " + point);
			break;
		}
	}
	
	/**
	 * Tager imod to parametre af typen int, 'terning1' og 'terning2'. 
	 * Viderefører dem i GUI metoden 'setDice()', som viser et terning kast på spillepladen.
	 * @param terning1 Første terning
	 * @param terning2 Anden terning
	 */
	public void visTerningKast(int terning1, int terning2) {
		GUI.setDice(terning1, terning2);
	}
	
	/**
	 * Tager imod en parameter Spiller 'spiller'.
	 * Henter spillerens navn, via 'getNavn()' metoden, og gemmer dem i en String 'navn'.
	 * En spillers 'navn' + ", din tur til at kaste" gemmes i en String 'besked'.
	 * 'besked' vises ved at kalde 'visBesked()'.
	 * @param spiller Respektive spillers navn
	 */
	public void næsteTur (Spiller spiller) {
		String navn = spiller.getNavn();
		String besked = navn + ", din tur til at kaste.";
		
		visBesked(besked,"Kast terninger");
	}
	
	/**
	 * Tager imod en parameter Spiller 'spiller'.
	 * Henter spillerens navn, via 'getNavn()' metoden, og gemmer dem i en String 'navn'.
	 * En spillers 'navn' + ", du har vundet" gemmes i en String 'besked'.
	 * 'besked' vises ved at kalde 'visBesked()'.
	 * @param spiller Respektivt spillernavn af vinder.
	 */
	public void spillerHarVundet (Spiller spiller) {
		String navn = spiller.getNavn();
		String besked = navn + ", du har vundet!.";
		
		visBesked(besked,"Genstart");
	
	}
	
	
	/**
	 * Taget fra BoardController klassen (linje: 53) i desktop_board pakken i GUI.jar
	 * og omksrevet en annelse så det passede vores kriterier.<br>
	 * Tager imod parametre String 'besked' og String 'knapTekst' 
	 * og bruger dem til at vise en besked (som i GUI'ens 'showMessage()' metoden)
	 * med egen tekst på knappen.
	 * 
	 * @param besked Beskeden der vises over knappen
	 * @param knapTekst Teksten der står på knappen
	 */
	private void visBesked(String besked, String knapTekst) {
		board = Board.getInstance();
		final CountDownLatch latch = new CountDownLatch(1);
		JButton knap = new JButton(knapTekst);
		knap.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				GUIFører.this.board.clearInputPanel();
				latch.countDown();
			}
		});
		this.board.getUserInput(besked, knap);
		try {
			latch.await();
		} catch(InterruptedException ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * Kalder GUI klassens 'close()' metode.<br>
	 * Lukker for spillepladen.
	 */
	public void luk() {
		GUI.close();
		//instance = null;
		
		
	}
	
	
	

}
