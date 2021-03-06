package TD12;

import java.util.ArrayList;
import java.util.Scanner;

public class Notes_tabStatic {

	static ArrayList<Integer> TAB_NOTES ;
	static ArrayList<Integer> TAB_COEFS ;

	public static void main(String[] args) {
		TAB_NOTES = new ArrayList<Integer>();
		TAB_COEFS = new ArrayList<Integer>();
		Scanner sc = new Scanner (System.in);
		int userChoice =-1;
		int newNote=-1, noteToModify=-1, newCoef=0;

		System.out.println("Bienvenue dans le gestionnaire de notes !");

		do {
			System.out.println("Que souhaitez-vous faire ? ");
			System.out.println("1-Ajouter une note ");
			System.out.println("2-Modifier une note ");
			System.out.println("3-Afficher les notes ");
			System.out.println("4-Afficher la moyenne des notes ");
			System.out.println("9-Quitter le programme ");
			System.out.print("Saisissez votre choix : ");
			userChoice=sc.nextInt();			

			switch (userChoice) {
			case 1:	
				System.out.print("Saisissez la note à ajouter : ");
				newNote=sc.nextInt();
				System.out.print("Saisissez le coef de cette note : ");
				newCoef=sc.nextInt();
				sc.nextLine();
				addNewNote(newNote,newCoef);
				break;
			case 2:
				System.out.print("Saisissez la note à modifier : ");
				noteToModify=sc.nextInt();
				System.out.print("Saisissez la nouvelle note : ");
				newNote=sc.nextInt();
				System.out.print("Saisissez le coef correspondant : ");
				newCoef=sc.nextInt();
				sc.nextLine();
				modifyNote(noteToModify,newNote,newCoef);
				break;
			case 3:
				displayNotes();
				break;
			case 4:
				System.out.println("Moyenne : "+notesAverage());
				break;
			case 9:
				System.out.println("On quitte le programme, byebye !");
			}
		} while(userChoice!=9);
		sc.close();
	}

	// ajouter une nouvelle note
	static void addNewNote (int iNewNote, int iCoef) {
		if (iNewNote<0) {
			System.out.println("Note négative -> Non ajoutée");
		} else if (iCoef<=0) {
			System.out.println("Coef négatif -> Non ajoutée");
		} else {
			TAB_NOTES.add(iNewNote);
			TAB_COEFS.add(iCoef);
		}
	}

	// afficher toutes les notes
	static void displayNotes() {
		int sizeNotes=TAB_NOTES.size();
		System.out.println("Voici les notes de ce brave élève et les coefs correspondant : ");
		for(int i=0;i<sizeNotes;i++) {
			System.out.print(TAB_NOTES.get(i)+" | ");
		}
		System.out.println();
		for(int i=0;i<sizeNotes;i++) {
			System.out.print(TAB_COEFS.get(i)+" | ");
		}
		System.out.println();
	}

	// calculer la moyenne des notes 
	static double notesAverage() {
		double moyenne=0.0, somme=0.0;
		int size=TAB_NOTES.size(), sommeCoefs=0;
		for(int i=0;i<size;i++) {
			somme+=(TAB_NOTES.get(i))*TAB_COEFS.get(i);
		}
		for(int i=0;i<size;i++) {
			sommeCoefs+=TAB_COEFS.get(i);
		}
		moyenne = ((int)((somme/sommeCoefs)*100))/100.;
		return moyenne;
	}

	static void modifyNote (int iNoteToModify, int iNewNote, int iCoef) {
		int indexOfNoteToModify=-1;
		if(!TAB_NOTES.contains(iNoteToModify)) {
			System.out.println("Note non présente dans le tableau.");
		} else {
			indexOfNoteToModify=TAB_NOTES.indexOf(iNoteToModify);
			TAB_NOTES.set(indexOfNoteToModify,iNewNote);
			TAB_COEFS.set(indexOfNoteToModify,iCoef);
		}
	}
}

