package info.novatec.aqe.showcase.livingdoc.showcase.sbe.uitest.workflows;

import info.novatec.aqe.showcase.livingdoc.showcase.sbe.uitest.pageobjects.HomePageObject;
import info.novatec.testit.webtester.api.browser.Browser;

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


	public HomePageObject openSut(){
		browser.openDefaultEntryPoint();
		
		return browser.create(HomePageObject.class);
	}	
}
