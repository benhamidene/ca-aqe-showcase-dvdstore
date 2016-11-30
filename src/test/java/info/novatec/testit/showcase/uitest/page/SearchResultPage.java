package info.novatec.testit.showcase.uitest.page;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import info.novatec.testit.webtester.pagefragments.GenericElement;
import info.novatec.testit.webtester.pagefragments.PageFragment;
import info.novatec.testit.webtester.pagefragments.annotations.IdentifyUsing;
import info.novatec.testit.webtester.pagefragments.identification.producers.IdEndsWith;
import info.novatec.testit.webtester.pages.Page;

public interface SearchResultPage extends Page {

	@IdentifyUsing(".message")
	GenericElement searchResultMessages();

	public interface SearchResult extends PageFragment {
		@IdentifyUsing(how = IdEndsWith.class, value = "TitleLink")
		GenericElement title();

		@IdentifyUsing(how = IdEndsWith.class, value = "StarringValue")
		GenericElement starring();

		@IdentifyUsing(how = IdEndsWith.class, value = "PriceValue")
		GenericElement price();
	}
	
	@IdentifyUsing(how = IdEndsWith.class, value = "SearchResultsTable")
	List<SearchResult> searchResults();
	
	
	default String getFirstTitleOfResults() {
		if (CollectionUtils.isEmpty(searchResults())) {
			return StringUtils.EMPTY;
		} else {
			return searchResults().get(0).title().getVisibleText();
		} 
	}

	default String getFirstStarringOfResults() {
		if (CollectionUtils.isEmpty(searchResults())) {
			return StringUtils.EMPTY;
		} else {
			return searchResults().get(0).starring().getVisibleText();
		} 
	}

	default String getFirstPriceOfResults() {
		if (CollectionUtils.isEmpty(searchResults())) {
			return StringUtils.EMPTY;
		} else {
			return searchResults().get(0).price().getVisibleText();
		} 
	}

	default int getNumberOfResults() {
		return CollectionUtils.size(searchResults());
	}
}