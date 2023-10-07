package it.as.tris;
/**
 * @(#)Board.java 27.04.2014
 * @author    Antonio Simonelli <antoniosimonelli@hotmail.com>
 * @version   0.1,  27.04.2014
 * Copyright 2014
 */
public class Board {
	protected Algorithm iAlgo;
	public char[] field;
	
	public Board(){
		iAlgo = new Bubbles();
		field = new char[9];
		for(int i=0;i<9;i++)
			field[i] = '#';
	}
	public void move(int n){
		if(0 < n && n < 10){
			field[n - 1] = 'O';
			iAlgo.store(n - 1);
			field[iAlgo.move()] = 'X';
		}
	}
}
