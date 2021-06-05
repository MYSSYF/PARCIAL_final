package view;

import java.util.LinkedList;

import model.Figura;
import processing.core.PApplet;

public class Main extends PApplet {
	public static void main(String[] args) {
		PApplet.main(Main.class.getName());
	}

	private LinkedList<Figura> polo;
	private LinkedList<Figura> marco;

	private int CANTIDAD_POLOS = 20;
	private int CANTIDAD_MARCOS = 1;

	public void settings() {
		size(800, 800);

	}

	public void setup() {

		polo = new LinkedList<Figura>();

		for (int i = 0; i < CANTIDAD_POLOS; i++) {

			float posX = random(100, 700);
			float posY = random(100, 700);
			Figura temp = new Figura(posX, posY, 147, 229, 255, this);
			polo.add(temp);

		}
		marco = new LinkedList<Figura>();

		for (int i = 0; i < CANTIDAD_MARCOS; i++) {

			figura_nueva();

		}

	}

	public void draw() {

		background(255, 255, 255);
		close();

		for (int i = 0; i < polo.size(); i++) {

			polo.get(i).dibujar();

			new Thread(polo.get(i)).start();

		}
		for (int j = 0; j < marco.size(); j++) {

			marco.get(j).dibujar();

		}
	}

	private void close() {
		for (int i = 0; i < marco.size(); i++) {

			marco.get(i).moverConEstiloX(marco.get(i).getPosX(), polo.get(i).getPosX(), marco.get(i).getPosY(),
					polo.get(i).getPosY());

			if (dist(marco.get(i).getPosX(), marco.get(i).getPosY(), polo.get(i).getPosX(),
					polo.get(i).getPosY()) <= 10) {

				polo.remove(i);

				//activar si quiere generar nuevos marcos, pero lanza un java.lang.IndexOutOfBoundsException: Index: 10, Size: 10
				//figura_nueva();

			}

		}
	}

	private void figura_nueva() {
		float posX = random(100, 700);
		float posY = random(100, 700);

		Figura temp2 = new Figura(posX, posY, 174, 43, 123, this);
		marco.add(temp2);

	}

}