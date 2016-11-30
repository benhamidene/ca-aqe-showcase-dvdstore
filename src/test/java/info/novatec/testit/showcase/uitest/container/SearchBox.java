package info.novatec.testit.showcase.uitest.container;

import info.novatec.testit.showcase.uitest.page.SearchResultPage;
import info.novatec.testit.webtester.pagefragments.Button;
import info.novatec.testit.webtester.pagefragments.PageFragment;
import info.novatec.testit.webtester.pagefragments.SingleSelect;
import info.novatec.testit.webtester.pagefragments.TextField;
import info.novatec.testit.webtester.pagefragments.annotations.IdentifyUsing;
import info.novatec.testit.webtester.pagefragments.identification.producers.IdEndsWith;

public interface SearchBox extends PageFragment {
	static final String ID = "#SearchForm";

	
	@IdentifyUsing(how = IdEndsWith.class, value = "Query")
	TextField searchTxt();

	@IdentifyUsing(how = IdEndsWith.class, value = "PageSize")
	SingleSelect resultPerPageSlc();

	@IdentifyUsing(how = IdEndsWith.class, value = "Search")
	Button searchBtn();

	default void typeSearchTxt(String text) {
		searchTxt().setText(text);
	}

	default void setResultsPerPage(ResultsPerPage noResults) {
		resultPerPageSlc().selectByValue(noResults.getValue());
		// resultPerPageSlc().click();
	}

	default SearchResultPage clickSearchBtn() {
		searchBtn().click();

		return create(SearchResultPage.class);
	}

	enum ResultsPerPage {
		RESULTS_10("10"), RESULTS_15("15"), RESULTS_20("20"), RESULTS_30("30");
		final String value;

		ResultsPerPage(String value) {
			this.value = value;
		}

		public String getValue() {
			return value;
		}

	}
}
