package com.rthomazine.marsrobots.model;

import java.util.List;
import java.util.Vector;

/**
 * The {@code MarsGround} class defines the Mars ground entity by building a
 * grid that represents the (x,y) axis coordinates that should limit the robots
 * movement.
 * 
 * @author rthomazine
 *
 */
public class MarsGround {

	/**
	 * The default ground length for each axis.
	 */
	public static final int DEFAULT_GROUND = 5;

	/**
	 * The ground space represented as a grid with (x,y) axis coordinates.
	 */
	private List<List<Integer>> ground;

	/**
	 * Constructs the Mars ground with default ground length.
	 */
	public MarsGround() {
		this(DEFAULT_GROUND);
	}

	/**
	 * Constructs the Mars ground with given length.
	 * 
	 * @param groundSize The ground length
	 */
	public MarsGround(int groundSize) {
		this.ground = fillGround(groundSize);
	}

	/**
	 * Returns the ground grid.
	 * 
	 * @return The ground as a grid
	 */
	public List<List<Integer>> getGround() {
		return ground;
	}

	/**
	 * Constructs the ground as a grid with (x,y) axis coordinates.
	 * 
	 * @param groundSize The grid length to build
	 * @return The grid with (x,y) axis coordinates
	 */
	private List<List<Integer>> fillGround(int groundSize) {
		// Initialize outer grid
		List<List<Integer>> outer = new Vector<List<Integer>>(groundSize);
		for (int i=0; i<groundSize; i++) {
			outer.add(new Vector<Integer>(groundSize));
		}
		// Fill the grid with coordinates
		for (int i=0; i<groundSize; i++) {
			// Create the row for the grid
			List<Integer> inner = new Vector<Integer>(groundSize);
			for (int j=0; j<groundSize; j++) {
				// Create the x,y coordinate
				inner.add(Integer.parseInt(String.format("%1$d%2$d", i, j)));
			}
			// Put the row into grid
			outer.set(groundSize-1-i, inner);
		}
		return outer;
	}

}
