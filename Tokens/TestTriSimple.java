package com.Tokens;

import java.io.IOException;
import java.util.Scanner;

public class TestTriSimple {

	public static void main(String[] args) throws IOException {
		
		/*
		 * TriSimple t_s = new TriSimple(6,5); t_s.Inserer_Elem(2);
		 * t_s.Inserer_Elem(-1); t_s.Inserer_Elem(4); t_s.Inserer_Elem(-2);
		 * t_s.Inserer_Elem(7); t_s.Inserer_Elem(0); t_s.Inserer_Elem(8);
		 * t_s.Inserer_Elem(-10); t_s.Inserer_Elem(3);
		 * 
		 * t_s.Supprimer_Elem(-10);
		 * System.out.println(t_s.toString());
		 */
		Scanner sc = new Scanner(System.in);
		int taille,increment,choix;
		System.out.println("Donnez La taille du tableau : ");
		taille = sc.nextInt();
		System.out.println("Donnez l'increment du tableau : ");
		increment = sc.nextInt();
		TriSimple ma_table = new TriSimple(taille,increment);
		
		do 
		{
			cls();
			System.out.println("********* Welcome To Your Table *********");
			System.out.println("\t 1- Inserer un element. ");
			System.out.println("\t 2- Supprimer un element. ");
			System.out.println("\t 3- Afficher mon tableau. ");
			System.out.println("\t 0- Quitter. ");
			System.out.println("Donnez votre choix : ");
			choix = sc.nextInt();
			switch(choix)
			{
				case 1: System.out.println("Donnez La valeur à insérer : ");
						ma_table.Inserer_Elem(sc.nextInt()); break;
				case 2:	System.out.println("Donnez La valeur à supprimer : ");
						ma_table.Supprimer_dic_elem(sc.nextInt()); break;
				case 3: cls();System.out.println(ma_table.toString()); break;
				case 0: cls();System.out.println("** Aurevoir. A bientot. **"); break;
				default: System.out.println("Choix invalide !!");break;
				
			}
			try {
				char ch = (char) System.in.read();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}while(choix !=0);
		
		
	}
	public static void cls(){
		for (int i = 0; i < 50; ++i) System.out.println();
	}
	
	

}
