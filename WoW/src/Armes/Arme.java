/*
Vendredi 15 novembre 2019
TP3 
Marc Cossais en binome avec Deryne Four
*/
package Armes;

public abstract class Arme {
    
    // attributs :
    public String nom; // nom de l'arme
    public int niveau_attaque; // niveau d'attaque de l'arme
    public String nom_type; // cette variable permet de savoir si l'arme est un baton ou une epee en dehors de la classe eppe et baton
    public int points; // cette variable permet de savoir l'age du baton et la finesse de l'epee en dehors de la classe eppe et baton
    
    
    // Constructeur :
public Arme(String pnom, int pniveau_attaque){
        nom=pnom;
        niveau_attaque=pniveau_attaque;
        
        if ((niveau_attaque> 100)) //on test si le niveau d'attaque de l'arme est cohérant
        {
            System.out.println("Le niveau d'attaque : ''"+niveau_attaque+"'' est trop eleve");
            System.out.println("");
            niveau_attaque= 0;
        }
        
    }

    //Methode :
@Override
public String toString()
    {
        String phrase;
        phrase = "\t\tNiveau attaque ''"+nom+"'' : "+niveau_attaque;
        return phrase;
    }

   

    
}
