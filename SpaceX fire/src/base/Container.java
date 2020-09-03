package base;

import javax.swing.JFrame;

import modelo.Fase;

public class Container extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Container() {
		
		//Adicionando um componente ao JFrame
		add(new Fase());
		
		//tamanho do JFrame
		setSize(1080, 720);
		
		//titulo do JFrame
		setTitle("SpaceX fire");
		
		//Opera��o padrao para quando a janela for fechada
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//propriedade para colocar em tela cheia
		this.setResizable(false);
		
		//Localiza��o da tela, null � centralizada
		setLocationRelativeTo(null);
		
		//visibilidade da tela
		setVisible(true);
		
	}
	
	public static void main(String[] args) {
		//instancia de novo objeto
		new Container();
	}

	
}
