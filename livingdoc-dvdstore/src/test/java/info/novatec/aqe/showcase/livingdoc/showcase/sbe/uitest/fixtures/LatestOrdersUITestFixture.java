package info.novatec.aqe.showcase.livingdoc.showcase.sbe.uitest.fixtures;

import info.novatec.aqe.showcase.livingdoc.showcase.sbe.uitest.pageobjects.HomePageObject;
import info.novatec.aqe.showcase.livingdoc.showcase.sbe.uitest.pageobjects.LatestOrderPageObject;
import info.novatec.aqe.showcase.livingdoc.showcase.sbe.uitest.pageobjects.ShopPageObject;
import info.novatec.testit.livingdoc.reflect.AfterTable;

import java.io.FileNotFoundException;
import java.io.IOException;

public class LatestOrdersUITestFixture extends BaseDVDStoreFixture {

	private HomePageObject homePageObject;
	private ShopPageObject shopPageObject;
	private LatestOrderPageObject latestOrderPageObject;

	public boolean openTheShoppingPage() throws FileNotFoundException, IOException {
		openSystemUnderTest();
		homePageObject = browser.create(HomePageObject.class);
		shopPageObject = homePageObject.getNavigation().clickShopLnk();
		return true;
	}

	public boolean loginWithUsernameAndPassword(String username, String password) {
		shopPageObject.getLogin().typeUsernameTxt(username);
		shopPageObject.getLogin().typePasswordTxt(password);
		shopPageObject = shopPageObject.getLogin().clickLoginBtn(
				ShopPageObject.class);
		return true;
	}

	public boolean openTheLatestOrdersPage() {
		latestOrderPageObject = shopPageObject.getNavigation()
				.clickLatestOrdersLnk();
		return true;
	}

	public int numberOfOrders() {
		return latestOrderPageObject.getOrders().size();
	}
	@AfterTable
	public void closeBrowser() {
		tearDownDriver();
	}

}
