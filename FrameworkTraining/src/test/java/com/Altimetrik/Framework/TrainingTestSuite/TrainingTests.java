package com.Altimetrik.Framework.TrainingTestSuite;

import org.testng.annotations.Test;

import com.Altimetrik.Framework.core.ParentTestCase;

public class TrainingTests extends ParentTestCase {
	
	@Test
	public void openDriverTest() throws InterruptedException {
		classSalesforceLoginPage.openSalesforce();
	}

}
