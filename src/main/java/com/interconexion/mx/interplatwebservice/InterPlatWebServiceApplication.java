package com.interconexion.mx.interplatwebservice;

import javax.xml.ws.Endpoint;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.interconexion.mx.interplatwebservice.ws.InterconexionIssue;
import com.interconexion.mx.interplatwebservice.ws.impl.InterconexionIssueImpl;

@SpringBootApplication
public class InterPlatWebServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InterPlatWebServiceApplication.class, args);
		String bindingURI = "http://localhost:9898/interconexion/service";
		InterconexionIssue serviceGetIssue = new InterconexionIssueImpl();
	    Endpoint.publish(bindingURI, serviceGetIssue);	   
	    System.out.println("Server started at: " + bindingURI);
	}

}
