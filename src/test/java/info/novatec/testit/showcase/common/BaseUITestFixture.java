package info.novatec.testit.showcase.common;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.firefox.FirefoxProfile;

import info.novatec.testit.webtester.browser.Browser;
import info.novatec.testit.webtester.browser.proxy.FirefoxFactory;



/**
 * This is the application-independent base class for all UI Tests supporting
 * common functionalities of the tests, mainly managing the creation of the
 * WebDriver. This Class should be used as a base class for all UI test.
 * 
 * @author Johannes Schlaudraff (NovaTec GmbH)
 */
public abstract class BaseUITestFixture {

	protected Browser browser ;
	
	/**
	 * Load the System under test in the browser.
	 * 
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	protected void openSystemUnderTest() throws FileNotFoundException, IOException {
		Configuration.loadSystemProperties("default");
		if(browser == null){
			browser = createBrowser();
		}
		browser.open(Configuration.getSutUrl());
	}


	/**
	 * Tears down the attached WebDriver.
	 */
	protected void tearDownDriver() {
		browser.close();
	}
	
	private Browser createBrowser(){
		
		FirefoxProfile ffProfile = new FirefoxProfile();
		ffProfile.setPreference("browser.private.browsing.autostart",true);
		return new FirefoxFactory().createBrowser(ffProfile);
		
	}
}
