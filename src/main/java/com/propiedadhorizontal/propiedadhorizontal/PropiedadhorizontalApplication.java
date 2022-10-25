package com.propiedadhorizontal.propiedadhorizontal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
//@RestController
public class PropiedadhorizontalApplication {

	public static void main(String[] args) {
		SpringApplication.run(PropiedadhorizontalApplication.class, args);
	}
        /*@RequestMapping(value="/hola")
        public String index(){
            return "Hola Mundo";
        }*/
}
