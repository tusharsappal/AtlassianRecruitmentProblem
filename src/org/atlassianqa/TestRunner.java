package org.atlassianqa;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunner {
	// TestRunner is the main Driver Class and has code to call the ConfluencePageWorkFlow Test Script
	// Since we had the single test script checking the both the creation and the restriction workflow
	// We didn't created the Test Suite ...

	public static void main(String[] args) {

		Result result = JUnitCore.runClasses(TestConfluencePageWorkflows.class);
		for (Failure failure : result.getFailures()) {
			System.out.println(failure.toString());
		}
		System.out.println(result.wasSuccessful());		
	}

}