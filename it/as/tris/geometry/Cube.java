package it.as.tris.geometry;
/**
 * @(#)Cube.java 06.07.2014
 * @author    Antonio Simonelli <antoniosimonelli@hotmail.com>
 * @version   0.1,  06.07.2014
 * Copyright 2014
 */
public class Cube implements Space{
	final int m = 3;
	protected Point[] iPoints;
	public Cube(){
		iPoints = new Point[m * m];
		iPoints[0] = new Cell(2, 1);
		iPoints[1] = new Cell(0, 1);
		iPoints[2] = new Cell(1, 1);
		iPoints[3] = new Cell(2, 0);
		iPoints[4] = new Cell(0, 0);
		iPoints[5] = new Cell(1, 0);
		iPoints[6] = new Cell(2, 2);
		iPoints[7] = new Cell(0, 2);
		iPoints[8] = new Cell(1, 2);
	}
	public Point[] getPoints(){
		return iPoints;
	}
	public Line[] getLines(Point point){
		Line[] result;
		result = new Line[countLines(point)];
		result[0] = new Row(getHorizontals(point));
		result[1] = new Row(getVerticals(point));
		if(result.length > 2)result[2] = new Row(getObliques(point));
		if(result.length > 3)result[3] = new Row(getBackObliques(point));
		//System.out.println(point.getX() + " " + point.getY() + " " + result.length);
		return result;
	}
	protected int countLines(Point point){
		int result;
		if(point.getX() * point.getY() == 0){
			if(point.getX() == 0 && point.getY() == 0)result = 4;
			else result = 2;
		}else result = 3;
		return result;
	}
	protected Point[] getHorizontals(Point point){
		Point[] result = new Point[3];
		for(int i = 0; i < 3; i++)
			result[i] = iPoints[indexOf(i, point.getY())];
		return result;
	}
	protected Point[] getVerticals(Point point){
		Point[] result = new Point[3];
		for(int i = 0; i < 3; i++)
			result[i] = iPoints[indexOf(point.getX(), i)];
		return result;
	}
	protected Point[] getObliques(Point point){
		int t = 1;
		Point[] result = new Point[3];
		if(point.getY() != 0)t = point.getX() * point.getY() % m;
		for(int i = 0; i < 3; i++){
			result[i] = iPoints[indexOf(i, (m + (i - point.getX()) * t + point.getY()) % m)];
		}
		return result;
	}
	protected Point[] getBackObliques(Point point){
		int t = 2;
		Point[] result = new Point[3];
		for(int i = 0; i < 3; i++)
			result[i] = iPoints[indexOf( i, (i * t) % m)];
		return result;
	}
	protected int indexOf(int x,int y){
		int i;
		for(i = 0; i < m * m; i++)
			if(iPoints[i].getX() == x && iPoints[i].getY() == y)return i;
		return 0;
	}
}
