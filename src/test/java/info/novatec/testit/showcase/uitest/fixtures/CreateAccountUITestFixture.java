package info.novatec.testit.showcase.uitest.fixtures;

import info.novatec.testit.livingdoc.reflect.AfterTable;
import info.novatec.testit.showcase.common.BaseUITestFixture;
import info.novatec.testit.showcase.uitest.page.CreateAccountPage;
import info.novatec.testit.showcase.uitest.page.CreditCardInformationPage;
import info.novatec.testit.showcase.uitest.page.HomePage;
import info.novatec.testit.showcase.uitest.page.NewAccountRegistrationPage;
import info.novatec.testit.showcase.uitest.page.ShopPage;
import info.novatec.testit.showcase.uitest.page.WelcomePage;

import java.io.FileNotFoundException;
import java.io.IOException;

public class CreateAccountUITestFixture extends BaseUITestFixture {

	private HomePage homePageObject;
	private ShopPage shopPageObject;
	private CreateAccountPage createAccountPageObject;
	private NewAccountRegistrationPage newAccountRegistrationPageObject;
	private CreditCardInformationPage creditCardInformationPage;
	private WelcomePage welcomePageObject;

	public boolean openTheShoppingPage() throws FileNotFoundException, IOException {
		openSystemUnderTest();
		homePageObject = browser.create(HomePage.class);
		shopPageObject = homePageObject.navigation().clickShopLnk();
		return true;
	}

	public boolean clickCreateAccount() throws FileNotFoundException, IOException {
		openTheShoppingPage();
		createAccountPageObject = shopPageObject.loginBox()
				.clickCreateAccount();
		return true;
	}

	public boolean typeAsPassword(String txt) {
		createAccountPageObject.typePassword(txt);
		return true;
	}

	public boolean typeAsUsername(String txt) {
		createAccountPageObject.typeUsername(String.valueOf(System
				.currentTimeMillis()));
		return true;
	}

	public boolean typeToVerifyPassword(String txt) {
		createAccountPageObject.typeVerifyPassword(txt);
		return true;
	}

	public void typeAsFirstName(String txt) {
		newAccountRegistrationPageObject.typeFirstNameTxt(txt);
	}

	public void typeAsLastName(String txt) {
		newAccountRegistrationPageObject.typeLastNameTxt(txt);
	}

	public void typeAsCity(String txt) {
		newAccountRegistrationPageObject.typeCityTxt(txt);
	}

	public void typeAsAddress(String txt) {
		newAccountRegistrationPageObject.typeAddressTxt(txt);
	}

	public void typeAsState(String txt) {
		newAccountRegistrationPageObject.typeStateTxt(txt);
	}

	public void typeAsZip(String txt) {
		newAccountRegistrationPageObject.typeZipTxt(txt);
	}

	public void typeAsEmail(String txt) {
		newAccountRegistrationPageObject.typeEmailTxt(txt);
	}

	public void selectAsCreditCard(String value) {
		creditCardInformationPage.selectAsCreditCard(value);
	}

	public void typeAsCreditCardNumber(String txt) {
		creditCardInformationPage.typeCreditCardNumberTxt(txt);
	}

	public void selectAsCreditCardMonth(String value) {
		creditCardInformationPage.selectCreditCardMonth(value);
	}

	public void selectAsCreditCardYear(String value) {
		creditCardInformationPage.selectCreditCardYear(value);
	}

	public boolean clickSubmit() {
		welcomePageObject = creditCardInformationPage.clickSubmitBtn();
		return true;
	}

	public boolean clickContinueButton() {
		newAccountRegistrationPageObject = createAccountPageObject
				.clickContinBtn();
		return true;
	}

	public boolean clickContinue() {
		creditCardInformationPage = newAccountRegistrationPageObject
				.clickContinueBtn();
		return true;
	}

	public boolean ifUserIsLoggedIn() {
		return welcomePageObject.loginBox().logoutBtn().isVisible();
	}
	
	@AfterTable
	public void closeBrowser() {
		tearDownDriver();
	}
}
