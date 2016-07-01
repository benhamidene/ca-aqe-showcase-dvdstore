package info.novatec.aqe.showcase.livingdoc.showcase.sbe.uitest.container;

import info.novatec.aqe.showcase.livingdoc.selenium.fwk.container.BaseContainer;
import info.novatec.aqe.showcase.livingdoc.showcase.sbe.uitest.pageobjects.CartPageObject;
import info.novatec.testit.webtester.api.annotations.IdentifyUsing;
import info.novatec.testit.webtester.api.enumerations.Method;
import info.novatec.testit.webtester.pageobjects.Button;
import info.novatec.testit.webtester.pageobjects.PageObject;
import info.novatec.testit.webtester.pageobjects.Table;
import info.novatec.testit.webtester.pageobjects.TableRow;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCartBox extends BaseContainer {
	public static final String ID = "sidebar";

	@IdentifyUsing(method = Method.CLASS_NAME, value = "dvdtable")
	private Table dvdTbl;

	
	@IdentifyUsing("cartcontents:CartTotal")
	private PageObject cartTotalSpan;

	@IdentifyUsing("cartcontents:Cart:Checkout1")
	private Button checkoutBtn;

	public CartPageObject clickCheckoutBtn() {
		checkoutBtn.click();
		return create(CartPageObject.class);
	}

	public double getTotal() {
		String totalText = cartTotalSpan.getVisibleText();
		// replace all letters and whitespaces
		totalText = totalText.replaceAll("[^0-9.,]", "");
		return Double.parseDouble(totalText);
	}

	public List<ShoppingCartItem> getShoppingCartItems() {
		List<ShoppingCartItem> items = new ArrayList<ShoppingCartItem>();
		for (TableRow row : dvdTbl.getRows()) {
			if (row.getFields().size() > 1) {
				int quantity = Integer.parseInt(row.getFields().get(0)
						.getVisibleText());
				String name = row.getFields().get(1).getVisibleText();
				items.add(new ShoppingCartItem(name, quantity));
				// }
			}
		}
		return items;

	}

	class ShoppingCartItem {
		private int quantity;
		private String name;

		protected ShoppingCartItem(String name, int quantity) {
			this.name = name;
			this.quantity = quantity;
		}

		public int getQuantity() {
			return quantity;
		}

		public String getName() {
			return name;
		}

	}
}
