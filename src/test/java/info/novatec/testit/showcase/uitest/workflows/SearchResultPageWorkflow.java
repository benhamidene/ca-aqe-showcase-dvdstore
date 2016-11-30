package info.novatec.testit.showcase.uitest.workflows;

import info.novatec.testit.showcase.uitest.page.HomePage;
import info.novatec.testit.showcase.uitest.page.ShopPage;
import info.novatec.testit.webtester.browser.Browser;

public class SearchResultPageWorkflow {

	private BasicWorkflow basicWorkflow;
	

	public SearchResultPageWorkflow(Browser browser) {
		basicWorkflow = new BasicWorkflow(browser);
	}

	public ShopPage openShopPage() {
		HomePage homePageObject = basicWorkflow.openSut();
		
		return homePageObject.navigation().clickShopLnk();
	}
}
