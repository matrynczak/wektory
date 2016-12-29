package wektory;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Random;

public class Wektor {
	private int x;
	private int y;
	private int r = 4;
	Color kolor;
	Random rnd;
	private int szer;
	private int wys;
	private int dx = 2;
	private int xr;
	private int yr;
	
	public Wektor(Dimension d){
		rnd = new Random();
		x = rnd.nextInt(d.width - 30);
		y = rnd.nextInt(d.height-30);
		kolor = new Color (rnd.nextFloat(), rnd.nextFloat(), rnd.nextFloat());
		szer = 20 + rnd.nextInt(40);
		wys = 1;
		xr = x -r;
		yr = y-r;
	}
	
	public void rysuj(Graphics g){
		g.setColor(kolor);
		g.fillRect(x, y, szer, wys);
		g.fillOval(xr, yr, 2*r, 2*r);
	}

	public void skupiaj(int x2, int y2) {
		x = x2;
		y = y2;
	}

	public void rozejdz(Dimension d) {
		x = rnd.nextInt(d.width - 50);
		y = rnd.nextInt(d.height - 50);
	}

	public void zwiekszDlugosc() {
		szer = szer + dx;
		
		if(szer >= 60 || szer <= 0) dx *= -1;
	}
	
	public void przesunKulke(){
		xr = xr + dx;
		
		if(xr >= x+szer || xr <= x-r) dx *= -1;
	}
}
