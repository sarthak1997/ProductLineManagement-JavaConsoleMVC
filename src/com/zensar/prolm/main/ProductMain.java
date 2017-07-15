package com.zensar.prolm.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.regex.Pattern;

import com.zensar.prolm.daoclass.ProductDAOClass;
import com.zensar.prolm.exception.DescriptionLengthException;
import com.zensar.prolm.exception.InvalidIDException;
import com.zensar.prolm.exception.InvalidNameException;
import com.zensar.prolm.exception.InvalidPriceException;
import com.zensar.prolm.model.Product;

public class ProductMain {
	
	Product p=new Product();
	ProductDAOClass pdc = new ProductDAOClass();
	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	Scanner sc = new Scanner(System.in);
	String pID,pName,pDesc;
	double price;
	
	public void chooseOption(String pcat){
		
		System.out.println("\nYOU HAVE CHOSEN "+pcat.toUpperCase());
		System.out.println("\nSELECT OPERATION");
		System.out.println("\n1. FOR ADDING NEW PRODUCT");
		System.out.println("\n2. FOR MODIFICATION OF A PRODUCT");
		System.out.println("\n3. FOR REMOVING A PRODUCT");
		System.out.println("\n4. FOR VIEWING A PRODUCT");
	}
	
	public void addProduct(Product p){
		System.out.println("\nADD NEW PRODUCT");
		System.out.println("\nENTER PRODUCT NAME");
		try{
		pName=sc.next();
		if(Pattern.matches("[0-9]{1}",(pName.charAt(0))+""))
			throw new InvalidNameException();
		}
		catch(InvalidNameException ine){
			System.out.println(ine.getMessage());
			return;
		}
		p.setpName(pName);
		System.out.println("\nENTER DESCRIPTION");
		
			try {
				pDesc=reader.readLine();
				try{
				if(pDesc.length()>=500){
					throw new DescriptionLengthException();
				}
				}
				catch(DescriptionLengthException dle){
					dle.getMessage();
					return;
				}
				p.setpDesc(pDesc);
			} catch (IOException e) {
				System.out.println("\nINVALID INPUT");
			}
		System.out.println("\nENTER PRICE");
		try{
			price=sc.nextDouble();
			if(price<=0)
				throw new InvalidPriceException();
			p.setpPrice(price);
		}
		catch(InvalidPriceException ipe){
			System.out.println(ipe.getMessage());
			return;
		}
		pID=pdc.generateProductID(p);
		p.setpID(pID);
		
		if(pdc.insertProduct(p))
			{
			System.out.println("\n*****Congratulations Your Product is added successfully*****");
			System.out.println();
			System.out.println("\nAdded Product ID is "+pID);
			}
		else
			System.out.println("Error Occured....Please Try Again");
		
		
	}
	
	public void modifyProduct(Product p){
		
		System.out.println("\nMODIFY");
		System.out.println("\nENTER PRODUCT ID FOR WHICH YOU HAVE TO MODIFY");
		try{
		pID=sc.next();
		if(!(pdc.verifyProductID(pID, p.getpCategory())))
			throw new InvalidIDException();
		}
		catch(InvalidIDException iie){
			System.out.println(iie.getMessage());
			return;
		}
		p.setpID(pID);
		System.out.println("\nENTER NEW DESCRIPTION");
		try {
			pDesc=reader.readLine();
			p.setpDesc(pDesc);
		} catch (IOException e) {
			System.out.println("\nINVALID INPUT");
		}
		if(pdc.modifyProduct(p))
			{
			System.out.println("\n-------MODIFIED-------");
			System.out.println("\nFor the Product ID - "+p.getpID());
			}
		else
		{
			System.out.println("Error Occured.....Please Try Again");
		}
	}
	
	public void deleteProduct(Product p)
	{
		System.out.println("\nREMOVE");
		System.out.println("\nENTER PRODUCT ID FOR THE PRODUCT YOU WANT TO DELETE");
		try{
			pID=sc.next();
			if(!(pdc.verifyProductID(pID, p.getpCategory())))
				throw new InvalidIDException();
			}
			catch(InvalidIDException iie){
				System.out.println(iie.getMessage());
				return;
			}
		p.setpID(pID);
		if(pdc.deleteProduct(p))
			{
			System.out.println("\n-------DELETED-------");
			}
		else
		{
			System.out.println("Error Occured.....Please Try Again");
		}
	}
	
	public void viewProduct(Product p)
	{
		System.out.println("\nVIEW");
		System.out.println("\nENTER PRODUCT ID FOR THE PRODUCT YOU WANT TO VIEW");
		try{
			pID=sc.next();
			if(!(pdc.verifyProductID(pID, p.getpCategory())))
				throw new InvalidIDException();
			}
			catch(InvalidIDException iie){
				System.out.println(iie.getMessage());
				return;
			}
		p.setpID(pID);
		Product pro=pdc.viewProduct(p.getpID(),p.getpCategory());
		if(pro!=null)
		System.out.println(pro);
		else
		{
			System.out.println("\nError Occured.....Please Try Again");
		}
	}
	
	public int productOperations(int g,String pCategory)
	{
		p.setpCategory(pCategory);
		chooseOption(pCategory);
		int y = sc.nextInt();
		switch(y)
		{
		case 1:
			addProduct(p);
			System.out.println("\nPRESS\n\n1. TO CONTINUE PERFORMING OPERATIONS IN ELECTRONIC CATEGORY");
			System.out.println("\n2. FOR CHANGING CATEGORY");
			System.out.println("\nELSE ANY FOR QUITING");
			g = sc.nextInt();
			break;
		case 2:
			modifyProduct(p);
			System.out.println("\nPRESS\n\n1. TO CONTINUE PERFORMING OPERATIONS IN ELECTRONIC CATEGORY");
			System.out.println("\n2. FOR CHANGING CATEGORY");
			System.out.println("\nELSE ANY FOR QUITING");
			
			g = sc.nextInt();
			break;
		case 3:
			deleteProduct(p);
			System.out.println("\nPRESS\n\n1. TO CONTINUE PERFORMING OPERATIONS IN ELECTRONIC CATEGORY");
			System.out.println("\n2. FOR CHANGING CATEGORY");
			System.out.println("\nELSE ANY FOR QUITING");
			g = sc.nextInt();
			break;
		case 4:
			viewProduct(p);
			System.out.println("\nPRESS\n\n1. TO CONTINUE PERFORMING OPERATIONS IN ELECTRONIC CATEGORY");
			System.out.println("\n2. FOR CHANGING CATEGORY");
			System.out.println("\nELSE ANY FOR QUITING");
			g = sc.nextInt();
			break;
			default:
				System.out.println("\nINVALID CHOICE ENTERED");
				g=1;
				break;
		}
		return g;
	}
	
	public static void main(String[] args) {
		int g=0;
		ProductMain pm=new ProductMain();
		String pCategory="";
		do{
			System.out.println("\n--------WELCOME TO \"PRODUCT LINE MANAGEMENT SYSTEM\"--------");
			System.out.println("\nSELECT CATEGORY FOR THE PRODUCT");
			System.out.println("\nENTER");
			System.out.println("\n1. FOR ELECTRONICS");
			System.out.println("\n2. FOR AUTOMOBILES");
			System.out.println("\n3. FOR GROCERIES");
			int x = pm.sc.nextInt();
			switch(x)
			{
			case 1:
			do{
				pCategory="Electronics";
				g=pm.productOperations(g, pCategory);
			}while(g==1);
			break;
				
			case 2:
			do{
				pCategory = "Automobiles";
				g=pm.productOperations(g, pCategory);
			}while(g==1);
			break;
				
			case 3:
				do{
					pCategory = "Groceries";
					g=pm.productOperations(g, pCategory);
				}while(g==1);
				break;
			default:
				System.out.println("\nINVALID CHOICE ENTERED");
				g=2;
				break;
	}
	}while(g==2);
		System.out.println("\n******************THANK YOU*********************");
}
}
