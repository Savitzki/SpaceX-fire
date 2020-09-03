package modelo;

import java.awt.Image;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

public class Player {

	private int x, y, dx, dy, altura, largura;
	private Image imagePlayer;

	public Player() {

		this.x = 100;
		this.y = 100;
	}

	// metodo para ler a imagem do player e definir o seu tamanho no painel
	public void loadPlayer() {
		ImageIcon ref = new ImageIcon("img\\spaceship.png");
		imagePlayer = ref.getImage();

		altura = imagePlayer.getHeight(null);
		largura = imagePlayer.getWidth(null);
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

	public void keyPressed(KeyEvent k) {
		int cod = k.getKeyCode();

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

}
