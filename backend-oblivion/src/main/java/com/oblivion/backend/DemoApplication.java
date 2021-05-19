package com.oblivion.backend;

import java.util.TimeZone;

import javax.annotation.PostConstruct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		System.out.println("Active resources for Cultivo entity");
		System.out.println("GET");
		System.out.println("/api/oblivion/cultivo");
		System.out.println("/api/oblivion/cultivo/{id}");
		System.out.println("POST");
		System.out.println("/api/oblivion/cultivo");
		System.out.println("PUT");
		System.out.println("/api/oblivion/cultivo");
		System.out.println("DELETE");
		System.out.println("/api/oblivion/cultivo/{id}");
		System.out.println("Active resources for Finca entity");
		System.out.println("GET");
		System.out.println("/api/oblivion/finca");
		System.out.println("/api/oblivion/finca/{id}");
		System.out.println("POST");
		System.out.println("/api/oblivion/finca");
		System.out.println("PUT");
		System.out.println("/api/oblivion/finca");
		System.out.println("DELETE");
		System.out.println("/api/oblivion/finca/{id}");
		System.out.println("Active resources for FincaCultivo entity");
		System.out.println("GET");
		System.out.println("/api/oblivion/fincaCultivo");
		System.out.println("/api/oblivion/fincaCultivo/{id}");
		System.out.println("POST");
		System.out.println("/api/oblivion/fincaCultivo");
		System.out.println("PUT");
		System.out.println("/api/oblivion/fincaCultivo");
		System.out.println("DELETE");
		System.out.println("/api/oblivion/fincaCultivo/{id}");
		System.out.println("Active resources for Monitoreo entity");
		System.out.println("GET");
		System.out.println("/api/oblivion/monitoreo");
		System.out.println("/api/oblivion/monitoreo/{id}");
		System.out.println("POST");
		System.out.println("/api/oblivion/monitoreo");
		System.out.println("PUT");
		System.out.println("/api/oblivion/monitoreo");
		System.out.println("DELETE");
		System.out.println("/api/oblivion/monitoreo/{id}");
		System.out.println("Active resources for Propietario entity");
		System.out.println("GET");
		System.out.println("/api/oblivion/propietario");
		System.out.println("/api/oblivion/propietario/{id}");
		System.out.println("POST");
		System.out.println("/api/oblivion/propietario");
		System.out.println("PUT");
		System.out.println("/api/oblivion/propietario");
		System.out.println("DELETE");
		System.out.println("/api/oblivion/propietario/{id}");
		System.out.println("Active resources for Rol entity");
		System.out.println("GET");
		System.out.println("/api/oblivion/rol");
		System.out.println("/api/oblivion/rol/{id}");
		System.out.println("POST");
		System.out.println("/api/oblivion/rol");
		System.out.println("PUT");
		System.out.println("/api/oblivion/rol");
		System.out.println("DELETE");
		System.out.println("/api/oblivion/rol/{id}");
		System.out.println("Active resources for Usuario entity");
		System.out.println("GET");
		System.out.println("/api/oblivion/usuario");
		System.out.println("/api/oblivion/usuario/{id}");
		System.out.println("POST");
		System.out.println("/api/oblivion/usuario");
		System.out.println("PUT");
		System.out.println("/api/oblivion/usuario");
		System.out.println("DELETE");
		System.out.println("/api/oblivion/usuario/{id}");
	}
	
	@PostConstruct
	public void init(){
		TimeZone.setDefault(TimeZone.getTimeZone("America/Guayaquil"));
	}			

}
