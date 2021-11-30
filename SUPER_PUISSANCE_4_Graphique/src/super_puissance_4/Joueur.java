package super_puissance_4;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Axel
 */
public class Joueur {
    
 String Nom ;
 String Couleur ;
 Jeton [] ListeJetons  = new Jeton [21];
 int nombreJetonsRestants = 0;
 int nombreDesintegrateurs = 0;
 
 public Joueur (String nom){
     Nom = nom ;
 }
    
 public void affecterCouleur (String couleur){
    Couleur =couleur;
}   
    
public boolean ajouterJeton (Jeton jeton){
    
    for (int i=0;i<=20;i++){
        
        if (ListeJetons [i] == null){
            ListeJetons [i] = jeton ;    
            nombreJetonsRestants += 1 ;
            return true; 
        }
    }
     return false;
     
}       
    

public void obtenirDesintegrateur(){
   nombreDesintegrateurs += 1 ; 
}


public boolean utiliserDesintegrateur() {
    if (nombreDesintegrateurs== 0){
       return false ;
    }
    else {
        nombreDesintegrateurs -= 1 ;
        return true;  
    }       
}



}