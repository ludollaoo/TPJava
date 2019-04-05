public class CarteMorteException extends Exception{

	private Vequipe vequipe;

	public CarteMorteException(Vequipe e){
		super("Cette carte est déjà morte");
		this.vequipe = e;
	}


	public CarteMorteException(Vequipe e, Carte c){
		super(c.getNom() + " est déjà morte");
		this.vequipe = e;
	}

	public Vequipe getequipe(){
		return this.vequipe;
	}
}