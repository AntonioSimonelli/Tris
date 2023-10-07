package it.as.tris.geometry;
/**
 * @(#)Space.java 27.04.2014
 * @author    Antonio Simonelli <antoniosimonelli@hotmail.com>
 * @version   0.1,  27.04.2014
 * Copyright 2014
 */
public interface Space {
	public Point[] getPoints();
	public Line[] getLines(Point point);
}
