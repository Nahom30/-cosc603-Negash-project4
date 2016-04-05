package edu.towson.cis.cosc603.project4.vendingmachine;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class VendingMachineItemTest {

	VendingMachineItem item;
	
	@Before
	public void setUp() throws Exception {
		item = new VendingMachineItem("Coca Cola", 5);
	}


	@Test
	public void testVendingMachineItem() {
		assertEquals("Coca Cola", item.getName());
		assertEquals(5.0, item.getPrice(), 0.0);
	}
	
	@Test(expected = VendingMachineException.class)
	public void testWithBadPrice(){
		new VendingMachineItem("Coca Cola", -1);
	}

	@Test
	public void testGetName() {
		assertEquals("Coca Cola", item.getName());
	}

	@Test
	public void testGetPrice() {
		assertEquals(5.0, item.getPrice(), 0.0);
	}

}
