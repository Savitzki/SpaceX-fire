package modelo;



import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Fase extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Image image;

	public Fase() {
	
		//Criando uma icone para importar a imagem de fundo
		ImageIcon ref = new ImageIcon("img\\background.png");
		image = ref.getImage();
		
	}
	
	public void paint(Graphics g) {
		
		Graphics2D grafic = (Graphics2D) g;
		//desenhando a imagem no painel do jframe
		grafic.drawImage(image, 0, 0, null);
		
	}

}
