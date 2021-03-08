
package Armes;

public class Epee extends Arme {
    
    //attributs :
    int indice_finesse;
    
    
    public Epee(String pnom, int pniveau_attaque, int pindice_finesse){
        
        super(pnom, pniveau_attaque);
        nom_type = "epee";
        indice_finesse=pindice_finesse;
        points = indice_finesse;
        if ((indice_finesse>=100)) //on test si l'indice de finesse de l'epee est coherante
        {
            System.out.println("L'indice de finesse : ''"+indice_finesse+"'' est trop eleve");
            System.out.println("");
            indice_finesse= 0;
        }
    }
    
}
