package info.novatec.aqe.showcase.livingdoc.showcase.sbe.uitest.pageobjects;

import info.novatec.testit.webtester.api.annotations.IdentifyUsing;
import info.novatec.testit.webtester.api.annotations.Visible;
import info.novatec.testit.webtester.pageobjects.PasswordField;
import info.novatec.testit.webtester.pageobjects.TextField;
public class CreateAccountPageObject extends DVDStoreBasePage {

	@IdentifyUsing( "NewAccountForm:userName")
	private TextField username;

	@IdentifyUsing( "NewAccountForm:password")
	private PasswordField password;

	@IdentifyUsing( "NewAccountForm:passwordVerify")
	@Visible
	private PasswordField verifyPassword;

	@IdentifyUsing( "NewAccountForm:ContinueButton")
	private info.novatec.testit.webtester.pageobjects.Button continBtn;

	public void typePassword(String txt) {
		password.setText(txt);
	}

	public void typeUsername(String txt) {
		username.setText(txt);
	}

	public void typeVerifyPassword(String txt) {
		verifyPassword.setText(txt);
	}

	public NewAccountRegistrationPageObject clickContinBtn() {
		continBtn.click();;
		return create(NewAccountRegistrationPageObject.class);
	}


}
