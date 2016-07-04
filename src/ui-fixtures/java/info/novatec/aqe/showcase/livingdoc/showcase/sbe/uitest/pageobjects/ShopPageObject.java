package info.novatec.aqe.showcase.livingdoc.showcase.sbe.uitest.pageobjects;

import info.novatec.aqe.showcase.livingdoc.showcase.sbe.uitest.container.MovieBox;
import info.novatec.aqe.showcase.livingdoc.showcase.sbe.uitest.container.SearchBox;
import info.novatec.testit.webtester.api.annotations.IdentifyUsing;
import info.novatec.testit.webtester.api.enumerations.Method;
import info.novatec.testit.webtester.pageobjects.ListItem;

import java.util.List;

public class ShopPageObject extends DVDStoreBasePage {
	@IdentifyUsing("page_shop")
	private ListItem listItem;

	@IdentifyUsing(SearchBox.ID)
	private SearchBox searchBox;

	@IdentifyUsing(method = Method.CLASS_NAME , value = "bestinner")
	private List<MovieBox> products;
	
	@IdentifyUsing("SearchResultsForm")
	private SearchResultPageObject searchResultPageObject;
	

	public List<MovieBox> getProducts() {
		return products;
	}

	public SearchBox getSearchBox() {
		return searchBox;
	}
	
	@Override
	public boolean isVisible() {
		return "current".equals(listItem.getWebElement().getAttribute("class"));
	}
}
