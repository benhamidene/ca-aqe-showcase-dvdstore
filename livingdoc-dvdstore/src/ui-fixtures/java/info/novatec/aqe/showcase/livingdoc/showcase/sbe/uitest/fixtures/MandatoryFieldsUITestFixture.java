package info.novatec.aqe.showcase.livingdoc.showcase.sbe.uitest.fixtures;

import info.novatec.aqe.showcase.livingdoc.selenium.fwk.elements.Span;
import info.novatec.aqe.showcase.livingdoc.showcase.sbe.uitest.pageobjects.NewAccountRegistrationPageObject;
import info.novatec.aqe.showcase.livingdoc.showcase.sbe.uitest.workflows.CreateAccountWorkflow;
import info.novatec.testit.livingdoc.reflect.AfterTable;
import info.novatec.testit.livingdoc.reflect.BeforeFirstExpectation;
import info.novatec.testit.livingdoc.reflect.BeforeTable;


public class MandatoryFieldsUITestFixture extends BaseDVDStoreFixture {

	public String firstname = "";
	public String lastname = "";
	public String city = "";
	public String state = "";
	public String zip = "";
	public String email = "";

	private NewAccountRegistrationPageObject newAccountRegistrationPageObject;
	private CreateAccountWorkflow createAccountWorkflow;
	
	public MandatoryFieldsUITestFixture() {
		super();
		openAccountDataPage();
	}

	@BeforeTable
	void openAccountDataPage()  {
		setup();
		createAccountWorkflow = new CreateAccountWorkflow(browser);
		newAccountRegistrationPageObject = createAccountWorkflow
				.openRegistrationPageWithRandomUserAndPassword();
	}

	@BeforeFirstExpectation
	public void typeData() {
		newAccountRegistrationPageObject.typeCityTxt(city);
		newAccountRegistrationPageObject.typeEmailTxt(email);
		newAccountRegistrationPageObject.typeFirstNameTxt(firstname);
		newAccountRegistrationPageObject.typeLastNameTxt(lastname);
		newAccountRegistrationPageObject.typeZipTxt(zip);
		newAccountRegistrationPageObject = newAccountRegistrationPageObject
				.clickContinueBtnWithoutSuccess();
	}
	
	@AfterTable
	public void closeBrowser() {
		tearDownDriver();
	}

	public String validFirstname() {

		return validationText(newAccountRegistrationPageObject
				.getFirstNameSpan());
	}

	public String validLastname() {
		return validationText(newAccountRegistrationPageObject
				.getLastNameSpan());
	}

	public String validCity() {
		return validationText(newAccountRegistrationPageObject.getCitySpan());
	}

	public String validZip() {
		return validationText(newAccountRegistrationPageObject.getZipSpan());
	}

	public String validEmail() {
		return validationText(newAccountRegistrationPageObject.getEmailSpan());
	}

	private String validationText(Span span) {
		if (span.isVisible()) {
			return span.getVisibleText();
		} else {
			return "valid";
		}
	}
}
