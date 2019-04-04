class Dyonisos extends Soigneur{

  public Dyonisos(){
    super("Dyonisos", 15, 7);
  }

  public void soigne(Carte c){
    int rand = random.nextInt(2);
    if(rand == 0){
      c.setPV(c.getPV() + this.soigne);
      System.out.println("Dyonisos soigne " + c.getNom() + " et lui restaure " + this.soigne + "PV\n");
    } else {
      System.out.println("Dyonisos est trop alcoolisé pour faire quoi que ce soit\n");
    }
  }
}
