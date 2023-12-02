package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage {
	@FindBy(xpath="//a[text()='Log in']")
	public static WebElement login_Link;
	
	@FindBy(xpath="//input[@id='Email']")
	public static WebElement email_Field;
	
	@FindBy(xpath="//input[@id='Password']")
	public static WebElement password_Field;
	
	@FindBy(xpath="//input[@value='Log in']")
	public static WebElement login_button;
	
	@FindBy(xpath="//a[text()='Log out']")
	public WebElement logout_button;
	
	
	public void enter_Login_Details(String email,String password ) {
		
		login_Link.click();
		email_Field.sendKeys(email);
		password_Field.sendKeys(password);
		login_button.click();
	}
	
	
	public LoginPage(WebDriver driver) {

		PageFactory.initElements(driver, this);
		// driver can now work with your elements and methods of this class
	}
	
}


