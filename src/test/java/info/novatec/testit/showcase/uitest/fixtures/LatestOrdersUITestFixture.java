package info.novatec.testit.showcase.uitest.fixtures;

import java.io.FileNotFoundException;
import java.io.IOException;

import info.novatec.testit.livingdoc.reflect.AfterTable;
import info.novatec.testit.showcase.common.BaseUITestFixture;
import info.novatec.testit.showcase.uitest.page.HomePage;
import info.novatec.testit.showcase.uitest.page.LatestOrderPage;
import info.novatec.testit.showcase.uitest.page.ShopPage;

public class LatestOrdersUITestFixture extends BaseUITestFixture {

	private HomePage homePageObject;
	private ShopPage shopPageObject;
	private LatestOrderPage latestOrderPageObject;

	public boolean openTheShoppingPage() throws FileNotFoundException, IOException {
		openSystemUnderTest();
		homePageObject = browser.create(HomePage.class);
		shopPageObject = homePageObject.navigation().clickShopLnk();
		return true;
	}

	public boolean loginWithUsernameAndPassword(String username, String password) {
		shopPageObject.loginBox().typeUsernameTxt(username);
		shopPageObject.loginBox().typePasswordTxt(password);
		shopPageObject = shopPageObject.loginBox().clickLoginBtn(
				ShopPage.class);
		return true;
	}

	public boolean openTheLatestOrdersPage() {
		latestOrderPageObject = shopPageObject.navigation()
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
