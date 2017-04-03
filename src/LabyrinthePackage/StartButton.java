package LabyrinthePackage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;

import javax.swing.JButton;

public class StartButton extends JButton {
	
	StartButton(Chrono chrono){
		super("START");
		addActionListener(new TraiteBouton(chrono,this));
	
	}
	}


class TraiteBouton implements ActionListener {
private Chrono chrono;
private StartButton start;
TraiteBouton(Chrono chrono, StartButton start){ this.chrono = chrono;this.start=start; }
public void actionPerformed(ActionEvent e){ 
	chrono.depart(); 
	start.setEnabled(false);
	chrono.running=true;
	chrono.startTime = e.getWhen();
	}
}



