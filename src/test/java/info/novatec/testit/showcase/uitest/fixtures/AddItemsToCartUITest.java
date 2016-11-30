package info.novatec.testit.showcase.uitest.fixtures;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import info.novatec.testit.livingdoc.LivingDoc;
import info.novatec.testit.livingdoc.reflect.AfterTable;
import info.novatec.testit.livingdoc.reflect.BeforeTable;
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

@FixtureClass("Add items to shopping cart (UI-Test)")
public class AddItemsToCartUITest extends BaseUITestFixture {

	private HomePage homePageObject;
	private ShopPage shopPageObject;
	private ProductDetailPage productDetailPageObject;
	private CartPage cartPage;
	private ConfirmOrderPage confirmOrderPage;

	
	@BeforeTable
	public void openStore(){
		LivingDoc.setStopOnFirstFailure(true);
		try {
			openSystemUnderTest();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public boolean theOnlineDvdStore() throws FileNotFoundException, IOException {
		homePageObject = browser.create(HomePage.class);
		shopPageObject = homePageObject.navigation().clickShopLnk();
		return true;
	}
	
	@Alias("the user opens the detail page of the product no")
	public boolean openDetailPageOfProductNo(int number) {
		List<MovieBox> products = shopPageObject.products();
		if (number > products.size()) {
			throw new UITestIllegalStateException(
					"openTheDetailPageOfTheProductNo: number > products.size()");
		}
		MovieBox movieBox = products.get(number);
		productDetailPageObject = movieBox.clickTitleLink();
		return productDetailPageObject.isVisible();
	}

	public boolean heAddsTheProductToTheShoppingCart() {
		productDetailPageObject = productDetailPageObject.clickAddToCartBtn();
		return true;
	}

	public boolean loginWithUsernameAndPassword(String username, String password) {
		shopPageObject.loginBox().typeUsernameTxt(username);
		shopPageObject.loginBox().typePasswordTxt(password);
		shopPageObject = shopPageObject.loginBox().clickLoginBtn(
				ShopPage.class);
		return true;
	}

	@Alias("he goes back to search")
	public boolean clickBackToSearch() {
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
		confirmOrderPage = confirmOrderPage.clickConfirmBtn();

		return true;
	}

	@Alias("the confirmation is displayed")
	public boolean ifPurchaseCompleteIsShown() {
		return confirmOrderPage.ifPurchaseCompleteIsShown();
	}

	
	@AfterTable
	public void closeBrowser() {
		tearDownDriver();
	}

}
