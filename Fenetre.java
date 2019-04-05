import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Fenetre extends JFrame{
	
	private Vequipe e1, e2;
	public JList jle1, jle2;
	private JTextArea jlabe1, jlabe2;

	public Fenetre(Vequipe equipe1, Vequipe equipe2){
		super("Combat");
		this.setSize(400, 200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		

		this.e1 = equipe1;
		this.e2 = equipe2;

		jle1 = new JList(e1); //creation de la premiere JList et de son ActionListener qui gere Jouer.flag
		jle1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		jle1.addListSelectionListener(new ListSelectionListener(){
			public void valueChanged(ListSelectionEvent e){
				Carte c = (Carte)((JList)e.getSource()).getSelectedValue();
				if (! e.getValueIsAdjusting() && c != null){ //pour eviter des bugs de null pointer
					//affichage
					jlabe1.setText(c.affichageGraphique());
					System.out.println(c.affichageConsole());

					//selection de la carte pour la class Jouer
					if(Jouer.getflag() == 0){
						Jouer.setc1(c);
					}

					if((Jouer.getflag() == 1) || (Jouer.getflag() == 2)){
						Jouer.setc2(c);
						if(Jouer.getflag() == 1)
							Jouer.setflag(3);
						if(Jouer.getflag() == 2)
							Jouer.setflag(4);
					}
				}

			}
		});
		jle2 = new JList(e2); //creation de la deuxieme JList et de son ActionListener qui gere Jouer.flag
		jle2.addListSelectionListener(new ListSelectionListener(){
			public void valueChanged(ListSelectionEvent e){
				Carte c = (Carte)((JList)e.getSource()).getSelectedValue();
				if(! e.getValueIsAdjusting() && c != null){ //ppur eviter des bugs de nullpointer
					//affichage
					jlabe2.setText(c.affichageGraphique());
					System.out.println(c.affichageConsole());

					//selection de la carte pour la class Jouer
					if(Jouer.getflag() == 0){
						Jouer.setc1(c);
					}

					if((Jouer.getflag() == 1) || (Jouer.getflag() == 2)){
						Jouer.setc2(c);
						if(Jouer.getflag() == 1)
							Jouer.setflag(3);
						if(Jouer.getflag() == 2)
							Jouer.setflag(4);
					}
				}
			}
		});

		//creation des boutons et de leur ActionListener qui gere Jouer.flag
		JButton jbattaque = new JButton("Attaque");
		JButton jbsoigne = new JButton("Soigne");
		jbattaque.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(Jouer.getflag() == 0){
					Jouer.setflag(1);
				}
			}
		});
		jbsoigne.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(Jouer.getflag() == 0){
					Jouer.setflag(2);
				}
			}
		});

		//JPanel du haut (JList + boutons)
		JPanel jpselection = new JPanel();
		jpselection.add(jle1);
		jpselection.add(jbattaque);
		jpselection.add(jbsoigne);
		jpselection.add(jle2);

		//JTextArea pour l'affichage en details des cartes sélectionnées
		jlabe1 = new JTextArea(4, 10);
		jlabe2 = new JTextArea(4, 10);

		//JPanel du bas (JTextArea)
		JPanel jpaffichage = new JPanel();
		jpaffichage.add(jlabe1);
		jpaffichage.add(jlabe2);

		//positionnment des deux JPanel dans le JPanel principal
		JPanel jptotal = new JPanel();
		jptotal.setLayout(new BoxLayout(jptotal, BoxLayout.PAGE_AXIS));
		jptotal.add(jpselection);
		jptotal.add(jpaffichage);

		this.add(jptotal);

		this.setVisible(true);
	}

	public JList getjle1(){
		return jle1;
	}

	public JList getjle2(){
		return jle2;
	}
}