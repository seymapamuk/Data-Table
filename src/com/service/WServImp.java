package com.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.jws.WebService;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;


@WebService(endpointInterface = "com.service.WService")
public class WServImp implements WService{
	
	//hashtablelý bi þeyler??
	
	@Override
	public boolean addDatabase(int s, String sn, String n, String d) {
		//GetWorkerInfo.add(s, sn, n, d);
		
		String sql = "insert into employee (sicil, surname, name, departman) values ('" + s + "'," + "'" + sn + "'," + "'" + n + "'," + "'" + d + "')";
		
	   	PreparedStatement stmt = null;
  	    Connection conn = null;
  	    Context ctx = null;
  	    Context envContext = null;
  	    
  	    try {
              ctx = new InitialContext();
              envContext = (Context) ctx.lookup("java:/comp/env");     
                  javax.sql.DataSource ds
                    = (javax.sql.DataSource) envContext.lookup ("stable"); 
                  
                  if(ds == null) {
                	  System.out.println("can't reach datasource");
                  }
              
        conn = ds.getConnection();
        
        if(conn == null) {
        	System.out.println("can't get database connection");
        }
        
        conn.setAutoCommit(true);
        stmt = conn.prepareStatement(sql);
        
        stmt.executeQuery();//execute
  	}
  	    catch(SQLException e){
  	    	System.out.println("sql exception");
  	    }
  	    catch (NamingException e) {
  	      	System.out.println(e.getMessage());

  	      }
  	    catch (Exception e) {
  	    	System.out.println(e.getMessage());

  	      }
  	    
  	    return true;
	}

	@Override
	public boolean updateDatabase(String f, String s, int l) {
		
		String sql = "update employee set " + f + " = " + "'" + s + "'" + "where sicil = '" + l + "'";
		
	   	PreparedStatement stmt = null;
  	    Connection conn = null;
  	    Context ctx = null;
  	    Context envContext = null;
  	    
  	    try {
              ctx = new InitialContext();
              envContext = (Context) ctx.lookup("java:/comp/env");     
                  javax.sql.DataSource ds
                    = (javax.sql.DataSource) envContext.lookup ("stable"); 
                  
                  if(ds == null) {
                	  System.out.println("can't reach datasource");
                  }
              
        conn = ds.getConnection();
        
        if(conn == null) {
        	System.out.println("can't get database connection");
        }
        
        conn.setAutoCommit(true);
        stmt = conn.prepareStatement(sql);
        
        stmt.executeQuery();//execute
  	}
  	    catch(SQLException e){
  	    	System.out.println("sql exception");
  	    }
  	    catch (NamingException e) {
  	      	System.out.println(e.getMessage());

  	      }
  	    catch (Exception e) {
  	    	System.out.println(e.getMessage());

  	      }
		
		return true;
	}

	@Override
	public boolean deleteDatabase(int s) {
		
		String sql = "delete from employee where Sicil = '" + s + "'";
		
		PreparedStatement stmt = null;
  	    Connection conn = null;
  	    Context ctx = null;
  	    Context envContext = null;
  	    
  	    try {
              ctx = new InitialContext();
              envContext = (Context) ctx.lookup("java:/comp/env");     
                  javax.sql.DataSource ds
                    = (javax.sql.DataSource) envContext.lookup ("stable"); 
                  
                  if(ds == null) {
                	  System.out.println("can't reach datasource");
                  }
              
        conn = ds.getConnection();
        
        if(conn == null) {
        	System.out.println("can't get database connection");
        }
        
        conn.setAutoCommit(true);
        stmt = conn.prepareStatement(sql);
        
        stmt.executeQuery();//execute
  	}
  	    catch(SQLException e){
  	    	System.out.println("sql exception");
  	    }
  	    catch (NamingException e) {
  	      	System.out.println(e.getMessage());

  	      }
  	    catch (Exception e) {
  	    	System.out.println(e.getMessage());

  	      }
		
		return true;
	}
	
	@Override
	public String newUser(int s, String sn, String n, String d, String p, boolean x) {
		
		String sql = "insert into employee (sicil, surname, name, departman, sifre) values ('" + s + "'," + "'" + sn + "'," + "'" + n + "'," + "'" + d + "','" + p + "')";
		
	  	PreparedStatement stmt = null;
  	    Connection conn = null;
  	    Context ctx = null;
  	    Context envContext = null;
  	    
  	    try {
  	    	
  	    	if(!x) {
  	    		conn.getTransactionIsolation();
  	    	}
  	    	
              ctx = new InitialContext();
              envContext = (Context) ctx.lookup("java:/comp/env");     
                  javax.sql.DataSource ds
                    = (javax.sql.DataSource) envContext.lookup ("stable"); 
                  
                  if(ds == null) {
                	  System.out.println("can't reach datasource");
                  }
              
        conn = ds.getConnection();
        
        if(conn == null) {
        	System.out.println("can't get database connection");
        }
        
        conn.setAutoCommit(true);
        stmt = conn.prepareStatement(sql);
        
        stmt.executeQuery();//execute
  	}
  	    catch(SQLException e){
  	    	System.out.println("sql exception");
  	    	return "Failed." + e.getMessage();
  	    }
  	    catch (NamingException e) {
  	      	System.out.println(e.getMessage());
  	      return "Failed." + e.getMessage();
  	      }
  	    catch (Exception e) {
  	    	System.out.println(e.getMessage());
  	    	return "Failed." + e.getMessage();
  	      }
  	    
  	    return "Succesful";
	}
	
}
