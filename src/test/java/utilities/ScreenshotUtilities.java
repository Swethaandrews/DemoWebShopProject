package utilities;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import pages.BaseTest;

public class ScreenshotUtilities extends BaseTest {
public static String takeScreenshot() throws IOException {
		
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		String path="C:\\Users\\Swetha Andrews\\eclipse-workspace\\POMFRAMEWORK\\target\\screenshots_"+System.currentTimeMillis()+".png";
		File target=new File(path);
		FileUtils.copyFile(source, target);
		String targetPath=target.getAbsolutePath();
		
		return targetPath;
		
		
		
	}
}



