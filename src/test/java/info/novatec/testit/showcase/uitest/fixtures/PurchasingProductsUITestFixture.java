package info.novatec.testit.showcase.uitest.fixtures;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import info.novatec.testit.livingdoc.reflect.AfterTable;
import info.novatec.testit.livingdoc.reflect.annotation.Alias;
import info.novatec.testit.livingdoc.reflect.annotation.FixtureClass;
import info.novatec.testit.showcase.common.BaseUITestFixture;
import info.novatec.testit.showcase.common.UITestIllegalStateException;
import info.novatec.testit.showcase.uitest.container.MovieBox;
import info.novatec.testit.showcase.uitest.page.CartPage;
import info.novatec.testit.showcase.uitest.page.ConfirmOrderPage;
import info.novatec.testit.showcase.uitest.page.HomePage;
import info.novatec.testit.showcase.uitest.page.ProductDetailPage;
import info.novatec.testit.showcase.uitest.page.ShopPage;
import info.novatec.testit.showcase.uitest.page.WelcomePage;

@FixtureClass("Purchasing a product [UI Test]")
public class PurchasingProductsUITestFixture extends BaseUITestFixture {

	private HomePage homePageObject;
	private ShopPage shopPageObject;
	private ProductDetailPage productDetailPageObject;
	private WelcomePage welcomePageObject;
	private CartPage cartPage;
	private ConfirmOrderPage confirmOrderPage;

	@Alias("the online DVD store")
	public boolean openTheShoppingPage() throws FileNotFoundException, IOException {
		openSystemUnderTest();
		homePageObject = browser.create(HomePage.class);
		shopPageObject = homePageObject.navigation().clickShopLnk();
		return true;
	}

	@Alias("the user opens the  detail page of the product no")
	public boolean openTheDetailPageOfTheProductNo(int number) {
		List<MovieBox> products = shopPageObject.products();
		if (number > products.size()) {
			throw new UITestIllegalStateException(
					"openTheDetailPageOfTheProductNo: number > products.size()");
		}
		MovieBox movieBox = products.get(number);
		productDetailPageObject = movieBox.clickTitleLink();
		return productDetailPageObject != null;
	}

	@Alias("he adds the product to the shopping cart")
	public boolean addProductToShoppingCart() {
		productDetailPageObject = productDetailPageObject.clickAddToCartBtn();
		return true;
	}

	@Alias("login with username")
	public boolean login(String username) {
		shopPageObject.loginBox().typeUsernameTxt(username);
		shopPageObject.loginBox().typePasswordTxt("password");
		shopPageObject = shopPageObject.loginBox().clickLoginBtn(
				ShopPage.class);
		return true;
	}

	@Alias("he goes back to search")
	public boolean backToSearch() {
		shopPageObject = productDetailPageObject.clickBackToSearchBtn();
		return true;
	}

	@Alias("checks out the cart")
	public boolean clickCheckout() {
		cartPage = shopPageObject.shoppingCartBox().clickCheckoutBtn();
		return true;
	}

	@Alias("he purchases the product")
	public boolean clickPurchase() {
		confirmOrderPage = cartPage.clickPurchaseBtn();
		return true;
	}

	@Alias("the confirmation is displayed")
	public boolean clickConfirm() {
		//confirmOrderPage = confirmOrderPage.clickConfirmBtn();
		return true;
	}

	public boolean ifPurchaseCompleteIsShown() {
		return confirmOrderPage.ifPurchaseCompleteIsShown();
	}

	public boolean ifUserIsLoggedIn() {
		return welcomePageObject.loginBox().logoutBtn().isVisible();
	}
	
	@AfterTable
	public void closeBrowser() {
		tearDownDriver();
	}

}
