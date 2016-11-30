package info.novatec.testit.showcase.uitest.container;

import info.novatec.testit.showcase.uitest.page.CartPage;
import info.novatec.testit.showcase.uitest.page.HomePage;
import info.novatec.testit.showcase.uitest.page.LatestOrderPage;
import info.novatec.testit.showcase.uitest.page.ShopPage;
import info.novatec.testit.webtester.pagefragments.Link;
import info.novatec.testit.webtester.pagefragments.PageFragment;
import info.novatec.testit.webtester.pagefragments.annotations.IdentifyUsing;

public interface Navigation extends PageFragment {
	static final String ID = "nav";

	@IdentifyUsing( "#Home")
	 Link homeLnk();

	@IdentifyUsing( "#Shop")
	 Link shopLnk();

	@IdentifyUsing( "#LatestOrders")
	 Link latestOrdersLnk();

	@IdentifyUsing( "#Cart")
	 Link cartLnk();


	default HomePage clickHomeLnk() {
		homeLnk().click();
		return create(HomePage.class);
	}

	default ShopPage clickShopLnk() {
		shopLnk().click();
		
		return create(ShopPage.class);
	}

	default LatestOrderPage clickLatestOrdersLnk() {
		latestOrdersLnk().click();
		return create(LatestOrderPage.class);
	}

	default CartPage clickCartLnk() {
		cartLnk().click();
		return create(CartPage.class);
	}



}
