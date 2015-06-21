package com.laboon;

import static org.junit.Assert.*;


import org.junit.Test;
import org.mockito.Mockito;

public class HouseTest {

	/*
	 * Test to see whether the method getCurrentRoomInfo can work in the legal number
	 * basic case
	 */
	@Test
	public void testGetCurrentRoomInfo_OutRange(){
		Room r=Mockito.mock(Room.class);
		Mockito.when(r.getDescription()).thenReturn("TEST");
		Room[] rooms=new Room[1];
		rooms[0]=r;
		House h=new House(rooms);
		String result=h.getCurrentRoomInfo();
		assertEquals(result,"TEST");	
	}
	
	/*
	 * Test to see whether the method getCurrentRoomInfo can correctly judge the out-range value
	 * edge case: _currentRoom=_numRooms
	 */
	@Test
	public void testGetCurrentRoomInfo_EdgeCase1(){
		House h=new House(1);
		h.moveNorth();
		String res=h.getCurrentRoomInfo();
		assertEquals("You are in a magical land!  But you are returned to the beginning!",res);
	}
	
	/*
	 * Test to see whether the method getCurrentRoomInfo can correctly judge the out-range value
	 * edge case: _currentRoom ==-1
	 */
	@Test
	public void testGetCurrentRoomInfo_EdgeCase2(){
		House h=new House(1);
		h.moveSouth();
		String res=h.getCurrentRoomInfo();
		assertEquals("You are in a magical land!  But you are returned to the beginning!",res);
	}
	
	
	/*
	 * Test to see whether the method moveNorth can work correctly
	 */
	@Test
	public void testMoveNorth(){
		House h=new House(2);
		h.moveNorth();
		String res1=h.getCurrentRoomInfo();
		Boolean check=res1.equals("You are in a magical land!  But you are returned to the beginning!");
		assertEquals(check,false);
		h.moveNorth();
		String res2=h.getCurrentRoomInfo();
		check=res2.equals("You are in a magical land!  But you are returned to the beginning!");
		assertEquals(check,true);
	}
	
	/*
	 * Test to see whether the method moveSouth can work correctly
	 */
	@Test
	public void testMoveSouth(){
		House h=new House(1);
		h.moveSouth();
		String res1=h.getCurrentRoomInfo();
		Boolean check=res1.equals("You are in a magical land!  But you are returned to the beginning!");
		assertEquals(check,true);
		h.moveNorth();
		h.moveSouth();
		String res2=h.getCurrentRoomInfo();
		check=res2.equals("You are in a magical land!  But you are returned to the beginning!");
		assertEquals(check,false);
	}
	
	
	/*
	 * Test look for coffee
	 */
    @Test
    public void testLookCoffee(){
    	Player p=Mockito.mock(Player.class);
    	Room r=Mockito.mock(Room.class);
    	Mockito.when(r.hasItem()).thenReturn(true);
    	Mockito.when(r.hasCoffee()).thenReturn(true);
    	House h=new House(1);
    	h.look(p, r);
    	Mockito.verify(p).getCoffee();	
    }
    

	/*
	 * Test look for cream
	 */
    @Test
    public void testLookCream(){
    	Player p=Mockito.mock(Player.class);
    	Room r=Mockito.mock(Room.class);
    	Mockito.when(r.hasItem()).thenReturn(true);
    	Mockito.when(r.hasCream()).thenReturn(true);
    	House h=new House(1);
    	h.look(p, r);
    	Mockito.verify(p).getCream();	
    }
    

	/*
	 * Test look for sugar
	 */
    @Test
    public void testLookSugar(){
    	Player p=Mockito.mock(Player.class);
    	Room r=Mockito.mock(Room.class);
    	Mockito.when(r.hasItem()).thenReturn(true);
    	Mockito.when(r.hasSugar()).thenReturn(true);
    	House h=new House(1);
    	h.look(p, r);
    	Mockito.verify(p).getSugar();	
    }
    
    /*
     * Test generateRoom, basic case for numRoomes=6
     * edge case: j=0,2,5
     * basic case: j=3
     */
	@Test
	public void testGenerateRoom(){
		House h=new House(1);
		Room[] r=h.generateRooms(6);
		//edge case: j=0
		Room room_0=new Room(false,true,false,true,false);
		assertEquals(r[0].hasCoffee(),room_0.hasCoffee());
		assertEquals(r[0].hasCream(),room_0.hasCream());
		assertEquals(r[0].hasSugar(),room_0.hasSugar());
		assertEquals(r[0].northExit(),room_0.northExit());
		assertEquals(r[0].southExit(),room_0.southExit());
		//edge case: j=2
		Room room_2=new Room(true,false,false,true,true);
		
		assertEquals(r[2].hasCoffee(),room_2.hasCoffee());
		assertEquals(r[2].hasCream(),room_2.hasCream());
		assertEquals(r[2].hasSugar(),room_2.hasSugar());
		assertEquals(r[2].northExit(),room_2.northExit());
		assertEquals(r[2].southExit(),room_2.southExit());
		//edge case: j=5
		Room room_5=new Room(false,false,true,false,true);
		assertEquals(r[5].hasCoffee(),room_5.hasCoffee());
		assertEquals(r[5].hasCream(),room_5.hasCream());
		assertEquals(r[5].hasSugar(),room_5.hasSugar());
		assertEquals(r[5].northExit(),room_5.northExit());
		assertEquals(r[5].southExit(),room_5.southExit());
		//basic case: j=3
		Room room_3=new Room(false,false,false,true,true);
		assertEquals(r[3].hasCoffee(),room_3.hasCoffee());
		assertEquals(r[3].hasCream(),room_3.hasCream());
		assertEquals(r[3].hasSugar(),room_3.hasSugar());
		assertEquals(r[3].northExit(),room_3.northExit());
		assertEquals(r[3].southExit(),room_3.southExit());
	}
	
	/*
	 * Test generateRoom, edge case: numRooms=0
	 */
	@Test
	public void testGenerateRoom_edgeCase0(){
		House h=new House(1);
		Room[] r=h.generateRooms(0);
		assertNotNull(r);
	}
	
	/*
	 * Test generateRoom, edge case: numRooms=1
	 * j=0 and j=numRooms-1 are equivalent class
	 */
	@Test
	public void testGenerateRoom_edgeRoom1(){
		House h=new House(1);
		Room[] r=h.generateRooms(1);
		Room room_0=new Room(false,true,true,false,false);
		assertEquals(r[0].hasCoffee(),room_0.hasCoffee());
		assertEquals(r[0].hasCream(),room_0.hasCream());
		assertEquals(r[0].hasSugar(),room_0.hasSugar());
		assertEquals(r[0].northExit(),room_0.northExit());
		assertEquals(r[0].southExit(),room_0.southExit());
	}
	
	/*
	 * Test generateRoom, edge case: numRooms=3
	 * j=2 and j=numRooms-1 are equivalent class
	 */
	@Test
	public void testGenerateRoom_edgeRoom3(){
		House h=new House(3);
		Room[] r=h.generateRooms(3);
		Room room_2=new Room(true,false,true,false,true);
		assertEquals(r[2].hasCoffee(), true); // room_2.hasCoffee());
		assertEquals(r[2].hasCream(),room_2.hasCream());
		assertEquals(r[2].hasSugar(),room_2.hasSugar());
		assertEquals(r[2].northExit(),room_2.northExit());
		assertEquals(r[2].southExit(),room_2.southExit());
	}
	
}
