package IgnoreException;

/**
 * This is the type IgnoreExceptionInterface.
 *
 * @author <a href="mailto:jsvg88@scania.com">jsvg88</a>
 * @since 2018-02-21
 */
public interface IgnoreExceptionInterface {
    @IgnoreException
    void execute();
}
