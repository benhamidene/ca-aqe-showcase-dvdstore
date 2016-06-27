package info.novatec.aqe.showcase.livingdoc.showcase.sbe.uitest.pageobjects;


import info.novatec.testit.webtester.api.annotations.IdentifyUsing;
import info.novatec.testit.webtester.api.annotations.Visible;
import info.novatec.testit.webtester.api.enumerations.Method;
import info.novatec.testit.webtester.pageobjects.Button;
import info.novatec.testit.webtester.pageobjects.PageObject;


public class ProductDetailPageObject extends DVDStoreBasePage {
	@IdentifyUsing( "AddToCartButton")
	@Visible
	private Button addToCartBtn;

	@IdentifyUsing( "BackToSearchButton")
	@Visible
	private Button backToSearchBtn;

	@IdentifyUsing(method = Method.CLASS_NAME , value = "productbox")
	private PageObject productboxDiv;

	public ProductDetailPageObject clickAddToCartBtn() {
		addToCartBtn.click();
		return create(ProductDetailPageObject.class);
	}

	public ShopPageObject clickBackToSearchBtn() {
		backToSearchBtn.click();
		return create(ShopPageObject.class);
	}

}
