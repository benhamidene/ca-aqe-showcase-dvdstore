package info.novatec.aqe.showcase.livingdoc.showcase.sbe.uitest.container;

import info.novatec.aqe.showcase.livingdoc.selenium.fwk.container.BaseContainer;
import info.novatec.aqe.showcase.livingdoc.showcase.sbe.uitest.pageobjects.ApplicationPerformanceSettingsPageObject;
import info.novatec.aqe.showcase.livingdoc.showcase.sbe.uitest.pageobjects.CartPageObject;
import info.novatec.aqe.showcase.livingdoc.showcase.sbe.uitest.pageobjects.HomePageObject;
import info.novatec.aqe.showcase.livingdoc.showcase.sbe.uitest.pageobjects.LatestOrderPageObject;
import info.novatec.aqe.showcase.livingdoc.showcase.sbe.uitest.pageobjects.ShopPageObject;
import info.novatec.testit.webtester.api.annotations.IdentifyUsing;
import info.novatec.testit.webtester.pageobjects.Link;

public class Navigation extends BaseContainer {
	public static final String ID = "Navigation";

	@IdentifyUsing( "Home")
	private Link homeLnk;

	@IdentifyUsing( "Shop")
	private Link shopLnk;

	@IdentifyUsing( "LatestOrders")
	private Link latestOrdersLnk;

	@IdentifyUsing( "Cart")
	private Link cartLnk;

	@IdentifyUsing( "ApplicationPerformanceSettings")
	private Link applicationPerformanceSettingsLnk;

	public HomePageObject clickHomeLnk() {
		homeLnk.click();
		return create(HomePageObject.class);
	}

	public ShopPageObject clickShopLnk() {
		shopLnk.click();
		
		return create(ShopPageObject.class);
	}

	public LatestOrderPageObject clickLatestOrdersLnk() {
		latestOrdersLnk.click();
		return create(LatestOrderPageObject.class);
	}

	public CartPageObject clickCartLnk() {
		cartLnk.click();
		return create(CartPageObject.class);
	}

	public ApplicationPerformanceSettingsPageObject clickApplicationPerformanceSettingsLnk() {
		applicationPerformanceSettingsLnk.click();
		return create(ApplicationPerformanceSettingsPageObject.class);
	}

}
