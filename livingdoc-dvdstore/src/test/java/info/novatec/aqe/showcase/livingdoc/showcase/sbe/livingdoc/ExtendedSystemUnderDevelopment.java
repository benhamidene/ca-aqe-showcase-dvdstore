package info.novatec.aqe.showcase.livingdoc.showcase.sbe.livingdoc;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.commons.lang3.StringUtils;

import info.novatec.aqe.showcase.livingdoc.showcase.sbe.uitest.fixtures.FixtureUtils;
import info.novatec.testit.livingdoc.reflect.Fixture;
import info.novatec.testit.livingdoc.reflect.TypeLoader;
import info.novatec.testit.livingdoc.systemunderdevelopment.DefaultSystemUnderDevelopment;

public class ExtendedSystemUnderDevelopment extends
		DefaultSystemUnderDevelopment {

	public static final String SETTINGS_DIR_NAME = "/settings/";

	public static final String DEFAULT_SETTINGS_NAME = "default";

	/**
	 * Extension for properties files.
	 */
	public static final String PROPS_EXT = ".properties";

	/**
	 * Default constructor.
	 * 
	 * @param params
	 *            fixture factory arguments.
	 * @throws IOException
	 *             I/O error
	 * @throws FileNotFoundException
	 *             if the system properties file is not found.
	 */
	public ExtendedSystemUnderDevelopment(String... params)
			throws FileNotFoundException, IOException {
		super();
		// set default
		setSystemProperties(DEFAULT_SETTINGS_NAME);
		// overwrite with custom properties
		if (params != null && params.length == 1) {
			setSystemProperties(params[0]);
		} else {
			throw new IllegalArgumentException("F:"+StringUtils.join(params, "#"));
		}

	}
	

	public Fixture getFixture(String name, String... params) throws Throwable {
        String normalizedName = FixtureUtils.replaceUmlauteAndSpecialChars(name);
        String[] normalizedParams = params;
        if (params != null) {
            normalizedParams = new String[params.length];
            for (int i = 0; i < params.length; i++ ) {
                normalizedParams[i] = FixtureUtils.removeWhiteSpaces(params[i]);
            }
        }
        return super.getFixture(normalizedName, normalizedParams);

    }

	/**
	 * Default constructor.
	 * 
	 * @param params
	 *            fixture factory arguments.
	 * @throws IOException
	 *             I/O error
	 * @throws FileNotFoundException
	 *             if the system properties file is not found.
	 */
	public ExtendedSystemUnderDevelopment() throws FileNotFoundException,
			IOException {
		super();
		// set default
		setSystemProperties(DEFAULT_SETTINGS_NAME);
	}

	/**
	 * Constructor setting the type loader.
	 * 
	 * @param typeLoader
	 *            type loader.
	 */
	public ExtendedSystemUnderDevelopment(TypeLoader<?> typeLoader) {
		super(typeLoader);
	}

	private void setSystemProperties(String target)
			throws FileNotFoundException, IOException {
		Properties sysProps = new Properties();
		InputStream fis = getPropertiesFile(target);
		sysProps.load(fis);
		for (Object keyObj : sysProps.keySet()) {
			String key = (String) keyObj;
			System.setProperty(key, sysProps.getProperty(key));
		}
	}

	private InputStream getPropertiesFile(String target)
			throws FileNotFoundException {
		java.io.InputStream fis = ExtendedSystemUnderDevelopment.class
				.getResourceAsStream(SETTINGS_DIR_NAME + target + PROPS_EXT);
		if (fis == null) {
			throw new FileNotFoundException("File not found:"
					+ SETTINGS_DIR_NAME + target + PROPS_EXT);
		}
		return fis;
	}

}
