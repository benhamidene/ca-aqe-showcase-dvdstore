package info.novatec.aqe.showcase.livingdoc.selenium.fwk.elements;

import info.novatec.testit.webtester.pageobjects.PageObject;
import org.openqa.selenium.NoSuchElementException;

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

