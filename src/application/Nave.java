package application;

import java.awt.Color;
import java.awt.Graphics;

public class Nave {
	
	private int posicaoX, posicaoY, tamanhoX, tamanhoY;
	
	public Nave() {
		posicaoX = 600;
		posicaoY = 600;
		tamanhoX = 100;
		tamanhoY = 90;
	}
	
	public void pintar(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(posicaoX, posicaoY, tamanhoX, tamanhoY);
	}

}
