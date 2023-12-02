package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {
public static WebDriver driver;



       public static void openBrowser() {
	
        driver = new ChromeDriver();
		driver.get("https://demowebshop.tricentis.com/");
}
       public static void closeBrowser() {
   		driver.close();
       }
  
       
}



