package com.promptoven.profileservice.temp;

import org.junit.jupiter.api.Test;

public class NpeExperiment {

	@Test
	public void testNpe() {
		PrivateClass privateClass = null;

		System.out.println("Start Test <null var> compare to null cause NPE");
		try {
			if (privateClass == null) {
				System.out.println("Success");
			}
			System.out.println("Start test null compare to null class's method call cause NPE");
			if (null == privateClass.getvalue()) {
				System.out.println("Success");
			}

		} catch (NullPointerException e) {
			System.out.println("Caught NPE");
		}

	}
}

class PrivateClass {

	private Integer privateField;

	protected Integer getvalue() {
		return privateField;
	}

	protected String print() {
		return privateField.toString();
	}

}