package info.novatec.aqe.showcase.livingdoc.showcase.sbe.uitest.fixtures;

import info.novatec.aqe.showcase.livingdoc.showcase.sbe.uitest.pageobjects.*;
import info.novatec.testit.livingdoc.reflect.AfterTable;

import java.io.FileNotFoundException;
import java.io.IOException;

public class CreateAccountUITestFixture extends BaseDVDStoreFixture {

	private HomePageObject homePageObject;
	private ShopPageObject shopPageObject;
	private CreateAccountPageObject createAccountPageObject;
	private NewAccountRegistrationPageObject newAccountRegistrationPageObject;
	private CreditCardInformationPageObject creditCardInformationPageObject;
	private WelcomePageObject welcomePageObject;

	public boolean openTheShoppingPage() throws FileNotFoundException, IOException {
		openSystemUnderTest();
		homePageObject = browser.create(HomePageObject.class);
		shopPageObject = homePageObject.getNavigation().clickShopLnk();
		return true;
	}

	public boolean clickCreateAccount() throws FileNotFoundException, IOException {
		openTheShoppingPage();
		createAccountPageObject = shopPageObject.getLogin()
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
		creditCardInformationPageObject.selectAsCreditCard(value);
	}

	public void typeAsCreditCardNumber(String txt) {
		creditCardInformationPageObject.typeCreditCardNumberTxt(txt);
	}

	public void selectAsCreditCardMonth(String value) {
		creditCardInformationPageObject.selectCreditCardMonth(value);
	}

	public void selectAsCreditCardYear(String value) {
		creditCardInformationPageObject.selectCreditCardYear(value);
	}

	public boolean clickSubmit() {
		welcomePageObject = creditCardInformationPageObject.clickSubmitBtn();
		return true;
	}

	public boolean clickContinueButton() {
		newAccountRegistrationPageObject = createAccountPageObject
				.clickContinBtn();
		return true;
	}

	public boolean clickContinue() {
		creditCardInformationPageObject = newAccountRegistrationPageObject
				.clickContinueBtn();
		return true;
	}

	public boolean ifUserIsLoggedIn() {
		return welcomePageObject.getLogin().getLogoutBtn().isVisible();
	}
	
	@AfterTable
	public void closeBrowser() {
		tearDownDriver();
	}
}
