package info.novatec.aqe.showcase.livingdoc.selenium.fwk.elements;

import org.openqa.selenium.NoSuchElementException;

import info.novatec.testit.webtester.pageobjects.PageObject;

/**
 * The {@link Div} implementation.
 * 
 * @author Johannes Schlaudraff (NovaTec GmbH)
 */
public class Div extends PageObject {

	@Override
	public boolean isVisible() {
		try{
			return super.isVisible();
		}catch(NoSuchElementException e){
			return false;
		}
	}

}

