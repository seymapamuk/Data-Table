package com.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;


import com.model.Worker;

public class GetWorkerInfo {
	
	private static ArrayList<Worker> workList = null;
	
	public static void connect(String sql) {
		
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
		
	}
	
    public static ArrayList<Worker> getWorker() {
    	
    workList = new ArrayList<Worker>();
    	
    final String sql = "select * from employee";
        
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
        
        ResultSet result = stmt.executeQuery();
        
        while(result.next()){
        	Worker worker = new Worker();
        	
			worker.setSicil(result.getInt("sicil"));
			worker.setName(result.getString("name"));
			worker.setSurname(result.getString("surname"));
			worker.setDepartman(result.getString("departman"));
			worker.setPassword(result.getString("sifre"));
			
			workList.add(worker);
		}
        
     } 
    catch (SQLException e) {
    	System.out.println(e.getMessage());
      } 
      catch (NamingException e) {
      	System.out.println(e.getMessage());

      }
    catch (Exception e) {
    	System.out.println(e.getMessage());

      }
        finally {
        try {
              if (ctx != null)
                    ctx.close();
        } catch (Exception e) {
        }
        try {
            if (envContext != null)
              envContext.close();
      } catch (Exception e) {
      }
        try {
              if (stmt != null)
                    stmt.close();
        } catch (Exception e) {
        }
        try {
              if (conn != null)
                    conn.close();
        } catch (Exception e) {
        }
        }  
        
        	return workList;

    }
    
    public static void update(String f, String s, int l) {
    	
    	String sql = "update employee set " + f + " = " + "'" + s + "'" + "where sicil = '" + l + "'";
    	connect(sql);
    	
    }
    
    public static void add(int s, String sn, String n, String d) {
    	
    	String sql = "insert into employee (sicil, surname, name, departman) values ('" + s + "'," + "'" + sn + "'," + "'" + n + "'," + "'" + d + "')";
    	
    	connect(sql);
    }
    
    public static void newUser(int s, String sn, String n, String d, String p) {
    	
    	String sql = "insert into employee (sicil, surname, name, departman, sifre) values ('" + s + "'," + "'" + sn + "'," + "'" + n + "'," + "'" + d + "','" + p + "')";
    	
    	connect(sql);
    }

    public static void delete(int s) {
    	
    	String sql = "delete from employee where Sicil = '" + s + "'";
    	
    	connect(sql);
    }
    
    public static boolean login(int s, String p) {
    	
    	String sql = "select count(*) as count from employee where sicil ='" + s + "' and sifre ='" + p + "'";
    	
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
        
        ResultSet result = stmt.executeQuery();
        
        while(result.next()) {
        if(result.getInt("count") > 0)
        	return true;
        }
  
  	    }
  	    catch(SQLException e){
  	    	System.out.println(e.getMessage());
  	    	return false;
  	    }
  	    catch (NamingException e) {
  	      	System.out.println(e.getMessage());
  	      	return false;

  	      }
  	    catch (Exception e) {
  	    	System.out.println(e.getMessage());
  	    	return false;
  	    }
  	    
  	    return false;
    }
    
    public static Worker search(String x) {
    	
    	Worker resultList = new Worker();
    	
    	String[] split = x.split(" ");
    	
    	String sql = "select * from employee where name like '%" + split[0] + "%' and surname like '%" + split[1] + "%'";
    	
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
    	        
    	        ResultSet result = stmt.executeQuery();
    	        
    	        while(result.next()){
    	        	Worker worker = new Worker();
    	        	
    				worker.setSicil(result.getInt("sicil"));
    				worker.setName(result.getString("name"));
    				worker.setSurname(result.getString("surname"));
    				worker.setDepartman(result.getString("departman"));
    				worker.setPassword(result.getString("sifre"));
    				
    				resultList = worker;
    			}
    	        
    	     } 
    	    catch (SQLException e) {
    	    	System.out.println(e.getMessage());
    	      } 
    	      catch (NamingException e) {
    	      	System.out.println(e.getMessage());

    	      }
    	    catch (Exception e) {
    	    	System.out.println(e.getMessage());

    	      }
    	        finally {
    	        try {
    	              if (ctx != null)
    	                    ctx.close();
    	        } catch (Exception e) {
    	        }
    	        try {
    	            if (envContext != null)
    	              envContext.close();
    	      } catch (Exception e) {
    	      }
    	        try {
    	              if (stmt != null)
    	                    stmt.close();
    	        } catch (Exception e) {
    	        }
    	        try {
    	              if (conn != null)
    	                    conn.close();
    	        } catch (Exception e) {
    	        }
    	        }  
    	
    	return resultList;
    }
    
    public static ArrayList<String> nameList() {
    	
    	String sql = "select name, surname from employee";
    	
    	ArrayList<String> nameList = new ArrayList<String>();
    	
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
            
            ResultSet result = stmt.executeQuery();
      
            while(result.next()){
            	nameList.add(result.getString("name") + " " + result.getString("surname"));
    		}
            
         } 
        catch (SQLException e) {
        	System.out.println(e.getMessage());
          } 
          catch (NamingException e) {
          	System.out.println(e.getMessage());

          }
        catch (Exception e) {
        	System.out.println(e.getMessage());

          }
            finally {
            try {
                  if (ctx != null)
                        ctx.close();
            } catch (Exception e) {
            }
            try {
                if (envContext != null)
                  envContext.close();
          } catch (Exception e) {
          }
            try {
                  if (stmt != null)
                        stmt.close();
            } catch (Exception e) {
            }
            try {
                  if (conn != null)
                        conn.close();
            } catch (Exception e) {
            }
            }  
    
    	return nameList;
    }
    
}
