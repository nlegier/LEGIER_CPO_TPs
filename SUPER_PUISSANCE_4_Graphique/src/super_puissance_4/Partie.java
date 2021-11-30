package super_puissance_4;

import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Axel
 */
public class Partie {

    Joueur[] ListeJoueurs = new Joueur[2];
    Joueur joueurCourant;
    Grille grilleJeu = new Grille();

    public Partie(Joueur joueur1, Joueur joueur2) {
        ListeJoueurs[0] = joueur1;
        ListeJoueurs[1] = joueur2;
        joueurCourant = ListeJoueurs[1];

    }

    public void attribueCouleursAuxJoueurs() {
        ListeJoueurs[0].affecterCouleur("jaune");
        System.out.println(ListeJoueurs[0].Nom + " tu as la couleur jaune.");
        ListeJoueurs[1].affecterCouleur("rouge");
        System.out.println(ListeJoueurs[1].Nom + " tu as la couleur rouge.");
    }

    public void initialiserPartie() {

        grilleJeu.viderGrille();

        Jeton jeton1 = new Jeton(ListeJoueurs[0].Couleur);
        ListeJoueurs[0].ajouterJeton(jeton1);
        Jeton jeton2 = new Jeton(ListeJoueurs[1].Couleur);
        ListeJoueurs[1].ajouterJeton(jeton2);

        for (int i = 1; i <= 3; i++) {
            int ligne;
            int colonne;

            ligne = (int) (Math.random() * 6);
            colonne = (int) (Math.random() * 7);
            boolean a = grilleJeu.CellulesJeu[ligne][colonne].placerTrouNoir();

            while (a == false) {
                a = grilleJeu.CellulesJeu[ligne][colonne].placerTrouNoir();
                ligne = (int) (Math.random() * 5);
                colonne = (int) (Math.random() * 6);
            }
        }
        for (int i = 1; i <= 2; i++) {
            int ligne;
            int colonne;

            ligne = (int) (Math.random() * 6);
            colonne = (int) (Math.random() * 7);
            boolean a = grilleJeu.CellulesJeu[ligne][colonne].placerTrouNoir();
            boolean b = grilleJeu.CellulesJeu[ligne][colonne].placerDesintegrateur();

            while (a == false || b == false) {
                a = grilleJeu.CellulesJeu[ligne][colonne].placerTrouNoir();
                b = grilleJeu.CellulesJeu[ligne][colonne].placerDesintegrateur();
                ligne = (int) (Math.random() * 5);
                colonne = (int) (Math.random() * 6);
            }
        }
        for (int i = 1; i <= 3; i++) {
            int ligne;
            int colonne;

            ligne = (int) (Math.random() * 6);
            colonne = (int) (Math.random() * 7);
            boolean b = grilleJeu.CellulesJeu[ligne][colonne].placerDesintegrateur();

            while (b == false || grilleJeu.CellulesJeu[ligne][colonne].presenceTrouNoir() == true) {
                b = grilleJeu.CellulesJeu[ligne][colonne].placerDesintegrateur();
                ligne = (int) (Math.random() * 5);
                colonne = (int) (Math.random() * 6);
            }
        }
    }
 
    public void debuterPartie() {

        Scanner sc = new Scanner(System.in);
        int colonne;
        int choix;
        int Crecup;
        int Lrecup;
        int Cdes;
        int Ldes;
        grilleJeu.afficherGrilleSurConsole();

        while (grilleJeu.etreGagnantPourJoueur(joueurCourant) == false && grilleJeu.etreRemplie() == false) {

            if (joueurCourant == ListeJoueurs[0]) {
                joueurCourant = ListeJoueurs[1];
            } else {                             //de mettre cet boucle en premier permet de verifier dès q'un joueur à joué
                joueurCourant = ListeJoueurs[0];  //au premier tour cest joueur1 qui joue
            }

            if (joueurCourant.nombreDesintegrateurs == 0) {
                System.out.println(joueurCourant.Nom + " c'est à toi de jouer,");
                System.out.println("Choisis l'action que tu veux effectuer :\n1) Ajouter un jeton\n2) Recuperer un jeton");
                choix = sc.nextInt();

                while (choix != 1 && choix != 2) {
                    System.out.println("Erreur de frappe, choisis de nouveau l'action que tu veux effectuer :\n1) Ajouter un jeton\n2) Recuperer un jeton");
                    choix = sc.nextInt();
                }
            } else {
                System.out.println(joueurCourant.Nom + " c'est à toi de jouer,");
                System.out.println("Choisis l'action que tu veux effectuer :\n1) Ajouter un jeton\n2) Recuperer un jeton\n3) Desintegrer un jeton");
                choix = sc.nextInt();

                while (choix != 1 && choix != 2 && choix != 3) {
                    System.out.println("Erreur de frappe, choisis de nouveau l'action que tu veux effectuer :\n1) Ajouter un jeton\n2) Recuperer un jeton\n3) Desintegrer un jeton");
                    choix = sc.nextInt();
                }
            }

            if (choix == 1) {
                System.out.println("Saisis la colonne :");
                colonne = sc.nextInt();

                while (colonne < 1 || colonne > 7 || grilleJeu.colonneRemplie(colonne) == true) {
                    System.out.println("La colonne est remplie ou il y a eu erreur de frappe, saisis une autre colonne :");
                    colonne = sc.nextInt();

                }

                Jeton jetonCourant = null;
                for (int i = 0; i <= 20; i++) {
                    if (joueurCourant.ListeJetons[20 - i] != null) {
                        jetonCourant = joueurCourant.ListeJetons[20 - i];
                        break;
                    }
                }

                int j = 0;
                for (int i = 5; i >= 0; i--) {
                    if (grilleJeu.CellulesJeu[i][colonne - 1].presenceJeton() == false) {
                        j = i;
                        break;
                    }
                }

                if (grilleJeu.CellulesJeu[j][colonne - 1].presenceDesintegrateur() == true) {
                    joueurCourant.nombreDesintegrateurs++;
                }

                grilleJeu.ajouterJetonDansColonne(joueurCourant, colonne);

            } else if (choix == 2) {
                System.out.println("Choisis la colonne du jeton que tu veux recuperer :");
                Crecup = sc.nextInt();
                System.out.println("Choisis la ligne du jeton que tu veux recuperer :");
                Lrecup = sc.nextInt();

                while (!joueurCourant.Couleur.equals(grilleJeu.CellulesJeu[Lrecup - 1][Crecup - 1].lireCouleurDuJeton())) {
                    System.out.println("Tu n'as pas de jeton a cette case, choisis en une autre,");
                    System.out.println("Choisis la colonne du jeton que tu veux recuperer :");
                    Crecup = sc.nextInt();
                    System.out.println("Choisis la ligne du jeton que tu veux recuperer :");
                    Lrecup = sc.nextInt();
                }

                Jeton j = grilleJeu.recupererJeton(Lrecup, Crecup);
                for (int i = 0; i <= 20; i++) {

                    if (joueurCourant.ListeJetons[i] == null) {
                        joueurCourant.ListeJetons[i] = j;
                        joueurCourant.nombreJetonsRestants += 1;
                        break;
                    }
                }

                grilleJeu.tasserGrille();
                System.out.println(joueurCourant.Nom + " tu as récupéré un jeton.");

                boolean verif1 = grilleJeu.etreGagnantPourJoueur(ListeJoueurs[0]);
                boolean verif2 = grilleJeu.etreGagnantPourJoueur(ListeJoueurs[1]);

                if (verif1 == true && verif2 == true) {
                    grilleJeu.afficherGrilleSurConsole();
                    System.out.println(joueurCourant.Nom + " a provoqué une faute de jeu, il a donc perdu.");
                    break;
                } else if (verif1 == true || verif2 == true) {
                    grilleJeu.afficherGrilleSurConsole();
                    break;
                }

            } else if (choix == 3) {

                System.out.println("Choisis la colonne du jeton que tu veux desintegrer :");
                Cdes = sc.nextInt();
                System.out.println("Choisis la ligne du jeton que tu veux desintegrer :");
                Ldes = sc.nextInt();

                boolean a = grilleJeu.supprimerJeton(Ldes, Cdes);

                while (a == false) {
                    System.out.println("Il n'y a pas de jeton adverse cette case, choisis en une autre,");
                    System.out.println("Choisis la colonne du jeton que tu veux desintegrer :");
                    Cdes = sc.nextInt();
                    System.out.println("Choisis la ligne du jeton que tu veux desintegrer :");
                    Ldes = sc.nextInt();
                    a = grilleJeu.supprimerJeton(Ldes, Cdes);
                    if (joueurCourant.Couleur.equals(grilleJeu.CellulesJeu[Ldes - 1][Cdes - 1].lireCouleurDuJeton())) {
                        a = false;
                    }
                }

                grilleJeu.tasserGrille();
                System.out.println(joueurCourant.Nom + " tu as désintégré un jeton.");

                boolean verif1 = grilleJeu.etreGagnantPourJoueur(ListeJoueurs[0]);
                boolean verif2 = grilleJeu.etreGagnantPourJoueur(ListeJoueurs[1]);

                if (verif1 == true && verif2 == true) {
                    grilleJeu.afficherGrilleSurConsole();
                    System.out.println(joueurCourant.Nom + " a provoqué une faute de jeu, il a donc perdu.");
                    break;
                } else if (verif1 == true || verif2 == true) {
                    grilleJeu.afficherGrilleSurConsole();
                    break;
                }

                joueurCourant.nombreDesintegrateurs -= 1;

            }

            grilleJeu.afficherGrilleSurConsole();

        }

        System.out.println("La partie est terminée !");
    }

}
  