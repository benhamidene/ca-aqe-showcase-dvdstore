package info.novatec.aqe.showcase.livingdoc.showcase.sbe.uitest.fixtures;


public class BuyINTTestFixture extends BaseDVDStoreFixture {

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
