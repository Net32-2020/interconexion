package com.interconexion.mx.interplatwebservice.ws.impl;


import javax.jws.WebMethod;
import javax.jws.WebService;

import org.apache.tomcat.util.codec.binary.Base64;

import com.interconexion.mx.interplatwebservice.azure.AzureCrud;
import com.interconexion.mx.interplatwebservice.ws.InterconexionIssue;

@WebService
public class InterconexionIssueImpl implements InterconexionIssue {

    Base64 base64 = new Base64();
	String PAT = "lvbmavqfkprqgnih3cy5glrb5htq35xjuw3qy3xohm5gsli65jcq";
	String AuthStr = ":" + PAT;	 
	String encodedPAT = new String(base64.encode(AuthStr.getBytes()));
	
	@Override
	@WebMethod
	public String getIssue(String idIssue) {
		
		AzureCrud ac = new AzureCrud();
		StringBuilder response = ac.consultaWorkItem(ac.url("/_apis/wit/workitemsbatch?api-version=6.0"), encodedPAT, ac.jsonQueryWorkItem("16"));
		return response.toString();
	}
	

	@Override
	@WebMethod
	public String getUpdateIssue(String idIssue) {
		// TODO Auto-generated method stub
		return "ok getUpdate";
	}

	
	
}
