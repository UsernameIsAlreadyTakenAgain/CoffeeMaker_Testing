package com.laboon;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import org.junit.Test;
import org.mockito.Mockito;

public class GameTest {
	
	/*
	 * Test doSomething edge case
	 * Input value: p(invalid value)
	 */
	@Test
	public void testDoSomething() {
		Player p=Mockito.mock(Player.class);
		House h=Mockito.mock(House.class);
		Game g=new Game(p,h);
		//Execution step
		int result=g.doSomething("p");
		//Assertions
		assertEquals(result,0);	
	}

	/*
	 * Test doSomething move north
	 * Input value: N
	 */
	@Test
	public void testDoSomethingN() {
		Player p=Mockito.mock(Player.class);
		House h=Mockito.mock(House.class);
		Game g=new Game(p,h);
		//Execution step
		int result=g.doSomething("N");
		//Assertions
		Mockito.verify(h).moveNorth(); 
		assertEquals(result,0);	
	}
	
	/*
	 * Test doSomething move north
	 * Input value: n
	 */
	@Test
	public void testDoSomethingn() {
		Player p=Mockito.mock(Player.class);
		House h=Mockito.mock(House.class);
		Game g=new Game(p,h);
		//Execution step
		int result=g.doSomething("n");
		//Assertions
		Mockito.verify(h).moveNorth();
	}
	
	/*
	 * Test doSomething help
	 * Input value: H
	 */
	@Test
	public void testDoSomethingH() {
		Player p=Mockito.mock(Player.class);
		House h=Mockito.mock(House.class);
		Game g=new Game(p,h);
		//Execution step
		int result=g.doSomething("H");
		//Assertions
		fail();
		
		
	}
	
	/*
	 * Test doSomething move south
	 *  Input value: S
	 */
	@Test
	public void testDoSomethingS() {
		Player p=Mockito.mock(Player.class);
		House h=Mockito.mock(House.class);
		Game g=new Game(p,h);
		//Execution step
		int result=g.doSomething("S");
		//Assertions
		Mockito.verify(h).moveSouth();
		assertEquals(result,0);	
	}
	
	/*
	 * Test doSomething move south
	 *  Input value: s
	 */
	@Test
	public void testDoSomethings() {
		Player p=Mockito.mock(Player.class);
		House h=Mockito.mock(House.class);
		Game g=new Game(p,h);
		//Execution step
		int result=g.doSomething("s");
		//Assertions
		Mockito.verify(h).moveSouth();
		assertEquals(result,0);	
	}
	
	/*
	 * Test doSomething look, also test lower case here
	 *  Input value: l
	 */
	@Test
	public void testDoSomethingl() {
		Player p=Mockito.mock(Player.class);
		House h=Mockito.mock(House.class);
		Game g=new Game(p,h);
		//Execution step
		int result=g.doSomething("l");
		//Assertions
		Mockito.verify(h).look(p, null);
		assertEquals(result,0);	
	}
	
	/*
	 * Test doSomething look
	 *  Input value: L
	 */
	@Test
	public void testDoSomethingL() {
		Player p=Mockito.mock(Player.class);
		House h=Mockito.mock(House.class);
		Game g=new Game(p,h);
		//Execution step
		int result=g.doSomething("L");
		//Assertions
		Mockito.verify(h).look(p, null);
		assertEquals(result,0);	
	}

	/*
	 * Test doSomething show inventory, also test lower case here
	 *  Input value: i
	 */
	@Test
	public void testDoSomethingi() {
		Player p=Mockito.mock(Player.class);
		House h=Mockito.mock(House.class);
		Game g=new Game(p,h);
		//Execution step
		int result=g.doSomething("i");
		//Assertions
		Mockito.verify(p).showInventory();
		assertEquals(result,0);	
	}
	
	/*
	 * Test doSomething show inventory
	 *  Input value: I
	 */
	@Test
	public void testDoSomethingI() {
		Player p=Mockito.mock(Player.class);
		House h=Mockito.mock(House.class);
		Game g=new Game(p,h);
		//Execution step
		int result=g.doSomething("I");
		//Assertions
		Mockito.verify(p).showInventory();
		assertEquals(result,0);	
	}

	/*
	 * Test doSomething drink, also test lower case here
	 *  Input value: d and D
	 *  for testing 1 and -1
	 */
	@Test
	public void testDoSomethingResult() {
		Player p=Mockito.mock(Player.class);
		House h=Mockito.mock(House.class);
		Game g=new Game(p,h);
		
		//assume win
		Mockito.when(p.drink()).thenReturn(true);
		int result=g.doSomething("D");	
		assertEquals(result,1);	
		
		//assume lose
		Mockito.when(p.drink()).thenReturn(false);
		result=g.doSomething("d");
		assertEquals(result,-1);	
	}
	
	/*
	 * Test doSomething drink, also test lower case here
	 *  Input value: D
	 *  for testing capital and small letter
	 */
	@Test
	public void testDoSomethingD() {
		Player p=Mockito.mock(Player.class);
		House h=Mockito.mock(House.class);
		Game g=new Game(p,h);
		g.doSomething("D");
		Mockito.verify(p).drink();	
	}
	
	/*
	 * Test doSomething drink, also test lower case here
	 *  Input value: d 
	 *  for testing capital and small letter
	 */
	@Test
	public void testDoSomethingd() {
		Player p=Mockito.mock(Player.class);
		House h=Mockito.mock(House.class);
		Game g=new Game(p,h);
		g.doSomething("d");
		Mockito.verify(p).drink();	
	}
	
	
	
	
	/*
	 * Test run
	 * fail deliberately because of without input value
	 */
	@Test
	public void testRun(){
		fail("Without Initialized value");
	}
}
