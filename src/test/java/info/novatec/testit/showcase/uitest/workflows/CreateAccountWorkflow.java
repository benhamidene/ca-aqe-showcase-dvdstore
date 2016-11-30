package info.novatec.testit.showcase.uitest.workflows;

import info.novatec.testit.showcase.uitest.page.CreateAccountPage;
import info.novatec.testit.showcase.uitest.page.HomePage;
import info.novatec.testit.showcase.uitest.page.NewAccountRegistrationPage;
import info.novatec.testit.webtester.browser.Browser;

public class CreateAccountWorkflow {

	private BasicWorkflow basicWorkflow;

	public CreateAccountWorkflow(Browser browser) {
		basicWorkflow = new BasicWorkflow(browser);
	}

	public CreateAccountPage openCreateAccountPage() {
		HomePage homePage = basicWorkflow.openSut();
		return homePage.loginBox().clickCreateAccount();
	}

	public NewAccountRegistrationPage openRegistrationPageWithUserAnsPassword(
			String user, String password) {
		CreateAccountPage createAccountPageObject = openCreateAccountPage();
		createAccountPageObject.typeUsername(user);
		createAccountPageObject.typePassword(password);
		createAccountPageObject.typeVerifyPassword(password);
		return createAccountPageObject.clickContinBtn();
	}

	public NewAccountRegistrationPage openRegistrationPageWithRandomUserAndPassword() {
		String randomUser = "u" + String.valueOf(System.currentTimeMillis());
		String randowPassword = "pP"
				+ String.valueOf(System.currentTimeMillis());
		return openRegistrationPageWithUserAnsPassword(randomUser,
				randowPassword);
	}
}
