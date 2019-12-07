package com.mt.spring.cloud.services;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class CommonService {
	
	@Autowired
	Environment environment;

	@GetMapping("/hello")
	public String sayHello() {
		String helloFromServer = "";
		try {
			helloFromServer = "Hello from : " + InetAddress.getLocalHost().getHostAddress()+":"+getPort();
			System.out.println(helloFromServer);
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return helloFromServer;
	}
	
	private String getPort() {
		String port = environment.getProperty("server.port");
		return port;
	}

}
