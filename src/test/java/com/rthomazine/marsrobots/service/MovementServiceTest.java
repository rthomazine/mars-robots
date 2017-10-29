package com.rthomazine.marsrobots.service;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.rthomazine.marsrobots.model.Robot;

/**
 * Test cases for {@code MovementService} class.
 * 
 * @author rthomazine
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class MovementServiceTest {

	@Autowired
	MovementService movementService;

	/**
	 * Test method for {@link com.rthomazine.marsrobots.service.MovementService#isValidMovementPattern(java.lang.String)}.
	 */
	@Test
	public void testIsValidMovementPattern() {
		// valid cases
		assertTrue("Failed to validate moviment: M", movementService.isValidMovementPattern("M"));
		assertTrue("Failed to validate moviment: L", movementService.isValidMovementPattern("L"));
		assertTrue("Failed to validate moviment: R", movementService.isValidMovementPattern("R"));
		assertTrue("Failed to validate movement: MMRMMRMM", movementService.isValidMovementPattern("MMRMMRMM"));
		assertTrue("Failed to validate movement: MML", movementService.isValidMovementPattern("MML"));
		// invalid cases
		assertFalse("Failed to validate movement: AAA", movementService.isValidMovementPattern("AAA"));
		assertFalse("Failed to validate movement: MMMMMMMMMMMMMMMMMMMMMMMM", movementService.isValidMovementPattern("MMMMMMMMMMMMMMMMMMMMMMMM"));
		assertFalse("Failed to validate moviment: mlr", movementService.isValidMovementPattern("mlr"));
		assertFalse("Failed to validate moviment: MMRLMZMaRMM", movementService.isValidMovementPattern("MMRLMZMaRMM"));
	}

	/**
	 * Test method for {@link com.rthomazine.marsrobots.service.MovementService#move(com.rthomazine.marsrobots.model.Robot, java.lang.String)}.
	 */
	@Test
	public void testMove() {
		try {
			// valid cases
			assertThat("Final position different from: (2, 0, S)", movementService.move(new Robot(), "MMRMMRMM"), is("(2, 0, S)"));
			assertThat("Final position different from: (0, 2, W)", movementService.move(new Robot(), "MML"), is("(0, 2, W)"));
			assertThat("Final position different from: (4, 4, N)", movementService.move(new Robot(), "RMMLMMMRMMLM"), is("(4, 4, N)"));
			// invalid movement cases, assure that robot does not transcend ground limits
			assertThat("Final position different from: (0, 4, N)", movementService.move(new Robot(), "MMMMMMMMMMMMMMMMMMMMMMMM"), is("(0, 4, N)"));
			assertThat("Final position different from: (0, 2, W)", movementService.move(new Robot(), "MMLMMM"), is("(0, 2, W)"));
		} catch (Exception e) {
		}
	}

}
