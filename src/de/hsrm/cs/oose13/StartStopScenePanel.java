package de.hsrm.cs.oose13;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class StartStopScenePanel extends ScenePanel{

	JButton btn = new JButton("Start/Stop");
	JButton speedUp = new JButton("+");
	JButton slowDown = new JButton("-");
	JLabel speed = new JLabel((int)(100-(delay-10)*2.5)+"%");
	JFrame f = new JFrame("Start-Stop-Geo-Scene");
	
	public StartStopScenePanel(CollisionScene cs){
		super(cs);
	}
	//100-(delay-10)*2,5.
	public void show(){
		btn.setBounds(collScene.getWidth()/2-100,collScene.getHeight()/2-25,200,50);
		btn.setBorder(new LineBorder(Color.black, 3));
		btn.setContentAreaFilled(false);
		btn.addActionListener(e -> {
			if(timer.isRunning()){
				timer.stop();
			}else{
				timer.start();
			}
		});
		speedUp.setBounds(collScene.getWidth()/2+2,collScene.getHeight()/2+27,20,20);
		speedUp.setBorder(new LineBorder(Color.black, 1));
		speedUp.setContentAreaFilled(false);
		speedUp.addActionListener(e -> {
			if(delay>10){
				delay-=4;
				timer.setDelay(delay);
				speed.setText((int)(100-(delay-10)*2.5)+"%");
			}
		});
		slowDown.setBounds(collScene.getWidth()/2-22,collScene.getHeight()/2+27,20,20);
		slowDown.setBorder(new LineBorder(Color.black, 1));
		slowDown.setContentAreaFilled(false);
		slowDown.addActionListener(e -> {
			if(delay<50){
				delay+=4;
				timer.setDelay(delay);
				speed.setText((int)(100-(delay-10)*2.5)+"%");
			}
		});
		speed.setBounds(collScene.getWidth()/2-12,collScene.getHeight()/2+50,50,50);
		f.setSize(collScene.getWidth(),collScene.getHeight()+20);
		this.setLayout(null);
		this.add(btn);
		this.add(speedUp);
		this.add(slowDown);
		this.add(speed);
		f.add(this);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
