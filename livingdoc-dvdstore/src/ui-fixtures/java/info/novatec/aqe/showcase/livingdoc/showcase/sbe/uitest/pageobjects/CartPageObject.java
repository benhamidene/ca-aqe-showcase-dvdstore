package info.novatec.aqe.showcase.livingdoc.showcase.sbe.uitest.pageobjects;

import info.novatec.testit.webtester.api.annotations.IdentifyUsing;
import info.novatec.testit.webtester.api.annotations.Visible;
import info.novatec.testit.webtester.pageobjects.Button;
import info.novatec.testit.webtester.pageobjects.Table;


public class CartPageObject extends DVDStoreBasePage {
	
	@IdentifyUsing("cartdetails:CartDetailsForm:CartItemsTable")
	@Visible
	private Table cartItemsTable;
	

	@IdentifyUsing("cartdetails:purchaseaction:PurchaseActionForm:PurchaseButton")
	private Button purchaseBtn;

	public Button getPurchaseBtn() {
		return purchaseBtn;
	}

	public ConfirmOrderPageObject clickPurchaseBtn() {
		purchaseBtn.click();
		return create(ConfirmOrderPageObject.class);
	}
	
	public int getCountItems(){
		return cartItemsTable.getRows().size();
	}

}
