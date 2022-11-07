package com.Tele.Controller;

import java.io.FileInputStream;
import java.util.Map;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Tele.TestService.TestService;

@RestController
@RequestMapping("/api/")
public class Controller {
	@Autowired
	TestService objTestService;

	@RequestMapping(value = "testApi", method = RequestMethod.GET)

	public ResponseEntity<?> testApi(@RequestParam Map<String, String> requestParams) throws Exception {
		int Calculation = 0;
		System.out.println(requestParams);
		String status = "Success";
		try {
			Logger log = LogManager.getLogger("Arith");

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
	@Value("${FilePath}")
	private String fileurl;
	@RequestMapping(value = "loadProperty", method = RequestMethod.GET)

	public ResponseEntity<?> loadProperty(@RequestParam Map<String, String> requestParams) throws Exception {
		System.out.println(requestParams);
		System.out.println(fileurl);
//		String status = "Success";
		 Properties prob=new Properties();
		try {
			  FileInputStream file=new FileInputStream(fileurl);
			  prob.load(file);
			
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("Exception occured");
		}
//		requestParams.put("status", status);
//		requestParams.put("result", Calculation + "");
	return new ResponseEntity<>(prob, HttpStatus.OK);

	}
}



