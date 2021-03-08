
package Personnages;

public class Guerrier extends Personnage{
    
    // attributs :
    public Boolean cheval;
    public static int nbguerriers = 0;
    
    // constructeur :
    public Guerrier(String pnom, int pniveau_vie, String pcheval){
        
    super(pnom,pniveau_vie);
    nbguerriers++; /*on compte le nombre de fois que le constructeur est verifier ce qui permet de 
        determiner le nombre de guerriers*/
    competence = set_cheval(pcheval); // le boolean compétence est utiliser dans la classe mere personnage
    
    }

    
    // Methode :
    
    /*Cette methode permet d'associer le boolean au moyen de transport par vrai ou faux
    pour qu'on puisse avoir accès à cet variable dans la classe mere*/
    public boolean set_cheval(String pcheval) 
    {
    if (pcheval ==  "à cheval"){
        cheval = true;
    }
    if (pcheval == "à pied"){
        cheval = false;
    }
    if ((pcheval !=  "à cheval")&&(pcheval != "à pied"))
    {
        System.out.println("Erreur");
    }
    return cheval;
    } 

}
