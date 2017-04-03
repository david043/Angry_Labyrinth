package LabyrinthePackage;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;


public class Board extends JPanel implements ActionListener{
	
	

	private static final long serialVersionUID = 1L;
	public Map m;
	boolean[][] boolMap;
	int largeur;
	int hauteur;
	private Image floor,wall, fin,floor1, wall1,fin1;
	boolean win = false;
	public Player p,p2; 
	public String Message = "", Message2 = "";
	public Font police = new Font("Arial",Font.BOLD,60);
	Chrono chrono;
	int taillebloc;
	public StartButton sb;
	
	
	public void actionPerformed(ActionEvent e){
		
		if(p.getBlocX() == (2*largeur)+1 && p.getBlocY() == (2*largeur)-1 && !win)
		{ Message="BRAVO !" ;
		Message2 = "Joueur 1 a gagné !";

		chrono.running=false;
		chrono.endTime=e.getWhen();
		chrono.timer.stop();
		chrono.stop();
		win = true;
		}
		
		if(p2.getBlocX() == (2*largeur)+1 && p2.getBlocY() == (2*largeur)-1 && !win)
		{ Message="BRAVO !" ;
		Message2 = "Joueur 2 a gagné !";
		chrono.running=false;
		chrono.endTime=e.getWhen();
		chrono.timer.stop();
		chrono.stop();
		win = true;
	
		}
		repaint();
	}
	
Board(int hauteur, int largeur, Chrono chrono){
		
		this.taillebloc  = 660/(2*hauteur+1);
		
		ImageIcon img = new ImageIcon("/Users/dav2802/Documents/JAVA/Labyrinthe2/images/redbrick.png");
		wall1= img.getImage();
		wall = wall1.getScaledInstance(taillebloc,taillebloc,Image.SCALE_DEFAULT);

		img = new ImageIcon("/Users/dav2802/Documents/JAVA/Labyrinthe2/images/grass.jpg");
		floor1= img.getImage();
		floor	= floor1.getScaledInstance(taillebloc,taillebloc,Image.SCALE_DEFAULT);
		img = new ImageIcon("/Users/dav2802/Documents/JAVA/Labyrinthe2/images/flag.png");
		fin1 = img.getImage();
		fin	= fin1.getScaledInstance(taillebloc,taillebloc,Image.SCALE_DEFAULT);


		this.chrono=chrono;
		this.largeur=largeur;
		this.hauteur=hauteur;
		Map m = new Map(largeur,hauteur);
		img = new ImageIcon("./images/playerx.png");		
		p = new Player(taillebloc, img);
		img = new ImageIcon("./images/playery.png");		
		p2 = new Player(taillebloc, img);
		addKeyListener(new ActionListener());
		setFocusable(true);
		boolMap=m.makeMaze();
		Timer boardTimer = new Timer(25, this);
		boardTimer.start();
	}
	
	public void paint(Graphics g) {
		super.paint(g);		
		
		
		for(int y=0;y<2*hauteur+1;y++){
			for(int x=0;x<2*largeur+1;x++){
				if(!boolMap[x][y]){
					g.drawImage(wall,y*taillebloc+10, x*taillebloc+10, null);
				}
				else{
					g.drawImage(floor,y*taillebloc+10, x*taillebloc+10, null);
				}
				
			}
		}
		g.setFont(police);
		g.setColor(Color.BLACK);
		g.drawString(Message, 225, 350);
		g.drawString(Message2, 65, 405);
		
		g.setColor(Color.YELLOW);
		g.drawString(Message, 220, 345);
		g.drawString(Message2, 60, 400);
	
		g.drawImage(fin,(2*hauteur)*taillebloc+10,(2*largeur-1)*taillebloc +10,null );
		g.drawImage(p.getPlayer(), p.getBlocX()*taillebloc-taillebloc+10, p.getBlocY()*taillebloc+10, null);
		g.drawImage(p2.getPlayer(), p2.getBlocX()*taillebloc-taillebloc+10, p2.getBlocY()*taillebloc+10, null);

	}


public class ActionListener extends KeyAdapter
{
	public void keyPressed(KeyEvent e){
		int keycode = e.getKeyCode();
		if(!win){     //si on n'a pas encore gagné
		if(keycode == KeyEvent.VK_UP && boolMap[p.getBlocY()-1][p.getBlocX()-1])
		{	
			p.move(0,-1);
		}
		if(keycode == KeyEvent.VK_DOWN && boolMap[p.getBlocY()+1][p.getBlocX()-1])
		{
			p.move(0,1);
		}
		if(keycode == KeyEvent.VK_LEFT && boolMap[p.getBlocY()][p.getBlocX()-1-1])
		{
				p.move(-1,0);
		} 
		if(keycode == KeyEvent.VK_RIGHT && boolMap[p.getBlocY()][p.getBlocX()-1+1]){
			p.move(1,0);
		}
		if(keycode == KeyEvent.VK_Z && boolMap[p2.getBlocY()-1][p2.getBlocX()-1])
		{
				p2.move(0,-1);
		}
		if(keycode == KeyEvent.VK_S && boolMap[p2.getBlocY()+1][p2.getBlocX()-1])
		{
			p2.move(0,1);
		}
		if(keycode == KeyEvent.VK_Q && boolMap[p2.getBlocY()][p2.getBlocX()-1-1])
		{	
			p2.move(-1,0);
		} 
		if(keycode == KeyEvent.VK_D && boolMap[p2.getBlocY()][p2.getBlocX()-1+1])
		{	
			p2.move(1,0);
		}
		}
	}
	
	public void keyReleased(KeyEvent e){
		
	}
	public void keyTyped(KeyEvent e){
		
	}
}
}

