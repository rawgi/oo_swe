package de.hsrm.cs.oose13;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class ScenePanel extends JPanel{
	
	CollisionScene collScene;
	int delay = 36;
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
	
	public Dimension getPreferredSize(){
		return new Dimension(collScene.getWidth(), collScene.getHeight());
	}
	
	protected void paintComponent(Graphics g){
		super.paintComponents(g);
		collScene.paintAll(g);
	}
}