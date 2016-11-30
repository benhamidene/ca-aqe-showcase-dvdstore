package info.novatec.testit.showcase.uitest.container;

import java.util.ArrayList;
import java.util.List;

import info.novatec.testit.showcase.uitest.page.CartPage;
import info.novatec.testit.webtester.pagefragments.Button;
import info.novatec.testit.webtester.pagefragments.PageFragment;
import info.novatec.testit.webtester.pagefragments.Span;
import info.novatec.testit.webtester.pagefragments.Table;
import info.novatec.testit.webtester.pagefragments.TableRow;
import info.novatec.testit.webtester.pagefragments.annotations.IdentifyUsing;
import info.novatec.testit.webtester.pagefragments.identification.producers.IdEndsWith;

public interface ShoppingCartBox extends PageFragment {
	static final String ID = "#sidebar";

	@IdentifyUsing(".dvdtable")
	 Table dvdTbl();

	
	@IdentifyUsing(how = IdEndsWith.class, value = "CartTotal")
	 Span cartTotalSpan();

	@IdentifyUsing(how = IdEndsWith.class, value = "Checkout1")
	 Button checkoutBtn();

	class ShoppingCartItem {
		 int quantity;
		 String name;

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

	default CartPage clickCheckoutBtn() {
		checkoutBtn().click();
		return create(CartPage.class);
	}

	default double getTotal() {
		String totalText = cartTotalSpan().getVisibleText();
		// replace all letters and whitespaces
		totalText = totalText.replaceAll("[^0-9.,]", "");
		return Double.parseDouble(totalText);
	}

	default List<ShoppingCartItem> getShoppingCartItems() {
		List<ShoppingCartItem> items = new ArrayList<ShoppingCartItem>();
		for (TableRow row : dvdTbl().allRows()) {
			if (row.fields().size() > 1) {
				int quantity = Integer.parseInt(row.fields().get(0)
						.getVisibleText());
				String name = row.fields().get(1).getVisibleText();
				items.add(new ShoppingCartItem(name, quantity));
				// }
			}
		}
		return items;

	}
}
