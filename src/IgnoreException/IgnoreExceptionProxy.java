package IgnoreException;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * This is the type IgnoreExceptionProxy.
 *
 * @author <a href="mailto:jsvg88@scania.com">jsvg88</a>
 * @since 2018-02-21
 */
public class IgnoreExceptionProxy implements InvocationHandler{

    @Override
    public Object invoke(final Object proxy, final Method method, final Object[] args) throws Throwable {
        if(method.isAnnotationPresent(IgnoreException.class))
        {
            try {
                return method.invoke(args);
            } catch (Throwable t) {}
        }
        return method.invoke(args);
    }
}
