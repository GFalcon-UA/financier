package ua.com.gfalcon.financier.exceptions;

/**
 * Yahoo Finance exception.
 */
public class YahooFinanceException extends RuntimeException {

    public YahooFinanceException() {
        super();
    }

    public YahooFinanceException(String message) {
        super(message);
    }

    public YahooFinanceException(String message, Throwable cause) {
        super(message, cause);
    }

    public YahooFinanceException(Throwable cause) {
        super(cause);
    }

    protected YahooFinanceException(String message, Throwable cause, boolean enableSuppression,
            boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
