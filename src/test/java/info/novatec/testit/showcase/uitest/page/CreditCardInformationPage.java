package info.novatec.testit.showcase.uitest.page;

import info.novatec.testit.webtester.pagefragments.Button;
import info.novatec.testit.webtester.pagefragments.PageFragment;
import info.novatec.testit.webtester.pagefragments.SingleSelect;
import info.novatec.testit.webtester.pagefragments.TextField;
import info.novatec.testit.webtester.pagefragments.annotations.IdentifyUsing;
import info.novatec.testit.webtester.pagefragments.identification.producers.IdEndsWith;

public interface CreditCardInformationPage extends DVDStoreBasePage {

	public interface CreditCardForm extends PageFragment {
		@IdentifyUsing(how = IdEndsWith.class, value = "CreditCardMenu")
		SingleSelect creditCardSelect();

		@IdentifyUsing(how = IdEndsWith.class, value = "creditCard")
		TextField creditCardNumberTxt();

		@IdentifyUsing(how = IdEndsWith.class, value = "CreditCardMonthMenu")
		SingleSelect creditCardMonthSelect();

		@IdentifyUsing(how = IdEndsWith.class, value = "CreditCardYearMenu")
		SingleSelect creditCardYearSelect();

		@IdentifyUsing("SubmitNewCustomerButton")
		Button submitBtn();
	}

	@IdentifyUsing("NewAccountForm")
	CreditCardForm creditCardForm();

	default void selectAsCreditCard(String value) {
		creditCardForm().creditCardSelect().selectByText(value);
	}

	default void typeCreditCardNumberTxt(String txt) {
		creditCardForm().creditCardNumberTxt().setText(txt);
	}

	default void selectCreditCardMonth(String value) {
		creditCardForm().creditCardMonthSelect().selectByText(value);
	}

	default void selectCreditCardYear(String value) {
		creditCardForm().creditCardYearSelect().selectByText(value);
	}

	default WelcomePage clickSubmitBtn() {
		creditCardForm().submitBtn().click();
		return create(WelcomePage.class);
	}

}
