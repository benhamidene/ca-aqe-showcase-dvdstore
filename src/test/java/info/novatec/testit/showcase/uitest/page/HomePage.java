package info.novatec.testit.showcase.uitest.page;

import info.novatec.testit.webtester.pagefragments.ListItem;
import info.novatec.testit.webtester.pagefragments.annotations.IdentifyUsing;

public interface HomePage extends DVDStoreBasePage {

	@IdentifyUsing("#page_home")
	ListItem listItem();

	default boolean isVisible() {
		return "current".equals(listItem().webElement().getAttribute("class"));
	}
}
