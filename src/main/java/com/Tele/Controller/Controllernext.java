package com.Tele.Controller;

import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Tele.TestService.TestService;

@RestController
@RequestMapping("/apinext/")
public class Controllernext {

	@Autowired
	TestService objTestService;

	@RequestMapping(value = "testApinext", method = RequestMethod.GET)

	public ResponseEntity<?> testApi(@RequestParam Map<String, String> requestParams) throws Exception {
		int Calculation = 0;
		System.out.println(requestParams);
		String status = "Success";
		try {
			Logger log = LogManager.getLogger("Controllernext");

			log.debug("testAPI started: " + requestParams);
			log.info("testAPI started: " + requestParams);

			String op = requestParams.get("op");
			int n1 = Integer.parseInt(requestParams.get("n1"));
			int n2 = Integer.parseInt(requestParams.get("n2"));
			switch (op) {
			case "add":
				Calculation = objTestService.add(n1, n2);
				break;
			case "sub":
				Calculation = objTestService.sub(n1, n2);
				break;
			case "mul":
				Calculation = objTestService.mul(n1, n2);
				break;
			case "div":
				Calculation = objTestService.div(n1, n2);
				break;
			default:
				Calculation = 0;
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
			status = "failure";
		}
		requestParams.put("status", status);
		requestParams.put("result", Calculation + "");
		return new ResponseEntity<>(requestParams, HttpStatus.OK);

	}
}
