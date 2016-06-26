package info.novatec.aqe.showcase.livingdoc.showcase.sbe.uitest.pageobjects;

import info.novatec.aqe.showcase.livingdoc.showcase.sbe.uitest.container.LoginBox;
import info.novatec.aqe.showcase.livingdoc.showcase.sbe.uitest.container.Navigation;
import info.novatec.aqe.showcase.livingdoc.showcase.sbe.uitest.container.ShoppingCartBox;
import info.novatec.testit.webtester.api.annotations.IdentifyUsing;
import info.novatec.testit.webtester.api.enumerations.Method;
import info.novatec.testit.webtester.pageobjects.PageObject;

public abstract class DVDStoreBasePage extends PageObject {

	@IdentifyUsing(Navigation.ID)
	private Navigation navigation;

	@IdentifyUsing(method = Method.CSS, value = "form[id='LoginForm'],form[id='LogoutForm']")
	private LoginBox login;

	@IdentifyUsing(method = Method.CSS, value = "div[id='sidebar'] > div[class='menu']:last-child")
	private ShoppingCartBox shoppingCartBox;

	public ShoppingCartBox getShoppingCartBox() {
		return shoppingCartBox;
	}

	public Navigation getNavigation() {
		return navigation;
	}

	public LoginBox getLogin() {
		return login;
	}

}
