package it.as.tris.geometry;
/**
 * @(#)Line.java 19.07.2014
 * @author    Antonio Simonelli <antoniosimonelli@hotmail.com>
 * @version   0.1,  19.07.2014
 * Copyright 2014
 */
public class Cell implements Point {
	protected int x,y,z;
	public Cell(int x,int y){
		this.x = x;
		this.y = y;
		this.z = 0;
	}
	public void setZ(int z){
		this.z = z;
	}
	public int getX(){
		return this.x;
	}
	public int getY(){
		return this.y;
	}
	public int getZ(){
		return this.z;
	}
}
