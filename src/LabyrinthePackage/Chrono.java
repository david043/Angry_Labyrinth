package LabyrinthePackage;

 
 
import java.awt.event.*;

import javax.swing.*;
 
public class Chrono extends JLabel implements ActionListener {
 
private static final long serialVersionUID = 1L;
 
public long startTime; // Start time of stopwatch.
public long endTime; 
public boolean running; // True when the stopwatch is running.
public Timer timer; // A timer that will generate events
// while the stopwatch is running
 
public Chrono() {
// Constructor.
super("00:00", JLabel.CENTER);

}

public void depart(){
	timer = new Timer(1,this);
	timer.start();
}

public void stop(){
	running=false;
	timer.stop();
	long time = (endTime - startTime);

	long seconds = (time / 1000) % 60;
	long minutes = time / 1000 / 60;
	
		if(seconds<10)
		{
			
			setText("0" + minutes + ":0" + seconds);
		}
		else
		{
			setText("0" + minutes + ":" + seconds);
		}
			
	
	
		if(seconds<10)
		{
			setText("0" + minutes + ":0" + seconds );
		}
		else
		{
			setText("0" + minutes + ":" + seconds);
		}
	}

 
public void actionPerformed(ActionEvent evt) {
// This will be called when an event from the
// timer is received. It just sets the stopwatch
// to show the amount of time that it has been running.
// Time is rounded down to the nearest second.
	
	if(running==true){
long seconds = ((System.currentTimeMillis() - startTime) / 1000) % 60;
long minutes = (System.currentTimeMillis() - startTime) / 1000 / 60;


	if(seconds<10)
	{
		setText("0" + minutes + ":0" + seconds);
	}
	else
	{
		setText("0" + minutes + ":" + seconds);
	}
		


	if(seconds<10)
	{
		setText("0" + minutes + ":0" + seconds);
	}
	else
	{
		setText("0" + minutes + ":" + seconds);
	}

}
	

	
}
 
}

	