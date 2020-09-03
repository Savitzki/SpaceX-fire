package modelo;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Missile {

	private int x, y, dx, dy, height, width;
	private Image imageMissile;
	private boolean isVisible;

	private static final int VELOCITY = 2;
	private static final int WIDTH = 930;

	public Missile(int x, int y) {
		this.x = x;
		this.y = y;
		isVisible = true;
	}

	public void loadMissile() {
		ImageIcon ref = new ImageIcon("img\\simpleShot.png");
		imageMissile = ref.getImage();

		height = imageMissile.getHeight(null);
		width = imageMissile.getWidth(null);

	}

	public void updateMissile() {
		this.x += VELOCITY;
		if (this.x > WIDTH) {
			isVisible = false;
		}
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

	public void setImageMissile(Image imageMissile) {
		this.imageMissile = imageMissile;
	}

	public Image getImageMissile() {
		return imageMissile;
	}
	
	

}
