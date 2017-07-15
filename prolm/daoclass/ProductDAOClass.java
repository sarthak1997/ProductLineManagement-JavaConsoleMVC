package com.zensar.prolm.daoclass;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.zensar.prolm.connection.DBUtil;
import com.zensar.prolm.daointerface.ProductDAOInterface;
import com.zensar.prolm.model.Product;

public class ProductDAOClass implements ProductDAOInterface {
	
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	public ProductDAOClass() {
		con=DBUtil.getConnection();
		ps=null;
		rs=null;
	}
	
	@Override
	public boolean insertProduct(Product p) {
		String qr="insert into "+p.getpCategory()+" values(?,?,?,?,?)";
		
		try {
			ps=con.prepareStatement(qr);
			
			ps.setString(1,p.getpID());
			ps.setString(2,p.getpName());
			ps.setString(3,p.getpDesc());
			ps.setDouble(4,p.getpPrice());
			ps.setString(5,p.getpCategory());
			
			if(ps.executeUpdate()>0)
				return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("ERROR OCCURED....PLEASE TRY AGAIN");
		}
		return false;
	}

	@Override
	public boolean modifyProduct(Product p) {
		
		String qr="update "+p.getpCategory()+" set pdesc=? where pid=?";
		try {
			ps=con.prepareStatement(qr);
			
			ps.setString(1,p.getpDesc());
			ps.setString(2,p.getpID());
			
			if(ps.executeUpdate()>0)
				return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("ERROR OCCURED....PLEASE TRY AGAIN");
		}
		
		return false;
	}

	@Override
	public boolean deleteProduct(Product p) {
		// TODO Auto-generated method stub
		
		String qr="delete from "+p.getpCategory()+" where pid=?";
		try {
			ps=con.prepareStatement(qr);
			ps.setString(1,p.getpID());
			
		if(ps.executeUpdate()>0)
				return true;
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("ERROR OCCURED....PLEASE TRY AGAIN");
		}
		return false;
		
		//return false;
	}

	@Override
	public Product viewProduct(String pID,String pCategory) {
		// TODO Auto-generated method stub
		
		String qr="select * from "+pCategory+" where pid=?";
		try {
			ps=con.prepareStatement(qr);
			ps.setString(1,pID);
			rs=ps.executeQuery();
			
			Product p=new Product();
			if(rs.next())
			{
				p.setpID(rs.getString(1));
				p.setpName(rs.getString(2));
				p.setpDesc(rs.getString(3));
				p.setpPrice(rs.getDouble(4));
				
				return p;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("ERROR OCCURED....PLEASE TRY AGAIN");
		}
		
		return null;
	}
	
	@Override
	public String generateProductID(Product p)
	{
		String id="";
		String qr="select max(substr(pid,5,length(pid))) from "+p.getpCategory();
		id+=p.getpName().substring(0,2).toUpperCase();
		id+=p.getpCategory().substring(0,2).toUpperCase();
		try {
			ps=con.prepareStatement(qr);
			//ps.setString(1,p.getpCategory());
			rs=ps.executeQuery();
			
			if(rs.next())
				id+=(rs.getInt(1)+1);
			
			return id;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("ERROR OCCURED....PLEASE TRY AGAIN");
		}
		
		return null;	
	}

	@Override
	public boolean verifyProductID(String pID, String pCategory) {
		// TODO Auto-generated method stub
		
		String qr="select pid from "+pCategory+" where pid=?";
		
		try {
			ps=con.prepareStatement(qr);
			ps.setString(1,pID);
			
			rs=ps.executeQuery();
			
			if(rs.next())
				return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("ERROR OCCURED....PLEASE TRY AGAIN");
		}
		
		return false;
	}
	
	

}
