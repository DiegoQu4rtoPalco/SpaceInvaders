package application;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JPanel;

public class SpaceInvaders extends JPanel implements Runnable, KeyListener {
	
	private static final long serialVersionUID = 1L;
	
	private Nave nave;
	private ArrayList <Tiro> tiro;
	private Inimigo inimigo;
	

	
	public SpaceInvaders() {
		Thread processoDoJogo = new Thread(this);
		processoDoJogo.start();
		nave = new Nave();
		tiro = new ArrayList<Tiro>();
		inimigo = new Inimigo(600, 50);
		
	}

	@Override
	public void run() {
		while(true) {
			atualizar();
			repaint();
			dorme();
		}
		
	}
	
	private void dorme() {
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
		inimigo.pintar(g);
		
		
	}

	private void atualizar() {
		nave.movimentar();
		
		for(int i = 0; i < tiro.size(); i++) {
			tiro.get(i).direcaoY();
			if(tiro.get(i).limite()) {
				tiro.remove(i);
				i--;
			}
		}
				
		System.out.println(tiro.size());
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_SPACE && nave.limite()) {
			tiro.add(nave.atirar());
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
	
		
	}
		
}
