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

	
	public SpaceInvaders() {
		Thread processoDoJogo = new Thread(this);
		processoDoJogo.start();
		nave = new Nave();
		tiro = new ArrayList<Tiro>();
		
		
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
		
	}

	private void atualizar() {
		for(int i = 0; i < tiro.size(); i++) {
			tiro.get(i).direcaoY();
		}
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_SPACE) {
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
