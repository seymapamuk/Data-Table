package com.control;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import com.database.GetWorkerInfo;
import com.session.SessionUtils;

@ManagedBean
@SessionScoped
public class LoginBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String password;
	private int s;
	private String n,sn,d;
	
	private boolean login;
	
	public void loginData() {
		
		if(GetWorkerInfo.login(s, password)) {
			HttpSession session = SessionUtils.getSession();
			session.setAttribute("username", s);
			
			login = true;
			
			OrderBean.redirection("secured/welcome.jsf");
		}
		
		else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Incorrect Username and Password","Please enter correct username and Password"));
			
			login = false;
			
			OrderBean.redirection("login.jsf");
		}
	}
	
	public void logOut() {
		HttpSession session = SessionUtils.getSession();
		session.invalidate();

		login = false;
		
		OrderBean.redirection("login.jsf");
	}
	
	public void signUp() {
		GetWorkerInfo.newUser(s, sn, n, d, password);
		OrderBean.redirection("login.jsf");
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getS() {
		return s;
	}

	public void setS(int s) {
		this.s = s;
	}

	public boolean isLogin() {
		return login;
	}

	public void setLogin(boolean login) {
		this.login = login;
	}
	
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
}
