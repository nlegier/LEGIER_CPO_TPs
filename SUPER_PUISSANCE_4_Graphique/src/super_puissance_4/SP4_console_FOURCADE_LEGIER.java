/**
 * TP3 console
 * Axel FOURCADE , Noa LEGIER
 * 12/11/2021
 */
package super_puissance_4;

import java.util.Scanner;

/**
 *
 * @author Axel
 */
public class SP4_console_FOURCADE_LEGIER {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

//Jeton j = new Jeton ("rouge");
//System.out.println(j.lireCouleur());
//Cellule c = new Cellule();
//System.out.println(c.lireCouleurDuJeton());
//c.affecterJeton(j);
//System.out.println(c.lireCouleurDuJeton());
//Grille g = new Grille();
//g.afficherGrilleSurConsole();
//g.ajouterJetonDansColonne(j,6);
//g.afficherGrilleSurConsole();

//Jeton j2 = new Jeton ("jaune");
//g.ajouterJetonDansColonne(j2,1);
//g.afficherGrilleSurConsole();

//g.ajouterJetonDansColonne(j,6);
//g.afficherGrilleSurConsole();

//g.ajouterJetonDansColonne(j,6);
//g.afficherGrilleSurConsole();

//g.ajouterJetonDansColonne(j,6);

//g.afficherGrilleSurConsole();

Scanner sc = new Scanner(System.in);
System.out.println("Joueur 1 quel est ton nom :");

String joueur1;
joueur1 = sc.next();
System.out.println("Joueur 2 quel est ton nom :");
String joueur2; 
joueur2 = sc.next();

Joueur j1 = new Joueur (joueur1);
Joueur j2 = new Joueur (joueur2);

Partie partie = new Partie(j1,j2);
partie.attribueCouleursAuxJoueurs();
partie.initialiserPartie();
partie.debuterPartie();




    }
    
}