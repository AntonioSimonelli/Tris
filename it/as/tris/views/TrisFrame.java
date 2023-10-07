package it.as.tris.views;
/**
 * @(#)TrisFrame.java 27.04.2014
 * @author    Antonio Simonelli <antoniosimonelli@hotmail.com>
 * @version   0.1,  27.04.2014
 * Copyright 2014
 */
import java.awt.*;
import java.awt.event.*;
import it.as.tris.*;
public class TrisFrame  extends Frame implements WindowListener,MouseListener{
	private static final long serialVersionUID = 1L;
	protected final int[] x = {30, 130, 220, 30, 130, 220, 30, 130, 220};
	protected final int[] y = {50, 50, 50, 125, 125, 125, 205, 205, 205};
	Board b;
	public TrisFrame(){
	    super("Gioco del Tris");
	    b = new Board();
	    setSize(400,400);
	    addWindowListener(this);
	    addMouseListener(this);
	    setSize(300,300);
	    setLayout(null);
	    setLocationRelativeTo(null);
	    setResizable(false);
	    addWindowListener((WindowListener)this);
	    setVisible(true);
	}
	public void mousePressed(MouseEvent e){
		for(int i= 0; i < 9; i++){
			if(e.getX() >= x[i] && e.getX() <= x[i] + 50 && e.getY() >= y[i] && e.getY() <= y[i] + 50){
				b.move(i + 1);
				repaint();
			}
		}
	}
	public void mouseReleased(MouseEvent e){}
	public void mouseEntered(MouseEvent e){}
	public void mouseExited(MouseEvent e){}
	public void mouseClicked(MouseEvent e) {}
	public void windowClosing(WindowEvent e){
	    dispose();
	}
	public void windowOpened(WindowEvent e){}
	public void windowClosed(WindowEvent e){}
	public void windowIconified(WindowEvent e){}
	public void windowDeiconified(WindowEvent e){}
	public void windowActivated(WindowEvent e){}
	public void windowDeactivated(WindowEvent e) {}
	public void paint(Graphics g){
		g.drawLine(100,50,100,260);
		g.drawLine(200,50,200,260);
		g.drawLine(20,110,280,110);
		g.drawLine(20,190,280,190);
		for (int i = 0; i < 9; i++){
			if(b.field[i] == 'X'){
				g.setColor(Color.BLUE);
				g.drawLine(x[i], y[i], x[i] + 50, y[i] + 50);
				g.drawLine(x[i] + 50, y[i], x[i], y[i] + 50);
			}
			if(b.field[i] == 'O'){
				g.setColor(Color.RED);
				g.drawOval(x[i], y[i], 50, 50);
			}
		}
	}
	public static void main(String[] args) {
		TrisFrame t = new TrisFrame();
	}
}
