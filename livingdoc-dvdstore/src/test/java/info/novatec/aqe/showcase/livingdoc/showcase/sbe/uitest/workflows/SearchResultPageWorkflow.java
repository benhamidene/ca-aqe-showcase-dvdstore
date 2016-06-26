package info.novatec.aqe.showcase.livingdoc.showcase.sbe.uitest.workflows;

import info.novatec.aqe.showcase.livingdoc.showcase.sbe.uitest.pageobjects.HomePageObject;
import info.novatec.aqe.showcase.livingdoc.showcase.sbe.uitest.pageobjects.ShopPageObject;
import info.novatec.testit.webtester.api.browser.Browser;

public class SearchResultPageWorkflow {

	private BasicWorkflow basicWorkflow;
	

	public SearchResultPageWorkflow(Browser browser) {
		basicWorkflow = new BasicWorkflow(browser);
	}

	public ShopPageObject openShopPage() {
		HomePageObject homePageObject = basicWorkflow.openSut();
		
		return homePageObject.getNavigation().clickShopLnk();
	}
}
