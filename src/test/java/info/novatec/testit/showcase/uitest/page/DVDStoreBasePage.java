package info.novatec.testit.showcase.uitest.page;

import info.novatec.testit.showcase.uitest.container.LoginBox;
import info.novatec.testit.showcase.uitest.container.Navigation;
import info.novatec.testit.showcase.uitest.container.ShoppingCartBox;
import info.novatec.testit.webtester.pagefragments.annotations.IdentifyUsing;
import info.novatec.testit.webtester.pagefragments.identification.producers.CssSelector;
import info.novatec.testit.webtester.pages.Page;

public interface DVDStoreBasePage extends Page {

	@IdentifyUsing("#nav")
	Navigation navigation();

	@IdentifyUsing("#LoginForm")
	LoginBox loginBox();

	@IdentifyUsing(how = CssSelector.class, value = "div[id='sidebar'] > div[class='menu']:last-child")
	 ShoppingCartBox shoppingCartBox();

}
