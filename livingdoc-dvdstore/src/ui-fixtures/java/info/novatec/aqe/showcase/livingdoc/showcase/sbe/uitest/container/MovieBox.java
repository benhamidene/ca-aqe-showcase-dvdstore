package info.novatec.aqe.showcase.livingdoc.showcase.sbe.uitest.container;

import info.novatec.aqe.showcase.livingdoc.selenium.fwk.container.BaseContainer;
import info.novatec.aqe.showcase.livingdoc.showcase.sbe.uitest.pageobjects.ProductDetailPageObject;
import info.novatec.testit.webtester.api.annotations.IdentifyUsing;
import info.novatec.testit.webtester.api.enumerations.Method;
import info.novatec.testit.webtester.pageobjects.Link;

public class MovieBox extends BaseContainer {
	public static final String ID = "LoginForm";
	
	@IdentifyUsing(method = Method.XPATH, value = ".//a[contains(@id, 'TitleLink')]")
	private Link titleLnk;

	public ProductDetailPageObject clickTitleLink() { // TODO add return value
		titleLnk.click();
		return create(ProductDetailPageObject.class);
	}

	public String getTitle() {
		return titleLnk.getVisibleText();
	}
}
