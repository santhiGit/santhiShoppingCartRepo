package com.company.application.appleorangeshoppingcart;
import java.util.Arrays;
import java.util.List;

public class ShoppingCart implements IShoppingCart{

	@Override
	public boolean isAvailableProduct(String product) {
		boolean available = false;
		for (Products prod : Products.values()) {
			if (prod.name().equals(product)) {
				available = true;
				break;
			}
		}

		return available;
	}

	@Override
	public double getProductPrice(String product) {

		double price = 0.0;
		for (Products prod : Products.values()) {
			if (prod.name().equals(product)) {
				price = prod.getProductPrice();
			}
		}

		return price;
	}

	@Override
	public boolean checkProductsAvailable(String purchase) {
		boolean validProducts = true;
		List<String> purchasedItems = Arrays.asList(purchase.split(","));
		for (String item : purchasedItems) {
			if (!isAvailableProduct(item)) {
				validProducts = false;
				break;
			}
		}

		return validProducts;
	}

	@Override
	public double checkOutTotal(String purchase) {
		double total = 0;
		if (checkProductsAvailable(purchase)) {
			List<String> purchasedItems = Arrays.asList(purchase.split(","));
			for (String item : purchasedItems) {
				total += Products.valueOf(item).getProductPrice();
			}
		}

		return total;
	}

}
