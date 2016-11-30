package info.novatec.testit.showcase.uitest.page;

import java.util.List;

import info.novatec.testit.showcase.uitest.container.MovieBox;
import info.novatec.testit.showcase.uitest.container.SearchBox;
import info.novatec.testit.webtester.pagefragments.ListItem;
import info.novatec.testit.webtester.pagefragments.annotations.IdentifyUsing;

public interface ShopPage extends DVDStoreBasePage {
	@IdentifyUsing("page_shop")
	 ListItem listItem();

	@IdentifyUsing(SearchBox.ID)
	 SearchBox searchBox();

	@IdentifyUsing(".bestinner")
	 List<MovieBox> products();
	
	@IdentifyUsing("SearchResultsForm")
	 SearchResultPage searchResultPageObject();
	
	default boolean isVisible() {
		return "current".equals(listItem().webElement().getAttribute("class"));
	}
}
