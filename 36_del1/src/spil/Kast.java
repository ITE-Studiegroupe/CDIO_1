package spil;

/**
 * Klassen: Kast
 * @author gruppe 36
 *
 */
public class Kast {
	
	private int t1;
	private int t2;
	private int sum;
	
	/**
	 * Laver to instancer af Terning klassen, 
	 * kalder deres 'Kast' metode 
	 * og gemmer deres hentet værdi, via 'getVærdi' metoden, i de private int 't1' og 't2'.
	 * Dernest beregnes summen og gemmes i den private int 'sum'.
	 */
	public void kastTerninger() {
		
		Terning master1_terning = new Terning();
		master1_terning.Kast();
		t1 = master1_terning.getVærdi();
		
		Terning master2_terning = new Terning();
		master2_terning.Kast();
		t2 = master2_terning.getVærdi();
		
		sum = t1 + t2;
		
	}
	
	/**
	 * Retunerer summen.
	 * @return private int sum
	 */
	public int getSum() {
		return sum;
	}
	
	/**
	 * Retunerer værdien på terning 1.
	 * @return private int t1
	 */
	public int getVærdiTerning1() {
		return t1;
	}
	
	/**
	 * Retunerer værdien på terning 2.
	 * @return private int t2
	 */
	public int getVærdiTerning2() {
		return t2;
	}
}