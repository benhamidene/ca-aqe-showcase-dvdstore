package info.novatec.aqe.showcase.livingdoc.showcase.sbe.uitest.fixtures;

import info.novatec.aqe.showcase.livingdoc.selenium.fwk.util.UITestIllegalStateException;
import info.novatec.aqe.showcase.livingdoc.showcase.sbe.uitest.container.MovieBox;
import info.novatec.aqe.showcase.livingdoc.showcase.sbe.uitest.pageobjects.*;
import info.novatec.testit.livingdoc.reflect.AfterTable;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class BuyUITestFixture extends BaseDVDStoreFixture {

	private HomePageObject homePageObject;
	private ShopPageObject shopPageObject;
	private ProductDetailPageObject productDetailPageObject;
	private WelcomePageObject welcomePageObject;
	private CartPageObject cartPageObject;
	private ConfirmOrderPageObject confirmOrderPageObject;

	public boolean openTheShoppingPage() throws FileNotFoundException, IOException {
		openSystemUnderTest();
		homePageObject = browser.create(HomePageObject.class);
		shopPageObject = homePageObject.getNavigation().clickShopLnk();
		return true;
	}

	public ProductDetailPageObject openTheDetailPageOfTheProductNo(int number) {
		List<MovieBox> products = shopPageObject.getProducts();
		if (number > products.size()) {
			throw new UITestIllegalStateException(
					"openTheDetailPageOfTheProductNo: number > products.size()");
		}
		MovieBox movieBox = products.get(number);
		productDetailPageObject = movieBox.clickTitleLink();
		return productDetailPageObject;
	}

	public boolean addTheProductToTheShoppingCart() {
		productDetailPageObject = productDetailPageObject.clickAddToCartBtn();
		return true;
	}

	public boolean loginWithUsernameAndPassword(String username, String password) {
		shopPageObject.getLogin().typeUsernameTxt(username);
		shopPageObject.getLogin().typePasswordTxt(password);
		shopPageObject = shopPageObject.getLogin().clickLoginBtn(
				ShopPageObject.class);
		return true;
	}

	public boolean clickBackToSearch() {
		shopPageObject = productDetailPageObject.clickBackToSearchBtn();
		return true;
	}

	public boolean clickCheckout() {
		cartPageObject = shopPageObject.getShoppingCartBox().clickCheckoutBtn();
		return true;
	}

	public boolean clickPurchase() {
		confirmOrderPageObject = cartPageObject.clickPurchaseBtn();
		return true;
	}

	public boolean clickConfirm() {
		confirmOrderPageObject = confirmOrderPageObject.clickConfirmBtn();
		return true;
	}

	public boolean ifPurchaseCompleteIsShown() {
		return confirmOrderPageObject.ifPurchaseCompleteIsShown();
	}

	public boolean ifUserIsLoggedIn() {
		return welcomePageObject.getLogin().getLogoutBtn().isVisible();
	}
	
	@AfterTable
	public void closeBrowser() {
		tearDownDriver();
	}

}
