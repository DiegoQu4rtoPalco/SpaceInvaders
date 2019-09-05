package application;

import java.awt.Color;
import java.awt.Graphics;

public class Tiro {
	
	private int posicaoX, posicaoY, tamanhoX, tamanhoY;
	
	public Tiro() {
		posicaoX = 625;
		posicaoY = 50;
		tamanhoX = 10;
		tamanhoY = 50;
		
	}
	
	public void pintar(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(posicaoX, posicaoY, tamanhoX, tamanhoY);
	}
	
	

}
