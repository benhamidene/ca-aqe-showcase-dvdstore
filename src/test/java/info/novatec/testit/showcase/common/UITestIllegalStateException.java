package info.novatec.testit.showcase.common;

/**
 * Signals that the gui is not in an appropriate state for the requested operation.
 * 
 * @author Johannes Schlaudraff (NovaTec GmbH)
 */
public class UITestIllegalStateException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    /**
     * Default constructor.
     */
    public UITestIllegalStateException() {
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
    public UITestIllegalStateException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructor .
     * 
     * @param message
     *            error message
     */
    public UITestIllegalStateException(String message) {
        super(message);
    }

    /**
     * Constructor .
     * 
     * @param cause
     *            cause
     */
    public UITestIllegalStateException(Throwable cause) {
        super(cause);
    }

}
