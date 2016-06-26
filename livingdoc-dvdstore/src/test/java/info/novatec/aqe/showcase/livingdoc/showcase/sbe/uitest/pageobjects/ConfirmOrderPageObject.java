package info.novatec.aqe.showcase.livingdoc.showcase.sbe.uitest.pageobjects;

import info.novatec.testit.webtester.api.annotations.IdentifyUsing;
import info.novatec.testit.webtester.api.enumerations.Method;
import info.novatec.testit.webtester.pageobjects.Button;
import info.novatec.testit.webtester.pageobjects.PageObject;


public class ConfirmOrderPageObject extends DVDStoreBasePage {

	@IdentifyUsing("orderdetail:ConfirmOrCancelForm:Confirm")
	private Button confirmBtn;
	@IdentifyUsing("orderdetail:OrderDetailForm")
	private PageObject orderDetailForm;

	@IdentifyUsing(method = Method.CLASS_NAME , value = "orderBox")
	private PageObject orderBox;

	public ConfirmOrderPageObject clickConfirmBtn() {
		confirmBtn.click();
		return create(ConfirmOrderPageObject.class);
	}

	public boolean ifPurchaseCompleteIsShown() {
		return orderBox.getVisibleText().contains("Thank you for ordering.");
	}

	
	
}
