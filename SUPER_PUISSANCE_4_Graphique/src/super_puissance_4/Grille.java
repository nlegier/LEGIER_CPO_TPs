/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package super_puissance_4;

/**
 *
 * @author Axel
 */
public class Grille {

    Cellule[][] CellulesJeu = new Cellule[6][7];
    Cellule[][] CellulesAff = new Cellule[6][7];

    public Grille() {
        for (int i = 0; i <= 5; i++) {
            for (int j = 0; j <= 6; j++) {
                CellulesJeu[i][j] = new Cellule();
            }
        }
    }

    public boolean ajouterJetonDansColonne(Joueur joueurCourant, int colonne) {

        Jeton jetonCourant = new Jeton(joueurCourant.Couleur);

        for (int i = 0; i <= 5; i++) {
            if (CellulesJeu[i][colonne - 1].presenceJeton() == false && CellulesJeu[i][colonne - 1].presenceTrouNoir() == false && CellulesJeu[i][colonne - 1].presenceDesintegrateur() == false) {
                CellulesJeu[i][colonne - 1].affecterJeton(jetonCourant);
                return true;
            } else if (CellulesJeu[i][colonne - 1].presenceTrouNoir() == true) {
                CellulesJeu[i][colonne - 1].activerTrouNoir();
                CellulesJeu[i][colonne - 1].recupererDesintegrateur();
                System.out.println("Ton jeton a été aspiré dans un trou noir.");
                return true;
            } else if (CellulesJeu[i][colonne - 1].presenceDesintegrateur() == true) {
                CellulesJeu[i][colonne - 1].recupererDesintegrateur();
                CellulesJeu[i][colonne - 1].affecterJeton(jetonCourant);
                return true;
            }
        }

        return false;
    }

    public boolean etreRemplie() {

        for (int i = 0; i <= 5; i++) {
            for (int j = 0; j <= 6; j++) {
                if (CellulesJeu[i][j].presenceJeton() == false) {
                    return false;
                }
            }
        }
        return true;
    }

    public void viderGrille() {
        for (int i = 0; i <= 5; i++) {
            for (int j = 0; j <= 6; j++) {
                CellulesJeu[i][j].jetonCourant = null;
                CellulesJeu[i][j].trouNoir = false;
                CellulesJeu[i][j].desintegrateur = false;
            }
        }
    }
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_YELLOW = "\u001B[33m";

    //System.out.println(ANSI_RED + "This text is red!" + ANSI_RESET);
    public void afficherGrilleSurConsole() {
        for (int i = 0; i <= 5; i++) {

            System.out.println("");

            for (int j = 0; j <= 6; j++) {

                if (CellulesJeu[i][j].presenceJeton() == false) {
                    if (CellulesJeu[i][j].presenceTrouNoir() == true) {
                        System.out.print("N  ");
                    } else if (CellulesJeu[i][j].presenceDesintegrateur() == true && CellulesJeu[i][j].presenceTrouNoir() == false) {
                        System.out.print("D  ");
                    } else {
                        System.out.print("x  ");
                    }
                } else {
                    if ("rouge".equals(CellulesJeu[i][j].lireCouleurDuJeton())) {
                        System.out.print("R  ");
                    }
                    if ("jaune".equals(CellulesJeu[i][j].lireCouleurDuJeton())) {
                        System.out.print("J  ");
                    }
                }
            }
            System.out.print(i + 1);
        }
        System.out.println("\n1  2  3  4  5  6  7");
        System.out.println("\n\n");
    }

    public boolean celluleOccupee(int ligne, int colonne) {

        if (CellulesJeu[ligne][colonne - 1].presenceJeton() == true) {
            return true;
        }
        return false;
    }

    public String lireCouleurDuJeton(int ligne, int colonne) {
        if (CellulesJeu[ligne][colonne].jetonCourant == null) {
            return "vide";
        }
        return CellulesJeu[ligne][colonne].jetonCourant.lireCouleur();
    }

    public boolean etreGagnantPourJoueur(Joueur joueur) {
        for (int i = 0; i <= 5; i++) {
            for (int j = 0; j <= 6; j++) {

                if ((j <= 3) && (joueur.Couleur.equals(lireCouleurDuJeton(i, j))) && (joueur.Couleur.equals(lireCouleurDuJeton(i, j + 1))) && joueur.Couleur.equals(lireCouleurDuJeton(i, j + 2)) && joueur.Couleur.equals(lireCouleurDuJeton(i, j + 3))) {
                    System.out.println("C'est gagné pour " + joueur.Nom);
                    return true;
                }
                if ((j <= 3) && (i <= 2) && (joueur.Couleur.equals(lireCouleurDuJeton(i, j))) && (joueur.Couleur.equals(lireCouleurDuJeton(i + 1, j + 1))) && joueur.Couleur.equals(lireCouleurDuJeton(i + 2, j + 2)) && joueur.Couleur.equals(lireCouleurDuJeton(i + 3, j + 3))) {
                    System.out.println("C'est gagné pour " + joueur.Nom);
                    return true;
                }
                if ((i <= 2) && (joueur.Couleur.equals(lireCouleurDuJeton(i, j))) && (joueur.Couleur.equals(lireCouleurDuJeton(i + 1, j))) && joueur.Couleur.equals(lireCouleurDuJeton(i + 2, j)) && joueur.Couleur.equals(lireCouleurDuJeton(i + 3, j))) {
                    System.out.println("C'est gagné pour " + joueur.Nom);
                    return true;
                }
                if ((j <= 3) && (i >= 3) && (joueur.Couleur.equals(lireCouleurDuJeton(i, j))) && (joueur.Couleur.equals(lireCouleurDuJeton(i - 1, j + 1))) && joueur.Couleur.equals(lireCouleurDuJeton(i - 2, j + 2)) && joueur.Couleur.equals(lireCouleurDuJeton(i - 3, j + 3))) {
                    System.out.println("C'est gagné pour " + joueur.Nom);
                    return true;
                }
            }
        }
        return false;

    }

    public void tasserColonne(int colonne) {
        for (int i = 0; i <= 5; i++) {
            if (i == 5) {
                CellulesJeu[i][colonne].jetonCourant = null;
            } else {

                if (CellulesJeu[i][colonne].jetonCourant == null) {
                    CellulesJeu[i][colonne].jetonCourant = CellulesJeu[i + 1][colonne].jetonCourant;
                    CellulesJeu[i + 1][colonne].jetonCourant = null;
                }
            }
        }
    }

    public void tasserGrille() {
        for (int i = 0; i < 7; i++) {
            tasserColonne(i);
        }
    }

    public boolean colonneRemplie(int colonne) {
        for (int i = 0; i <= 5; i++) {
            if (celluleOccupee(i, colonne) == false) {
                return false;
            }

        }
        return true;
    }

    public boolean placerDesintegrateur(int ligne, int colonne) {
        if (CellulesJeu[ligne - 1][colonne - 1].presenceDesintegrateur() == false) {
            CellulesJeu[ligne - 1][colonne - 1].placerDesintegrateur();
            return true;
        }
        return false;
    }

    public boolean placerTrouNoir(int ligne, int colonne) {
        if (CellulesJeu[ligne - 1][colonne - 1].presenceTrouNoir() == false) {
            CellulesJeu[ligne - 1][colonne - 1].placerTrouNoir();
            return true;
        }
        return false;

    }

    public boolean supprimerJeton(int ligne, int colonne) {
        if (CellulesJeu[ligne - 1][colonne - 1].presenceJeton() == true) {
            CellulesJeu[ligne - 1][colonne - 1].jetonCourant = null;
            return true;
        }
        return false;

    }

    public Jeton recupererJeton(int ligne, int colonne) {

        Jeton j = CellulesJeu[ligne - 1][colonne - 1].jetonCourant;
        CellulesJeu[ligne - 1][colonne - 1].jetonCourant = null;

        return j;
    }

}
