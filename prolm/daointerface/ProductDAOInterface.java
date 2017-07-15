package com.zensar.prolm.daointerface;

import com.zensar.prolm.model.Product;

public interface ProductDAOInterface {
	  boolean insertProduct(Product p);
	  boolean modifyProduct(Product p);
	  boolean deleteProduct(Product p);
	  Product viewProduct(String pID,String pCategory);
	  String generateProductID(Product p);
	  boolean verifyProductID(String pID,String pCategory);
}
