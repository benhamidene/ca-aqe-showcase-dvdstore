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
import info.novatec.testit.showcase.uitest.page.HomePage;
import info.novatec.testit.showcase.uitest.page.ProductDetailPage;
import info.novatec.testit.showcase.uitest.page.ShopPage;

@FixtureClass("Add products to shopping cart [UI-Test]")
public class AddingItemsUITestFixture extends BaseUITestFixture {

	private HomePage homePageObject;
	private ShopPage shopPageObject;
	private ProductDetailPage productDetailPageObject;
	private CartPage cartPage;

	@BeforeTable
	public void setup(){
		LivingDoc.setStopOnFirstFailure(true);

	}

	@Alias("a successfully signed in user with password")
	public boolean loginUser(String username, String password)
			throws FileNotFoundException, IOException {
		openTheShoppingPage();
		return loginWithUsernameAndPassword(username, password);
	}

	public boolean openDetails(int number) {
		openTheDetailPageOfTheProductNo(number);
		return productDetailPageObject.isVisible();
	}


	@Alias("repeats the last two steps for the products")
	public boolean repeat(int... numbers) {
		for(int i : numbers) {
			productDetailPageObject.clickBackToSearchBtn();
			openTheDetailPageOfTheProductNo(i);
			addTheProductToTheShoppingCart();
		}
		return true;
	}

	public int theNumberOfObjectsInTheShoppingCartIs() {
		
		return shopPageObject.shoppingCartBox().getShoppingCartItems().size();
	}

	@Alias("the user checks out")
	public boolean checkout() {
		cartPage = shopPageObject.shoppingCartBox().clickCheckoutBtn();
		return cartPage.isVisible();
	}
	@Alias("he adds the product to the shopping cart")
	public boolean addTheProductToTheShoppingCart() {
		productDetailPageObject = productDetailPageObject.clickAddToCartBtn();
		return productDetailPageObject.isVisible();
	}
	@Alias("the user views the details of the product No")
	public boolean openTheDetailPageOfTheProductNo(int number) {
		List<MovieBox> products = shopPageObject.products();
		if (number > products.size()) {
			throw new UITestIllegalStateException("openTheDetailPageOfTheProductNo: number > products.size()");
		}
		MovieBox movieBox = products.get(number);
		productDetailPageObject = movieBox.clickTitleLink();
		return productDetailPageObject.isVisible();
	}
	@AfterTable
	public void closeBrowser() {
		tearDownDriver();
	}

	@Alias("the shopping cart overview is displayed")
	public boolean isShoppingCartOverviewDisplayed() {
		return cartPage.isVisible();
	}

	@Alias("the number of items in the list is")
	public int getNumberOfItemsInList() {
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





	private boolean loginWithUsernameAndPassword(String username, String password) {
		shopPageObject.loginBox().typeUsernameTxt(username);
		shopPageObject.loginBox().typePasswordTxt(password);
		shopPageObject = shopPageObject.loginBox().clickLoginBtn(ShopPage.class);
		return true;
	}


}
