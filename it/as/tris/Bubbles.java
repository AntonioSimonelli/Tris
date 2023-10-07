package it.as.tris;
/**
 * @(#)Bubbles.java 06.07.2014
 * @author    Antonio Simonelli <antoniosimonelli@hotmail.com>
 * @version   0.1,  06.07.2014
 * Copyright 2014
 */
import it.as.tris.geometry.*;
public class Bubbles implements Algorithm{
	final int m = 3;
	final int chi = 1;
	final int omega = 2;
	protected int iiMove;
	protected Space iCube;
	
	public  Bubbles(){
		iiMove = 0;
		iCube = new Cube();
	}
	public void store(int move){
		iCube.getPoints()[move].setZ(omega);
		iiMove++;
	}
	public int move(){
		int result,max;
		max = 0;
		result = 0;
		if(entropy() < 0){
			max = 0;
			for(int i = 0; i < m * m; i++){
				if(potential(iCube.getPoints()[i]) > max && iCube.getPoints()[i].getZ() == 0){
					result = i;
					max = potential(iCube.getPoints()[i]);
				}
			}
			iiMove++;
			iCube.getPoints()[result].setZ(chi);
		}
		//System.out.println(iiMove);
		return result;
	}
	public int entropy(){
		int result, sum, max;
		result = -(m * m - iiMove);
		max = 0;
		for(int i = 0; i < m * m; i++){
			sum = 0;
			for(int j = 0; j < iCube.getLines(iCube.getPoints()[i]).length; j++){
				Point[] p = iCube.getPoints();
				Line[] l = iCube.getLines(p[i]);
				p = l[j].getPoints();
				for(int h = 0; h < l[j].getPoints().length; h++)
					sum += (tau(p[h]) * tau(p[h])) % m;
			}
			if (sum > max)max = sum;
		}
		result *= max;
		return result;
	}
	public int tau(Point point){
		return point.getZ();
	}
	public int potential(Point point){
		int result, sum, exp;
		result = 0;
		sum = 0;
		exp = 0;
		for(int i = 0; i < iCube.getLines(point).length; i++){
			exp = 0;
			for(int j = 0; j < iCube.getLines(point)[i].getPoints().length; j++){
				exp += (tau(iCube.getLines(point)[i].getPoints()[j])) % m;
			}
			if(exp == 3)exp = 0;
			sum += Math.pow(2, exp);
		}
		//result = (int)Math.pow(-1, iiMove) * iCube.getLines(point).length * sum;
		result = iCube.getLines(point).length * sum;
		return result;
	}	
}
