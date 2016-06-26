package info.novatec.aqe.showcase.livingdoc.selenium.fwk.util;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

/**
 * This helper class wraps a {@link WebElement} to prevent it from
 * initialisation through the {@link PageFactory} .
 * 
 * @author Johannes Schlaudraff (NovaTec GmbH)
 */
public class WebElementWrapper {
	private final WebElement webElement;

	/**
	 * The Constructor.
	 * 
	 * @param webElement
	 *            the {@link WebElement} to wrap.
	 */
	public WebElementWrapper(WebElement webElement) {
		this.webElement = webElement;
	}

	/**
	 * Gets {@link #webElement}.
	 * 
	 * @return {@link #webElement}
	 */
	public WebElement getWebElement() {
		return webElement;
	}

}
