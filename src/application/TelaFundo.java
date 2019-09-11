package application;

import java.awt.Color;
import java.awt.Graphics;

public class TelaFundo {
	
	private int posX, posY, tamX, tamY;
	
	public TelaFundo(int indiceX, int indiceY) {
		
		this.posX = indiceX;
		this.posY = indiceY;
		tamX = 10;
		tamY = 10;
		
	}
	
	public void pintar(Graphics g) {
		g.setColor(Color.DARK_GRAY);
		g.fillRect(posX, posY, tamX, tamY);
	}
	

}
