/*
Vendredi 15 novembre 2019
TP3 
Marc Cossais en binome avec Deryne Four
*/
package Armes;

public class Baton extends Arme {
    
    //attributs :
    int age;
    
    
    public Baton(String pnom, int pniveau_attaque, int page){
        
        super(pnom, pniveau_attaque);
        nom_type = "baton";
        age=page;
        points = age;
        
        if ((age>=100)) //on test si l'age du baton est cohérant
        {
            System.out.println("L'age : ''"+age+"'' est trop eleve");
            System.out.println("");
            age= 0;
        }
    }
    
    
    
}
