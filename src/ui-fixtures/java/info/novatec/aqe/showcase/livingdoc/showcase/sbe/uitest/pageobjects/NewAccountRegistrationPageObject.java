package info.novatec.aqe.showcase.livingdoc.showcase.sbe.uitest.pageobjects;

import info.novatec.aqe.showcase.livingdoc.selenium.fwk.elements.Span;
import info.novatec.testit.webtester.api.annotations.IdentifyUsing;
import info.novatec.testit.webtester.api.annotations.Visible;
import info.novatec.testit.webtester.api.enumerations.Method;
import info.novatec.testit.webtester.pageobjects.Button;
import info.novatec.testit.webtester.pageobjects.TextField;

public class NewAccountRegistrationPageObject extends DVDStoreBasePage {

	
	@IdentifyUsing( "NewAccountForm:firstName")
	@Visible
	private TextField firstNameTxt;
	
	@IdentifyUsing( "NewAccountForm:lastName")
	private TextField lastNameTxt;
	
	@IdentifyUsing( "NewAccountForm:city")
	private TextField cityTxt;
	
	@IdentifyUsing( "NewAccountForm:address1")
	private TextField addressTxt;
	
	@IdentifyUsing( "NewAccountForm:state")
	private TextField stateTxt;
	
	@IdentifyUsing( "NewAccountForm:zip")
	private TextField zipTxt;
	
	@IdentifyUsing( "NewAccountForm:email")
	private TextField emailTxt;
	
	@IdentifyUsing( "NewAccountForm:MessageForFirstName")
	private Span firstNameSpan;
	
	@IdentifyUsing( "NewAccountForm:MessageForLastName")
	private Span lastNameSpan;
	
	@IdentifyUsing( "NewAccountForm:MessageForCity")
	private Span citySpan;
	
	@IdentifyUsing( "NewAccountForm:MessageForState")
	private Span stateSpan;
	
	@IdentifyUsing( "NewAccountForm:MessageForZip")
	private Span zipSpan;
	
	@IdentifyUsing( "NewAccountForm:MessageForEmail")
	private Span emailSpan;
	@IdentifyUsing("NewAccountForm:ContinueButton")
	private Button continBtn;
	@IdentifyUsing(method = Method.CLASS_NAME, value = "cntError")
	private Span errorSpan;

	public TextField getFirstNameTxt() {
		return firstNameTxt;
	}

	public TextField getLastNameTxt() {
		return lastNameTxt;
	}

	public TextField getCityTxt() {
		return cityTxt;
	}

	public TextField getStateTxt() {
		return stateTxt;
	}

	public TextField getZipTxt() {
		return zipTxt;
	}

	public TextField getEmailTxt() {
		return emailTxt;
	}

	public Span getFirstNameSpan() {
		return firstNameSpan;
	}

	public Span getLastNameSpan() {
		return lastNameSpan;
	}

	public Span getCitySpan() {
		return citySpan;
	}

	public Span getStateSpan() {
		return stateSpan;
	}

	public Span getZipSpan() {
		return zipSpan;
	}

	public Span getEmailSpan() {
		return emailSpan;
	}

	public Button getContinBtn() {
		return continBtn;
	}

	public Span getErrorSpan() {
		return errorSpan;
	}

	

	public void typeFirstNameTxt(String txt) {
		firstNameTxt.setText(txt);
	}

	public void typeLastNameTxt(String txt) {
		lastNameTxt.setText(txt);
	}

	public void typeCityTxt(String txt) {
		cityTxt.setText(txt);
	}

	public void typeAddressTxt(String txt) {
		addressTxt.setText(txt);
	}

	public void typeStateTxt(String txt) {
		stateTxt.setText(txt);
	}

	public void typeZipTxt(String txt) {
		zipTxt.setText(txt);
	}

	public void typeEmailTxt(String txt) {
		emailTxt.setText(txt);
	}

	public CreditCardInformationPageObject clickContinueBtn() {
		continBtn.click();
		return create(CreditCardInformationPageObject.class);
	}

	public NewAccountRegistrationPageObject clickContinueBtnWithoutSuccess() {
		continBtn.click();
		return create(NewAccountRegistrationPageObject.class);
	}

}
