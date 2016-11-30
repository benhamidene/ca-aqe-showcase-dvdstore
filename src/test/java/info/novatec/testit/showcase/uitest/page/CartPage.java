package info.novatec.testit.showcase.uitest.page;

import info.novatec.testit.webtester.pagefragments.Button;
import info.novatec.testit.webtester.pagefragments.Table;
import info.novatec.testit.webtester.pagefragments.annotations.IdentifyUsing;
import info.novatec.testit.webtester.pagefragments.identification.producers.IdEndsWith;

public interface CartPage extends DVDStoreBasePage {

	@IdentifyUsing(how = IdEndsWith.class ,value = "CartItemsTable")
	Table cartItemsTable();

	@IdentifyUsing(how = IdEndsWith.class ,value = "PurchaseButton")
	Button purchaseBtn();

	default ConfirmOrderPage clickPurchaseBtn() {
		purchaseBtn().click();
		return create(ConfirmOrderPage.class);
	}

	default int getCountItems() {
		return cartItemsTable().allRows().size();
	}

	default boolean isVisible(){
		return cartItemsTable().isVisible();
	}

}
