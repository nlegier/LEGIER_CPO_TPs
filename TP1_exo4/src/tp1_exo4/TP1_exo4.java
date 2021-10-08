/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tp1_exo4;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Legier
 */
public class TP1_exo4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
    int tab[] = new int[6] ;
    
    Scanner sc = new Scanner(System.in);
    System.out.println("Saisir le nombre de lancé :");
    int m = sc.nextInt();
    int i = 0;
    while (i<=m-1) {
        Random r = new Random();
        int n = r.nextInt(6);
        tab[n]+= 1 ;
        i+=1 ;
    }
    System.out.println("Nombre 1:"+tab[0]);
    System.out.println("Nombre 2:"+tab[1]);
    System.out.println("Nombre 3:"+tab[2]);
    System.out.println("Nombre 4:"+tab[3]);
    System.out.println("Nombre 5:"+tab[4]);
    System.out.println("Nombre 6:"+tab[5]);

        
        
        
    }
    
}
