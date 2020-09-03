package modelo;

import java.awt.Image;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;

public class Player {

	private int x, y, dx, dy, height, width;
	private Image imagePlayer;
	private List<Missile> missiles;

	public Player() {

		this.x = 100;
		this.y = 100;
		
		missiles = new ArrayList<Missile>();
	}

	// metodo para ler a imagem do player e definir o seu tamanho no painel
	public void loadPlayer() {
		ImageIcon ref = new ImageIcon("img\\spaceship.png");
		imagePlayer = ref.getImage();

		height = imagePlayer.getHeight(null);
		width = imagePlayer.getWidth(null);
	}

	// metodo para atualizar o player
	public void updatePlayer() {
		x += dx;
		y += dy;
		
		
//delimita o player dentro da tela visivel
		if (x > 920) {
			x = 920;
		}
		if (x < 0) {
			x = 1;
		}
		if (y > 600) {
			y = 600;
		}
		if (y < 0) {
			y = 1;
		}
	}
	
	public void simpleMissile() {
		this.missiles.add(new Missile(x+width, (y+height/2)));
	}

	public void keyPressed(KeyEvent k) {
		int cod = k.getKeyCode();
		
		if (cod == KeyEvent.VK_SPACE) {
			simpleMissile();

		}
		if (cod == KeyEvent.VK_UP) {
			dy = -3;

		}
		if (cod == KeyEvent.VK_DOWN) {
			dy = 3;

		}
		if (cod == KeyEvent.VK_LEFT) {
			dx = -3;

		}
		if (cod == KeyEvent.VK_RIGHT) {
			dx = 3;

		}
	}
	
	public void keyReleased(KeyEvent k) {
		int cod = k.getKeyCode();

		if (cod == KeyEvent.VK_UP) {
			dy = 0;

		}
		if (cod == KeyEvent.VK_DOWN) {
			dy = 0;

		}
		if (cod == KeyEvent.VK_LEFT) {
			dx = 0;

		}
		if (cod == KeyEvent.VK_RIGHT) {
			dx = 0;

		}
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public Image getImagePlayer() {
		return imagePlayer;
	}

	public List<Missile> getMissiles() {
		return missiles;
	}
	
	

}

