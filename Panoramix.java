class Panoramix extends Soigneur{

  public Panoramix(){
    super("Panoramix", 10, 7);
  }

  public void soigne(Carte c){
    System.out.println("Panoramix soigne " + c.getNom() + "\n");
    c.setPV(c.getPV() + this.soigne);
  }

}
