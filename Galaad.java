class Galaad extends Paladin{

  public Galaad(){
    super("Galaad", 15, 5, 5);
  }

  public void attaque(Carte c){
    System.out.println("Galaad attaque " + c.getNom() + "\n");
    c.setPV(c.getPV() - this.degat);
  }

  public void soigne(Carte c){
    System.out.println("Galaad soigne " + c.getNom() + "\n");
    c.setPV(c.getPV() + this.soigne);
  }

}
