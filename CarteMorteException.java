public class CarteMorteException extends Exception{

	private Equipe equipe;

	public CarteMorteException(Equipe e){
		super("Cette carte est déjà morte");
		this.equipe = e;
	}

	public CarteMorteException(Equipe e, Carte c){
		super(c.getNom() + " est déjà morte");
		this.equipe = e;
	}

	public Equipe getequipe(){
		return this.equipe;
	}
}