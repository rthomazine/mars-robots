package com.rthomazine.marsrobots.model;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import java.util.Collections;
import java.util.List;
import java.util.Vector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

/**
 * Test cases for {@code MarsGround} class.
 * 
 * @author rthomazine
 *
 */
public class MarsGroundTest {

	/**
	 * Test method for {@link com.rthomazine.marsrobots.model.MarsGround#getGround()}.
	 */
	@Test
	public void testGetGround() {
		MarsGround mars = new MarsGround();
		assertNotNull("Mars ground is null", mars.getGround());
		assertThat("Mars ground is empty", mars.getGround(), not(Collections.EMPTY_LIST));
		List<List<Integer>> grid = new Vector<List<Integer>>(5);
		grid.add(Stream.of(40,41,42,43,44).collect(Collectors.toList()));
		grid.add(Stream.of(30,31,32,33,34).collect(Collectors.toList()));
		grid.add(Stream.of(20,21,22,23,24).collect(Collectors.toList()));
		grid.add(Stream.of(10,11,12,13,14).collect(Collectors.toList()));
		grid.add(Stream.of(00,01,02,03,04).collect(Collectors.toList()));
		assertThat("Mars ground was not initialized correctly", mars.getGround(), equalTo(grid)); 
	}

}
