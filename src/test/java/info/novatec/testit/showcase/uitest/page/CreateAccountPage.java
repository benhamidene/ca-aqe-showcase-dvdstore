package info.novatec.testit.showcase.uitest.page;

import info.novatec.testit.webtester.pagefragments.Button;
import info.novatec.testit.webtester.pagefragments.PageFragment;
import info.novatec.testit.webtester.pagefragments.PasswordField;
import info.novatec.testit.webtester.pagefragments.TextField;
import info.novatec.testit.webtester.pagefragments.annotations.IdentifyUsing;
import info.novatec.testit.webtester.pagefragments.identification.producers.IdEndsWith;

public interface CreateAccountPage extends DVDStoreBasePage {

	public interface AccountForm extends PageFragment {
		@IdentifyUsing(how = IdEndsWith.class, value = "userName")
		TextField username();

		@IdentifyUsing(how = IdEndsWith.class, value = "password")
		PasswordField password();

		@IdentifyUsing(how = IdEndsWith.class, value = "passwordVerify")
		PasswordField verifyPassword();

		@IdentifyUsing(how = IdEndsWith.class, value = "ContinueButton")
		Button continBtn();
	}

	@IdentifyUsing("#NewAccountForm")
	AccountForm accountForm();

	default void typePassword(String txt) {
		accountForm().password().setText(txt);
	}

	default void typeUsername(String txt) {
		accountForm().username().setText(txt);
	}

	default void typeVerifyPassword(String txt) {
		accountForm().verifyPassword().setText(txt);
	}

	default NewAccountRegistrationPage clickContinBtn() {
		accountForm().continBtn().click();

		return create(NewAccountRegistrationPage.class);
	}

}
