package info.novatec.testit.showcase.uitest.fixtures;

import java.io.FileNotFoundException;
import java.io.IOException;

import info.novatec.testit.livingdoc.reflect.AfterTable;
import info.novatec.testit.livingdoc.reflect.annotation.Alias;
import info.novatec.testit.livingdoc.reflect.annotation.FixtureClass;
import info.novatec.testit.showcase.common.BaseUITestFixture;
import info.novatec.testit.showcase.uitest.page.HomePage;
import info.novatec.testit.showcase.uitest.page.LatestOrderPage;
import info.novatec.testit.showcase.uitest.page.ShopPage;

@FixtureClass("Latest orders [ UI-Test ]")
public class LatestOrdersUITestFixture extends BaseUITestFixture {

	private HomePage homePageObject;
	private ShopPage shopPageObject;
	private LatestOrderPage latestOrderPageObject;

	@Alias("the online shop")
	public boolean openTheShoppingPage() throws FileNotFoundException, IOException {
		openSystemUnderTest();
		homePageObject = browser.create(HomePage.class);
		shopPageObject = homePageObject.navigation().clickShopLnk();
		return true;
	}

	@Alias("the user logs in with username and password")
	public boolean loginWithUsernameAndPassword(String username, String password) {
		shopPageObject.loginBox().typeUsernameTxt(username);
		shopPageObject.loginBox().typePasswordTxt(password);
		shopPageObject = shopPageObject.loginBox().clickLoginBtn(
				ShopPage.class);
		return true;
	}

	@Alias("he opens the \"Latest Orders\" page")
	public boolean openTheLatestOrdersPage() {
		latestOrderPageObject = shopPageObject.navigation()
				.clickLatestOrdersLnk();
		return true;
	}

	@Alias("the number of orders is")
	public int getNumberOfOrders() {
		return latestOrderPageObject.getOrders().size();
	}
	@AfterTable
	public void closeBrowser() {
		tearDownDriver();
	}

}
