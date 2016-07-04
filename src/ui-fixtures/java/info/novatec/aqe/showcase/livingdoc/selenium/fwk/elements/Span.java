package info.novatec.aqe.showcase.livingdoc.selenium.fwk.elements;

import info.novatec.testit.webtester.pageobjects.Button;
import info.novatec.testit.webtester.pageobjects.PageObject;

/**
 * The {@link Button} implementation.
 * 
 * @author Johannes Schlaudraff (NovaTec GmbH)
 */
public class Span extends PageObject {

	@Override
	public boolean isVisible() {
		try {
			return super.isVisible();
		} catch (RuntimeException e) {
			return false;
		}
	}

}
