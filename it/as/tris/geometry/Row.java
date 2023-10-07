package it.as.tris.geometry;
/**
 * @(#)Row.java 19.07.2014
 * @author    Antonio Simonelli <antoniosimonelli@hotmail.com>
 * @version   0.1,  19.07.2014
 * Copyright 2014
 */
public class Row implements Line {
	protected Point[] iPoints;
	public Row(Point[] points){
		iPoints = points;
	}
	public Point[] getPoints(){
		//System.out.println("Row.getPoints");
		return iPoints;
	}
}
