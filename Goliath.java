class Goliath extends Combattant{

  public Goliath(){
    super("Goliath", 20, 7);
  }

  public void attaque(Carte c){
    System.out.println("Goliath attaque " + c.getNom() + "\n");
    c.setPV(c.getPV() - this.degat);
  }

}
