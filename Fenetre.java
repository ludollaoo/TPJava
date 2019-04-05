import javax.swing.*;
import javax.swing.event.*;
import java.util.*;

public class Fenetre extends JFrame{
	
	Vequipe e1, e2;
	JTextArea jlabe1, jlabe2;

	public Fenetre(Vequipe equipe1, Vequipe equipe2){
		super("Combat");
		this.setSize(400, 200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		

		this.e1 = equipe1;
		this.e2 = equipe2;

		JList<Carte> jle1 = new JList<Carte>(e1);
		jle1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		jle1.addListSelectionListener(new ListSelectionListener(){
			public void valueChanged(ListSelectionEvent e){
				jlabe1.setText(((Carte)((JList)e.getSource()).getSelectedValue()).affichageGraphique());
				System.out.println(((Carte)((JList)e.getSource()).getSelectedValue()).affichageConsole());
			}
		});
		JList<Carte> jle2 = new JList<Carte>(e2);
		jle2.addListSelectionListener(new ListSelectionListener(){
			public void valueChanged(ListSelectionEvent e){
				jlabe2.setText(((Carte)((JList)e.getSource()).getSelectedValue()).affichageGraphique());
				System.out.println(((Carte)((JList)e.getSource()).getSelectedValue()).affichageConsole());
			}
		});
		JButton jbattaque = new JButton("Attaque");
		JButton jbsoigne = new JButton("Soigne");

		JPanel jpselection = new JPanel();
		jpselection.add(jle1);
		jpselection.add(jbattaque);
		jpselection.add(jbsoigne);
		jpselection.add(jle2);

		jlabe1 = new JTextArea(4, 10);
		jlabe2 = new JTextArea(4, 10);

		JPanel jpaffichage = new JPanel();
		jpaffichage.add(jlabe1);
		jpaffichage.add(jlabe2);

		JPanel jptotal = new JPanel();
		jptotal.setLayout(new BoxLayout(jptotal, BoxLayout.PAGE_AXIS));
		jptotal.add(jpselection);
		jptotal.add(jpaffichage);

		this.add(jptotal);

		this.setVisible(true);
	}
}