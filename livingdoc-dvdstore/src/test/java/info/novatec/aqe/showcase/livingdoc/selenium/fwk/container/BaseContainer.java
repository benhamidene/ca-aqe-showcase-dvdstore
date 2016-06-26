package info.novatec.aqe.showcase.livingdoc.selenium.fwk.container;

import info.novatec.testit.webtester.api.annotations.IdentifyUsing;
import info.novatec.testit.webtester.api.enumerations.Method;
import info.novatec.testit.webtester.pageobjects.PageObject;

import java.awt.Container;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.NoSuchElementException;

/**
 * Base class for all {@link Container}.
 * 
 * @author Johannes Schlaudraff (NovaTec GmbH)
 */
public abstract class BaseContainer extends PageObject {
	/**
	 * The error messages css class.
	 */
	public static final String ERROR_MESSAGES_CSS_CLASS = ".Error";

	/**
	 * The warning messages css class.
	 */
	public static final String WARNING_MESSAGES_CSS_CLASS = ".Warning";

	/**
	 * The error messages on the page.
	 */
	@IdentifyUsing(method = Method.CSS, value = ERROR_MESSAGES_CSS_CLASS)
	public List<PageObject> errorMessages;

	/**
	 * The warnings on the page.
	 */
	@IdentifyUsing(method = Method.CSS, value = WARNING_MESSAGES_CSS_CLASS)
	public List<PageObject> warningMessages;


	
	

	/**
	 * {@inheritDoc}
	 */
	public boolean isDisplayed() {
		try {
			String tagName = getWebElement().getTagName();
			return StringUtils.isNotEmpty(tagName);
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	

	/**
	 * {@inheritDoc}
	 */
	public boolean hasErrorMessages() {
		try {
			return CollectionUtils.isNotEmpty(errorMessages);
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean hasWarningMessages() {
		try {
			return CollectionUtils.isNotEmpty(warningMessages);
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean isDisplayedWithOutErrorsAndWarnings() {
		return isDisplayed() && !(hasWarningMessages() || hasErrorMessages());
	}

}
