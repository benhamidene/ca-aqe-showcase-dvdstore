package info.novatec.aqe.showcase.livingdoc.showcase.sbe.uitest.pageobjects;

import info.novatec.testit.webtester.api.annotations.IdentifyUsing;
import info.novatec.testit.webtester.api.annotations.Visible;
import info.novatec.testit.webtester.pageobjects.Button;
import info.novatec.testit.webtester.pageobjects.Select;
import info.novatec.testit.webtester.pageobjects.TextField;


public class CreditCardInformationPageObject extends DVDStoreBasePage {

	@IdentifyUsing( "NewAccountForm:CreditCardMenu")
	@Visible
	private Select creditCardSelect;

	@IdentifyUsing( "NewAccountForm:creditCard")
	private TextField creditCardNumberTxt;

	@IdentifyUsing( "NewAccountForm:CreditCardMonthMenu")
	private Select creditCardMonthSelect;

	@IdentifyUsing( "NewAccountForm:CreditCardYearMenu")
	private Select creditCardYearSelect;

	@IdentifyUsing( "NewAccountForm:SubmitNewCustomerButton")
	private Button submitBtn;

	public void selectAsCreditCard(String value) {
		creditCardSelect.selectByText(value);
	}

	public void typeCreditCardNumberTxt(String txt) {
		creditCardNumberTxt.setText(txt);
	}

	public void selectCreditCardMonth(String value) {
		creditCardMonthSelect.selectByText(value);
	}

	public void selectCreditCardYear(String value) {
		creditCardYearSelect.selectByText(value);
	}

	public WelcomePageObject clickSubmitBtn() {
		submitBtn.click();
		return create(WelcomePageObject.class);
	}

	

}
