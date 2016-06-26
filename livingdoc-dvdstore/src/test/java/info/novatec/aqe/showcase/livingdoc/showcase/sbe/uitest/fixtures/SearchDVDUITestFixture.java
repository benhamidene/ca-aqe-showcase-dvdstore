package info.novatec.aqe.showcase.livingdoc.showcase.sbe.uitest.fixtures;

import info.novatec.aqe.showcase.livingdoc.showcase.sbe.uitest.container.SearchBox;
import info.novatec.aqe.showcase.livingdoc.showcase.sbe.uitest.pageobjects.SearchResultPageObject;
import info.novatec.aqe.showcase.livingdoc.showcase.sbe.uitest.pageobjects.ShopPageObject;
import info.novatec.aqe.showcase.livingdoc.showcase.sbe.uitest.workflows.SearchResultPageWorkflow;
import info.novatec.testit.livingdoc.reflect.AfterTable;
import info.novatec.testit.livingdoc.reflect.BeforeFirstExpectation;
import info.novatec.testit.livingdoc.reflect.BeforeRow;
import info.novatec.testit.livingdoc.reflect.BeforeTable;

public class SearchDVDUITestFixture extends BaseDVDStoreFixture {
	
	private String search;
	private SearchBox searchBox;
	private SearchResultPageObject searchResults;
	private ShopPageObject shopPage;
	private SearchResultPageWorkflow searchResultPageWorkflow;
	
	public SearchDVDUITestFixture(){
		super();
		openShopPage();
	}
		
	@BeforeTable
	public void openShopPage() {
		setup();
		
		searchResultPageWorkflow = new SearchResultPageWorkflow(browser);
	}
	
	@AfterTable
	public void closeBrowser() {
		tearDownDriver();
	}

	@BeforeRow
	public void resetShopPage(){
		shopPage = searchResultPageWorkflow.openShopPage();
	}
	
	@BeforeFirstExpectation
	public void searchQuery(){
		searchResults = enterQuery(search);
	}

	public String expectedFirstTitleOfResults(){		
		return searchResults.getFirstTitleOfResults();
	}
	
	public String expectedFirstStarring(){
		return searchResults.getFirstStarringOfResults();
	}
	
	public String expectedFirstPrice(){
		return searchResults.getFirstPriceOfResults();
	}
	
	public int expectedNumberOfResults() {			
		return searchResults.getNumberOfResults();
	}

	
	
	public void setSearch(String search) {
		this.search = search;
	}
	
	private SearchResultPageObject enterQuery(String query){
		searchBox = shopPage.getSearchBox();
		searchBox.typeSearchTxt(query);		

		return searchBox.clickSearchBtn();
	}
}