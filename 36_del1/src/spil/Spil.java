package spil;

import java.util.Scanner;

public class Spil {

	public static void main(String[] args) {

		GUIFører spilleBræt;
		Scanner s;
		
		while(true) {
			int nr = 1;
			String input;
			Spiller[] spillere = new Spiller[2];
			Kast kast = new Kast();
			
			s = new Scanner(System.in);

			System.out.println("\n\n\n\n" +
					"# # # # # # # # # # # # # # # # # # # # #\n" + 
					"#   ______                 _            #\n" + 
					"#  /_  __/___  ____ ___   (_)___  ___ _ #\n" + 
					"#   / /  / -_)/ __// _ \\ / // _ \\/ _ `/ #\n" + 
					"#  /_/   \\__//_/  /_//_//_//_//_/\\_, /  #\n" + 
					"#                               /___/   #\n" + 
					"#     ____       _  __ __      __       #\n" + 
					"#    / __/___   (_)/ // /___  / /_      #\n" + 
					"#   _\\ \\ / _ \\ / // // // -_)/ __/      #\n" + 
					"#  /___// .__//_//_//_/ \\__/ \\__/       #\n" + 
					"#      /_/                              #\n" + 
					"# # # # # # # # # # # # # # # # # # # # #\n" +
					"# # # # # # # # # # # # # # # # # # # # #\n" +
					"# # # # # # # # # # # # # # # # # # # # #\n");
			
			System.out.print("Indtast spiller 1's navn eller \"exit\" for at lukke: ");
			
			input = s.nextLine();
			//Checker om "exit" er blevet indtastet, hvis sandt, lukkes programmet.
			if(input.toLowerCase().contentEquals("exit")) {
				s.close();
				System.exit(0);
				break;
			}
			else spillere[0] = new Spiller(input,1);
			
			
			System.out.print("Indtast spiller 2's navn: ");
			
			input = s.nextLine();
			spillere[1] = new Spiller(input,2);
			
			
			spilleBræt = GUIFører.getInstance();
			spilleBræt.skabSpillePlade(spillere[0], spillere[1]);
			
			
			while(true) {
				
				spilleBræt.næsteTur(spillere[nr]);
				
				kast.kastTerninger();
				
				spilleBræt.visTerningKast(kast.getVærdiTerning1(), kast.getVærdiTerning2());
				
				spillere[nr].setPoint(kast.getSum());
				
				spilleBræt.visSpillerPoint(spillere[nr]);
				
				if(spillere[nr].getPoint() >= 40) {
					spilleBræt.spillerHarVundet(spillere[nr]);
					
					spilleBræt.luk();
					break;
				}
				
				
				if (nr == 0) nr = 1;
				else nr = 0;
			}
		}

	}

}
