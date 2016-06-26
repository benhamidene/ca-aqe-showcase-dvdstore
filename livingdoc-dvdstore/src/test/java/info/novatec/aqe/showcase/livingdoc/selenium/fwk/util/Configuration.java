package info.novatec.aqe.showcase.livingdoc.selenium.fwk.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.commons.lang3.StringUtils;

/**
 * Loads the Configuration from System.properties.
 * 
 * @author Johannes Schlaudraff (NovaTec GmbH)
 */
public class Configuration {
	public static final String SETTINGS_DIR_NAME = "/settings/";

	public static final String DEFAULT_SETTINGS_NAME = "default";

	public static final String PROPS_EXT = ".properties";

	public static void loadSystemProperties(String profile)  {
		
		try {
			Properties sysProps = new Properties();
			InputStream fis = getPropertiesFile(profile);
			sysProps.load(fis);
			for (Object keyObj : sysProps.keySet()) {
				String key = (String) keyObj;
				System.setProperty(key, sysProps.getProperty(key));
			}
		} catch (FileNotFoundException e) {
			throw new IllegalStateException("Configuration file not found", e);
		} catch (IOException e) {
			throw new IllegalStateException("Configuration file could not be opened or accessed", e);
		}
	}

	private static InputStream getPropertiesFile(String target) throws FileNotFoundException {
		java.io.InputStream fis = Configuration.class.getResourceAsStream(SETTINGS_DIR_NAME + target + PROPS_EXT);
		if (fis == null) {
			throw new FileNotFoundException("File not found:" + SETTINGS_DIR_NAME + target + PROPS_EXT);
		}
		return fis;
	}

	/**
	 * Returns the system under test url.
	 * 
	 * @return url of the system under test
	 */
	public static String getSutUrl() {
		String key = "sut.url";
		String sut = System.getProperty(key);
		if (StringUtils.isEmpty(sut)) {
			throw new ConfigurationException("System under test URL not set! Please set property: " + key);
		}
		return sut;
	}

	/**
	 * Returns {@link WebDriverFactory.Browser}.
	 * 
	 * @return list of {@link WebDriverFactory.Browser}
	 */
//	public static WebDriverFactory.Browser getTestOnBrowser() {
//		String key = "test.browser";
//		String browserString = System.getProperty(key, "firefox");
//		if (StringUtils.isEmpty(browserString)) {
//			throw new ConfigurationException("Browser not set! Please set property: " + key);
//		}
//		WebDriverFactory.Browser browser = WebDriverFactory.stringToBrowser(browserString);
//		if (browser != null) {
//			return browser;
//		} else {
//			throw new ConfigurationException("Invalid browser: " + browser);
//		}
//	}

	/**
	 * Returns the path to the folder where debug info can be placed, eg.
	 * Screenshots
	 * 
	 * @return the debug info folder
	 */
	public static String getDebugInfoFolder() {
		String key = "debug.info.folder";
		String debugInfoFolder = System.getProperty(key);
		if (StringUtils.isEmpty(debugInfoFolder)) {
			throw new ConfigurationException("Debug folder not set! Please set property: " + key);
		}
		return debugInfoFolder;
	}
}
