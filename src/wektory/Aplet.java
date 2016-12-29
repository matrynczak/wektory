package wektory;

import java.applet.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class Aplet extends Applet{
	Wektor wektor;
	Random rnd;
	private ArrayList<Wektor> wektory = new ArrayList();

	@Override
	public void init() {
		rnd = new Random();
		int n = 5 + rnd.nextInt(15);
		setSize(500,500);
		setBackground(Color.white);
		Dimension d = getSize();
		for (int i=0; i<n; i++)
			wektory.add(new Wektor(d));
		
		addMouseListener (new MouseAdapter(){

			@Override
			public void mouseClicked(MouseEvent e) {
				Dimension d = getSize();
				if(e.getButton() == MouseEvent.BUTTON1)
					for(Wektor w : wektory)
						w.skupiaj(e.getX(), e.getY());
					repaint();
				if(e.getButton() == MouseEvent.BUTTON3)
					for(Wektor w : wektory)
						w.rozejdz(d);
			}
			
		});
		
		class Animacja extends TimerTask{

			@Override
			public void run() {
				for (Wektor w : wektory)
					w.przesunKulke();
				repaint();
			}
		}
		
		Timer ruch = new Timer();
		ruch.schedule(new Animacja(), 1000, 200);
	}

	@Override
	public void paint(Graphics g) {
		for (Wektor w : wektory)
			w.rysuj(g);
	}
	
	
}
