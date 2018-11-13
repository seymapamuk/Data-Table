package com.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

@WebService
@SOAPBinding(style = Style.RPC)
public interface WService {

	@WebMethod boolean addDatabase(@WebParam(name = "Sicil") int s, @WebParam(name = "Soyad") String sn, @WebParam(name = "Ad") String n, @WebParam(name = "Departman") String d);
	
	@WebMethod boolean updateDatabase(@WebParam(name = "Sýra") String f, @WebParam(name = "Deger") String s, @WebParam(name = "Sicil") int l);
	
	@WebMethod boolean deleteDatabase(@WebParam(name = "Sicil") int s);
	
	@WebMethod String newUser(@WebParam(name = "Sicil") int s, @WebParam(name = "Surname") String sn, @WebParam(name = "Name") String n, @WebParam(name = "Department") String d, @WebParam(name = "Password") String p, boolean x);
}
