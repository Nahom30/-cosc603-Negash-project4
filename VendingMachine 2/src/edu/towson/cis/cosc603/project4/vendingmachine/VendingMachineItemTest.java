package edu.towson.cis.cosc603.project4.vendingmachine;

import org.junit.*;

import static org.junit.Assert.*;

/**
 * The class <code>VendingMachineItemTest</code> contains tests for the class <code>{@link VendingMachineItem}</code>.
 *
 * @generatedBy CodePro at 4/5/16 9:03 PM
 * @author nahomnegash
 * @version $Revision: 1.0 $
 */
public class VendingMachineItemTest {

	VendingMachineItem item;
	
	@Before
	public void setUp() throws Exception {
		item = new VendingMachineItem("Coca Cola", 5);
	}


	@Test
	public void testVendingMachineItem() {
		assertEquals(null, item.getName());
		assertEquals(0.0, item.getPrice(), 0.0);
	}
	
	@Test(expected = VendingMachineException.class)
	public void testWithBadPrice(){
		new VendingMachineItem("Coca Cola", -1);
	}

	@Test
	public void testGetName() {
		assertEquals(null, item.getName());
	}

	@Test
	public void testGetPrice() {
		assertEquals(0.0, item.getPrice(), 0.0);
	}

	
}