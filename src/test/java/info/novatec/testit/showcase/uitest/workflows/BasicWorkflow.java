package info.novatec.testit.showcase.uitest.workflows;

import info.novatec.testit.showcase.uitest.page.HomePage;
import info.novatec.testit.webtester.browser.Browser;

/**
 * This Workflow defines the basic steps needed by the most of other workflows.
 * @author novatec
 *
 */
public class BasicWorkflow {

	
	private Browser browser ;
	
	public BasicWorkflow(Browser browser) {
		this.browser = browser;
	}


	public HomePage openSut(){
		browser.open();
		
		return browser.create(HomePage.class);
	}	
}
