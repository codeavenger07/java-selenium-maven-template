package killer;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.io.TemporaryFilesystem;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Assassinate {

	protected WebDriver driver;

	public WebDriver getDriver() {
	    return driver;
	}

	@BeforeMethod(alwaysRun = true)
	@Parameters({"isHeadless"})
	public void beforeMethod() throws Exception {
//	    String customProfile = System.getProperty("customFirefoxProfile");
//	    FirefoxProfile profile = new FirefoxProfile(new File(customProfile));
	
	    FirefoxOptions fo = new FirefoxOptions();
	    System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver");
	    fo.setAcceptInsecureCerts(true);
//	    fo.setProfile(profile);
	    fo.setHeadless(true);
	    driver = new FirefoxDriver(fo);
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@AfterMethod(alwaysRun = true)
	public void tearDown() throws Exception {
	    getDriver().quit();
	    TemporaryFilesystem.getDefaultTmpFS().deleteTemporaryFiles();
	}

	@Test (groups = {"testPass", "testGroup"})
	public void testPass () {
//		String dir = System.getProperty("user.dir");
//	    getDriver().get("file://" + dir + "/src/test/resources/test.html");
//	    getDriver().findElement(By.className("class12")).click();
//	    getDriver().findElement(By.id("twelve")).click();
		Assert.assertEquals(true, true);
	}
	
	@Test (groups = {"testFail", "testGroup"})
	public void testFail () {
//		String dir = System.getProperty("user.dir");
//	    getDriver().get("file://" + dir + "/src/test/resources/test.html");
//	    getDriver().findElement(By.className("class12")).click();
//	    getDriver().findElement(By.id("twelve")).click();
		Assert.assertEquals(true, false);
	}
}