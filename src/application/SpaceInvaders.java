package application;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JPanel;

public class SpaceInvaders extends JPanel implements Runnable, KeyListener {
	
	private static final long serialVersionUID = 1L;
	
	private Nave nave;
	private ArrayList <Tiro> tiro;
	private ArrayList<Inimigo> inimigo;
	private int direcao;
	private boolean ganhou;
	private Font mensagemGanhou = new Font ("Consolas", Font.BOLD, 20);
	
	
	

	
	public SpaceInvaders() {
		Thread processoDoJogo = new Thread(this);
		processoDoJogo.start();
		nave = new Nave();
		tiro = new ArrayList<Tiro>();
		
		inimigo = new ArrayList<Inimigo>();
		for(int i = 0; i < 60; i++) {
			inimigo.add(new Inimigo(50 + i%20 * 50, 50 + i/20 * 50, 1));
		}
		direcao = 0;
		ganhou = false;
		
	}

	@Override
	public void run() {
		while(true) {
			
			long tempoInicial = System.currentTimeMillis();
			atualizar();
			repaint();
			
			long tempoFinal = System.currentTimeMillis();
			long diferenca = 16 - (tempoFinal - tempoInicial);
			if(diferenca > 0) {
				dorme(diferenca);
			}
		}
		
	}
	
	private void dorme(long diferenca) {
		try {
			Thread.sleep(1000/60);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		nave.pintar(g);
		
		for(int i = 0; i < tiro.size(); i++) {
			tiro.get(i).pintar(g);
		}
		for(int i = 0; i < inimigo.size(); i++) {
			inimigo.get(i).pintar(g);
		}
		
		TelaFundo telaFundo = new TelaFundo(new Random().nextInt(1366), new Random().nextInt(768));
		telaFundo.pintar(g);
		
		if(ganhou) {
			g.setColor(Color.BLUE);
			g.setFont(mensagemGanhou);
			g.drawString("Voc� ganhou !!!", 550, 500);
		}
		
	}

	private void atualizar() {
		if(inimigo.size() == 0) {
			ganhou = true;
		}
		
		if(nave != null) {
			nave.movimentar(direcao);
		}
		
		for(int i = 0; i < inimigo.size(); i++) {
			inimigo.get(i).movimentar();
		}

		for(int i = 0; i < tiro.size(); i++) {
			tiro.get(i).direcaoY();
			if(tiro.get(i).limite()) {
				tiro.remove(i);
				i--;
			}
			else {
				for(int j = 0; j < inimigo.size(); j++) {
					if(tiro.get(i).colisaoInimigo(inimigo.get(j))) {
						tiro.remove(i);
						inimigo.remove(j);
						j--;
						break;
					}
				}
				}
			}
		for(int i = 0; i < inimigo.size(); i++) {
			if(inimigo.get(i).getPosicaoX() <= 0 || inimigo.get(i).getPosicaoX() >= 1366 - 45) {
				for(int j = 0; j < inimigo.size(); j++) {
				inimigo.get(j).trocaDirecao();	
				}
				break;
			}
		}
		}


	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_D) {
			direcao = 1;
		}
		if(e.getKeyCode() == KeyEvent.VK_A) {
			direcao = -1;
		}
		if(e.getKeyCode() == KeyEvent.VK_SPACE && nave.limite()) {
			tiro.add(nave.atirar());
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_D || e.getKeyCode() == KeyEvent.VK_A ) {
			direcao = 0;
		}
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
	
		
	}
		
}
