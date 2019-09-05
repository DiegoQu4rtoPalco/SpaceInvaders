package application;

import javax.swing.JFrame;

public class Main {
	
	public static int LARGURA = 1366, ALTURA = 768;
	
	public static void main (String [] args) {
		
		JFrame janela = new JFrame("SpaceInvaders");
		janela.setSize(LARGURA, ALTURA);
		janela.setVisible(true);
		janela.setResizable(false);
		//janela.setLocationRelativeTo(null); Descomente caso queira nascer a tela no centro
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		SpaceInvaders spaceInvaders = new SpaceInvaders();
		spaceInvaders.setBounds(0, 0, LARGURA, ALTURA);
		janela.add(spaceInvaders);
		janela.addKeyListener(spaceInvaders);
		
	}

}
