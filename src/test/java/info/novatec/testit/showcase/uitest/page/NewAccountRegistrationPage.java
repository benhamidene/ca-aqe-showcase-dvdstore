package info.novatec.testit.showcase.uitest.page;

import info.novatec.testit.webtester.conditions.pagefragments.Visible;
import info.novatec.testit.webtester.pagefragments.Button;
import info.novatec.testit.webtester.pagefragments.PageFragment;
import info.novatec.testit.webtester.pagefragments.Span;
import info.novatec.testit.webtester.pagefragments.TextField;
import info.novatec.testit.webtester.pagefragments.annotations.IdentifyUsing;
import info.novatec.testit.webtester.pagefragments.annotations.PostConstructMustBe;
import info.novatec.testit.webtester.pagefragments.identification.producers.IdEndsWith;

public interface NewAccountRegistrationPage extends DVDStoreBasePage {

    public interface RegistrationForm extends PageFragment {

        @IdentifyUsing(how = IdEndsWith.class, value = "firstName")
        @PostConstructMustBe(Visible.class)
        TextField firstNameTxt();

        @IdentifyUsing(how = IdEndsWith.class, value = "lastName")
        TextField lastNameTxt();

        @IdentifyUsing(how = IdEndsWith.class, value = "city")
        TextField cityTxt();

        @IdentifyUsing(how = IdEndsWith.class, value = "address1")
        TextField addressTxt();

        @IdentifyUsing(how = IdEndsWith.class, value = "state")
        TextField stateTxt();

        @IdentifyUsing(how = IdEndsWith.class, value = "zip")
        TextField zipTxt();

        @IdentifyUsing(how = IdEndsWith.class, value = "email")
        TextField emailTxt();

        @IdentifyUsing(how = IdEndsWith.class, value = "MessageForFirstName")
        Span firstNameSpan();

        @IdentifyUsing(how = IdEndsWith.class, value = "MessageForLastName")
        Span lastNameSpan();

        @IdentifyUsing(how = IdEndsWith.class, value = "MessageForCity")
        Span citySpan();

        @IdentifyUsing(how = IdEndsWith.class, value = "MessageForState")
        Span stateSpan();

        @IdentifyUsing(how = IdEndsWith.class, value = "MessageForZip")
        Span zipSpan();

        @IdentifyUsing(how = IdEndsWith.class, value = "MessageForEmail")
        Span emailSpan();

        @IdentifyUsing(how = IdEndsWith.class, value = "ContinueButton")
        Button continBtn();
    }

    @IdentifyUsing("#NewAccountForm")
    RegistrationForm registrationForm();

    @IdentifyUsing(".cntError")
    Span errorSpan();

    default void typeFirstNameTxt(String txt) {
        registrationForm().firstNameTxt().setText(txt);
    }

    default void typeLastNameTxt(String txt) {
        registrationForm().lastNameTxt().setText(txt);
    }

    default void typeCityTxt(String txt) {
        registrationForm().cityTxt().setText(txt);
    }

    default void typeAddressTxt(String txt) {
        registrationForm().addressTxt().setText(txt);
    }

    default void typeStateTxt(String txt) {
        registrationForm().stateTxt().setText(txt);
    }

    default void typeZipTxt(String txt) {
        registrationForm().zipTxt().setText(txt);
    }

    default void typeEmailTxt(String txt) {
        registrationForm().emailTxt().setText(txt);
    }

    default CreditCardInformationPage clickContinueBtn() {
        registrationForm().continBtn().click();
        return create(CreditCardInformationPage.class);
    }

    default NewAccountRegistrationPage clickContinueBtnWithoutSuccess() {
        registrationForm().continBtn().click();
        return create(NewAccountRegistrationPage.class);
    }

}
