package info.novatec.testit.showcase.uitest.fixtures;


import info.novatec.testit.livingdoc.reflect.annotation.FixtureClass;

@FixtureClass("Buy (INT-Test)")
public class BuyINTTestFixture {

	private String[] productIds;

	public void setAddProductWithIds(String... productIds) {
		this.productIds = productIds;
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
		}
	}
	
	public String[] productIdsInTheShoppingCart(){
		return productIds;
	}
}
