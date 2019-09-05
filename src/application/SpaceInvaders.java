package application;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class SpaceInvaders extends JPanel implements Runnable {
	
	private static final long serialVersionUID = 1L;

	
	public SpaceInvaders() {
		Thread processoDoJogo = new Thread(this);
		processoDoJogo.start();
		
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
		g.setColor(Color.BLACK);
		g.fillRect(50, 50, 100, 100);
	}

	private void atualizar() {
		// TODO Auto-generated method stub
		
	}
		
}
