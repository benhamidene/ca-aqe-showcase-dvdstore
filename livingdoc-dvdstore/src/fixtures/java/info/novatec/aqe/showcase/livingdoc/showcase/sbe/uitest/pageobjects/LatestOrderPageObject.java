package info.novatec.aqe.showcase.livingdoc.showcase.sbe.uitest.pageobjects;

import info.novatec.testit.webtester.api.annotations.IdentifyUsing;
import info.novatec.testit.webtester.api.enumerations.Method;
import info.novatec.testit.webtester.pageobjects.ListItem;
import info.novatec.testit.webtester.pageobjects.PageObject;

import java.util.List;

public class LatestOrderPageObject extends DVDStoreBasePage {
	@IdentifyUsing( "page_latestorders")
	private ListItem listItem;
	
	@IdentifyUsing(method = Method.CSS , value = ".dvdtableodd, .dvdtableeven")
	private List<PageObject> orders;

	public List<PageObject> getOrders() {
		return orders;
	}

	@Override
	public boolean isVisible() {
		return "current".equals(listItem.getWebElement().getAttribute("class"));
	}

}
