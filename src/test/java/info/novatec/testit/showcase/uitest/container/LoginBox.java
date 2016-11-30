package info.novatec.testit.showcase.uitest.container;

import info.novatec.testit.showcase.uitest.page.CreateAccountPage;
import info.novatec.testit.webtester.pagefragments.Button;
import info.novatec.testit.webtester.pagefragments.Link;
import info.novatec.testit.webtester.pagefragments.PageFragment;
import info.novatec.testit.webtester.pagefragments.PasswordField;
import info.novatec.testit.webtester.pagefragments.TextField;
import info.novatec.testit.webtester.pagefragments.annotations.IdentifyUsing;
import info.novatec.testit.webtester.pagefragments.identification.producers.IdEndsWith;
import info.novatec.testit.webtester.pages.Page;

public interface LoginBox extends PageFragment {


	@IdentifyUsing(how = IdEndsWith.class, value = "Username")
	TextField usernameTxt();

	@IdentifyUsing(how = IdEndsWith.class, value = "Password")
	PasswordField passwordTxt();

	@IdentifyUsing(how = IdEndsWith.class, value = "Login")
	Button loginBtn();

	@IdentifyUsing(how = IdEndsWith.class, value = "Logout")
	Button logoutBtn();

	@IdentifyUsing(how = IdEndsWith.class, value = "CreateAccount")
	Link createAccountBtn();



	default void typeUsernameTxt(String username) {
		usernameTxt().setText(username);
	}

	default void typePasswordTxt(String password) {
		passwordTxt().setText(password);
	}

	default <P extends Page> P clickLoginBtn(Class<P> expectedPage) {
		loginBtn().click();
		return create(expectedPage);
	}

	default CreateAccountPage clickCreateAccount() {
		createAccountBtn().click();
		return create(CreateAccountPage.class);
	}
}
