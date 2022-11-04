package com.Tele.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Tele.TestService.TestService;


@SpringBootApplication(scanBasePackages = ("com.Tele"))
@RestController
@RequestMapping("/api/")
public class Controller {
	@Autowired
	TestService objTestService;
	String Calculation;

	@RequestMapping(value = "testApi", method = RequestMethod.GET)
	public ResponseEntity<?> testApi(@RequestParam String op, @RequestParam int n1, @RequestParam int n2)
			throws Exception {

		switch (op) {
		case "add":
			Calculation = "ADDITION = " + objTestService.add(n1, n2);
			break;
		case "sub":
			Calculation = "SUBTRACTION = " + objTestService.sub(n1, n2);
			break;
		case "mul":
			Calculation = "MULTIPLICATION = " + objTestService.mul(n1, n2);
			break;
		case "div":
			Calculation = "DIVISION = " + objTestService.div(n1, n2);
			break;
		}
		return new ResponseEntity<>(Calculation, HttpStatus.OK);

	}
	
}
