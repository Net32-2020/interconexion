package com.interconexion.mx.interplatwebservice.ws;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface InterconexionIssue {
	  @WebMethod
	  public String getIssue(String idIssue); 
	  @WebMethod
	  public String getUpdateIssue(String idIssue); 

}
