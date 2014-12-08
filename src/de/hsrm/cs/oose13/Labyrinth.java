package de.hsrm.cs.oose13;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

import de.hsrm.cs.oose13.util.FileUtil;

public class Labyrinth extends JPanel{
	
	private GeometricObject[] myObjects;
	private int recLength = 20;
	private String[] lines;
	
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
	}
	
	@Override
	public Dimension getPreferredSize(){
		return new Dimension(lines[0].length()*recLength,lines.length*recLength);
	}
	
	@Override
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		for(GeometricObject geo: myObjects){
			g.drawRect((int)geo.getCorner().getX(), (int)geo.getCorner().getX(), (int)geo.getWidth(), (int)geo.getHeight());
		}
	}
	
	private void create(){
		Vertex curPos = new Vertex(0,0);
		int moPos = 0;
		
		for(String curLine: lines){
			char[] chars = curLine.toCharArray();
			for(char c: chars){
				if(c == 'W'){
					myObjects[moPos] = new GeometricObject(curPos,recLength,recLength);
					moPos++;
				} else if (c == 'X') {
					myObjects[moPos] = new Star(curPos,5,recLength/2,recLength);
					moPos++;
				}
				curPos.setX(curPos.getX()+recLength);
			}
			curPos.setX(0);
			curPos.setY(curPos.getY()+recLength);
		}
	}
	
	public void show(){
		JFrame frame = new JFrame("Labyrinth");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(this);
		frame.pack();
		frame.setVisible(true);
		repaint();
	}
}
