package modelo;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

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

	public Fase() {

		setFocusable(true);
		setDoubleBuffered(true);

		// Criando uma icone para importar a imagem de fundo
		ImageIcon ref = new ImageIcon("img\\background.png");
		image = ref.getImage();

		player = new Player();
		player.loadPlayer();

		addKeyListener(new TecladoAdapter());

		timer = new Timer(5, this);
		timer.start();

	}

	public void paint(Graphics g) {

		Graphics2D grafic = (Graphics2D) g;
		// desenhando a imagem no painel do jframe
		grafic.drawImage(image, 0, 0, null);

		grafic.drawImage(((Player) player).getImagePlayer(), player.getX(), player.getY(), this);
		g.dispose();

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		player.updatePlayer();
		repaint();

	}

	private class TecladoAdapter extends KeyAdapter {
		@Override
		public void keyPressed(KeyEvent t) {
			player.keyPressed(t);
		}

		@Override
		public void keyReleased(KeyEvent t) {
			player.keyReleased(t);
		}
	}

}
