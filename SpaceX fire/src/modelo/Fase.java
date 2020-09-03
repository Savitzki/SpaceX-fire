package modelo;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Fase extends JPanel implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Image image;
	private Player player;
	private Timer timer;
	private boolean inGame;

	private List<Enemy> enemies;

	public Fase() {

		setFocusable(true);
		setDoubleBuffered(true);
		inGame = true;

		// Criando uma icone para importar a imagem de fundo
		ImageIcon ref = new ImageIcon("img\\background.png");
		image = ref.getImage();

		player = new Player();
		player.loadPlayer();

		addKeyListener(new TecladoAdapter());

		timer = new Timer(5, this);
		timer.start();

		initEnemies();
	}

	public void initEnemies() {
		int coord[] = new int[40];
		
		enemies = new ArrayList<Enemy>();

		for (int i = 0; i < coord.length; i++) {
			int x = (int) (Math.random() * 8000 + 1024);
			int y = (int) (Math.random() * 650 + 30);
			enemies.add(new Enemy(x, y));
		}

	}

	public void paint(Graphics g) {

		Graphics2D grafic = (Graphics2D) g;

		if (inGame == true) {
			// desenhando a imagem do background na view
			grafic.drawImage(image, 0, 0, null);

			// desenhando o player na view
			grafic.drawImage(player.getImagePlayer(), player.getX(), player.getY(), this);

			List<Missile> missiles = player.getMissiles();
			for (int i = 0; i < missiles.size(); i++) {
				Missile m = missiles.get(i);
				m.loadMissile();
				grafic.drawImage(m.getImageMissile(), m.getX(), m.getY(), this);
			}

			for (int j = 0; j < enemies.size(); j++) {
				Enemy en = enemies.get(j);
				en.loadEnemy();
				grafic.drawImage(en.getImageEnemy(), en.getX(), en.getY(), this);
			}
		} else {
			ImageIcon gameOver = new ImageIcon("img\\gameOver.png");
			grafic.drawImage(gameOver.getImage(), 330, 100, null);
			
			
		}

		g.dispose();

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		player.updatePlayer();
		List<Missile> missiles = player.getMissiles();
		for (int i = 0; i < missiles.size(); i++) {
			Missile m = missiles.get(i);
			if (m.isVisible()) {
				m.updateMissile();
			} else {
				missiles.remove(i);
			}
		}

		for (int j = 0; j < enemies.size(); j++) {
			Enemy en = enemies.get(j);
			if (en.isVisible()) {
				en.updateEnemy();
			} else {
				enemies.remove(j);
			}
		}
		checkColisions();
		repaint();

	}

	public void checkColisions() {
		Rectangle formPlayer = player.getBounds();
		Rectangle formEnemy;
		Rectangle formMissile;

		for (int i = 0; i < enemies.size(); i++) {
			Enemy tempEnemy = enemies.get(i);
			formEnemy = tempEnemy.getBounds();
			if (formPlayer.intersects(formEnemy)) {
				player.setVisible(false);
				tempEnemy.setVisible(false);
				inGame = false;
			}
		}

		List<Missile> missiles = player.getMissiles();
		for (int j = 0; j < missiles.size(); j++) {
			Missile tempMiss = missiles.get(j);
			formMissile = tempMiss.getBounds();
			for (int k = 0; k < enemies.size(); k++) {
				Enemy tempEnemy = enemies.get(k);
				formEnemy = tempEnemy.getBounds();
				if (formMissile.intersects(formEnemy)) {
					tempEnemy.setVisible(false);
					tempMiss.setVisible(false);
				}
			}

		}
	}

	// classe para verificar a captura de teclas (movimentaçao do player)
	private class TecladoAdapter extends KeyAdapter {
		@Override
		public void keyPressed(KeyEvent t) {
			
			if (t.getKeyCode() == KeyEvent.VK_ENTER) {
				inGame= true;
				player = new Player();
				player.loadPlayer();
				initEnemies();
			}
			player.keyPressed(t);
		}

		@Override
		public void keyReleased(KeyEvent t) {
			player.keyReleased(t);
		}
	}

	

}
