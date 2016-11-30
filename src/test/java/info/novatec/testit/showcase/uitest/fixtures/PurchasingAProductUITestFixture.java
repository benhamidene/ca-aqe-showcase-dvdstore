package info.novatec.testit.showcase.uitest.fixtures;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import info.novatec.testit.livingdoc.LivingDoc;
import info.novatec.testit.livingdoc.reflect.AfterTable;
import info.novatec.testit.livingdoc.reflect.annotation.Alias;
import info.novatec.testit.livingdoc.reflect.annotation.FixtureClass;
import info.novatec.testit.showcase.common.BaseUITestFixture;
import info.novatec.testit.showcase.common.UITestIllegalStateException;
import info.novatec.testit.showcase.uitest.container.MovieBox;
import info.novatec.testit.showcase.uitest.page.CartPage;
import info.novatec.testit.showcase.uitest.page.HomePage;
import info.novatec.testit.showcase.uitest.page.ProductDetailPage;
import info.novatec.testit.showcase.uitest.page.ShopPage;

@FixtureClass("Purchasing a product [UI Test]")
public class PurchasingAProductUITestFixture extends BaseUITestFixture {

	private HomePage homePageObject;
	private ShopPage shopPageObject;
	private ProductDetailPage productDetailPageObject;
	private CartPage cartPage;

	@Alias("a successfully signed in user with password")
	public boolean loginUser(String username, String password)
			throws FileNotFoundException, IOException {
		LivingDoc.setStopOnFirstFailure(true);
		openTheShoppingPage();
		return loginWithUsernameAndPassword(username, password);
	}

	@Alias("the user views the details of the product No")
	public boolean openDetails(int number) {
		openTheDetailPageOfTheProductNo(2);
		return productDetailPageObject.isVisible();
	}

	@Alias("he adds the product to the shopping cart")
	public boolean addProuctToShoppingCart() {
		return addTheProductToTheShoppingCart();
	}

	@Alias("repeats the last two steps for the products and")
	public boolean repeat(int number1, int number2) {
		if (clickBackToSearch()) {
			openTheDetailPageOfTheProductNo(number1);
			if (productDetailPageObject.isVisible() && addTheProductToTheShoppingCart() && clickBackToSearch()) {
				openTheDetailPageOfTheProductNo(number2);
				return productDetailPageObject.isVisible() && addTheProductToTheShoppingCart() && clickBackToSearch();
			}
		}
		return false;
	}

	public int theNumberOfObjectsInTheShoppingCartIs() {
		
		return shopPageObject.shoppingCartBox().getShoppingCartItems().size();
	}

	@Alias(value = "When the user checks out")
	public boolean checkout() {
		cartPage = shopPageObject.shoppingCartBox().clickCheckoutBtn();
		return cartPage.isVisible();
	}

	@AfterTable
	public void closeBrowser() {
		tearDownDriver();
	}

	public boolean thatTheShoppingCartOverviewIsDisplayed() {
		return cartPage.isVisible();
	}

	public int thatTheNumberOfItemsInTheListIs() {
		return cartPage.getCountItems() - 1;
	}

	public boolean thatThePurchaseCanBeStarted() {
		return cartPage.purchaseBtn().isEnabled();
	}

	private boolean openTheShoppingPage() throws FileNotFoundException, IOException {
		openSystemUnderTest();
		homePageObject = browser.create(HomePage.class);
		shopPageObject = homePageObject.navigation().clickShopLnk();
		return true;
	}

	private ProductDetailPage openTheDetailPageOfTheProductNo(int number) {
		List<MovieBox> products = shopPageObject.products();
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
		shopPageObject.loginBox().typeUsernameTxt(username);
		shopPageObject.loginBox().typePasswordTxt(password);
		shopPageObject = shopPageObject.loginBox().clickLoginBtn(ShopPage.class);
		return true;
	}

	private boolean clickBackToSearch() {
		shopPageObject = productDetailPageObject.clickBackToSearchBtn();
		return shopPageObject.isVisible();
	}

}
