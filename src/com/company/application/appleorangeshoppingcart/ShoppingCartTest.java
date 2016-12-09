package com.company.application.appleorangeshoppingcart;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ShoppingCartTest {
	ShoppingCart shopcart;
	
	@Before
	public void setUp() {
		
		shopcart = new ShoppingCart();
	}
	
	@Test
	public void testIsObjectNull() {
			
		assertNotNull(shopcart);
	}
	
	@Test
	public void testIsAvailableProductTrue() {	
		assertTrue(shopcart.isAvailableProduct("Orange"));
	}

	@Test
	public void testIsAvailableProductFalse() {	
		assertFalse(shopcart.isAvailableProduct("Mango"));
	}
	
	@Test
	public void testGetProductPriceTrue() {	
		assertTrue(0.25/shopcart.getProductPrice("Orange") == 1);	
}
	
	@Test
	public void testGetProductPriceFalse() {	
		assertFalse(0.25/shopcart.getProductPrice("Apple") == 1);	
}
	
	@Test
	public void testCheckProductsAvailableValid() {	
		assertTrue(shopcart.checkProductsAvailable("Orange,Apple,Apple,Orange,Apple"));	
}
	
	@Test
	public void testCheckProductsAvailableInvalid() {	
		assertFalse(shopcart.checkProductsAvailable("Orange,Apple,Mango,Orange,Apple"));	
}
	
	@Test
	public void testCheckoutTotalValid() {	
		assertEquals(2.05, shopcart.checkOutTotal("Apple,Apple,Orange,Apple"), 0.0);
}
	
	@Test
	public void testCheckoutTotalInvalid() {	
		assertNotEquals(2.30, shopcart.checkOutTotal("Apple,Apple,Orange,Apple"), 0.0);
}
	
	
}
