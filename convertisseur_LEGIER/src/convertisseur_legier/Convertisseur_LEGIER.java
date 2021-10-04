/*//
 * TP 1 
 * Convertisseur de températures
 */
package convertisseur_legier;

import java.util.Scanner;

/**
 *
 * @author Legier
 */
public class Convertisseur_LEGIER {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        System.out.println("Bonjour saisissez une valeur : ");
        Scanner sc = new Scanner(System.in);
        double temp = sc.nextDouble();
        
        System.out.println("Saisissez la valeur que vous souhaitez effectuer :");
        System.out.println(" 1) De Celcius vers Kelvin\n" +
" 2) De Kelvin vers Celcius"+"\n 3) F vers C\n 4) C vers F\n 5) K vers F\n 6) F vers K");
        
        int choix = sc.nextInt();
        
        if (choix ==1) {
           double temp2 = CelsiusversKelvin(temp) ;
        }
        else if (choix ==2) {
            
        }
    }
    public static double CelsiusversKelvin (double temp) {
        double k = temp + 273.15 ;
        return k ;   
    }           
        
    public static double KelvinversCelsius (double temp) {
        double a = temp - 273.15 ;
        return a ;
    }     
        
    public static double FarenheitversCelsius (double temp) {
        double a = (temp-32)*5/9 ;
        return a ;
    }
    
    public static double CelsiusversFarenheint (double temp) {
        double a = 32 + 9*temp/5 ;
        return a ;
    }
    
    public static double KelvinversFarenheint (double temp) {
        double a = 32 - 273.15 + 9 *temp /5 ;
        return a ;
    }
    
    public static double FarenheitversKelvin (double temp) {
        double a = (temp-32)*5/9 + 273.15 ;
        return a ;
        
    }
   
    
    
    
    
    
    
    
    
}
