package info.novatec.aqe.showcase.livingdoc.showcase.sbe.uitest.pageobjects;

import info.novatec.testit.webtester.api.annotations.IdentifyUsing;
import info.novatec.testit.webtester.pageobjects.ListItem;

public class HomePageObject extends DVDStoreBasePage {

	@IdentifyUsing("page_home")
	private ListItem listItem;

	@Override
	public boolean isVisible() {
		return "current".equals(listItem.getWebElement().getAttribute("class"));
	}
}
