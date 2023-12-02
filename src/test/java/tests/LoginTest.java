package tests;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.BaseTest;
import pages.LoginPage;
import utilities.ExcelUtility;
import utilities.MyListener;

@Listeners(value=MyListener.class)
public class LoginTest extends BaseTest {
	LoginPage loginPage;

	//@Test
	public void test_Login_Page() {
		
		loginPage=new LoginPage(driver);
		String email="Itest@test.com";
		String password="Itest@test";
		loginPage.enter_Login_Details(email, password);
		
		
	}
	
	@Test(dataProvider = "testdata")
	public void test_Login_Page(String Username,String Password , String Status) throws InterruptedException {
		
		loginPage=new LoginPage(driver);

		Thread.sleep(3000);
		loginPage.enter_Login_Details(Username, Password);
		
		Thread.sleep(10000);
		if(Status.equals("pass")) {
			loginPage.logout_button.click();
			Assert.assertTrue(true);
			}
		else {
			Assert.fail("fail");
		}
		
	}

		
	@DataProvider(name = "testdata")
	public Object[][] datasupplier() throws EncryptedDocumentException, IOException {

		Object input[][] = ExcelUtility.getTestData("Sheet1");
		return input;

	}
	
	
	
	@BeforeTest
	public void open_browser() {
		openBrowser();
	}	
	@AfterTest
	public void close_browser() {
		closeBrowser();
	}
}

	
	


