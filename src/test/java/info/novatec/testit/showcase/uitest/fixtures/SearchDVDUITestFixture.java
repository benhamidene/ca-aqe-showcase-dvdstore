package info.novatec.testit.showcase.uitest.fixtures;

import java.io.FileNotFoundException;
import java.io.IOException;

import info.novatec.testit.livingdoc.reflect.AfterTable;
import info.novatec.testit.livingdoc.reflect.BeforeFirstExpectation;
import info.novatec.testit.livingdoc.reflect.BeforeRow;
import info.novatec.testit.livingdoc.reflect.BeforeTable;
import info.novatec.testit.livingdoc.reflect.annotation.FixtureClass;
import info.novatec.testit.showcase.common.BaseUITestFixture;
import info.novatec.testit.showcase.uitest.container.SearchBox;
import info.novatec.testit.showcase.uitest.page.SearchResultPage;
import info.novatec.testit.showcase.uitest.page.ShopPage;
import info.novatec.testit.showcase.uitest.workflows.SearchResultPageWorkflow;

@FixtureClass("Search DVD ( UITest )")
public class SearchDVDUITestFixture extends BaseUITestFixture {
	
	private String search;
	private SearchBox searchBox;
	private SearchResultPage searchResults;
	private ShopPage shopPage;
	private SearchResultPageWorkflow searchResultPageWorkflow;
	

		
	@BeforeTable
	public void openShopPage() throws FileNotFoundException, IOException {
		openSystemUnderTest();
		searchResultPageWorkflow = new SearchResultPageWorkflow(browser);
		shopPage = searchResultPageWorkflow.openShopPage();
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
	
	private SearchResultPage enterQuery(String query){
		searchBox = shopPage.searchBox();
		searchBox.typeSearchTxt(query);		

		return searchBox.clickSearchBtn();
	}
}