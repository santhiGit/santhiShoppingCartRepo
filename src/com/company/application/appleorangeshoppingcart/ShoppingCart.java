package com.company.application.appleorangeshoppingcart;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ShoppingCart implements IShoppingCart{

	//Must be made configurable based on dates/days etc.
	public boolean offerAvailable = true;

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
	public int getProductQuantity(String product, String purchasedItems) {
		int productQuantity = 0;
		if (checkProductsAvailable(purchasedItems)) {		
			List<String> purchasedItemsList = Arrays.asList(purchasedItems.split(","));
			for (String item : purchasedItemsList) {
				if(item.equals(product))
					productQuantity++;
			}

		}
		return productQuantity;
	}
	
	
	@Override
	public double checkOutTotal(String purchase) {
		double totalPrice = 0;
		if(checkProductsAvailable(purchase)){
			List<String> purchasedItemsList = Arrays.asList(purchase.split(","));
			Set<String> uniquePurchaseItems = new HashSet<String>(purchasedItemsList);

			for(String item: uniquePurchaseItems){
				switch(item){
				case "Apple":
					int appleProdQunatity = getProductQuantity(item, purchase);
					int newAppleProdQunatity = appleProdQunatity;
					if(offerAvailable && appleProdQunatity>1)
						newAppleProdQunatity = appleProdQunatity - appleProdQunatity/2;
					totalPrice += newAppleProdQunatity * Products.valueOf(item).getProductPrice();
					break;
				case "Orange":
					int orangeProdQunatity = getProductQuantity(item, purchase);
					int newOrangeProdQunatity = orangeProdQunatity;
					if(offerAvailable && orangeProdQunatity>2)
						newOrangeProdQunatity = orangeProdQunatity - orangeProdQunatity/3;
					totalPrice += newOrangeProdQunatity * Products.valueOf(item).getProductPrice();
					break;
				}
			}
		}
		return totalPrice;
	}

}
