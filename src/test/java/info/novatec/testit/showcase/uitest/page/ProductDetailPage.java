package info.novatec.testit.showcase.uitest.page;

import info.novatec.testit.webtester.pagefragments.Button;
import info.novatec.testit.webtester.pagefragments.Div;
import info.novatec.testit.webtester.pagefragments.annotations.IdentifyUsing;

public interface ProductDetailPage extends DVDStoreBasePage {
	@IdentifyUsing( "#AddToCartButton")
	 Button addToCartBtn();

	@IdentifyUsing( "#BackToSearchButton")
	 Button backToSearchBtn();

	@IdentifyUsing( ".productbox")
	 Div productboxDiv();

	default ProductDetailPage clickAddToCartBtn() {
		addToCartBtn().click();
		return create(ProductDetailPage.class);
	}

	default ShopPage clickBackToSearchBtn() {
		backToSearchBtn().click();
		return create(ShopPage.class);
	}

	default boolean isVisible(){
		return productboxDiv().isVisible();
	}

}
