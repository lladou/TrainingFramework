package com.Altimetrik.Framework.TrainingTestSuite;

import org.testng.annotations.Test;

import com.Altimetrik.Framework.PageHelpers.ForceApiUtils;
import com.Altimetrik.Framework.core.ParentTestCase;

public class TrainingTests extends ParentTestCase {
	
	@Test
	public void openDriverTest() throws InterruptedException {
		String AccountId= ForceApiUtils.createAccount("222222");
		Thread.sleep(10000);
		ForceApiUtils.deleteRecord("Account", AccountId);
	}

}
