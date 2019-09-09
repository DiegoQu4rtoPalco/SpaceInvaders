package application;

import java.awt.Color;
import java.awt.Graphics;

public class Inimigo {
	
	private int posicaoX, posicaoY, tamanhoX, tamanhoY, velocidade;
	
	public Inimigo(int indiceX, int indiceY) {
		this.posicaoX = indiceX;
		this.posicaoY = indiceY;
		tamanhoX = 45;
		tamanhoY = 45;
		velocidade = 2;
	}
	
	public void pintar(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(posicaoX, posicaoY, tamanhoX, tamanhoY);
		
	}
	
	public void movimentar() {
		posicaoX += velocidade;
		if(posicaoX >= 1366) {
			posicaoX = -50;
		}
		
	}
	
	public int getPosicaoX() {
		return posicaoX;
	}
	
	public int getPosicaoY() {
		return posicaoY;
	}
	
	public int getTamanhoX() {
		return tamanhoX;
	}
	public int getTamanhoY() {
		return tamanhoY;
	}
	


}
