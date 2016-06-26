package info.novatec.aqe.showcase.livingdoc.showcase.sbe.uitest.fixtures;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import info.novatec.aqe.showcase.livingdoc.selenium.fwk.util.UITestIllegalStateException;
import info.novatec.aqe.showcase.livingdoc.showcase.sbe.uitest.container.MovieBox;
import info.novatec.aqe.showcase.livingdoc.showcase.sbe.uitest.pageobjects.CartPageObject;
import info.novatec.aqe.showcase.livingdoc.showcase.sbe.uitest.pageobjects.HomePageObject;
import info.novatec.aqe.showcase.livingdoc.showcase.sbe.uitest.pageobjects.ProductDetailPageObject;
import info.novatec.aqe.showcase.livingdoc.showcase.sbe.uitest.pageobjects.ShopPageObject;
import info.novatec.testit.livingdoc.LivingDoc;
import info.novatec.testit.livingdoc.reflect.AfterTable;
import info.novatec.testit.livingdoc.reflect.annotation.Alias;
import info.novatec.testit.webtester.utils.Invalidator;

public class PurchasingAProductUITestFixture extends BaseDVDStoreFixture {

	private HomePageObject homePageObject;
	private ShopPageObject shopPageObject;
	private ProductDetailPageObject productDetailPageObject;
	private CartPageObject cartPageObject;

	public boolean givenASuccessfullySignedInUserWithPassword(String username, String password)
			throws FileNotFoundException, IOException {
		LivingDoc.setStopOnFirstFailure(true);
		openTheShoppingPage();
		return loginWithUsernameAndPassword(username, password);
	}

	public boolean whenTheUserViewsTheDetailsOfTheProductNo(int number) {
		openTheDetailPageOfTheProductNo(2);
		return productDetailPageObject.isVisible();
	}

	public boolean andHeAddsTheProductToTheShoppingCart() {
		return addTheProductToTheShoppingCart();
	}

	public boolean andRepeatsTheLastTwoStepsForTheProductsAnd(int number1, int number2) {
		if (clickBackToSearch()) {
			openTheDetailPageOfTheProductNo(number1);
			if (productDetailPageObject.isVisible() && addTheProductToTheShoppingCart() && clickBackToSearch()) {
				openTheDetailPageOfTheProductNo(number2);
				return productDetailPageObject.isVisible() && addTheProductToTheShoppingCart() && clickBackToSearch();
			}
		}
		return false;
	}

	public int thatTheNumberOfObjectsInTheShoppingCartIs() {
		if (!shopPageObject.getShoppingCartBox().isVisible()) {
			Invalidator.invalidate(shopPageObject);
		}
		return shopPageObject.getShoppingCartBox().getShoppingCartItems().size();
	}

	@Alias(value = "When the user checks out")
	public boolean checkout() {
		cartPageObject = shopPageObject.getShoppingCartBox().clickCheckoutBtn();
		return cartPageObject.isVisible();
	}

	@AfterTable
	public void closeBrowser() {
		tearDownDriver();
	}

	public boolean thatTheShoppingCartOverviewIsDisplayed() {
		return cartPageObject.isVisible();
	}

	public int thatTheNumberOfItemsInTheListIs() {
		return cartPageObject.getCountItems() - 1;
	}

	public boolean thatThePurchaseCanBeStarted() {
		return cartPageObject.getPurchaseBtn().isEnabled();
	}

	private boolean openTheShoppingPage() throws FileNotFoundException, IOException {
		openSystemUnderTest();
		homePageObject = browser.create(HomePageObject.class);
		shopPageObject = homePageObject.getNavigation().clickShopLnk();
		return true;
	}

	private ProductDetailPageObject openTheDetailPageOfTheProductNo(int number) {
		List<MovieBox> products = shopPageObject.getProducts();
		if (number > products.size()) {
			throw new UITestIllegalStateException("openTheDetailPageOfTheProductNo: number > products.size()");
		}
		MovieBox movieBox = products.get(number);
		productDetailPageObject = movieBox.clickTitleLink();
		return productDetailPageObject;
	}

	private boolean addTheProductToTheShoppingCart() {
		productDetailPageObject = productDetailPageObject.clickAddToCartBtn();
		return productDetailPageObject.isVisible();
	}

	private boolean loginWithUsernameAndPassword(String username, String password) {
		shopPageObject.getLogin().typeUsernameTxt(username);
		shopPageObject.getLogin().typePasswordTxt(password);
		shopPageObject = shopPageObject.getLogin().clickLoginBtn(ShopPageObject.class);
		return true;
	}

	private boolean clickBackToSearch() {
		shopPageObject = productDetailPageObject.clickBackToSearchBtn();
		return shopPageObject.isVisible();
	}

}
