package info.novatec.testit.showcase.uitest.page;

import java.util.List;

import info.novatec.testit.webtester.pagefragments.GenericElement;
import info.novatec.testit.webtester.pagefragments.ListItem;
import info.novatec.testit.webtester.pagefragments.annotations.IdentifyUsing;
import info.novatec.testit.webtester.pagefragments.identification.producers.CssSelector;

public interface LatestOrderPage extends DVDStoreBasePage {
	@IdentifyUsing( "#page_latestorders")
	 ListItem listItem();
	
	@IdentifyUsing(how = CssSelector.class , value = ".dvdtableodd, .dvdtableeven")
	 List<GenericElement> orders();

	default List<GenericElement> getOrders() {
		return orders();
	}

	default boolean isVisible() {
		return "current".equals(listItem().webElement().getAttribute("class"));
	}

}
