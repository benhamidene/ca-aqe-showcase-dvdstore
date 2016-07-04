package info.novatec.aqe.showcase.livingdoc.showcase.sbe.uitest.pageobjects;

import info.novatec.testit.webtester.api.annotations.IdentifyUsing;
import info.novatec.testit.webtester.api.enumerations.Method;
import info.novatec.testit.webtester.pageobjects.PageObject;
import org.apache.commons.lang3.StringUtils;

public class SearchResultPageObject extends PageObject{
	
	@IdentifyUsing(method= Method.CLASS_NAME, value="message")
	private PageObject searchResults;
	
	@IdentifyUsing("SearchResultsForm:SearchResultsTable:0:TitleLink")
	private PageObject firstTitleInSearchResult;
	
	@IdentifyUsing("SearchResultsForm:SearchResultsTable:0:StarringValue")
	private PageObject firstStarringInSearchResult;
	
	@IdentifyUsing("SearchResultsForm:SearchResultsTable:0:PriceValue")
	private PageObject firstPriceInSearchResult;
	
	
	
	public String getFirstTitleOfResults(){		
		if(firstTitleInSearchResult.isVisible()){
			return firstTitleInSearchResult.getVisibleText();
		} else {
			return StringUtils.EMPTY;
		}
	}
	
	public String getFirstStarringOfResults(){
		if(firstStarringInSearchResult.isVisible()){
			return firstStarringInSearchResult.getVisibleText();
		} else {
			return StringUtils.EMPTY;
		}
	}
	
	public String getFirstPriceOfResults(){
		if(firstPriceInSearchResult.isVisible()){
			return firstPriceInSearchResult.getVisibleText();
		} else {
			return StringUtils.EMPTY;
		}
	}
	
	public int getNumberOfResults(){
		if(searchResults.isVisible()){
			return (int) Integer.parseInt(searchResults.getVisibleText().replaceAll("\\D+",""));
		} else {
			return 0;
		}		
	}
}