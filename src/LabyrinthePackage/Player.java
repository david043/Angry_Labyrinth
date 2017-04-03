package LabyrinthePackage;

import java.awt.Image;

import javax.swing.*;

public class Player  {
	
private int blocX,blocY;	
private Image player,player1;

	public Player(int taillebloc, ImageIcon img){
		player1 = img.getImage();
		player	= player1.getScaledInstance(taillebloc,taillebloc,Image.SCALE_DEFAULT);

		blocX = 1;
		blocY = 1;
	}
	
	public Image getPlayer(){
		return player;
	}
	
	public int getBlocX(){
		return blocX;
	}
	public int getBlocY(){
		return blocY;
	}
	
public void move( int tx,int ty){

	
	blocX +=tx;
	blocY +=ty;
}
}
