package com.Tokens;
import java.text.*;
import java.util.*;





public class TestMethodeTronque {

	public static void main(String[] args) {
		
		String arg1,arg2 ;
		Scanner clavier = new Scanner(System.in);
		System.out.println("Donnez Les arguments :  ");
		String arguments = clavier.nextLine();
		StringTokenizer st = new StringTokenizer(arguments);
		
		arg1 = st.nextToken();
		if(st.hasMoreTokens())
		{
			arg2= st.nextToken();
			try {
				
			
				double ar1 = Double.parseDouble(arg1);
				int ar2 = Integer.parseInt(arg2);
				String result = tronque(ar1,ar2);
				System.out.println("Le resultat est : " +result);
				
			} 
			catch(NumberFormatException e)
			{
				System.out.println(e);
			}
		}
		else {
			System.out.println("** Arguments non suffisants !! ");
		}
		
	
	}
	public static String tronque(double x,int nbDecimales) {
			
			
			if(nbDecimales >= 0)
			{
				DecimalFormat df = new DecimalFormat () ;
				df.setMaximumFractionDigits ( nbDecimales ) ;
				df.setMinimumFractionDigits ( nbDecimales ) ;
				df.setDecimalSeparatorAlwaysShown ( true ) ;
				return df.format(x);
			}
			else {
				return "Error Entrer un nombre supérieur a 0 ou null ";
			}
		}
	}

