package com.tek.interview.question;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
/**
 * @author satya
 *
 */	
public class FooTest {
	Order order;
	OrderLine orderline;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		orderline = new OrderLine(new Item("imported box of chocolate", 10), 1);
		order = new Order();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test(expected = IllegalArgumentException.class) 
	public void testAddWithNull() throws Exception {
		
		order.add(null);
	}
	@Test 
	public void testAddWithFirstOrderline() throws Exception  {
		
		order.add(orderline);
		assertEquals(order.size(), 1);
	}
	@Test 
	public void testAddWithTwoOrderlines() throws Exception  {
		
		order.add(orderline);
		order.add(orderline);
		assertNotEquals(order.size(), 3);
	}
	@Test 
	public void testClearOrder() throws Exception  {
		
		order.add(orderline);
		order.add(orderline);
		order.clear();
		assertEquals(order.size(), 0);
	}

	
	@Test(expected = Exception.class) 
	public void testOrderLineWithNull() throws Exception {
		
		new OrderLine(null, 1);
	}
	@Test(expected = Exception.class) 
	public void testOrderLineWithNegativeQuantity() throws Exception {
		
		new OrderLine(new Item("imported box of chocolate", 10), -1);
	}
	@Test(expected = Exception.class) 
	public void testOrderLineWithZeroQuantity() throws Exception {
		
		new OrderLine(new Item("imported box of chocolate", 10), 0);
	}
	@Test 
	public void testOrderLineWithFirstItem() throws Exception  {
		
		OrderLine orderline = new OrderLine(new Item("imported box of chocolate", 10), 1);
		assertEquals(orderline.getQuantity(), 1);
		
	}
	
	
	@Test
	public void testRounding(){
		
		assertEquals(calculator.rounding(74.6789), 74.68, 0.001);
		
	}
	@Test
	public void testRoundingWithFailCase(){
		
		assertNotEquals(calculator.rounding(74.6333333), 74.68, 0.001);
		
	}
}
