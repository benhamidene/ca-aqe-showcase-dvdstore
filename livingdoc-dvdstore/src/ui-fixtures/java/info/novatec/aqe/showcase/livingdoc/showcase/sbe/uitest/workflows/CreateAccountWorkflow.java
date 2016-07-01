package info.novatec.aqe.showcase.livingdoc.showcase.sbe.uitest.workflows;

import info.novatec.aqe.showcase.livingdoc.showcase.sbe.uitest.pageobjects.CreateAccountPageObject;
import info.novatec.aqe.showcase.livingdoc.showcase.sbe.uitest.pageobjects.HomePageObject;
import info.novatec.aqe.showcase.livingdoc.showcase.sbe.uitest.pageobjects.NewAccountRegistrationPageObject;
import info.novatec.testit.webtester.api.browser.Browser;

public class CreateAccountWorkflow {

	private BasicWorkflow basicWorkflow;

	public CreateAccountWorkflow(Browser browser) {
		basicWorkflow = new BasicWorkflow(browser);
	}

	public CreateAccountPageObject openCreateAccountPage() {
		HomePageObject homePageObject = basicWorkflow.openSut();
		return homePageObject.getLogin().clickCreateAccount();
	}

	public NewAccountRegistrationPageObject openRegistrationPageWithUserAnsPassword(
			String user, String password) {
		CreateAccountPageObject createAccountPageObject = openCreateAccountPage();
		createAccountPageObject.typeUsername(user);
		createAccountPageObject.typePassword(password);
		createAccountPageObject.typeVerifyPassword(password);
		return createAccountPageObject.clickContinBtn();
	}

	public NewAccountRegistrationPageObject openRegistrationPageWithRandomUserAndPassword() {
		String randomUser = "u" + String.valueOf(System.currentTimeMillis());
		String randowPassword = "pP"
				+ String.valueOf(System.currentTimeMillis());
		return openRegistrationPageWithUserAnsPassword(randomUser,
				randowPassword);
	}
}
