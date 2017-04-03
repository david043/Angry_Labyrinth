package LabyrinthePackage;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class Graphique{
	
int largeur;
int hauteur;


	Graphique(int x)
	{
		hauteur = x;
		largeur = x;
		JFrame f= new JFrame("Labyrinthe");
		f.setSize(675,740);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setLocationRelativeTo(null);
		f.setLayout(new BorderLayout());
		JPanel p = (JPanel)f.getContentPane();
		JPanel top = new JPanel();
		f.add(top,BorderLayout.NORTH);
		Chrono chrono = new Chrono();
		StartButton start = new StartButton(chrono);
		top.add("West",chrono);
		top.add("East",start);
	
		Board lab = new Board(largeur,hauteur,chrono);
		p.add(lab);
		f.setVisible(true);
	}
	
}

