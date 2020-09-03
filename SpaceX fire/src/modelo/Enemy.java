package modelo;

import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Enemy {

	private int x, y, dx, dy, height, width;
	private Image imageEnemy;
	private boolean isVisible;

	private static final int VELOCITY = 2;

	public Enemy(int x, int y) {
		this.x = x;
		this.y = y;
		isVisible = true;
	}

	public void loadEnemy() {
		ImageIcon ref = new ImageIcon("img\\enemy1.png");
		imageEnemy = ref.getImage();

		height = imageEnemy.getHeight(null);
		width = imageEnemy.getWidth(null);

	}
	public Rectangle getBounds() {
		return new Rectangle(x, y, width, height);
		
	}
	
	public void updateEnemy() {
		this.x -= VELOCITY;
	}

	public void setVisible(boolean isVisible) {
		this.isVisible = isVisible;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public static int getVelocity() {
		return VELOCITY;
	}

	public boolean isVisible() {
		return isVisible;
	}

	public Image getImageEnemy() {
		return imageEnemy;
	}
	
	

}
