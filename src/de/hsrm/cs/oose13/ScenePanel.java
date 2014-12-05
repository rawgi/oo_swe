package de.hsrm.cs.oose13;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class ScenePanel extends JPanel{
	
	CollisionScene collScene;
	int delay = 30;
	ActionListener aListener = new ActionListener() {
		public void actionPerformed(ActionEvent evt) {
			collScene.move();
			collScene.collisions();
			repaint();
		}
	};
	Timer timer = new Timer(delay, aListener);
	
	public ScenePanel(CollisionScene cs){
		this.collScene = cs;
	}
	
	@Override
	public Dimension getPreferredSize(){
		return new Dimension(collScene.getWidth(), collScene.getHeight());
	}
	
	@Override
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		collScene.paintAll(g);
	}
	
	public void show(){
		  JFrame f = new JFrame("Geo-Scene");
		  f.add(this);
		  f.pack();
		  f.setVisible(true);
		  f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		  timer.start();
	}
}