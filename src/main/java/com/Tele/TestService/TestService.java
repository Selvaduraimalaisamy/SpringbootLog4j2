package com.Tele.TestService;

import org.springframework.stereotype.Service;

@Service
public class TestService {
	public int add(int n1, int n2) {
		int addition = n1 + n2;
		return addition;

	}

	public int sub(int n1, int n2) {
		int subtraction = n1 - n2;
		return subtraction;
	}

	public int mul(int n1, int n2) {
		int multiplication = n1 * n2;
		return multiplication;
	}

	public int div(int n1, int n2) {
		int division = n1 / n2;
		return division;
	}
}
