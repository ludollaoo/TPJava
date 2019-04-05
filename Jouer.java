class Jouer{
	
	public static void jouer(){
		//preparation
		int tour = 0;
		Vequipe e1 = new Vequipe(1);
		Vequipe e2 = new Vequipe(2);
		//ajouter une fonction composerEquipe() qui permet de composer son equipe au debut
		//e1.composerEquipe();
		//e2.composerEquipe();
		//au lieu de juste faire des .add
		e1.add(new Goliath());
		e1.add(new Galaad());
		e2.add(new Minotaure());
		e2.add(new Panoramix());

		//lancement de l'affichage
		Fenetre f1 = new Fenetre(e1, e2);


		//debut du tour par tour
		while(!(e1.isEmpty()) && !(e2.isEmpty())){
			if(tour > 50){ break;} //limitation du temps de jeu

			//debut du tour, affichage
			System.out.println("Tour : " + tour);
			System.out.println(e1.toString());
			System.out.println(e2.toString());

			//tant que action() n'aboutit pas, on reesaye cette fonction
			while(true){
				try{
					e1.action(tour, e2);
					break;
				} catch(CarteMorteException e){
					System.out.println(e.getMessage());
					e.getequipe().nettoyer();
				} catch(ListeVideException e){
					break;
				}
			}

			while(true){
				try{
					e2.action(tour, e1);
					break;
				} catch(CarteMorteException e){
					System.out.println(e.getMessage());
					e.getequipe().nettoyer();
				} catch(ListeVideException e){
					break;
				}
			}

			//fin du tour nettoyage des equipes, et incrementation de tour
			e1.nettoyer();
			e2.nettoyer();
			tour++;
		}

		// fin de jeu, declaration du vainqueur et affichage
		if(e1.isEmpty()){
			System.out.println("Victoire de " + e2.toString());
		} else if(e2.isEmpty()){
			System.out.println("Victoire de " + e1.toString());
		} else {
			System.out.println("Egalité");
		}


	}
}