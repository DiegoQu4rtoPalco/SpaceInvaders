package application;

import java.awt.Color;
import java.awt.Graphics;

public class Nave {
	
	private int posicaoX, posicaoY, tamanhoX, tamanhoY;
	private boolean tiroLimite;
	private int tempo, frames;
		
	public Nave() {
		posicaoX = 600;
		posicaoY = 600;
		tamanhoX = 100;
		tamanhoY = 90;
		tiroLimite = true; tempo = 0; frames = 20;
		
	}
	
	public void pintar(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(posicaoX - tamanhoX / 2, posicaoY, tamanhoX, tamanhoY);
	}
	
	public Tiro atirar() {
		tiroLimite = false;
		Tiro tiro = new Tiro(posicaoX, posicaoY);
		return tiro;
	}
	
	public void movimentar() {
		
		if(tempo >= frames) {
			tiroLimite = true;
			tempo = 0;
		}
		tempo++;
	}
	
	public boolean limite () {
		return tiroLimite;
	}

}
