package info.novatec.aqe.showcase.livingdoc.showcase.sbe.uitest.container;

import info.novatec.aqe.showcase.livingdoc.selenium.fwk.container.BaseContainer;
import info.novatec.aqe.showcase.livingdoc.showcase.sbe.uitest.pageobjects.CreateAccountPageObject;
import info.novatec.testit.webtester.api.annotations.IdentifyUsing;
import info.novatec.testit.webtester.pageobjects.Button;
import info.novatec.testit.webtester.pageobjects.Link;
import info.novatec.testit.webtester.pageobjects.PageObject;
import info.novatec.testit.webtester.pageobjects.PasswordField;
import info.novatec.testit.webtester.pageobjects.TextField;

public class LoginBox extends BaseContainer {

	@IdentifyUsing( "LoginForm:Username")
	private TextField usernameTxt;

	@IdentifyUsing( "LoginForm:Password")
	private PasswordField passwordTxt;

	@IdentifyUsing( "LoginForm:Login")
	private Button loginBtn;

	@IdentifyUsing( "LogoutForm:Logout")
	private Button logoutBtn;

	@IdentifyUsing( "LoginForm:CreateAccount")
	private Link createAccountBtn;

	public Button getLogoutBtn() {
		return logoutBtn;
	}

	public void typeUsernameTxt(String username) {
		usernameTxt.setText(username);
	}

	public void typePasswordTxt(String password) {
		passwordTxt.setText(password);
	}

	public <P extends PageObject> P clickLoginBtn(Class<P> expectedPage) {
		loginBtn.click();
		return create(expectedPage);
	}

	public CreateAccountPageObject clickCreateAccount() {
		createAccountBtn.click();
		return create(CreateAccountPageObject.class);
	}
}
