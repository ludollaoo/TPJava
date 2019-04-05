import java.util.Vector;
import java.util.Random;

public class Vequipe extends Vector<Carte>{
	private int num;
	private static  Random random;

	public Vequipe(int i){
		super();
		random = new Random();
		num = i;
	}

	public String toString(){
		String msg = "Equipe" + this.num + "\n";
		for(Carte c : this){
			msg = msg + c.toString() + "\n";
		}
		return msg;
	}

	//fonction principale du jeu

	public void action(int tour, Vequipe adverse) throws CarteMorteException, ListeVideException{

		//selection de la carte qui doit jouer
		int taille = this.size();
		if(taille == 0) throw new ListeVideException();
		int index = tour % taille;
		Carte c = this.get(index);
		if(c.getPV() < 0) throw new CarteMorteException(this, c);
		Carte selection;

		//une fois la carte sélectionner elle effectue des actions selon sa classe
		if(c instanceof Combattant){ 			//COMBATTANT
			selection = adverse.choisirCarte();
			((Combattant) c).attaque(selection);
		}

		if(c instanceof Soigneur){ 				//SOIGNEUR
			selection = this.choisirCarte();
			((Soigneur) c).soigne(selection);
		}

		if(c instanceof Paladin){ 				//PALADIN
			int choix = choisirAction(); //attaquer ou soigner
			if(choix == 0){ //attaque
				selection = adverse.choisirCarte();
				((Paladin) c).attaque(selection);
			} else { //soigne
				selection = this.choisirCarte();
				((Paladin) c).soigne(selection);
			}

		}
	}

	//enleve les cartes mortes de l'équipe
	public void nettoyer(){
		Vector<Carte> copie = new Vector<Carte>();
		for(Carte c : this){
			copie.add(c);
		}
		for(Carte c : copie){
			if(c.getPV() < 0){
				this.remove(c);
			}
		}
	}


	//permet de choisir la carte à attaquer ou à soigner dans l'équipe
	public Carte choisirCarte() throws CarteMorteException{ //pour l'instant aléatoire, mettre un scanner plus tard
		int rand = random.nextInt(this.size());
		Carte c = this.get(rand);
		if(c.getPV() < 0) throw new CarteMorteException(this, c);
		return c;
	}

	//dans le cas des paladins, permet de chosir ci ce dernier attaque ou soigne
	public static int choisirAction(){ //pour l'instant aléatoire, mettre un scanner plus tard
		int rand = random.nextInt(2);
		return rand;
	}
}