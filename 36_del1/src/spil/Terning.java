package spil;

/**
 * Klassen: Terning
 * @author gruppe 36
 *
 */
public class Terning {
	private int terning;

	/**
	 * Beregner en tilfældig værdi mellem 1 og 6 inklusiv 
	 * og gemmer resultatet i en privat int 'terning'.
	 */
	public void Kast() {
		int terning;
		terning = ((int) (Math.random()*6)+1);
		this.terning = terning;
	}
	
	/**
	 * Retunerer den private int 'terning''s værdi.
	 * @return private int terning
	 */
	public int getVærdi() {
		return this.terning;
	}

}




