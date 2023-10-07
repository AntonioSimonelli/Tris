package it.as.tris;
/**
 * @(#)Algorithm.java 27.04.2014
 * @author    Antonio Simonelli <antoniosimonelli@hotmail.com>
 * @version   0.1,  27.04.2014
 * Copyright 2014
 */
import it.as.tris.geometry.*;
public interface Algorithm {
	public int move();
	public int tau(Point point);
	public int entropy();
	public int potential(Point point);
	public void store(int move);
}

