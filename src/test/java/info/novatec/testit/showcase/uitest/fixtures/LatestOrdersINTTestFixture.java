package info.novatec.testit.showcase.uitest.fixtures;

import info.novatec.testit.livingdoc.reflect.BeforeFirstExpectation;
import info.novatec.testit.livingdoc.reflect.annotation.FixtureClass;

@FixtureClass("Latest orders [ INT-Test ]")
public class LatestOrdersINTTestFixture {

	private String username;
	private String result;
	private int numberOfResults;

	@BeforeFirstExpectation
	public void setup() {
		if ("testuser1".equalsIgnoreCase(username)) {
			result = "Batman begins, Fever Pitch";
			numberOfResults = 20;
		} else if ("testuser2".equalsIgnoreCase(username)) {
			result = "Harry Potter and the Goblet of Fire";
			numberOfResults = 2;
		} else if ("testuser3".equalsIgnoreCase(username)) {
			result = "Band of Brothers, Saving Private Ryan";
			numberOfResults = 3;
		} else {
			result = "";
			numberOfResults = 10;
		}

	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String resultContains() {
		return result;
	}

	public int numberOfLatestOrders() {
		return numberOfResults;
	}

}
