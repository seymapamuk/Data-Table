package com.control;


import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import com.database.GetWorkerInfo;
import com.model.Customer;
import com.model.Worker;
 
@ManagedBean(name="order")
@ViewScoped
public class OrderBean implements Serializable{
	
	@Resource(name = "stable")
	private DataSource ds;

	private static final long serialVersionUID = 1L;

	private static ArrayList<Worker> workList = null;
	private static ArrayList<Customer> custList = null;
	
	String n,sn,d;
	int s;
	
	public ArrayList<Worker> getWorkList() {
		return workList;
	}

	public void setWorkList(ArrayList<Worker> workList) {
		OrderBean.workList = workList;
	}

	public ArrayList<Customer> getCustList() {
		return custList;
	}

	@PostConstruct
	public void init() {
		
		workList = new ArrayList<Worker>();
		custList = new ArrayList<Customer>();
		
		workList = GetWorkerInfo.getWorker();
		
		custList.add(new Customer("Ýsim","Soyisim",373738,"Bjk"));
	}
	
	
	public void addWork() {
		workList.add(new Worker(n,sn,s,d));
		
		GetWorkerInfo.add(s, sn, n, d);
	}
	
	public void deleteWork(Worker o) {
		workList.remove(o);
		
		GetWorkerInfo.delete(o.getSicil());
	}
	
	public void addCust() {
		custList.add(new Customer(n,sn,s,d));
	}
	
	public void deleteCust(Customer o) {
		custList.remove(o);
	}

	public static void redirection(String s) {
		
		FacesContext context = FacesContext.getCurrentInstance();
	    HttpServletRequest origRequest = (HttpServletRequest)context.getExternalContext().getRequest();
	    String contextPath = origRequest.getContextPath();
	    try {
	        FacesContext.getCurrentInstance().getExternalContext()
	                .redirect(contextPath  + "/" + s);
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
	
	public void editCust(Customer c) {
		c.setEdit(true);
	}
	
	public void editWork(Worker w) {
		w.setEdit(true);
	}
	
	public void saveWork() throws SQLException {
		
		for(Worker w : workList) {
			if(w.isEdit()) {
				GetWorkerInfo.update("name", w.getName(), w.getSicil());
				GetWorkerInfo.update("surname", w.getSurname(), w.getSicil());
				GetWorkerInfo.update("departman", w.getDepartman(), w.getSicil());
			}
			w.setEdit(false);
		}
	}
	
	public void saveCust() {
		for(Customer c : custList) {
			c.setEdit(false);
		}
	}
	
	/*public void login() {
		
		for(Worker w : workList) {
			if(w.getSicil() == s && w.getPassword() == password)
				redirection("welcome");
			else {
				

				}
			}
			
		}*/
	
	public String getN() {
		return n;
	}

	public void setN(String n) {
		this.n = n;
	}

	public String getSn() {
		return sn;
	}

	public void setSn(String sn) {
		this.sn = sn;
	}

	public String getD() {
		return d;
	}

	public void setD(String d) {
		this.d = d;
	}

	public int getS() {
		return s;
	}

	public void setS(int s) {
		this.s = s;
	}

}