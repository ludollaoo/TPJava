class Jouer{


	

	//premiere version de jouer
	//les cartes sont selectionnées l'une après l'autre
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

	//deuxieme version de jouer
	//les cartes sont sélectionnés qui doivent exécuter l'action sont sélectionneés en temps réel
	//cette fonction necessite des variables globales
	private static Carte c1, c2;
	private static Combattant combattant;
	private static Soigneur soigneur;
	private static Paladin paladin;
	private static int flag;

	public static void jouer2(){

		System.out.println("Lancement du jeu");

		int tour = 0;
		//initialisation des equipes et des cartes
		Vequipe e1 = new Vequipe(1);
		Vequipe e2 = new Vequipe(2);
		e1.add(new Goliath());
		e1.add(new Galaad());
		e2.add(new Minotaure());
		e2.add(new Panoramix());

		//initialisation graphique
		Fenetre f1 = new Fenetre(e1, e2);

		//debut du jeu
		while(!(e1.isEmpty()) && !(e2.isEmpty())){
			if(tour > 50){break;} //limitation du temps de jeu

			System.out.println("Tour : " + tour);

			//selection de la premiere carte
			System.out.println("Choix de la carte");
			while(true){ //attente d'event sur l'un des boutons, flag passe 1(attaque) ou 2(soigne)
				System.out.print("");
				if(flag == 1 || flag == 2){
					break;
				}
			}
			System.out.println("Choix de la cible"); 
			while(true){ //attente d'event sur l'une des JList, le choix de la carte 2, pour le flag 1 devient 3, 2 devient 4
				System.out.print("");
				if((flag == 4) || (flag == 3)){
					System.out.println("Break choix de c2");
					break;
				}
			}

			if(flag == 4){ //flag == 4 on soigne
				if(c1 instanceof Soigneur){
					soigneur = (Soigneur) c1;
					soigneur.soigne(c2);
				}
				if(c1 instanceof Paladin){
					paladin = (Paladin) c1;
					paladin.soigne(c2);
				}
			}
			if(flag == 3){ //flag == 3 on attaque
				if(c1 instanceof Combattant){
					combattant = (Combattant) c1;
					combattant.attaque(c2);
				}
				if(c1 instanceof Paladin){
					paladin = (Paladin) c1;
					paladin.attaque(c2);
				}
			}
			
			setflag(0); // on reinitialise le flag
			f1.getjle1().clearSelection(); //on clear les JList pour pouvoir selectionner de nouveau
			f1.getjle2().clearSelection();
			e1.nettoyer(); //on enleve les morts
			e2.nettoyer();
			tour++;
		}
		if(e1.isEmpty()){
			System.out.println("Victoire de " + e2.toString());
		} else if(e2.isEmpty()){
			System.out.println("Victoire de " + e1.toString());
		} else {
			System.out.println("Egalité");
		}


	}

	public static void setc1(Carte c){
		System.out.println("c1 set to " + c.toString());
		Jouer.c1 = c;
	}

	public static void setc2(Carte c){
		System.out.println("c2 set to " + c.toString());
		Jouer.c2 = c;
	}

	public static void setflag(int i){
		System.out.println("flag set to " + i);
		Jouer.flag = i;
	}

	public static int getflag(){
		return flag;
	}
}