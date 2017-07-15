package com.zensar.prolm.model;

public class Product 
{
   String pID;
   String pName;
   String pDesc;
   double pPrice;
   String pCategory;
   
   public Product() 
   {
	   pID="test2";
	   pName="test";
	   pDesc="test";
	   pCategory="electronics";
	   pPrice=1.0;
   }
   

public Product(String pName, String pDesc, double pPrice,
	String pCategory) {
	this.pName = pName;
	this.pDesc = pDesc;
	this.pPrice = pPrice;
	this.pCategory = pCategory;
}

public Product(String pID, String pName, String pDesc, double pPrice, String pCategory) {
	super();
	this.pID = pID;
	this.pName = pName;
	this.pDesc = pDesc;
	this.pPrice = pPrice;
	this.pCategory = pCategory;
}


public String getpID() {
	return pID;
}

public void setpID(String pID) {
	this.pID = pID;
}

public String getpName() {
	return pName;
}

public void setpName(String pName) {
	this.pName = pName;
}

public String getpDesc() {
	return pDesc;
}

public void setpDesc(String pDesc) {
	this.pDesc = pDesc;
}

public double getpPrice() {
	return pPrice;
}

public void setpPrice(double pPrice) {
	this.pPrice = pPrice;
}

public String getpCategory() {
	return pCategory;
}

public void setpCategory(String pCategory) {
	this.pCategory = pCategory;
}
@Override
	public String toString() {
		// TODO Auto-generated method stub
		return ("\n******PRODUCT DETAILS******\n\n-->ID = "+pID+" \n-->NAME = "+pName+" \n-->DESCRIPTION = "+pDesc+" \n-->PRICE = "+pPrice);
	}
  
   
   
}
