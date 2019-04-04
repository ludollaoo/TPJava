abstract class Combattant extends Carte implements Attaque{
  protected int degat;

  public Combattant(String nom, int PV, int degat){
    super(nom, PV);
    this.degat = degat;
  }

  public String toString(){
    String sCombattant = "Combattant";
    String sdegat = "degat:";
    return String.format("%10s %s %7s%3d", sCombattant, super.toString(), sdegat, degat);
  }

  public abstract void attaque(Carte c);
}
