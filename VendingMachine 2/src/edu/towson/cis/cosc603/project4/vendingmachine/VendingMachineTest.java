package edu.towson.cis.cosc603.project4.vendingmachine;

import org.junit.*;

import static org.junit.Assert.*;

/**
 * The class <code>VendingMachineTest</code> contains tests for the class <code>{@link VendingMachine}</code>.
 *
 * @generatedBy CodePro at 4/5/16 9:03 PM
 * @author nahomnegash
 * @version $Revision: 1.0 $
 */
public class VendingMachineTest {
	VendingMachine machine;
	VendingMachineItem coke;
	VendingMachineItem sprite;
	
	@Before
	public void setUp() throws Exception {
		coke = new VendingMachineItem("Coca Cola", 5);
		sprite = new VendingMachineItem("Sprite", 5);
		machine = new VendingMachine();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAddItem() {
		machine.addItem(coke, "A");
		assertEquals(coke, machine.getItem("A"));
		assertEquals(null, machine.getItem("B"));	
	}
	
	@Test(expected = VendingMachineException.class)
	public void testInsertingItemAtTheSameLocation(){
		machine.addItem(coke, "A");
		machine.addItem(sprite, "A");
	}
	
	@Test(expected = VendingMachineException.class)
	public void testInsertingItemAtInvalidCode(){
		machine.addItem(coke, "Z");
	}

	@Test
	public void testRemoveItem() {
		machine.addItem(sprite, "A");
		machine.removeItem("A");
		assertEquals(null, machine.getItem("A"));
	}
	
	@Test(expected = VendingMachineException.class)
	public void testRemovingAnItemFromAnEmptySlot(){
		machine.removeItem("C");
	}
	
	@Test(expected = VendingMachineException.class)
	public void testRemoveAnItemFromAnInvalidSlot(){
		machine.removeItem("Z");
	}

	@Test
	public void testInsertMoney() {
		machine.insertMoney(5);
		assertEquals(5, machine.getBalance(), 0.0);
		machine.insertMoney(2);
		assertEquals(7, machine.getBalance(), 0.0);
	}
	
	@Test(expected = VendingMachineException.class)
	public void testTryingToStealMoney(){
		machine.insertMoney(-2);
	}
	@Test
	public void testMakePurchaseWrongSlot(){
		machine.insertMoney(5);
		machine.addItem(coke, "A");
		assertFalse(machine.makePurchase("B"));
	}

	@Test
	public void testGetBalance() {
		assertEquals(0, machine.getBalance(), 0.0);
		machine.insertMoney(5);
		assertEquals(5, machine.getBalance(), 0.0);
	}

	@Test
	public void testMakePurchase() {
		machine.insertMoney(5);
		machine.addItem(coke, "A");
		boolean status = machine.makePurchase("A");
		assertEquals(true, status);
	}
	
	@Test
	public void testPurchasingWithoutEnoughMoney() {
		machine.addItem(coke, "A");
		boolean status = machine.makePurchase("A");
		assertEquals(true, status);
		machine.insertMoney(3);
		status = machine.makePurchase("A");
		assertEquals(false, status);
	}
	
	@Test
	public void testPurchasingAnItemAtAnEmptySlot(){
		boolean status = machine.makePurchase("D");
		assertEquals(false, status);
	}
	
	@Test(expected = VendingMachineException.class)
	public void testPurchasingAnItemAtInvalidSlot(){
		boolean status = machine.makePurchase("Z");
		assertEquals(false, status);
	}
	
	@Test
	public void testItemShouldBeRemovedFromSlotAfterMakingPurchase(){
		machine.insertMoney(5);
		machine.addItem(coke, "A");
		machine.makePurchase("A");
		assertEquals(null,machine.getItem("A"));
	}

	@Test
	public void testReturnChange() {
		machine.insertMoney(7);
		machine.addItem(coke, "A");
		machine.makePurchase("A");
		assertEquals(7,machine.returnChange(),0.0);
		assertEquals(0,machine.getBalance(),0.0);
	}
	
	@Test
	public void testAskForChangeWithoutPuttingInMoney(){
		assertEquals(0,machine.returnChange(),0.0);
		assertEquals(0,machine.getBalance(),0.0);
	}
	
	@Test
	public void testAskForChangeBeforePurchasing() {
		machine.insertMoney(7);
		assertEquals(7,machine.returnChange(),0.0);
		assertEquals(0,machine.getBalance(),0.0);
	}
	
	

}
