/*
Vendredi 15 novembre 2019
TP3 
Marc Cossais en binome avec Deryne Four
*/
package tp3wow;

import Armes.*;
import Personnages.*;

public class TP3WoW {

    public static void main(String[] args) {
      
      //On crée les personnages Magiciens
      Magicien magicien1 = new Magicien("Gandalf",65,"confirmé");
      Magicien magicien2 = new Magicien("Garcimore",44,"novice");
            
      //On crée les personnages Guerriers
      Guerrier guerrier1 = new Guerrier("Conan",78,"à pied");
      Guerrier guerrier2 = new Guerrier("Lannister",45,"à cheval");

        //On crée les armes Epee
        Epee Excalibur= new Epee("Excalibur",7,5);
        Epee Durandal= new Epee("Durandal",4,7);
        Epee Mastersword= new Epee("MasterSword",7,5);
        //On test le constructeur
        Epee Erreur1= new Epee("Durandal",102,7);
        Epee Erreur2= new Epee("Durandal",10,102);
        
        //On crée les armes Baton
        Baton Chene= new Baton("Chêne",4,5);
        Baton Charme= new Baton("Charme",5,6);
        //On test le constructeur
        Baton Erreur3= new Baton("Chêne",4,105);

        //On ajoute des armes aux personnages
        guerrier1.ajouter(Charme);
        guerrier1.ajouter(Excalibur);
        guerrier1.ajouter(Mastersword);
        magicien1.ajouter(Charme);
        magicien1.ajouter(Chene);
        magicien1.ajouter(Excalibur);
        magicien2.ajouter(Charme);
        magicien2.ajouter(Mastersword);
        magicien2.ajouter(Chene);
        
        //Chaque personnages prend son arme de prédilection
        guerrier1.get_arme_pred();
        guerrier1.equiper_pred();
        magicien1.get_arme_pred();
        magicien1.equiper_pred();
        magicien2.get_arme_pred();
        magicien2.equiper_pred();
        
        //On test un premier combat :
        guerrier1.Attaque(magicien1);
        magicien1.Attaque(guerrier1);
        guerrier1.Attaque(magicien1);
        
        //On test un deuxieme combat :
        guerrier1.Attaque(magicien2);
        magicien2.Attaque(guerrier1);
        
    }
    
}
