import java.util.Random;

abstract class Carte{
  private String nom;
  private int PV;
  protected Random random;

  public Carte(String nom, int PV){
    this.random = new Random();
    this.nom = nom;
    this.PV = PV;
  }

  public int getPV(){
    return this.PV;
  }

  public void setPV(int PV){
    this.PV = PV;
  }

  public String getNom(){
    return this.nom;
  }

  public String toString(){
    return this.nom;
  }

  public String affichageConsole(){
    return String.format("%10s PV:%3d", nom, this.PV);
  }

  public String affichageGraphique(){
    return nom +"\nPV : "+this.PV;
  }
}
