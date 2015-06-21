package com.laboon;

import static org.junit.Assert.*;


import org.junit.Test;

public class PlayerTest {

	private Player player;
	
	 //Test to see if False is returned when the drink() function is called when Player has no items.
	 
	@Test
	public void testDrinkWithNoItems() {
		player = new Player();
		assertFalse(player.drink());	

}
	//Test to see if False is returned when the drink() function is called when Player has coffee and cream
	 
	@Test
	public void testDrinkWithCoffeeAndCream() {
		player = new Player();
		player.getCoffee();
		player.getCream();
		assertFalse(player.drink());		
	}
	
	//Test to see if False is returned when the drink() function is called when Player has coffee and sugar
	 
		@Test
		public void testDrinkWithCoffeeAndSugar() {
			player = new Player();
			player.getCoffee();
			player.getSugar();
			assertFalse(player.drink());		
		}
	
	 //Test to see if False is returned when the drink() function is called when Player has cream and sugar.
	 
	@Test
	public void testDrinkWithCreamAndSugar() {
		player = new Player();
		player.getCream();
		player.getSugar();
		assertFalse(player.drink());		
	}
	
	
	 //Test to see if False is returned when the drink() function is called when Player has sugar.
	 
	@Test
	public void testDrinkWithSugar() {
		player = new Player();
		player.getSugar();
		assertFalse(player.drink());		
	}
	
	 //Test to see if False is returned when the drink() function is called when Player has cream.
	 
	@Test
	public void testDrinkWithCream() {
		player = new Player();
		player.getCream();
		assertFalse(player.drink());		
	}
	
	 //Test to see if True is returned when the drink() function is called when Player has coffee.
	 
		@Test
		public void testDrinkWithCoffee() {
			player = new Player();
			player.getCoffee();
			assertFalse(player.drink());		
		}
	
		//Test to see if True is returned when the drink() function is called when Player has sugar,cream, and coffee.
	
		@Test
		public void testDrinkWithAllItems() {
			player = new Player(true, true, true);
			assertTrue(player.drink());		
		}
		
		
		 //Test to see if True is returned after the all items have been collected.
		 
		@Test
		public void testAllItemsCollected() {
			player = new Player(true, true, true);
			assertTrue(player.hasAllItems());
		}
		
		//Test to see if True is returned after getCoffee() function is called
		
		@Test
		public void testGetCoffee() {
			player = new Player(true,true,false);
			player.getCoffee();
			assertTrue(player.hasAllItems());
		}
		
		//Test to see if True is returned after getCream() function is called
		
		@Test
		public void testGetCream() {
			player = new Player(true,false,true);
			player.getCream();
			assertTrue(player.hasAllItems());
		}
		//Test to see if True is returned after getSugar() function is called
				
		@Test
		public void testGetSugar() {
			player = new Player(false,true,true);
			player.getSugar();
			assertTrue(player.hasAllItems());
		}
				
		
		
}
