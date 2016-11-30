package info.novatec.testit.showcase.common;

/**
 * Exception class for errors that relate to configuration problems.
 * 
 * @author Anis Ben Hamidene (NovaTec GmbH)
 */
public class ConfigurationException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    /**
     * Default constructor.
     */
    public ConfigurationException() {
        super();
    }

    /**
     * Constructor .
     * 
     * @param message
     *            error message
     * @param cause
     *            cause
     */
    public ConfigurationException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructor .
     * 
     * @param message
     *            error message
     */
    public ConfigurationException(String message) {
        super(message);
    }

    /**
     * Constructor .
     * 
     * @param cause
     *            cause
     */
    public ConfigurationException(Throwable cause) {
        super(cause);
    }

}
