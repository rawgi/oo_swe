package de.hsrm.cs.oose13;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import de.hsrm.cs.oose13.util.FileUtil;

public class Labyrinth extends JPanel{
	
	private GeometricObject[] myObjects;
	private int recLength = 20;
	private String[] lines;
	private int playerPos;

	JFrame frame = new JFrame("Labyrinth");
	private JButton btnUp = new JButton();
	private JButton btnDown = new JButton();
	private JButton btnLeft = new JButton();
	private JButton btnRight = new JButton();
	
	public Labyrinth(String fileName){
		lines = FileUtil.readTextLines("files/"+fileName);
		int counter = 0;
		for(String curLine: lines){
			char[] chars = curLine.toCharArray();
			for(char c: chars){
				if(c == 'W'){
					counter++;
				} else if (c == 'X') {
					counter++;
				}
			}
		}
		myObjects = new GeometricObject[counter];
		create();
		
		btnUp.setBounds((lines[0].length()*recLength)/2-20, lines.length*recLength, 40, 40);
		btnUp.addActionListener(e -> {
			if(!isWall(new GeometricObject(new Vertex(myObjects[playerPos].getCorner().getX(),myObjects[playerPos].getCorner().getY()-recLength),
					myObjects[playerPos].getWidth(), myObjects[playerPos].getHeight()))){
				
				myObjects[playerPos].getCorner().setY(myObjects[playerPos].getCorner().getY()-recLength);
				repaint();
				System.out.println("up");
			}
		});
		
		btnDown.setBounds((lines[0].length()*recLength)/2-20, lines.length*recLength+40, 40, 40);
		btnDown.addActionListener(e -> {
			if(!isWall(new GeometricObject(new Vertex(myObjects[playerPos].getCorner().getX(),myObjects[playerPos].getCorner().getY()+recLength),
					myObjects[playerPos].getWidth(), myObjects[playerPos].getHeight()))){
				
				myObjects[playerPos].getCorner().setY(myObjects[playerPos].getCorner().getY()+recLength);
				repaint();
				System.out.println("down");
			}
		});
		
		btnLeft.setBounds((lines[0].length()*recLength)/2-60, lines.length*recLength+40, 40, 40);
		btnLeft.addActionListener(e -> {
			if(!isWall(new GeometricObject(new Vertex(myObjects[playerPos].getCorner().getX()-recLength,myObjects[playerPos].getCorner().getY()),
					myObjects[playerPos].getWidth(), myObjects[playerPos].getHeight()))){
				
				myObjects[playerPos].getCorner().setX(myObjects[playerPos].getCorner().getX()-recLength);
				repaint();
				System.out.println("left");
			}
		});
		
		btnRight.setBounds((lines[0].length()*recLength)/2+20, lines.length*recLength+40, 40, 40);
		btnRight.addActionListener(e -> {
			if(!isWall(new GeometricObject(new Vertex(myObjects[playerPos].getCorner().getX()+recLength,myObjects[playerPos].getCorner().getY()),
					myObjects[playerPos].getWidth(), myObjects[playerPos].getHeight()))){
				
				myObjects[playerPos].getCorner().setX(myObjects[playerPos].getCorner().getX()+recLength);
				repaint();
				System.out.println("right");
			}
		});
		setLayout(null);
		add(btnUp);
		add(btnDown);
		add(btnLeft);
		add(btnRight);
	}
	
	private boolean isWall(GeometricObject nextPos){
		for(GeometricObject check: myObjects){
			if(nextPos.touches(check)){
				return true;
			}
		}
		return false;
	}
	
	@Override
	public Dimension getPreferredSize(){
		return new Dimension(lines[0].length()*recLength,lines.length*recLength+80);
	}
	
	@Override
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		for (int i = 0; i < myObjects.length; i++) {
			myObjects[i].paintMeTo(g);
		}
	}
	
	private void create(){
		Vertex curPos = new Vertex(0,0);
		int moPos = 0;
		
		for(String curLine: lines){
			char[] chars = curLine.toCharArray();
			for(char c: chars){
				if(c == 'W'){
					myObjects[moPos] = new GeometricObject(new Vertex(curPos.getX(),curPos.getY()),recLength,recLength);
					moPos++;
				} else if (c == 'X') {
					myObjects[moPos] = new Star(new Vertex(curPos.getX()+1,curPos.getY()+1),5,recLength/2,recLength-2);
					playerPos = moPos;
					moPos++;
				}
				curPos.setX(curPos.getX()+recLength);
			}
			curPos.setX(0);
			curPos.setY(curPos.getY()+recLength);
		}
	}
	
	public void show(){
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(this);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setVisible(true);
		frame.pack();
	}
}
