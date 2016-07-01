package info.novatec.aqe.showcase.livingdoc.showcase.sbe.uitest.container;

import info.novatec.aqe.showcase.livingdoc.selenium.fwk.container.BaseContainer;
import info.novatec.aqe.showcase.livingdoc.showcase.sbe.uitest.pageobjects.SearchResultPageObject;
import info.novatec.testit.webtester.api.annotations.IdentifyUsing;
import info.novatec.testit.webtester.pageobjects.Button;
import info.novatec.testit.webtester.pageobjects.Select;
import info.novatec.testit.webtester.pageobjects.TextField;

public class SearchBox extends BaseContainer {
	public static final String ID = "SearchForm";

	@IdentifyUsing("SearchForm:Query")
	private TextField searchTxt;

	@IdentifyUsing("SearchForm:PageSize")
	private Select resultPerPageSlc;

	@IdentifyUsing("SearchForm:Search")
	private Button searchBtn;

	public void typeSearchTxt(String text) {
		searchTxt.setText(text);
	}

	public void setResultsPerPage(ResultsPerPage noResults) {
		resultPerPageSlc.selectByValue(noResults.getValue());
		resultPerPageSlc.click();
	}

	public SearchResultPageObject clickSearchBtn() {
		searchBtn.click();
		
		return create(SearchResultPageObject.class);
	}

	public enum ResultsPerPage {
		RESULTS_10("10"), RESULTS_15("15"), RESULTS_20("20"), RESULTS_30("30");
		private final String value;

		ResultsPerPage(String value) {
			this.value = value;
		}

		public String getValue() {
			return value;
		}

	}
}
