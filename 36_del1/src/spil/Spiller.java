package spil;

/**
 * Klassen: Spiller
 * @author gruppe 36
 *
 */
public class Spiller {

	private String navn;
	private int point;
	private int spiller_Nummer;

	/**
	 * Spiller klassens konstruktør.
	 * Tager to parametre, String 'navn' og int 'spiller_Nummer' 
	 * og gemmer dem hver især i klassens respektive variabler.
	 * Samt instantierer den private int 'point' i nul.
	 * @param navn Navnet på spiller
	 * @param spiller_Nummer Nummer på spiller
	 */
	public Spiller (String navn, int spiller_Nummer) {
		this.navn = navn;
		this.point = 0;
		this.spiller_Nummer = spiller_Nummer;
	}

	/**
	 * Tager imod en parameter af int 'nyPoint' og tilføjer den til den private int 'point'.
	 * @param nyPoint De point der skal tilføjes spillers point
	 */
	public void setPoint(int nyPoint) {
		point = point + nyPoint;
	}

	/**
	 * Retunerer spillers point.
	 * @return private int point
	 */
	public int getPoint() {
		return point;
	}

	/**
	 * Tager imod en parameter af String 'navn_spiller' og gemmer den i den private String 'navn'.
	 * @param navn_spiller Det nye navn spilleren skal have
	 */
	public void setNavn(String navn_spiller) {
		navn = navn_spiller;
	}
	
	/**
	 * Retunerer spillers navn.
	 * @return private String navn
	 */
	public String getNavn() {
		return navn;
	}
	
	/**
	 * Tager imod en parameter af int 'spiller_nr' og gemmer den i den private int 'spiller_Nummer'.
	 * @param spiller_nr Spillers nye nummer mellem 1 og 2.
	 */
	public void setSpiller_nr(int spiller_nr) {
		spiller_Nummer = spiller_nr;
	}
	
	/**
	 * Retunerer spillerens nummer.
	 * @return private int spiller_Nummer
	 */
	public int getSpiller_nr() {
		return spiller_Nummer;
	}
}
