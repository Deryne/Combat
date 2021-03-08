
package Personnages;

public class Magicien extends Personnage{
    
    // attributs :
    public Boolean confirme;
    public static int nbmagiciens = 0;

    
    // constructeur :
    public Magicien(String pnom, int pniveau_vie, String pconfirme){
    
    super(pnom,pniveau_vie);
    nbmagiciens++; /*on compte le nombre de fois que le constructeur est verifier ce qui permet de 
        determiner le nombre de magiciens*/
    competence = set_confirme(pconfirme);
    
    }
    

    
    // Methode :
    
    /*Cette methode permet d'associer l'attribut confirme au niveau de maitrise du magicien par vrai ou faux
    pour qu'on puisse avoir accès à cet variable dans la classe mere*/
    public boolean set_confirme(String pconfirme)
    {
        if (pconfirme ==  "confirmé")
        {
        confirme = true;
        }
        if (pconfirme == "novice")
        {
        confirme = false;
        }
        if ((pconfirme != "confirmé")&&(pconfirme != "novice"))
        {
        System.out.println("Erreur");
        }    
        return confirme;
    }


    
}
