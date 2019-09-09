package application;

import java.awt.Color;
import java.awt.Graphics;

public class Inimigo {
	
	private int posicaoX, posicaoY, tamanhoX, tamanhoY, velocidade, direcao;
	
	public Inimigo(int indiceX, int indiceY, int direcao) {
		this.posicaoX = indiceX;
		this.posicaoY = indiceY;
		this.direcao = direcao;
		tamanhoX = 45;
		tamanhoY = 45;
		velocidade = 2;
		
	}
	
	public void pintar(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(posicaoX, posicaoY, tamanhoX, tamanhoY);
		
	}
	
	public void movimentar() {
		posicaoX += velocidade * direcao;
	}
	
	public void trocaDirecao() {
		direcao = direcao *= -1;
		posicaoY+= 20;
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
