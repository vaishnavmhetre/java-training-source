/**
 * 
 */
package com.collections;

/**
 * @author Allianz3076
 *
 */
public class Circle implements Comparable<Circle> {
	
	protected int radius;

	/**
	 * @param radius
	 */
	public Circle(int radius) {
		this.radius = radius;
	}


	/**
	 * @return the radius
	 */
	public int getRadius() {
		return radius;
	}


	/**
	 * @param radius the radius to set
	 */
	public void setRadius(int radius) {
		this.radius = radius;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Circle [radius=" + radius + "]";
	}


	@Override
	public int compareTo(Circle circle) {
		return ((Integer)getRadius()).compareTo(circle.getRadius());
	}
	
}
