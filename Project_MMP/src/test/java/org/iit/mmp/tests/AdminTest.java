package org.iit.mmp.tests;

import org.iit.mmp.pages.AddPrescriptionPage;
import org.iit.mmp.pages.AdminPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class AdminTest {
	WebDriver driver;
	AddPrescriptionPage app = new AddPrescriptionPage(driver);

	@Test(description = "US_002 Validating the Admin Login Page")
	public void adminLogin() throws InterruptedException {

		// calling admin login page and its methods
		AdminPage ap = new AdminPage(driver);
		ap.adminUrl();
		ap.navigatetoDoctorLoginButton();
		ap.adminLogin("Thomas_444", "Edison_444");
		// ap.approvePatient("qwee");
		ap.navigateToPatientsTab();
		ap.addPresciptionDetails();
		/*
		 * AddPrescriptionPage app = new AddPrescriptionPage(driver); app.adminUrl();
		 * app.navigatetoDoctorLoginButton(); app.adminLogin("Thomas_444",
		 * "Edison_444"); app.navigateToPatientsTab(); Thread.sleep(4000);
		 * app.addPresciptionDetails();
		 */

	}

}
