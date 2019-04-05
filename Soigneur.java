abstract class Soigneur extends Carte implements Soigne{

  protected int soigne;

  public Soigneur(String nom, int PV, int soigne){
    super(nom, PV);
    this.soigne = soigne;
  }

  public String affichageConsole(){
    String sSoigneur = "Soigneur";
    String sSoigne = "soigne:";
    return String.format("%10s %s %7s%3d", sSoigneur, super.affichageConsole(), sSoigne, soigne);
  }

  public String affichageGraphique(){
    return "Soigneur "+super.affichageGraphique()+ "\nsoigne : " + this.soigne;

  }

  public abstract void soigne(Carte c);
}
