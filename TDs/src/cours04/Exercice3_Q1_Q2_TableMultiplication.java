package cours04;

import java.util.Scanner;

public class Exercice3_Q1_Q2_TableMultiplication {
	
	public static void main(String[] args) 
	{
		int nbUser = 0, result = 0, i = 0;
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Saisissez l'entier de la table : ");
		nbUser = sc.nextInt();
		
		// On gère le fait que l'utilisateur puisse saisir un mauvais entier
		if (nbUser<1 || nbUser>9) 
		{
			System.out.println("L'entier saisi n'est pas compris entre 1 et 9..:(");
		}
		else
		{
			System.out.println("Table de multiplication de "+nbUser);
			for (i=1;i<=9;i++)
			{
				result = i*nbUser;
				System.out.println(i+" x "+nbUser+" = "+result);
			}
		}
		sc.close();
	}
}
