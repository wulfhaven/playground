/**
 * This is the type AsArrayAsList.
 *
 * @author <a href="mailto:jsvg88@scania.com">jsvg88</a>
 * @since 2017-09-28
 */
import java.util.Arrays

/**
 * This is the type AsArrayAsList.

 * @author [jsvg88](mailto:jsvg88@scania.com)
 * *
 * @since 2017-09-28
 */
    fun main(args: Array<String>) {

        val strings = Arrays.asList(*"Hello world".split("(?!^)".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray())
        val strings2 = strings.toTypedArray()
        val strings3 = Arrays.asList(*strings2)
        val strings4 = strings3.toTypedArray()

        println(java.lang.Boolean.valueOf(strings === strings3))
        println(java.lang.Boolean.valueOf(strings2 === strings4))


        println(Arrays.asList(*strings4))


    }



