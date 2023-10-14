package com.example.bookapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BookApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookApplication.class, args);
		System.out.println("Execution Successful");
		
	}

}


/*

Add album - 1 api (http://localhost:9001/api/v1/album) - POST (http methods)
Get album - 1 api (http://localhost:9001/api/v1/album) - GET ( http methods)
Update album - 1 api (http://localhost:9001/api/v1/album) - PUT ( http methods)
Delete album - 1 api (http://localhost:9001/api/v1/album/{albumid}) - DELETE ( httpmethods)



REST API:
    - http methods
    - uri
    - request data
    - response data
    - http status 

*/

