package com.rthomazine.marsrobots.service;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.rthomazine.marsrobots.model.CardinalDirections;
import com.rthomazine.marsrobots.model.Position;
import com.rthomazine.marsrobots.model.Robot;

/**
 * Test cases for {@code RobotService} class.
 * 
 * @author rthomazine
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class RobotServiceTest {

	@TestConfiguration
	static class RobotServiceTestConfiguration {
		@Bean
		public RobotService robotService() {
			return new RobotServiceImpl();
		}
		@Bean
		public Robot robot() {
			return new Robot(0, new Position(0, 0, CardinalDirections.NORTH));
		}
	}

	@Autowired
	RobotService robotService;
	@Autowired
	Robot robot;

	/**
	 * Tests a series of movement commands in a sequence over the same robot unit.
	 */
	@Test
	public void testMovement() {
		robotService.move(robot);
		assertThat(robot.getRobotPosition().getDirection(), is(CardinalDirections.NORTH));
		assertThat(robot.getRobotPosition().getxAxis().intValue(), is(0));
		assertThat(robot.getRobotPosition().getyAxis().intValue(), is(1));

		robotService.turnRight(robot);
		assertThat(robot.getRobotPosition().getDirection(), is(CardinalDirections.EAST));
		assertThat(robot.getRobotPosition().getxAxis().intValue(), is(0));
		assertThat(robot.getRobotPosition().getyAxis().intValue(), is(1));

		robotService.move(robot);
		assertThat(robot.getRobotPosition().getDirection(), is(CardinalDirections.EAST));
		assertThat(robot.getRobotPosition().getxAxis().intValue(), is(1));
		assertThat(robot.getRobotPosition().getyAxis().intValue(), is(1));

		robotService.turnLeft(robot);
		assertThat(robot.getRobotPosition().getDirection(), is(CardinalDirections.NORTH));
		assertThat(robot.getRobotPosition().getxAxis().intValue(), is(1));
		assertThat(robot.getRobotPosition().getyAxis().intValue(), is(1));
	}

}
