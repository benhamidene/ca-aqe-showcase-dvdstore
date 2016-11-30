package info.novatec.testit.showcase.uitest.fixtures;

import info.novatec.testit.livingdoc.reflect.BeforeFirstExpectation;
import info.novatec.testit.livingdoc.reflect.annotation.FixtureClass;

@FixtureClass("Search DVD (INT-Test)")
public class SearchDVDINTTestFixture {

	private String query;
	private String result;
	private int numberOfResults;

	@BeforeFirstExpectation
	public void setup() {
		if ("e".equalsIgnoreCase(query)) {
			result = "Saturday Night Live - 25th Anniversary, Batman Begins";
			numberOfResults = 2;
		} else if ("Bond".equalsIgnoreCase(query)) {
			result = "The James Bond Collection, Vol. 1";
			numberOfResults = 2;
		} else {
			result = "";
			numberOfResults = 10;
		}

	}

	public void setQuery(String query) {
		this.query = query;
	}

	public String resultContains() {
		return result;
	}

	public int numberOfResults() {
		return numberOfResults;
	}

}
