package application;

import java.awt.Color;
import java.awt.Graphics;

public class Inimigo {
	
	private int posicaoX, posicaoY, tamanhoX, tamanhoY, velocidade;
	
	public Inimigo(int indiceX, int indiceY) {
		this.posicaoX = indiceX;
		this.posicaoY = indiceY;
		tamanhoX = 80;
		tamanhoY = 80;
		velocidade = 2;
	}
	
	public void pintar(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(posicaoX, posicaoY, tamanhoX, tamanhoY);
		
	}
	


}
