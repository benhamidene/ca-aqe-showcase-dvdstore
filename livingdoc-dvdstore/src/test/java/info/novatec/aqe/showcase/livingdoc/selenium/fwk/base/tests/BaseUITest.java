package info.novatec.aqe.showcase.livingdoc.selenium.fwk.base.tests;

import info.novatec.aqe.showcase.livingdoc.selenium.fwk.util.Configuration;
import info.novatec.testit.webtester.api.browser.Browser;
import info.novatec.testit.webtester.browser.factories.FirefoxFactory;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.After;
import org.junit.BeforeClass;
import org.openqa.selenium.firefox.FirefoxProfile;



/**
 * This is the application-independent base class for all UI Tests supporting
 * common functionalities of the tests, mainly managing the creation of the
 * WebDriver. This Class should be used as a base class for all UI test.
 * 
 * @author Johannes Schlaudraff (NovaTec GmbH)
 */
public class BaseUITest {

	protected Browser browser = createBrowser();
	
	
	
	@BeforeClass
	public void setup() throws FileNotFoundException, IOException {
		openSystemUnderTest();
	}

	/**
	 * Load the System under test in the browser.
	 * 
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	public void openSystemUnderTest() throws FileNotFoundException, IOException {
		Configuration.loadSystemProperties("default");
		browser.open(Configuration.getSutUrl());
	}


	/**
	 * Tears down the attached WebDriver.
	 */
	@After
	protected void tearDownDriver() {
		browser.close();
	}
	
	private Browser createBrowser(){
		
		FirefoxProfile ffProfile = new FirefoxProfile();
		ffProfile.setPreference("browser.private.browsing.autostart",true);
		return new FirefoxFactory().createBrowser(ffProfile);
		
	}
}
