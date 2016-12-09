package com.company.application.appleorangeshoppingcart;

public enum Products {
	
		Apple(0.60), Orange(0.25);

		private final double productPrice;

		Products(double productPrice) {
			this.productPrice = productPrice;
		}

		public double getProductPrice() {
			return productPrice;
		}	

}
