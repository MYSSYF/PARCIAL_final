package model;

import processing.core.PApplet;

public class Figura implements Runnable {

	private float posX;
	private float posY;
	private int r;
	private int g;
	private int b;
	private int TAMANO = 60;
	private int ran;
	private PApplet app;

	public Figura(float posX, float posY, int r, int g, int b, PApplet app) {

		this.posX = posX;
		this.posY = posY;
		this.app = app;
		this.r = r;
		this.g = g;
		this.b = b;
	

	}


	public void run() {

		mover();


		try {

			Thread.sleep(2000);

		} catch (InterruptedException e) {

			e.printStackTrace();

		}

	}

	public void dibujar() {

		app.fill(r, g, b);
		app.stroke(60,250,250);
		app.circle(posX, posY, TAMANO);

	}

	public void mover() {
	    posX += app.random(-2, 2);
	    posY += app.random(-2, 2);
		
		if(posX>900) {
			posX=-100;
		}
		if(posX<-100) {
			posX=900;
		}
		if(posY>900) {
			posY=-100;
		}
		if(posY<-100) {
			posY=900;
		}

	}
	
	public void moverConEstiloX(float f, float h, float c, float v) {
		if(f<h) {
			posX +=2;
		}
		if(f>h) {
			posX -=2;
		}
		if(c<v) {
			posY +=2;
		}
		if(c>v) {
			posY -=2;
		}

	}


	public float getPosX() {
		return posX;
	}

	public void setPosX(float posX) {
		this.posX = posX;
	}

	public float getPosY() {
		return posY;
	}

	public void setPosY(float posY) {
		this.posY = posY;
	}

}
