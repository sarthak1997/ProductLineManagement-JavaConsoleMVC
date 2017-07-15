package com.zensar.prolm.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import com.zensar.prolm.daoclass.ProductDAOClass;
import com.zensar.prolm.model.Product;

public class ProductTestClass {

	static ProductDAOClass pdc;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		pdc=new ProductDAOClass();
	}


	@Test
	public void testProductDAOClass() {
		//fail("Not yet implemented");
		assertNotNull(new ProductDAOClass());
	}

	@Test
	public void testInsertProduct() {
		//fail("Not yet implemented");
		Product p=new Product();
		p.setpID("test3");
		assertTrue(pdc.insertProduct(p));
	}

	@Test
	public void testModifyProduct() {
		//fail("Not yet implemented");
		Product p=new Product();
		p.setpID("TVEL2");
		p.setpCategory("electronics");
		assertTrue(pdc.modifyProduct(p));
	}

	@Test
	public void testDeleteProduct() {
		//fail("Not yet implemented");
		Product p=new Product();
		p.setpID("test2");
		p.setpCategory("electronics");
		assertTrue(pdc.deleteProduct(p));
	}

	@Test
	public void testViewProduct() {
		//fail("Not yet implemented");
		assertNotNull(pdc.viewProduct("TVEL2","electronics"));
		
	}
	
	@Test
	public void testGenerateProductID() {
		//fail("Not yet implemented");
		
		assertEquals("TEGR1",pdc.generateProductID(new Product("test","test",10.0,"groceries")));
	}

	@Test
	public void testVerifyProductID() {
		//fail("Not yet implemented");
		
		assertTrue(pdc.verifyProductID("TVEL2", "electronics"));
	}

}
