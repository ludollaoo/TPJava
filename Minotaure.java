class Minotaure extends Combattant{

  public Minotaure(){
    super("Minotaure", 20, 8);
  }

  public void attaque(Carte c){
    int rand = random.nextInt(4);
    int degatTotal = rand + this.degat;
    c.setPV(c.getPV() - degatTotal);
    this.setPV(this.getPV() - rand);
    System.out.println("Minotaure attaque " + c.getNom() + " !!!\nIl lui inflige " + degatTotal + " degats mais perd " + rand +"PV\n");

  }
}
