package info.novatec.testit.showcase.uitest.fixtures;

import java.io.FileNotFoundException;
import java.io.IOException;

import info.novatec.testit.livingdoc.LivingDoc;
import info.novatec.testit.livingdoc.reflect.AfterTable;
import info.novatec.testit.livingdoc.reflect.BeforeFirstExpectation;
import info.novatec.testit.livingdoc.reflect.BeforeRow;
import info.novatec.testit.livingdoc.reflect.BeforeTable;
import info.novatec.testit.livingdoc.reflect.annotation.FixtureClass;
import info.novatec.testit.showcase.common.BaseUITestFixture;
import info.novatec.testit.showcase.uitest.page.NewAccountRegistrationPage;
import info.novatec.testit.showcase.uitest.workflows.CreateAccountWorkflow;
import info.novatec.testit.webtester.pagefragments.Span;

@FixtureClass("Mandatory fields [ UI-Test ]")
public class MandatoryFieldsUITestFixture extends BaseUITestFixture{

	public String firstname = "";
	public String lastname = "";
	public String city = "";
	public String state = "";
	public String zip = "";
	public String email = "";

	private NewAccountRegistrationPage newAccountRegistrationPage;
	private CreateAccountWorkflow createAccountWorkflow;
	

	@BeforeTable
	public void openAccountDataPage() throws FileNotFoundException, IOException  {
		LivingDoc.setStopOnFirstFailure(true);
		openSystemUnderTest();
		createAccountWorkflow = new CreateAccountWorkflow(browser);
		newAccountRegistrationPage = createAccountWorkflow
				.openRegistrationPageWithRandomUserAndPassword();
	}
	
	@BeforeRow
	public void initRow(){
		LivingDoc.setStopOnFirstFailure(false);
	}
	@BeforeFirstExpectation
	public void typeData() {
		newAccountRegistrationPage.typeCityTxt(city);
		newAccountRegistrationPage.typeEmailTxt(email);
		newAccountRegistrationPage.typeFirstNameTxt(firstname);
		newAccountRegistrationPage.typeLastNameTxt(lastname);
		newAccountRegistrationPage.typeZipTxt(zip);
		newAccountRegistrationPage = newAccountRegistrationPage
				.clickContinueBtnWithoutSuccess();
	}
	
	@AfterTable
	public void closeBrowser() {
		tearDownDriver();
	}

	public String validFirstname() {

		return validationText(newAccountRegistrationPage
				.registrationForm().firstNameSpan());
	}

	public String validLastname() {
		return validationText(newAccountRegistrationPage
				.registrationForm().lastNameSpan());
	}

	public String validCity() {
		return validationText(newAccountRegistrationPage.registrationForm().citySpan());
	}

	public String validZip() {
		return validationText(newAccountRegistrationPage.registrationForm().zipSpan());
	}

	public String validEmail() {
		return validationText(newAccountRegistrationPage.registrationForm().emailSpan());
	}

	private String validationText(Span span) {
		if (span.isPresent() && span.isVisible()) {
			return span.getVisibleText();
		} else {
			return "valid";
		}
	}
}
