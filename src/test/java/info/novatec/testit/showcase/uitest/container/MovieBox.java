package info.novatec.testit.showcase.uitest.container;

import info.novatec.testit.showcase.uitest.page.ProductDetailPage;
import info.novatec.testit.webtester.pagefragments.Link;
import info.novatec.testit.webtester.pagefragments.PageFragment;
import info.novatec.testit.webtester.pagefragments.annotations.IdentifyUsing;
import info.novatec.testit.webtester.pagefragments.identification.producers.XPath;

public interface MovieBox extends PageFragment {
	public static final String ID = "LoginForm";
	
	@IdentifyUsing(how = XPath.class, value = ".//a[contains(@id, 'TitleLink')]")
	Link titleLnk();

	default ProductDetailPage clickTitleLink() { // TODO add return value
		titleLnk().click();
		return create(ProductDetailPage.class);
	}

	default String getTitle() {
		return titleLnk().getVisibleText();
	}
}
