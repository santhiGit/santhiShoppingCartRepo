package com.company.application.appleorangeshoppingcart;

public interface IShoppingCart {
	
	public boolean isAvailableProduct(String product);
	public double getProductPrice(String product);
	public boolean checkProductsAvailable(String purchase);
	public double checkOutTotal(String purchase);
	public int getProductQuantity(String product, String purchasedItems);

}
