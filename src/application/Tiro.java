package application;

import java.awt.Color;
import java.awt.Graphics;

public class Tiro {
	
	private int posicaoX, posicaoY, tamanhoX, tamanhoY, velocidade;

	
	public Tiro(int indiceX, int indiceY) {
		this.posicaoX = indiceX;
		posicaoY = indiceY;
		tamanhoX = 10;
		tamanhoY = 50;
		velocidade = 3;
		
	}
	
	public void pintar(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(posicaoX, posicaoY, tamanhoX, tamanhoY);
	}
	
	public void direcaoY() {
		posicaoY -= velocidade;
	}
	
	public boolean limite() {
		return posicaoY <= 0;
	}
	
	public boolean colisaoInimigo(Inimigo inimigo) {
		if(posicaoX >= inimigo.getPosicaoX() && posicaoX + tamanhoX <= inimigo.getPosicaoX() + inimigo.getTamanhoX()) {
			if(posicaoY <= inimigo.getPosicaoY() + inimigo.getTamanhoY()) {
				return true;
			}
		}
		return false;
	}
}
