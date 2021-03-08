/*
Vendredi 15 novembre 2019
TP3 
Marc Cossais en binome avec Deryne Four
*/

package Personnages;
import Armes.*;
import tp3wow.etreVivant;
import java.util.Vector;
        
abstract class Personnage implements etreVivant{
    // attributs
    String nom;
    int niveau_vie;
    Vector<Arme> sac;
    public boolean competence;
    int j;
    Arme Arme_en_Main;
    public static int nbjoueurs;
    public static int nbmagiciens;
    public static int nbguerriers;

    
    // constructeur
    public Personnage(String pnom, int pniveau_vie){
        nom = pnom;
        niveau_vie = pniveau_vie;
        sac = new Vector(5); // sac de taille 5
        Arme_en_Main = null;
        nbjoueurs++;        
    }
    @Override
     //destructeur
     public void finalize(){
        nbjoueurs --;
        if (this instanceof Magicien){
            nbmagiciens --;
        }
        if (this instanceof Guerrier){
            nbguerriers --;
        }
    }
    
    // Methodes
    public int set_nbjoueur1(){
        return nbjoueurs;
        
    }
    
    public void afficheInventaire(){
        String etat;
        if (this.niveau_vie > 0){
        if (this instanceof Magicien){
            if (competence == true){
                etat = "confirme";
            }
            else{
                etat = "novice";
            }
        }
        else{
            if (competence == true){
                etat = "a cheval";
            }
            else{
                etat = "a pied";
            }
        }
        System.out.println("");
        System.out.println("\t__ INVENTAIRE de "+nom+" de niveau "+ niveau_vie +" qui est "+ etat+ " : __");
        if (sac.size()==0){
            System.out.println("\t__ Le sac de "+ nom + " est vide __");
        }
        else {
            for (int i=0; i<sac.size();i++){
                System.out.println(sac.elementAt(i));
            }
        }
        System.out.println("");
        }
    }
    
    @Override
    public String toString(){
        String phrase;        
        if (Arme_en_Main != null){
        phrase = "Le personnage s'apelle "+ nom + " et a pour niveau "+ niveau_vie + ". Il possede "+ Arme_en_Main.nom+".";
        }
        else{
        phrase = "Le personnage s'apelle "+ nom + " et a pour niveau "+ niveau_vie + ". Il n'a pas d'armes en main.";
        }
        return phrase;
    }
    
    public void ajouter(Arme parme){
        sac.addElement(parme);
        System.out.println(""+ nom +" possede "+ parme.nom);
        j++;
        if (j>5){
            System.out.println("Trop d'armes tuent les armes. Il serait judicieux de limiter le stock d'armes");
        }
    }
    
    public void Equiper(String nom_arme){
        for(int i = 0; i < sac.size() ; i++)//on parcoure le tableau
        {
            if (nom_arme == sac.get(i).nom)// si on trouve l'arme
            {
                Arme_en_Main = sac.get(i);
                //System.out.println(""+ nom +" a "+ sac.get(i).nom);
            }
        }
        if (Arme_en_Main == null) // si on ne la trouve pas
        {
            System.out.println(""+ nom + " n'a pas "+ nom_arme+ ".");
        }
    }
    
    public boolean get_arme(){
        // test pour savoir si le personnage porte une arme
        if (Arme_en_Main == null){
            System.out.println("Il n'a pas d'armes en main");
            return false;
        }
        else{
        return true;
        }
    }
    
    public void get_arme_pred(){
       int nb_epee=0;
       int nb_baton=0;
        for(int i = 0; i<sac.size();i++){
            if ((sac.get(i) instanceof Baton)&&(this instanceof Magicien))
            {
                nb_baton ++; // on incrémente le nombre de baton
            }
        if ((sac.get(i) instanceof Epee)&&(this instanceof Guerrier)){
                nb_epee ++; //on incrémente le nombre d'epees
            }    
        }
        if (this instanceof Magicien){ // si c'est un magicien
            System.out.println(""+ nom +" possède "+ nb_baton +" baton(s) (arme(s) de prédilection)");
            // on affiche un message pour savoir combien d'armes de prédilection a le personnage
        }
        if (this instanceof Guerrier){ // si c'est un guerrier
            System.out.println(""+ nom +" possède "+ nb_epee +" epee(s) (arme(s) de prédilection)");
            // on affiche un message pour savoir combien d'armes de prédilection a le personnage

        }    
    
    }
    
    public void equiper_pred()
    {
        boolean arme = false; // on cree un indicateur pour savoir quand une arme correspond aux besoins du personnage
        int i = 0; // initialisation d'un compteur
        while ((arme == false)&&(i<5)) // tant qu'on a pas parcourru les 5 cases du tableau et qu'aucune arme ne correspond
        {
                if ((this.sac.get(i) instanceof Baton)&&(this instanceof Magicien))
                {
                Arme_en_Main = sac.get(i); //on equipe l'arme
                arme = true; // on veut sortir de la boucle
                }
                if ((this.sac.get(i) instanceof Epee)&&(this instanceof Guerrier))
                {
                Arme_en_Main = sac.get(i); // on equipe l'arme
                arme = true; // on veut sortir de la boucle
                } 
                
                i++; // on incrémente    
        }
        if (Arme_en_Main != null){
             System.out.println(""+ nom + " a choisi d'equiper "+ Arme_en_Main.nom + " une arme de prédilection");
             System.out.println("");
        }
        if (Arme_en_Main == null){
            System.out.println(""+ nom + "n'a pas d'armes de prédilection"); // affichage d'un message s'il n'y a pas d'arme de predilection dans le sac
        }
       
    }
    
    @Override
    public void seFatiguer(){
        niveau_vie = niveau_vie -10; // on enleve 10 points de vie par attaque
    }
    
    @Override
    public boolean estVivant(){
        if (niveau_vie >0)
        {
        System.out.println("\t  -> "+ this.nom + " est toujours vivant après l'attaque");
        afficheInventaire(); // si le personnage est vivant on affiche l'inventaire
        return true;
        }
        else
        {
            System.out.println("\t  -> "+ this.nom+ " est mort"); // RIP le personnage
            finalize(); // on le supprime
            return false; // il est mort
        }
    }
    
    @Override
    public void estAttaque(int points){
        niveau_vie = niveau_vie - points; // on retire un certain nombre de points de vie par attaque
    }
    
    
    public void Attaque(Personnage perso ){
            int points=0;
            boolean mort_fatigue=false; // au début du combat l'attaquant ne peut pas etre mort de fatgue
            
            if ((perso.niveau_vie > 0)&&(this.get_arme()== true)) // si le personne vicitime a une barre de vie positive
            // et que l'attaquant possede une arme en main
            {
            System.out.println("\t\t ==  "+ this.nom+ " attaque "+ perso.nom+ "  ==");
            if ((this.Arme_en_Main instanceof Baton)&&(this instanceof Magicien)) // si l'attaquant est un magicien
            // et qu'il possede à la main un baton (une arme de predilection)
            {
                points = perso.Arme_en_Main.niveau_attaque; // on affecte le niveau d'attaque aux degats
                points = points*(this.Arme_en_Main.points); // et on multiplie par l'âge du baton
            }
            if ((this.Arme_en_Main instanceof Epee)&&(this instanceof Guerrier))// si l'attaquant est un guerrier
            { // et qu'il possede en main une epee
                points = this.Arme_en_Main.niveau_attaque; // on affecte le niveau d'attaque aux degats
                points = points *(this.Arme_en_Main.points); // et on multiplie par la finesse de l'epee
            }
            if (this.competence == true){ // si la victime est a cheval ou confirme
                points = this.Arme_en_Main.points;
                points = points/2; // les degats sont divises par deux
            }
            perso.estAttaque(points); // l'attaquant attaque
            this.seFatiguer(); // l'attaquant se fatigue
            
            if (this.estVivant() == false){ // affichage d'un message si l'attaquant est mort de fatigue
                System.out.println("Dans un dernier elan "+ this.nom +" a lance sa derniere attaque et est mort d'epuisemenent");
                mort_fatigue=true;
            }
            if ((perso.estVivant() ==  false)){ // affichage d'un message si le personnage qui est attaque est mort
                System.out.println("\t ************* Victoire de "+ this.nom+ " sur "+ perso.nom+ " !!! *************");
                System.out.println("\t  ************                                     ************");
                System.out.println("\t   ***********                                     ***********");
                System.out.println("\t    **********                                     **********");
                System.out.println("\t     *********                                     *********");
                System.out.println("\t      ********                                     ********");
                System.out.println("\t       *******                                     *******");
                System.out.println("");
            }
            if (mort_fatigue == true){ // affichage d'un message si l'attaquant est mort de fatigue
                System.out.println("\t ************* Victoire de "+ perso.nom+ " sur "+ this.nom+ " !!! *************");
                System.out.println("\t  ************                                     ************");
                System.out.println("\t   ***********                                     ***********");
                System.out.println("\t    **********                                     **********");
                System.out.println("\t     *********                                     *********");
                System.out.println("\t      ********                                     ********");
                System.out.println("\t       *******                                     *******");
                System.out.println("");
            }
           

            }

    }
    
    
    
    
}