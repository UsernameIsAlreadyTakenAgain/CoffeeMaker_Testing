package com.laboon;

import static org.junit.Assert.*;

import org.junit.Test;

public class RoomTest {

private Room room;
	
	//Test to see if True is returned when the hasItem() function is called when Room has all items coffee,cream, and sugar.
	 
	@Test
	public void testHasAllItems() {
		room = new Room(true, true, true, false, false);
		assertTrue(room.hasItem());
	}
	
	
	 //Test to see if False is returned when the hasItem() function is called when the Room has no items.
	 
	@Test
	public void testHasNoItems() {
		room = new Room(false, false, false, false, false);
		assertFalse(room.hasItem());
	}
	
	
	//Test to see if True is returned when the hasItem() function is called when Room has sugar.
	 
	@Test
	public void testHasSugar() {
		room = new Room(false, false, true, false, false);
		assertTrue(room.hasSugar());
	}
	
	//Test to see if True is returned when the hasItem() function is called when Room has cream.
	 
	@Test
	public void testHasCream() {
		room = new Room(false, true, false, false, false);
		assertTrue(room.hasCream());
	}
	
	//Test to see if True is returned when the hasItem() function is called when Room has coffee.

	@Test
	public void testHasCoffee() {
		room = new Room(true, false, false, false, false);
		assertTrue(room.hasCoffee());
	}

	//Test to see if True is returned when the northExit() function is called when Room has a North exit.
	 
	@Test
	public void testHasNorthExit() {
		room = new Room(false, false, false, true, false);
		assertTrue(room.northExit());
	}
	
	//Test to see if True is returned when the southExit() function is called when Room has a South exit.
	 
	@Test
	public void testHasSouthExit() {
		room = new Room(false, false, false, false, true);
		assertTrue(room.southExit());
	}
	
	//Test to see if True is returned when the getDescription() function is called.
	 
	@Test
	public void testGetDescription() {
		room = new Room(false, false, false, false, false);
		assertTrue(room.getDescription().contains("You see a"));
		assertTrue(room.getDescription().contains("It has a"));
	}
}
