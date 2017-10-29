package com.rthomazine.marsrobots.config;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import java.util.Collections;
import java.util.List;
import java.util.Vector;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.rthomazine.marsrobots.model.CardinalDirections;
import com.rthomazine.marsrobots.model.MarsGround;
import com.rthomazine.marsrobots.model.Robot;

/**
 * Test cases for {@code BeansConfig} class.
 * 
 * @author rthomazine
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class BeansConfigTest {

	@Autowired
	private Robot robot;
	@Autowired
	private MarsGround marsGround;
	@Autowired
	private Pattern commandsPattern;
	@Autowired
	private Pattern maxMovimentPattern;

	/**
	 * Test method for {@link com.rthomazine.marsrobots.config.BeansConfig#robot()}.
	 */
	@Test
	public void testRobot() {
		assertNotNull("Robot is null", robot);
		assertNotNull("Robot position is null", robot.getRobotPosition());
		assertThat("Robot initial direction is not NORTH", robot.getRobotPosition().getDirection(), is(CardinalDirections.NORTH));
		assertThat("Robot initial X axys is not 0", robot.getRobotPosition().getxAxis().intValue(), is(0));
		assertThat("Robot initial Y axys is not 0", robot.getRobotPosition().getyAxis().intValue(), is(0));
	}

	/**
	 * Test method for {@link com.rthomazine.marsrobots.config.BeansConfig#marsGround()}.
	 */
	@Test
	public void testMarsGround() {
		assertNotNull("Mars ground is null", marsGround.getGround());
		assertThat("Mars ground is empty", marsGround.getGround(), not(Collections.EMPTY_LIST));
		List<List<Integer>> grid = new Vector<List<Integer>>(5);
		grid.add(Stream.of(40,41,42,43,44).collect(Collectors.toList()));
		grid.add(Stream.of(30,31,32,33,34).collect(Collectors.toList()));
		grid.add(Stream.of(20,21,22,23,24).collect(Collectors.toList()));
		grid.add(Stream.of(10,11,12,13,14).collect(Collectors.toList()));
		grid.add(Stream.of(00,01,02,03,04).collect(Collectors.toList()));
		assertThat("Mars ground was not initialized correctly", marsGround.getGround(), equalTo(grid)); 
	}

	/**
	 * Test method for {@link com.rthomazine.marsrobots.config.BeansConfig#commandsPattern()}.
	 */
	@Test
	public void testCommandsPattern() {
		// successful cases
		assertTrue("Failed to validate moviment: M", commandsPattern.matcher("M").matches());
		assertTrue("Failed to validate moviment: L", commandsPattern.matcher("L").matches());
		assertTrue("Failed to validate moviment: R", commandsPattern.matcher("R").matches());
		assertTrue("Failed to validate moviment: MMRMMRMM", commandsPattern.matcher("MMRMMRMM").matches());
		assertTrue("Failed to validate moviment: MML", commandsPattern.matcher("MML").matches());
		// failure cases
		assertFalse("Failed to validate moviment: AAA", commandsPattern.matcher("AAA").matches());
		assertFalse("Failed to validate moviment: mlr", commandsPattern.matcher("mlr").matches());
		assertFalse("Failed to validate moviment: MMRLMZMaRMM", commandsPattern.matcher("MMRLMZMaRMM").matches());
	}

	/**
	 * Test method for {@link com.rthomazine.marsrobots.config.BeansConfig#maxMovimentPattern()}.
	 */
	@Test
	public void testMaxMovimentPattern() {
		// successful cases
		assertFalse("Failed to validate moviment: M", maxMovimentPattern.matcher("M").matches());
		assertFalse("Failed to validate moviment: MMM", maxMovimentPattern.matcher("MMM").matches());
		assertFalse("Failed to validate moviment: MMRMMRMM", maxMovimentPattern.matcher("MMRMMRMM").matches());
		// failure cases
		assertTrue("Failed to validate moviment: MMMMM", maxMovimentPattern.matcher("MMMMM").matches());
		assertTrue("Failed to validate moviment: MMRMMMMMMMR", maxMovimentPattern.matcher("MMRMMMMMMMR").matches());
		assertTrue("Failed to validate moviment: MMMMMMMMMMMMMMMMMMMMMMMM", maxMovimentPattern.matcher("MMMMMMMMMMMMMMMMMMMMMMMM").matches());
	}

}
