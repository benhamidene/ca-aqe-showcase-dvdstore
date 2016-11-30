package info.novatec.testit.showcase.uitest.page;

import info.novatec.testit.webtester.pagefragments.Button;
import info.novatec.testit.webtester.pagefragments.GenericElement;
import info.novatec.testit.webtester.pagefragments.annotations.IdentifyUsing;
import info.novatec.testit.webtester.pagefragments.identification.producers.IdEndsWith;


public interface ConfirmOrderPage extends DVDStoreBasePage {

	@IdentifyUsing(how = IdEndsWith.class ,value = "Confirm")
	 Button confirmBtn();
	@IdentifyUsing(how = IdEndsWith.class ,value = "OrderDetailForm")
	GenericElement orderDetailForm();

	@IdentifyUsing(".orderBox")
	 GenericElement orderBox();

	default ConfirmOrderPage clickConfirmBtn() {
		confirmBtn().click();
		return create(ConfirmOrderPage.class);
	}

	default boolean ifPurchaseCompleteIsShown() {
		return orderBox().getVisibleText().contains("Thank you for ordering.");
	}

	
	
}
