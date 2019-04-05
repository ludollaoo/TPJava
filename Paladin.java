abstract class Paladin extends Carte implements Attaque, Soigne{

  protected int degat;
  protected int soigne;

  public Paladin(String nom, int PV, int degat, int soigne){
    super(nom, PV);
    this.degat = degat;
    this.soigne = soigne;
    }

  public String affichageConsole(){
    String sPaladin = "Paladin";
    String sdegat = "degat:";
    String ssoigne = "soigne:";
    return String.format("%10s %s %7s%3d %7s%3d", sPaladin, super.affichageConsole(),sdegat, degat,ssoigne, soigne);
  }

  public String affichageGraphique(){
    return "Paladin "+super.affichageGraphique()+ "\ndegat : " + this.degat +"\nsoigne : " + this.soigne;
  }

   public abstract void attaque(Carte c);
   public abstract void soigne(Carte c);

}
